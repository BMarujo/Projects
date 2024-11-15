function logOut() {
    if (getCookie("token")) {
        // check if token is valid
        const encryptedToken = window.encryptData(getCookie("token"));
        $.post("/users/logOut", { token: encryptedToken})
        .done(function( data ) {
            const info = JSON.parse(data);

            if (info.deleted === "YES") {
                // delete authentication token
                eraseCookie("token");

                // return to login
                window.location.href = window.location.href.split("?")[0].replace("/collections/details", "/")
                                                                         .replace("/collections/imageDetails", "/");
            } else {
                console.log("Ocorreu um erro ao tentar contactar o servidor.");
            }
        })
        .fail(function() {
            errorBox.innerHTML = "Ocorreu um erro ao tentar contactar o servidor!";
        });
    }
}
