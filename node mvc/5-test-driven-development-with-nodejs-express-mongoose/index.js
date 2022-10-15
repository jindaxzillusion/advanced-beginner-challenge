require('dotenv').config()

const express = require("express")
const mongoose = require("mongoose")
const bodyParser = require("body-parser")

const app = express();
const port = 8000;


mongoose.connect(process.env.mongoURI, {
    useNewUrlParser: true,
    useUnifiedTopology: true
}).then(res => console.log(`Connection Sucessful ${res}`))
  .catch(err => console.log(`Error in DB connection ${err}`));

// body-parser config
app.use(express.json())
app.use(bodyParser.urlencoded({extended: true}))
app.use(bodyParser.json())

app.get("/", (req, res) => {
    res.send(`<h1>Hello!</h1>`)
})

app.listen(port, () => {
    console.log(`Application is listening at port ${port}`);
})