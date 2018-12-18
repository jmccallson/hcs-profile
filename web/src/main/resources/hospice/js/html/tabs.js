/*
This is for building tabs :)
*/
var hcstabs = new Array();

function buildTab(objId){
  var currentSelected = document.getElementById(objId);
  var clientTab = document.createElement("BUTTON");
  clientTab.setAttribute("class", "tablink");
  clientTab.setAttribute("onclick", "openPage('patient" + objId + "', this, '#3377ff')");
  clientTab.setAttribute("id", "tabpatient" + objId);
  var patientsName = document.createTextNode(currentSelected.innerText);
  clientTab.appendChild(patientsName);
  document.getElementById("tabs").appendChild(clientTab);
  filterFunctionByNameR(currentSelected.innerText);
  hcstabs.push(clientTab.id);
  clientTab.click();
}

function openPage(pageName, elmnt, color) {
    // Hide all elements with class="tabcontent" by default */
    for (var i = 0; i < hcstabs.length; i++) {
        var str = hcstabs[i];
        if (pageName === str.slice(3, str.length)){
            //TODO: build the whole page
            if (pageName === "agent") {
            }
            else {
                tmpbtns = document.getElementsByClassName("accordion-left");
                var isCreated = false;
                for (var k = 0; k < tmpbtns.length; k++){
                    if (tmpbtns[k].id=== 'bttn' + pageName) {
                        isCreated = true;
                    }
                }

                if (!isCreated) {
                    buildTabContent(pageName);
                }
            }
        }
        else {
            document.getElementById(str.slice(3, str.length)).style.display = "none";
        }
    }

    var i, tablinks;

    // Remove the background color of all tablinks/buttons
    tablinks = document.getElementsByClassName("tablink");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].style.backgroundColor = "";
    }

    // Show the specific tab content
    document.getElementById(pageName).style.display = "block";

    // Add the specific color to the button used to open the tab content
    elmnt.style.backgroundColor = color;
}

function buildTabContent(patientId){
    var parentdiv = document.getElementById("container");
    var tabcontainerForms, tabcontentForms, formdivForms, bttnForms, pnFormsl;
    var tabcontainerProfile, tabcontentProfile, formdivProfile, bttnProfile, pnlProfile;

    try {
        /* forms section */
        tabcontainerForms = document.createElement("DIV");
        tabcontainerForms.setAttribute("class", "tab-container");
        tabcontainerForms.setAttribute("id", patientId);

        tabcontentForms = document.createElement("DIV");
        tabcontentForms.setAttribute("class", "tab-content");
        tabcontentForms.setAttribute("id", "formstab-content" + patientId);
        tabcontentForms.style.left = "-85px";
        tabcontentForms.style.top = "85px";
        tabcontentForms.style.transform = "rotate(-90deg)";
        tabcontainerForms.appendChild(tabcontentForms);

        formdivForms = document.createElement("DIV");
        formdivForms.setAttribute("class", "forms");
        formdivForms.setAttribute("id", "formsform-div" + patientId);
        tabcontentForms.appendChild(formdivForms);

        bttnForms = document.createElement("BUTTON");
        bttnForms.setAttribute("class", "accordion-right");
        bttnForms.setAttribute("id", "formsbttn" + patientId);
        var bttnTxtForms = document.createTextNode("Forms");
        bttnForms.appendChild(bttnTxtForms);
        formdivForms.appendChild(bttnForms);

        pnlForms = document.createElement("PANEL");
        pnlForms.setAttribute("class", "panel");
        pnlForms.setAttribute("id", "formspnl" + patientId);
        formdivForms.appendChild(pnlForms);

        /* profile section */
        tabcontentProfile = document.createElement("DIV");
        tabcontentProfile.setAttribute("class", "tab-content");
        tabcontentProfile.setAttribute("id", "profiletab-content" + patientId);
        tabcontentProfile.style.float = "right";
        tabcontentProfile.style.top = "85px";
        tabcontentProfile.style.left = "80px";
        tabcontentProfile.style.width = "200px";
        tabcontentProfile.style.transform = "rotate(-90deg)";
        tabcontainerForms.appendChild(tabcontentProfile);

        formdivProfile = document.createElement("DIV");
        formdivProfile.setAttribute("class", "profile");
        formdivProfile.setAttribute("id", "profile-div" + patientId);
        tabcontentProfile.appendChild(formdivProfile);

        bttnProfile = document.createElement("BUTTON");
        bttnProfile.setAttribute("class", "accordion-right");
        bttnProfile.setAttribute("id", "profilebttn" + patientId);
        var bttnTxtProfile = document.createTextNode("Patient Profile");
        bttnProfile.appendChild(bttnTxtProfile);
        formdivProfile.appendChild(bttnProfile);

        pnlProfile = document.createElement("PANEL");
        pnlProfile.setAttribute("class", "panel");
        pnlProfile.setAttribute("id", "profilepnl" + patientId);
        formdivProfile.appendChild(pnlProfile);

        parentdiv.appendChild(tabcontainerForms);

        accordionLeft(bttnForms);
        accordionRight(bttnProfile);
    } catch(ex){
        alert(ex.message)
    }
}

hcstabs.push("tabagent");
document.getElementById("tabagent").click();