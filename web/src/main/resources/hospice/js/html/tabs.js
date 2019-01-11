/*
This is for building patient tabs :)
*/
var hcstabs = new Array();

/* clinician tab */
function buildClinicianTab(){
    try{
    var clientTab = document.createElement("BUTTON");
    clientTab.setAttribute("class", "tablink");
    clientTab.setAttribute("onclick", "openPage('agent', this, '#3377ff')");
    clientTab.setAttribute("id", "tabagent");
    //clientTab.style.height = "30px";
    var clientImgForms = document.createElement("IMG");
    clientImgForms.style.paddingRight = "3px";
    clientImgForms.style.float = "left"
    clientImgForms.setAttribute("src", "/images/clinician.png");
    clientImgForms.style.width = "16px";
    clientTab.appendChild(clientImgForms);
    var patientsName = document.createTextNode("Clinician");
    clientTab.appendChild(patientsName);
    document.getElementById("tabs").appendChild(clientTab);


    hcstabs.push("tabagent");
    clientTab.click();
    }
    catch(ex) {
        alert(ex.mesage)
    }
}

function buildClinicianTabContent() {
    var parentdiv = document.getElementById("container");
    var tabcontainer, tabcontentFilter, divFilter, bttnFilter, pnlFilter;
    try {
    tabcontainer = document.createElement("DIV");
    tabcontainer.setAttribute("class", "left-tab-container");
    tabcontainer.setAttribute("id", "agent");
    /* filter section */
    tabcontentFilter = document.createElement("DIV");
    tabcontentFilter.setAttribute("class", "left-tab-content");
    tabcontentFilter.setAttribute("id", "filter-tab-content");
    tabcontentFilter.style.left = "5px";
    tabcontentFilter.style.top = "0px";
    //tabcontentFilter.style.transform = "rotate(-90deg)";
    tabcontainer.appendChild(tabcontentFilter);

    divFilter = document.createElement("DIV");
    divFilter.setAttribute("class", "filter");
    divFilter.setAttribute("id", "filter-div");
    tabcontentFilter.appendChild(divFilter);

    bttnFilter = document.createElement("BUTTON");
    bttnFilter.setAttribute("class", "accordion-left");
    bttnFilter.setAttribute("id", "filterbttn");
    bttnFilter.style.textAlign = "left";
    bttnFilter.style.height = "30px";
    var bttnTxtFilter = document.createTextNode("Filters");
    bttnFilter.appendChild(bttnTxtFilter);
    var bttnImgFilter = document.createElement("IMG");
    bttnImgFilter.setAttribute("id", "imgfilterbttn");
    bttnImgFilter.setAttribute("src", "/images/kfm.png");
    bttnImgFilter.style.width = "24px";
    bttnImgFilter.style.paddingRight = "3px";
    bttnImgFilter.style.float = "left"
    bttnFilter.appendChild(bttnImgFilter);
    divFilter.appendChild(bttnFilter);

    pnlFilter = document.createElement("DIV");
    pnlFilter.setAttribute("class", "panel");
    pnlFilter.setAttribute("id", "filterpnl");
    pnlFilter.style.height = "300px";
    pnlFilter.style.margin = "0px";
    pnlFilter.style.padding = "0px";
    divFilter.appendChild(pnlFilter);

    var pnlDivFrom = document.createElement("DIV");
    pnlDivFrom.style.position = "absolute";
    pnlDivFrom.style.top = "35px";
    pnlDivFrom.style.left = "10px";
    pnlDivFrom.style.fontSize = "13px";
    pnlDivFrom.style.fontWeight = "bold";
    var pnlTxtFrom = document.createTextNode("From");
    pnlDivFrom.appendChild(pnlTxtFrom);
    var pnlInputFrom = document.createElement("INPUT");
    pnlInputFrom.style.position = "absolute";
    pnlInputFrom.style.left = "10px";
    pnlInputFrom.style.top = "60px";
    pnlInputFrom.style.width = "70px";
    pnlInputFrom.setAttribute("id", "filterfrom");

    var pnlDivFromToDash = document.createElement("DIV");
    pnlDivFromToDash.style.position = "absolute";
    pnlDivFromToDash.style.top = "62px";
    pnlDivFromToDash.style.left = "90px";
    pnlDivFromToDash.style.fontSize = "14px";
    pnlDivFromToDash.style.fontWeight = "bold";
    var pnlTxtFromToDash = document.createTextNode("-");
    pnlDivFromToDash.appendChild(pnlTxtFromToDash);

    var pnlDivTo = document.createElement("DIV");
    pnlDivTo.style.position = "absolute";
    pnlDivTo.style.top = "35px";
    pnlDivTo.style.left = "100px";
    pnlDivTo.style.fontSize = "13px";
    pnlDivTo.style.fontWeight = "bold";
    var pnlTxtTo = document.createTextNode("To");
    pnlDivTo.appendChild(pnlTxtTo);
    var pnlInputTo = document.createElement("INPUT");
    pnlInputTo.style.position = "absolute";
    pnlInputTo.style.left = "100px";
    pnlInputTo.style.top = "60px";
    pnlInputTo.style.width = "70px";
    pnlInputTo.setAttribute("id", "filterto");

    var pnlInputFromDate = document.createElement("INPUT");
    pnlInputFromDate.style.position = "absolute";
    pnlInputFromDate.style.left = "10px";
    pnlInputFromDate.style.top = "95px";
    pnlInputFromDate.setAttribute("name", "datefilter");
    pnlInputFromDate.setAttribute("type", "radio");

    var pnlDivFromDate = document.createElement("DIV");
    pnlDivFromDate.style.position = "absolute";
    pnlDivFromDate.style.top = "96px";
    pnlDivFromDate.style.left = "40px";
    pnlDivFromDate.style.fontSize = "13px";
    pnlDivFromDate.style.fontWeight = "bold";
    var pnlTxtFromDate = document.createTextNode("From Date");
    pnlDivFromDate.appendChild(pnlTxtFromDate);

    var pnlInputDateCreate = document.createElement("INPUT");
    pnlInputDateCreate.style.position = "absolute";
    pnlInputDateCreate.style.left = "10px";
    pnlInputDateCreate.style.top = "115px";
    pnlInputDateCreate.setAttribute("name", "datefilter");
    pnlInputDateCreate.setAttribute("type", "radio");

    var pnlDivDateCreate = document.createElement("DIV");
    pnlDivDateCreate.style.position = "absolute";
    pnlDivDateCreate.style.top = "116px";
    pnlDivDateCreate.style.left = "40px";
    pnlDivDateCreate.style.fontSize = "13px";
    pnlDivDateCreate.style.fontWeight = "bold";
    var pnlTxtDateCreate = document.createTextNode("Date Created");
    pnlDivDateCreate.appendChild(pnlTxtDateCreate);

    pnlFilter.appendChild(pnlDivFrom);
    pnlFilter.appendChild(pnlInputFrom);
    pnlFilter.appendChild(pnlDivFromToDash);
    pnlFilter.appendChild(pnlDivTo);
    pnlFilter.appendChild(pnlInputTo);
    pnlFilter.appendChild(pnlInputFromDate);
    pnlFilter.appendChild(pnlDivFromDate);
    pnlFilter.appendChild(pnlInputDateCreate);
    pnlFilter.appendChild(pnlDivDateCreate);

    parentdiv.appendChild(tabcontainer);
    }
    catch(ex) {
        alert(ex.message)
    }
}

