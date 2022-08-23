const express = require('express')
const {
    registerView, 
    loginView,
    registerUser,
    loginUser,
} = require('../controllers/loginController')

const router = express.Router()

router.get('/register', registerView)
router.get('/login', loginView)

module.exports = router;