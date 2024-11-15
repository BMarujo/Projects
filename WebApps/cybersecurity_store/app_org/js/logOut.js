function logOut() {
    if (getCookie("token") /*localStorage.token*/) {
        // check if token is valid
        $.post("/users/logOut", { token: getCookie("token") /*localStorage.token*/})
        .done(function( data ) {
            const info = JSON.parse(data)

            if (info.deleted === "YES") {
                // delete authentication token
                eraseCookie("token") //localStorage.removeItem("token");

                // return to login
                window.location.href = window.location.href.split("?")[0].replace("/collections/details", "/")
                                                                         .replace("/collections/imageDetails", "/");
            } else {
                console.log("ocorreu um erro ao tentar contactar o servidor");
            }
        })
        .fail(function() {
            errorBox.innerHTML = "Ocurreu um erro ao tentar contactar o servidor!";
        });
    }
}