function buildTab(objId, img){
    var checkboxes = document.getElementById("checkboxes");
    checkboxes.style.display = "none";
    expanded = false;
    var currentSelected = document.getElementById(objId);
    var clientTab = document.createElement("BUTTON");
    clientTab.setAttribute("class", "tablink");
    clientTab.setAttribute("onclick", "openPage('patient" + objId + "', this, '#3377ff')");
    clientTab.setAttribute("id", "tabpatient" + objId);
    //clientTab.style.height = "30px";
    var clientImgForms = document.createElement("IMG");
    clientImgForms.style.paddingRight = "3px";
    clientImgForms.style.float = "left"
    clientImgForms.setAttribute("src", img);
    clientImgForms.style.width = "16px";
    clientTab.appendChild(clientImgForms);
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
                buildClinicianTabContent();
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
    var tabcontainer, tabcontentForms, formdivForms, bttnForms, pnlForms;
    var tabcontainerProfile, tabcontentProfile, formdivProfile, bttnProfile, pnlProfile;

    try {
        tabcontainer = document.createElement("DIV");
        tabcontainer.setAttribute("class", "tab-container");
        tabcontainer.setAttribute("id", patientId);

        /* forms section */
        tabcontentForms = document.createElement("DIV");
        tabcontentForms.setAttribute("class", "tab-content");
        tabcontentForms.setAttribute("id", "formstab-content" + patientId);
        tabcontentForms.style.left = "-85px";
        tabcontentForms.style.top = "85px";
        tabcontentForms.style.transform = "rotate(-90deg)";
        tabcontentForms.style.zIndex = "4";
        tabcontainer.appendChild(tabcontentForms);

        formdivForms = document.createElement("DIV");
        formdivForms.setAttribute("class", "forms");
        formdivForms.setAttribute("id", "forms-div" + patientId);
        tabcontentForms.appendChild(formdivForms);

        bttnForms = document.createElement("BUTTON");
        bttnForms.setAttribute("class", "accordion-right");
        bttnForms.setAttribute("id", "formsbttn" + patientId);
        bttnForms.style.textAlign = "right";
        bttnForms.style.height = "30px";
        var bttnTxtForms = document.createTextNode("Show Forms");
        bttnForms.appendChild(bttnTxtForms);
        var bttnImgForms = document.createElement("IMG");
        bttnImgForms.setAttribute("id", "imgformsbttn" + patientId);
        bttnImgForms.setAttribute("src", "/images/documents.png");
        bttnImgForms.style.width = "24px";
        bttnImgForms.style.paddingLeft = "3px";
        bttnImgForms.style.float = "right"
        bttnForms.appendChild(bttnImgForms);
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
        tabcontentProfile.style.zIndex = "4";
        tabcontainer.appendChild(tabcontentProfile);

        profiledivProfile = document.createElement("DIV");
        profiledivProfile.setAttribute("class", "profile");
        profiledivProfile.setAttribute("id", "profile-div" + patientId);
        tabcontentProfile.appendChild(profiledivProfile);

        bttnProfile = document.createElement("BUTTON");
        bttnProfile.setAttribute("class", "accordion-right");
        bttnProfile.setAttribute("id", "profilebttn" + patientId);
        bttnProfile.style.textAlign = "right";
        bttnProfile.style.height = "30px";
        var bttnTxtProfile = document.createTextNode("Show Patient Profile");
        bttnProfile.appendChild(bttnTxtProfile);
        var bttnImgProfile = document.createElement("IMG");
        bttnImgProfile.setAttribute("id", "imgprofilebttn" + patientId);
        bttnImgProfile.setAttribute("src", "/images/customer_info.png");
        bttnImgProfile.style.width = "24px";
        bttnImgProfile.style.paddingLeft = "3px";
        bttnImgProfile.style.float = "right"
        bttnProfile.appendChild(bttnImgProfile);
        profiledivProfile.appendChild(bttnProfile);

        pnlProfile = document.createElement("PANEL");
        pnlProfile.setAttribute("class", "panel");
        pnlProfile.setAttribute("id", "profilepnl" + patientId);
        profiledivProfile.appendChild(pnlProfile);

        / *chart section */
        tabcontentChart = document.createElement("DIV");
        tabcontentChart.setAttribute("class", "tab-content");
        tabcontentChart.setAttribute("id", "charttab-content" + patientId);
        tabcontentChart.style.float = "right";
        tabcontentChart.style.top = "132px";
        tabcontentChart.style.left = "210px";
        tabcontentChart.style.width = "700px";
        tabcontentChart.style.float = "left";
        tabcontentChart.style.zIndex = "3";
        tabcontentChart.style.position = "fixed";
        tabcontainer.appendChild(tabcontentChart);

        chartdivChart = document.createElement("DIV");
        chartdivChart.setAttribute("class", "chart");
        chartdivChart.setAttribute("id", "chart-div" + patientId);
        tabcontentChart.appendChild(chartdivChart);

        bttnChart = document.createElement("BUTTON");
        bttnChart.setAttribute("class", "accordion-center");
        bttnChart.setAttribute("id", "chartbttn" + patientId);
        bttnChart.style.textAlign = "left";
        bttnChart.style.width = "700px";
        bttnChart.style.height = "30px";
        bttnChart.style.paddingTop = "5px";
        var bttnTxtChart = document.createTextNode("Chart");
        bttnChart.appendChild(bttnTxtChart);
        var bttnImgChart = document.createElement("IMG");
        bttnImgChart.setAttribute("id", "imgchartbttn" + patientId);
        bttnImgChart.setAttribute("src", "/images/folder_yellow.png");
        bttnImgChart.style.width = "24px";
        bttnImgChart.style.marginTop = "-6px";
        bttnImgChart.style.paddingLeft = "3px";
        bttnImgChart.style.paddingRight = "3px";
        bttnImgChart.style.float = "left"
        bttnImgChart.style.transform = "rotate(90deg)";
        bttnChart.appendChild(bttnImgChart);
        tabcontentChart.appendChild(bttnChart);

        parentdiv.appendChild(tabcontainer);

        accordionLeft(bttnForms);
        accordionRight(bttnProfile);
    } catch(ex){
        alert(ex.message)
    }
}

buildClinicianTab();


