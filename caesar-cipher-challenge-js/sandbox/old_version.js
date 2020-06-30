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
const urlAPI = 'https://api.codenation.dev/v1/challenge/dev-ps/generate-data';
const tokenAPI = 'cbb150e68433eef5ae8e78ec405ef702295ae4db';

//Output path
const outputFolder = './output';
const answer = 'answer.json';

//The body of output wich will result in a JSON: "answer.json"
/*let answer = {
    "numero_casas":1,
    "token":"cbb150e68433eef5ae8e78ec405ef702295ae4db",
    "cifrado":"uif cftu sfbdujpo up \"uijt jt dpogvtjoh, xifsf bsf uif epdt\" jt up sfxsjuf uif gfbuvsf up nblf ju mftt dpogvtjoh, opu xsjuf npsf epdt. kfgg buxppe",
    "decifrado":"",
    "resumo_criptografico":""
}*/


//Function to make a GET request and create/write the "answer.json" file on the "output" folder
function makingGetRequest() {
    //Making a GET request from de API
    httpsRequest.get(`${urlAPI}?token=${tokenAPI}`, (res) => {
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
            fs.writeFile(`${outputFolder}/${answer}`, JSON.stringify(received), (err) => {
                if (err) {
                    console.log(`Error! Coudn't write the file...`, err);
                } else {
                    console.log(`File saved successfully £:D`);
                }
            });
        });
    }).on('error', (err) => {
        console.log("Error: ", err.message);
    });
}

makingGetRequest();


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
    fs.writeFile(`${outputFolder}/${answer}`, JSON.stringify(makingGetRequest), (err) => {
        if (err) {
            console.log(`Error! Coudn't write the file...`, err);
        } else {
            console.log(`File saved successfully £:D`);
        }
    });
    
}

createAnswerFile();
*/