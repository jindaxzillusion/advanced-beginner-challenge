const passport = require("passport")
const User = require("../models/User")
const bcrypt = require("bcryptjs")
// For register page
const registerView = (req, res) => {
    res.rend("register", {})
}

const registerUser = (req, res) => {
    // we get all the inputs submitted into the form by users
    const {name, email, location, password, confirm} = req.body
    if (!name || !email || !password || !confirm){
        console.log("Fill empty fields");
    }
    // confirm Passwords2
    if (password !== confirm) {
        console.log('Password must match');
    } else {
        // Validation
        User.findOne({email: email}).then((user) => {
            if (user) {
                console.log("email exists");
                res.render("register", {
                    name,
                    email,
                    password,
                    confirm
                });
            } else {
                // validation
                const newUser = new User({
                    name,
                    email,
                    location,
                    password,
                });
                // password hashing
                bcrypt.genSalt(10, (err, salt) =>
                  bcrypt.hash(newUser), salt, (err, hash) => {
                    if (err) throw err;
                    newUser.password = hash;
                    newUser
                      .save()
                      .then(res.redirect("/login"))
                      .catch((error) => consoloe.log(error))
                  })
            }
        })
    }
}

// for view
const loginView = (req, res) => {
    res.render("login", {})
}

const loginUser = (req, res) => {
    const {email, password} = req.body;
    // required
    if (!email || !password) {
        console.log("please fill in all fields")
        res.render("login", {
            email,
            password
        })
    } else {
        passport.authenticate("local", {
            successRedirect: "/dashboard",
            failureRedirect: "/login",
            failureFlash: true,
        })(req, res);
    }
}

module.exports = {
    registerView,
    loginView,
    registerUser,
    loginUser,
}