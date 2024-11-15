window.onload = () => {
    show_username();
    show_avatar();
    
};

function show_avatar() {
    $.get("/profile/show_avatar",{"token":getCookie("token")})
    .done(function(avatar){
        console.log(avatar);
        let avatarContainer = document.getElementById("avatar-image");
        avatarContainer.src = avatar.replaceAll('"', "");
    })
    .fail(function(){
        console.log("Failed to get image");
    });
    
}

function uploadAvatar() {
    const avatarInput = document.getElementById("avatar-input");
    const avatarFile = avatarInput.files[0]; // Get the selected file

    if (avatarFile) {
        const formData = new FormData();
        formData.append("newAvatar", avatarFile);

        $.ajax({
            url: "/profile/upload_avatar",
            type: "POST",
            headers: {"X-Filename": avatarFile.name},
            data: formData,
            processData: false,
            contentType: false,
            success: function (response) {
                // Handle the response from the server
                result = JSON.parse(response)
                console.log(result["success"]);
                if (result["success"] == "uploaded avatar") {
                    alert("Avatar upload successful.");
                    location.reload();
                } else {
                    alert("Avatar upload failed.");
                }
            },
            error: function () {
                // Handle errors, if any
                console.log("Error uploading.");
            },
        });
    }
}

/*
function updateAvatarImage(newAvatarPath) {
    const avatarImage = document.getElementById("avatar-image");
    console.log(newAvatarPath);
    avatarImage.src= newAvatarPath; // Set the source of the image to the new path
}
function displayImage(input){
    const avatarImage = document.getElementById("avatar-image");

    if (input.files && input.files[0]) {
        const reader = new FileReader();

        reader.onload = function (e) {
            avatarImage.src = e.target.result;
        };

        reader.readAsDataURL(input.files[0]);
    }
}*/

function show_username() {
    $.get("/profile/show_username",{"token":getCookie("token")})
    .done(function(username){
        console.log(username);
        let usernameContainer = document.getElementById("USERNAME");
        usernameContainer.value = username.replaceAll('"', "");
    })
    .fail(function(){
        console.log("Failed to get username");
    });
    
}

function change_username() {
    newusername = document.getElementById("USERNAME").value;
    console.log(newusername);
    $.get("/profile/change_username",{"token":getCookie("token"),"newUsername":newusername})
    .done(function(success){
        console.log(success);
        alert("Username changed!"); 
        show_username();
    })
    .fail(function(){
        alert("Failed to change username!")
    });
    
}

function change_password() {
    let CURRENT_PASSWORD = document.getElementById("CURRENT_PASSWORD").value;
    console.log("Current_password",CURRENT_PASSWORD);
    $.get("/profile/check_password",{"token":getCookie("token"),"password":CURRENT_PASSWORD})
    .done(function(success){
        console.log(success);
        if (success == '"wrong password"'){    // if password is incorrect terminate function, else continue
            alert("Incorrect password!");

            return;
        }
        else{
            let NEW_PASSWORD = document.getElementById("NEW_PASSWORD").value;
            let CONFIRM_PASSWORD = document.getElementById("CONFIRM_PASSWORD").value;
            if (NEW_PASSWORD != CONFIRM_PASSWORD){
                alert("Passwords do not match!");
                return;
            }
            $.get("/profile/change_password",{"token":getCookie("token"),"newPassword":NEW_PASSWORD})
            .done(function(success){
                result = JSON.parse(success);
                console.log(result);
                if (result["DONE"] == "YES"){
                    alert("Password changed!");
                }
                else {
                    alert(result["ERROR"]);
                }
               
            })
            .fail(function(){
                console.log("Failed to change password");
            });
        }
    })
    
}
