

var expanded = false;

function showCheckboxes() {
  var checkboxes = document.getElementById("checkboxes");
  if (!expanded) {
    checkboxes.style.display = "block";
    expanded = true;
  } else {
    checkboxes.style.display = "none";
    expanded = false;
  }
}

function filterFunction() {
    var input, filter;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    filterFunctionByName(filter)
}

function filterFunctionByName(filterName) {
    var ul, li, a, i;
    div = document.getElementById("checkboxes");
    a = div.getElementsByTagName("span");
    img = div.getElementsByTagName("img");
    //inpt = div.getElementsByTagName("input");
    lbl = div.getElementsByTagName("label");
    for (i = 0; i < a.length; i++) {
        if (a[i].innerHTML.toUpperCase().indexOf(filterName.toUpperCase()) > -1) {
            a[i].style.display = "";
            img[i].style.display = "";
            //inpt[i].style.display = "";
            lbl[i].style.display = "";
        } else {
            a[i].style.display = "none";
            img[i].style.display = "none";
            //inpt[i].style.display = "none";
            lbl[i].style.display = "none";
        }
    }
}

function filterFunctionByNameR(filterName) {
    var ul, li, a, i;
    div = document.getElementById("checkboxes");
    a = div.getElementsByTagName("span");
    img = div.getElementsByTagName("img");
    //inpt = div.getElementsByTagName("input");
    lbl = div.getElementsByTagName("label");
    for (i = 0; i < a.length; i++) {
        if (a[i].innerHTML.toUpperCase() === filterName.toUpperCase()) {
            a[i].style.display = "none";
            img[i].style.display = "none";
            //inpt[i].style.display = "none";
            lbl[i].style.display = "none";
        }
    }
}