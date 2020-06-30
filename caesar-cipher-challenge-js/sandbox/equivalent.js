//##File System module - to work with the file system on the computer
const fs = require('fs');

//#API source
const urlAPI = 'https://api.codenation.dev/v1/challenge/dev-ps/generate-data';
const tokenAPI = 'cbb150e68433eef5ae8e78ec405ef702295ae4db';

//#P1 - with third party library
const request = require('request');

request.get(`${urlAPI}?token=${tokenAPI}`, (error, response, body) => {
    let json = JSON.parse(body);
    console.log(json);
});

//#P1 - natively
//Function to make a GET request
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
        });
    }).on('error', (err) => {
        console.log("Error: ", err.message);
    });
}

//makingGetRequest();