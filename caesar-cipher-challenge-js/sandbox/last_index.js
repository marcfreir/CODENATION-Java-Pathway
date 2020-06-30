/*
    Created on : 09-June-2020, 09:20:57 AM
    Author     : Marc Freir
    License    : This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License.
*/

//Strict mode - to avoid the use of undeclared variables
'use strict'

//Globals
//#Requiring Node modules
//##File System module - to work with the file system on the computer
const fs = require('fs');
//##HTTPS module - to transfer data over HTTP TLS/SSL protocol - For native HTTPS requests
const httpsRequest = require('https');
//##Crypto module - to handle encrypted data
const crypto = require('crypto');

//#API source
const urlAPI = 'https://api.codenation.dev/v1/challenge/dev-ps';
const tokenAPI = 'cbb150e68433eef5ae8e78ec405ef702295ae4db';

//Output path
const outputFolder = './output';
const answerFile = 'answer.json';

//let answer = '';

//The body of output wich will result in a JSON: "answer.json"
let answer = {
    "numero_casas":1,
    "token":"cbb150e68433eef5ae8e78ec405ef702295ae4db",
    "cifrado":"uif cftu sfbdujpo up \"uijt jt dpogvtjoh, xifsf bsf uif epdt\" jt up sfxsjuf uif gfbuvsf up nblf ju mftt dpogvtjoh, opu xsjuf npsf epdt. kfgg buxppe",
    "decifrado":"",
    "resumo_criptografico":""
}


//Function to make a GET request and create/write the "answer.json" file on the "output" folder
function makingGetRequest() {
    //Making a GET request from de API
    httpsRequest.get(`${urlAPI}/generate-data?token=${tokenAPI}`, (res) => {
        let data = '';
        //Called when a data chunck is received
        res.on('data', (chunk) => {
            data += chunk;
        });

        //Called when the complete response is received
        res.on('end', () => {
            const received = JSON.parse(data);
            console.log(received);
            //Now take the received" result and create/write the "answer.json" file on the "output" folder
            fs.writeFile(`${outputFolder}/${answerFile}`, JSON.stringify(received), (err) => {
                if (err) {
                    console.log(`Error! Coudn't write the file...`, err);
                } else {
                    console.log(`File saved successfully £:D`);
                    decryptMessage(received.numero_casas, received.cifrado);
                }
            });
        });
    }).on('error', (err) => {
        console.log(`Error: `, err.message);
    });
}

makingGetRequest();

/*Function to decrypt the message through the SHA-1*/
function decryptMessage(shiftParameter, encryptedMessage) {
    //Read the file "answer.json"
    fs.readFile(`${outputFolder}/${answerFile}`, 'utf8', (err) => {
        if (err) {
            console.log(`Error! Coudn't read the file...`, err);
        } else {
            console.log(`File read successfully £:D`);
            console.log(`[File log of characters: ---vvv]`);

            //Decrypt the encrypted message and create the cryptographic_summary
            try {
                let convertedMessage = encryptedMessage.toLowerCase();
                for (let index = 0; index < convertedMessage.length; index++) {
                    //Pick the ASCII code of each character of the message
                    let asciiCodeElement = convertedMessage.charCodeAt(index);
                    //Pick the ASCII code of each lowercase letter...
                    //...from a = 97 (decimal) to z = 122 (decimal)
                    //#The shift parameter here is equal to 1, then to the right 97 + 1 = 98
                    if (asciiCodeElement >= 98 && asciiCodeElement <= 122) {
                        answer.decifrado += String.fromCharCode(asciiCodeElement - shiftParameter);
                    } else if (asciiCodeElement === 97) {
                        answer.decifrado += String.fromCharCode(asciiCodeElement + shiftParameter + 24);
                    } else {
                        answer.decifrado += convertedMessage[index];
                    }
                    console.log(`\tCharacter ${index} decrypted...`);
                }
                //
                answer.resumo_criptografico = crypto.createHash('sha1').update(answer.decifrado).digest('hex');
                const answerJSONString = JSON.stringify(answer);
                fs.writeFile(`${outputFolder}/${answerFile}`, answerJSONString, (error) => {
                    if (error) {
                        console.log(`Error! Coudn't write the file...`, error);
                    } else {
                        console.log(`File updated successfully £:D`);
                    }
                });
            } catch (error) {
                console.log(error);
            }
        }
    });
    //Prepare to send the file via POST request
    //Let us create a object literal for answer
    /*
    const savedAnswer = {
        answer: fs.createReadStream(`${outputFolder}/${answerFile}`)
    };
    console.log(savedAnswer);*/
    /*######TEST######*/
    //faz a requisição na api, enviando o arquivo "answer.json"
    /*
    let request = require('request');
    request.post({url:'http://127.0.0.1:5500', savedAnswer: savedAnswer}, function optionalCallback(err, httpResponse, body) {
      if (err) {
        return console.error('erro no upload:', err);
      }
      console.log('Upload feito: ', body);
    });
    */
    
    /*######TEST######*/
}

