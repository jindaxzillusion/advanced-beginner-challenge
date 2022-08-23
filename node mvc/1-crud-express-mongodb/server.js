console.log('May node be with you')

const express = require('express')
const bodyParser = require('body-parser')
const app = express()
const MongoClient = require('mongodb').MongoClient
const dbstring = 'mongodb+srv://jindacz:jindacz@cluster0.tgpmqis.mongodb.net/?retryWrites=true&w=majority'

MongoClient.connect(dbstring, {
    useUnifiedTopology: true
}).then(client => {
    const db = client.db('star-wars-quotes')
    // console.log('Connected to Database')
    const quotesCollection = db.collection('quotes')
    // app.use(bp.json()) looks at requests where the Content-Type: application/json header is present and transforms the text-based JSON input into JS-accessible variables under req.body. app.use(bp.urlencoded({extended: true}) does the same for URL-encoded requests. the extended: true precises that the req.body object will contain values of any type instead of just strings.
    app.use(bodyParser.urlencoded({extended: true}))
    app.use(bodyParser.json())
    app.use(express.static('public'))
    app.set('view engine', 'ejs')

    app.get('/', (req, res) => {
        db.collection('quotes').find().toArray((err, result) => {
            if (err) return console.log(err)
            res.render('index.ejs', {quotes: result})
        })
    })

    app.post('/quotes', (req, res) => {
        quotesCollection.insertOne(req.body)
          .then(result => {
            console.log(result)
            res.redirect('/')
          })
          .catch(error => console.error(error))
    })

    app.put('/quotes', (req, res) => {
        quotesCollection.findOneAndUpdate(
            {name: 'Yoda'},
            {
                $set: {
                    name: req.body.name,
                    quote: req.body.quote
                }
            },
            {
                upsert: true
            }
        ).then(result => {
            res.json('Success')
        })
        .catch(error => console.error(error))
    })

    app.delete('/quotes', (req, res) => {
        quotesCollection.deleteOne(
            {name: req.body.name}
        )
        .then(result => {
            if (result.deletedCount === 0){
                return res.json('No quote to delete')
            }
            res.json(`Delete Darth Vader's quote`)
        })
        .catch(error => console.error(error))
    })

    app.listen(3000, function(){
        console.log('listening on 3000')
    })
    
}).catch(console.error)

    


