
function checkToken () {
    if (getCookie("token")) {
        // check if token is valid
        const encryptedToken = window.encryptData(getCookie("token"));
        $.post({
            url:"/users/valid", 
            data:{ token: encryptedToken}
        })
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
            errorBox.innerHTML = "Ocorreu um erro ao tentar contactar o servidor!";
        });
    } else {
        // return to login
        window.location.pathname = '/'
    }
}
