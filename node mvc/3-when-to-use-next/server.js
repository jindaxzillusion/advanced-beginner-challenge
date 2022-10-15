const express = require('express')
const app = express()

app.get(
    '/next', function (req, res, next){
        console.log('hi there');
        next();
        console.log('you are still here');
    }
)

app.get(
    '/return-next', function(req, res, next){
        console.log('hi there');
        return next()
        console.log('you are still here');
    }
)

app.listen(5000, () => {
    console.log("app is running on port 5000");
})