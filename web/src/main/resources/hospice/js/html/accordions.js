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
                document.getElementById("filter-button").style.textAlign = "right";
                document.getElementById("filter-button").innerHTML = "Show Filters";
            }
            else {
                var newid = parent.id.replace('formstab-content', '')
                document.getElementById("formsbttn" + newid).style.textAlign = "right";
                document.getElementById("formsbttn" + newid).innerHTML = "Show Forms";
            }

        } else {
            panel.style.display = "block";
            parent.style.left = "0px";
            parent.style.top = "0px";
            parent.style.transform = "rotate(0deg)";
            if (parent.id === "filter-tab-content") {
                document.getElementById("filter-button").style.textAlign = "left";
                document.getElementById("filter-button").innerHTML = "Filters";
            }
            else {
                var newid = parent.id.replace('formstab-content', '')
                document.getElementById("formsbttn" + newid).style.textAlign = "left";
                document.getElementById("formsbttn" + newid).innerHTML = "Forms";
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
            document.getElementById("profilebttn" + newid).style.textAlign = "right";
            document.getElementById("profilebttn" + newid).style.width = "200px"
            document.getElementById("profilebttn" + newid).innerHTML = "Show Patient Profile";

        } else {
            panel.style.display = "block";
            parent.style.left = "-10px";
            parent.style.top = "0px";
            parent.style.width = "70%";
            subparent.style.width = "100%";
            parent.style.transform = "rotate(0deg)";
            var newid = parent.id.replace('profiletab-content', '')
            document.getElementById("profilebttn" + newid).style.textAlign = "left";
            document.getElementById("profilebttn" + newid).style.width = "100%";
            document.getElementById("profilebttn" + newid).innerHTML = "Patient Profile";
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

accordionLeft(document.getElementById("filter-button"));
document.getElementById("filter-button").click();