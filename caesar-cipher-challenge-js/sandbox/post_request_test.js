/* test */
async function testPOST() {
    /*test working################*/
    const data = JSON.stringify({
        name: 'John Doe',
        job: 'DevOps Specialist'
    });
    
    const options = {
        protoco: 'https',
        hostname: 'reqres.in',
        port: 443,
        path: '/api/users',
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Content-Length': data.length
        }
    };
    
    
    const req = httpsRequest.request(options, (res) => {
        let newdata = '';
    
        res.on('data', (chunk) => {
            newdata += chunk;
        });
    
        res.on('end', () => {
            console.log(JSON.parse(newdata));
            console.log(`\tData sent successfully £:D`);
        });
    
    }).on("error", (err) => {
        console.log("Error: ", err.message);
    });
    
    req.write(data);
    req.end();

/*-----------NEW----------------*/
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
/*-----------------------------------*/
}

testPOST();
/* test */