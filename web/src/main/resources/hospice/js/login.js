var usernameInput = document.getElementById("usernameInput");
var passwordInput = document.getElementById("passwordInput");
var loginBtn = document.getElementById("loginBtn");

/* user name */
usernameInput.setAttribute("placeholder", "Enter Username");
usernameInput.addEventListener('keyup',
    function(){
        try{
            profileUserEntity.loginName = usernameInput.value;
        } catch(ex){
            alert(ex.message)
        }
    }
);

/* password */
passwordInput.setAttribute("placeholder", "Enter Password");
passwordInput.addEventListener('keyup',
    function(){
        try{
            profileUserEntity.password = passwordInput.value;
        } catch(ex){
            alert(ex.message)
        }
    }
);

/* login button */
var txtLoginBtn = document.createTextNode("Login");
loginBtn.appendChild(txtLoginBtn);
loginBtn.addEventListener('click',
    function(){
        try{
            if(profileUserEntity.password.length > 0 && profileUserEntity.loginName.length > 0){
                action = function(){
                    window.location.replace('clinician');
                };
                postRequests("login", action)
            }
        }catch(ex){
            alert(ex.message)
        }
    }
);

function myFunction() {
    var x = document.getElementById("psw");
    if (x.type === "password") {
        x.type = "text";
    } else {
        x.type = "password";
    }
} 