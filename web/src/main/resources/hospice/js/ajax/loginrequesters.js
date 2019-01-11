var url = "userprofile";

var profileUserEntity = {};
profileUserEntity.loginName = "John";
profileUserEntity.contactName  = "Snow";
var jsonValue = JSON.stringify(profileUserEntity);

var newUrl='/userprofile/123';

$(document).ready(function(){
    $("#cancelBtn").click(function () {
      deleteRequests(newUrl)

    });
});

function putRequests(uri, action2take){
    $.ajax({
        type : 'PUT',
        url : uri,
        data : jsonValue,
        beforeSend: function(xhr) {
            xhr.setRequestHeader("Accept", "application/json");
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.setRequestHeader("Authorization", "Bearer sessionId");
        },
        success: function(result){
           action2take();
        },
        error : function(e) {
            action2take();
            console.log("ERROR: ", e);
        }
    });
}

function postRequests(uri){
    $.ajax({
        type : 'POST',
        url : uri,
        data : jsonValue,
        beforeSend: function(xhr) {
            xhr.setRequestHeader("Accept", "application/json");
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.setRequestHeader("Authorization", "Bearer sessionId");
        },
        success: function(result){
           alert(result);
        },
        error : function(e) {
            alert("ERROR: ", e);
            console.log("ERROR: ", e);
        }
    });
}

function getRequests(uri){
    $.ajax({
        type : "GET",
        url : uri,
        contentType : 'application/json',
        headers : {'Authorization' : 'Bearer sessionId'},
        success: function(result){
           alert(result);
        },
        error : function(e) {
            alert("ERROR: ", e);
            console.log("ERROR: ", e);
        }
    });
}

function deleteRequests(uri){
    $.ajax({
        type : 'DELETE',
        url : uri,
        beforeSend: function(xhr) {
            xhr.setRequestHeader("Accept", "application/json");
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.setRequestHeader("Authorization", "Bearer sessionId");
        },
        success: function(result){
           alert(result);
        },
        error : function(e) {
            alert("ERROR: ", e);
            console.log("ERROR: ", e);
        }
    });
}
