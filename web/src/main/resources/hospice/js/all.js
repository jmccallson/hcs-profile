
var objAgent = navigator.userAgent;
var objbrowserName  = navigator.appName;
var objOffsetVersion;

// In Chrome
if ((objOffsetVersion = objAgent.indexOf("Chrome"))!=-1) {
    objbrowserName = "Chrome";
}

// In Firefox else
if ((objOffsetVersion = objAgent.indexOf("Firefox"))!=-1) {
    objbrowserName = "Firefox";
}

alert(objbrowserName)