var acc = document.getElementsByClassName("accordion");
var accleft = document.getElementsByClassName("accordion-left");
var i;
var j;

for (i = 0; i < acc.length; i++) {
  acc[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var panel = this.nextElementSibling;
    if (panel.style.display === "block") {
      panel.style.display = "none";
    } else {
      panel.style.display = "block";
    }
  });
}

function accordionLeft(accountLeft){
    accountLeft.addEventListener("click", function() {
        this.classList.toggle("active");
        var parent = this.parentElement.parentElement;
        var panel = this.nextElementSibling;
        if (panel.style.display === "block") {
            panel.style.display = "none";
            parent.style.left = "-85px";
            parent.style.top = "85px";
            parent.style.transform = "rotate(-90deg)";
            if (parent.id === "filter-tab-content") {
                document.getElementById("filterbttn").innerHTML = "";
                document.getElementById("filterbttn").style.textAlign = "right";
                var bttnTxtFilter = document.createTextNode("Show Filters");
                document.getElementById("filterbttn").appendChild(bttnTxtFilter);
                var bttnImgFilter = document.createElement("IMG");
                bttnImgFilter.setAttribute("src", "/images/kfm.png");
                bttnImgFilter.style.width = "20px";
                bttnImgFilter.style.paddingLeft = "3px";
                //bttnImgFilter.style.paddingRight = "3px";
                bttnImgFilter.style.float = "right"
                document.getElementById("filterbttn").appendChild(bttnImgFilter);
            }
            else {
                var newid = parent.id.replace('formstab-content', '')
                document.getElementById("formsbttn" + newid).innerHTML = "";
                document.getElementById("formsbttn" + newid).style.textAlign = "right";
                var bttnTxtForms = document.createTextNode("Show Forms");
                document.getElementById("formsbttn" + newid).appendChild(bttnTxtForms);
                var bttnImgForms = document.createElement("IMG");
                bttnImgForms.setAttribute("src", "/images/documents.png");
                bttnImgForms.style.width = "20px";
                bttnImgForms.style.paddingLeft = "3px";
                bttnImgForms.style.float = "right"
                document.getElementById("formsbttn" + newid).appendChild(bttnImgForms);
            }

        } else {
            panel.style.display = "block";
            parent.style.left = "0px";
            parent.style.top = "0px";
            parent.style.transform = "rotate(0deg)";
            if (parent.id === "filter-tab-content") {
                document.getElementById("filterbttn").innerHTML = "";
                document.getElementById("filterbttn").style.textAlign = "left";
                var bttnTxtFilter = document.createTextNode("Filters");
                document.getElementById("filterbttn").appendChild(bttnTxtFilter);
                var bttnImgFilter = document.createElement("IMG");
                bttnImgFilter.setAttribute("src", "/images/kfm.png");
                bttnImgFilter.style.width = "20px";
                bttnImgFilter.style.paddingLeft = "3px";
                bttnImgFilter.style.paddingRight = "3px";
                bttnImgFilter.style.float = "left"
                document.getElementById("filterbttn").appendChild(bttnImgFilter);
            }
            else {
                var newid = parent.id.replace('formstab-content', '')
                document.getElementById("formsbttn" + newid).style.textAlign = "left";
                document.getElementById("formsbttn" + newid).innerHTML = "";
                var bttnTxtForms = document.createTextNode("Forms");
                document.getElementById("formsbttn" + newid).appendChild(bttnTxtForms);
                var bttnImgForms = document.createElement("IMG");
                bttnImgForms.setAttribute("src", "/images/documents.png");
                bttnImgForms.style.width = "20px";
                bttnImgForms.style.paddingLeft = "3px";
                bttnImgForms.style.paddingRight = "3px";
                bttnImgForms.style.float = "left"
                document.getElementById("formsbttn" + newid).appendChild(bttnImgForms);
            }
        }
    });
}

function accordionRight(accountRight){
    accountRight.addEventListener("click", function() {
        this.classList.toggle("active");
        var parent = this.parentElement.parentElement;
        var subparent = this.parentElement;
        var panel = this.nextElementSibling;
        if (panel.style.display === "block") {
            panel.style.display = "none";
            parent.style.float = "right";
            parent.style.top = "85px";
            parent.style.left = "80px";
            parent.style.width = "200px";
            parent.style.transform = "rotate(-90deg)";
            var newid = parent.id.replace('profiletab-content', '')
            document.getElementById("profilebttn" + newid).innerHTML = "";
            document.getElementById("profilebttn" + newid).style.textAlign = "right";
            document.getElementById("profilebttn" + newid).style.width = "200px"
            var bttnTxtProfile = document.createTextNode("Show Patient Profile");
            document.getElementById("profilebttn" + newid).appendChild(bttnTxtProfile);
            var bttnImgProfile = document.createElement("IMG");
            bttnImgProfile.setAttribute("src", "/images/customer_info.png");
            bttnImgProfile.style.width = "20px";
            bttnImgProfile.style.paddingLeft = "3px";
            bttnImgProfile.style.float = "right"
            document.getElementById("profilebttn" + newid).appendChild(bttnImgProfile);
        } else {
            panel.style.display = "block";
            parent.style.left = "-10px";
            parent.style.top = "0px";
            parent.style.width = "70%";
            subparent.style.width = "100%";
            parent.style.transform = "rotate(0deg)";
            var newid = parent.id.replace('profiletab-content', '')
            document.getElementById("profilebttn" + newid).innerHTML = "";
            document.getElementById("profilebttn" + newid).style.textAlign = "left";
            document.getElementById("profilebttn" + newid).style.width = "100%";
            var bttnImgProfile = document.createElement("IMG");
            bttnImgProfile.setAttribute("src", "/images/customer_info.png");
            bttnImgProfile.style.width = "20px";
            bttnImgProfile.style.paddingLeft = "3px";
            bttnImgProfile.style.paddingRight = "3px";
            bttnImgProfile.style.float = "left";
            document.getElementById("profilebttn" + newid).appendChild(bttnImgProfile);
            var bttnTxtProfile = document.createTextNode("Patient Profile");
            document.getElementById("profilebttn" + newid).appendChild(bttnTxtProfile);

        }
    });
}
/*
for (j = 0; j < accleft.length; j++) {
  accleft[j].addEventListener("click", function() {
     this.classList.toggle("active");
     var parent = this.parentElement.parentElement;

     var panel = this.nextElementSibling;
     if (panel.style.display === "block") {
       panel.style.display = "none";
       parent.style.left = "-85px";
       parent.style.top = "85px";
       parent.style.transform = "rotate(-90deg)";
       document.getElementById("filter-button").style.textAlign = "right";
       document.getElementById("filter-button").innerHTML = "Show Filters";

     } else {
       panel.style.display = "block";
       parent.style.left = "5px";
       parent.style.top = "0px";
       parent.style.transform = "rotate(0deg)";
       document.getElementById("filter-button").style.textAlign = "left";
       document.getElementById("filter-button").innerHTML = "Filters";
     }
   });
}
*/

accordionLeft(document.getElementById("filterbttn"));
document.getElementById("filterbttn").click();