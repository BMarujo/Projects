
window.onload = () => {
    checkToken();
    show_username();
    show_avatar();
};

function show_avatar() {
    const encryptedToken = window.encryptData(getCookie("token"));
    $.post({
        url:"/profile/show_avatar", 
        data: {"token": encryptedToken}
    }).done((avatar) => {
        // generate random string to append to end of avatar file url (forcing browser relaod of the image)
        let r = (Math.random() + 1).toString(36).substring(2);
        let avatarContainer = document.getElementById("avatar-image");
        avatarContainer.src = avatar.replaceAll('"', "") + "?" + r;
    }).fail(() => {
        console.log("Failed to get image");
    });
}

function uploadAvatar() {
    const avatarInput = document.getElementById("avatar-input");
    const avatarFile  = avatarInput.files[0]; // get the selected file

    if (avatarFile) {
        // check file size before upload
        const maxSizeInBytes = 5 * 1024 * 1024; // 5 MB
        if (avatarFile.size  > maxSizeInBytes) {
            alert("O ficheiro selecionado excede o tamanho máximo (5 MB). Por favor escolha outra imagem.");
            return;
        }

        const formData = new FormData();
        formData.append("newAvatar", avatarFile);

        $.ajax({
            url: "/profile/upload_avatar",
            type: "POST",
            headers: {"X-Filename": avatarFile.name},
            data: formData,
            processData: false,
            contentType: false,
            success: (response) => {
                // handle the response from the server
                const result = JSON.parse(response)
                if (result["DONE"] === "YES") {
                    alert("Upload do avatar foi feito com sucesso.");
                    show_avatar();
                } else {
                    alert(result["ERROR"]);
                }
            }, error: () => {
                // something went wrong
                alert("Upload do avatar foi feito com sucesso.");
            }
        });
    }
}

function show_username() {
    const encryptedToken = window.encryptData(getCookie("token"));

    $.post({
        url:"/profile/show_username", 
        data:{"token": encryptedToken}
    }).done((username) => {
        let usernameContainer = document.getElementById("USERNAME");
        usernameContainer.value = username.replaceAll('"', "");
    }).fail(() => {
        console.log("Failed to get username");
    });
}

function change_username() {
    const newusername = document.getElementById("USERNAME").value;
    const encryptedToken = window.encryptData(getCookie("token"));

    $.post({
        url:"/profile/change_username", 
        data:{"token": encryptedToken,"newUsername": newusername}
    }).done(() => {
        alert("Username alterado!");
        show_username();
    }).fail(() => {
        alert("Não foi possivel alterar o username!");
    });
}


  

function change_password() {
    let current_password = document.getElementById("CURRENT_PASSWORD").value;
    let new_password = document.getElementById("NEW_PASSWORD").value;

    if (new_password !== document.getElementById("CONFIRM_PASSWORD").value) {
        alert("As palavras-passe não são iguas.");
        return;
    }
    // Encrypt the new password before sending it

    const encryptedToken = window.encryptData(getCookie("token"));
    const encryptedCurrentPassword = window.encryptData(current_password);
    const encryptedNewPassword = window.encryptData(new_password);
    
    $.post( {
        url: "/profile/change_password",
        data: {
        "token": encryptedToken,
        "password": encryptedCurrentPassword,
        "newPassword": encryptedNewPassword
    }, 
    success: function(result) {
        const data = JSON.parse(result);
        if (data["DONE"] === "NO") {
            // something went wrong so tell the user
            alert(data["ERROR"]);
            return;
        } else {
            // everything is ok so tell the user
            alert("A palavra-passe foi alterado com sucesso!");
        }
    }
    });
    
}

function deletedata() {
    var r = confirm("Tem certeza de que pretende apagar a sua conta?");
    if (r == false) {
        return;
    }

    const encryptedToken = window.encryptData(getCookie("token"));
    if (getCookie("token")) {
        // check if token is valid
        $.post({
            url:"/profile/deleteAccount",
            data: { token: encryptedToken }
        })
            .done(function(data) {
                const info = JSON.parse(data)

                if (info.deleted === "YES") {
                    // delete authentication token
                    eraseCookie("token");

                    // return to login
                    window.location.href = window.location.href.split("?")[0].replace("/collections/details", "/")
                                                                             .replace("/collections/imageDetails", "/");
                } else {
                    console.log("Ocorreu um erro ao tentar contactar o servidor");
                }
            })
            .fail(function() {
                console.log("Ocorreu um erro ao tentar contactar o servidor");
            });
    }
}