/* test */
async function sendAnswerViaPOST() {
    /*test working################*/
    /*
    const data = JSON.stringify({
        name: 'John Doe',
        job: 'DevOps Specialist'
    });*/
    
    const options = {
        //key: fs.readFileSync('key.pem'),
        //cert: fs.readFileSync('cert.pem'),
        hostname: 'api.codenation.dev',
        path: '/v1/challenge/dev-ps/submit-solution?token=cbb150e68433eef5ae8e78ec405ef702295ae4db',
        method: 'POST',
        //url: `${urlAPI}/submit-solution?token=${tokenAPI}`,
        port: 443,
        headers: {
            'Content-Type': 'multipart/form-data' //,
            //'Content-Length': data.length
        },
        formData: {
            answer: fs.createReadStream(`${outputFolder}/${answerFile}`) //,
        }
    };
    
    
    const req = httpsRequest.request(options, (res) => {
        let newdata = '';
        console.log('Status Code:', res.statusCode);
    
        res.on('data', (chunk) => {
            newdata += chunk;
        });
    
        res.on('end', () => {
            console.log(`Body: `, JSON.parse(newdata));
            console.log(`\tData sent successfully £:D`);
            console.log(`Done!`);
        });
    
    }).on("error", (err) => {
        console.log("Error: ", err.message);
    });
    
    //req.write(data);
    req.end();

/*
    const data = JSON.stringify({
        name: 'John Doe',
        job: 'Content Writer'
    });

    const options = {
        hostname: 'reqres.in',
        path: '/api/users',
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Content-Length': data.length
        }
    };


    const req = httpsRequest.request(options, (res) => {
        let newdata = '';

        console.log('Status Code:', res.statusCode);

        res.on('data', (chunk) => {
            newdata += chunk;
        });

        res.on('end', () => {
            console.log('Body: ', JSON.parse(newdata));
            console.log(`\tData sent successfully £:D`);
        });

    }).on("error", (err) => {
        console.log("Error: ", err.message);
    });

    req.write(data);
    req.end();
    */
}

sendAnswerViaPOST();

function httpsServer() {
    const options = {
        key: fs.readFileSync('key.pem'),
        cert: fs.readFileSync('cert.pem')
    };
      
    httpsRequest.createServer(options, function (req, res) {
        res.writeHead(200);
        res.end("hello world\n");
    }).listen(8000);
}

//httpsServer();
/* test */

/*###TEST###*/
/*
//Making a GET request from de API
const makingGetRequest = () => httpsRequest.get(`${urlAPI}?token=${tokenAPI}`, (res) => {
    let data = '';
    //Called when a data chunck is received
    res.on('data', (chunk) => {
        data += chunk;
    });

    //Called when the complete response is received
    res.on('end', () => {
        const received = JSON.parse(data);
        console.log(received);
    });
}).on('error', (err) => {
    console.log("Error: ", err.message);
});

makingGetRequest();
*/
/*###TEST###*/


//Function to create/write the "answer.json" file on the "output" folder
/*
function createAnswerFile() {
    fs.writeFile(`${outputFolder}/${answerFile}`, JSON.stringify(makingGetRequest), (err) => {
        if (err) {
            console.log(`Error! Coudn't write the file...`, err);
        } else {
            console.log(`File saved successfully £:D`);
        }
    });
    
}

createAnswerFile();
*/