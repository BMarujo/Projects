function checkToken () {
    if (getCookie("token") /*localStorage.token*/) {
        // check if token is valid
        $.post("/users/valid", { token: getCookie("token") /*localStorage.token*/})
        .done(function( data ) {
            const info = JSON.parse(data)

            if (info.tokenIsValid === "VALID") {
                // get page content
            } else {
                // return to login
                window.location.href = window.location.origin;
            }
        })
        .fail(function() {
            errorBox.innerHTML = "Ocurreu um erro ao tentar contactar o servidor!";
        });
    } else {
        // return to login
        window.location.pathname = '/'
    }
}
