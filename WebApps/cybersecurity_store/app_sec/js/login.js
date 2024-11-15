window.onload = () => {
    const usernameInput = document.getElementById("username");
    const passwordInput = document.getElementById("password");

    usernameInput.addEventListener("keyup", (event) => {
        if (event.key === "Enter") {
            tryLogin();
        }
    });

    passwordInput.addEventListener("keyup", (event) => {
        if (event.key === "Enter") {
            tryLogin();
        }
    });
};

function tryLogin () {
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let checkboxElement = document.getElementById("minhaCheckbox");
    let errorBox = document.getElementById("errorBox");
    let totp_key = document.getElementById("totp_key").value;

    if (password === "" || username === "" || checkboxElement.checked === false || totp_key === ""){
        errorBox.innerHTML = "Por favor preencha todos os campos e aceite os termos e condições (caso não o tenha feito)!";
    } else {
        $.post("/totp/auth", { username: username, password: password, totp_key: totp_key })
        .done(function( data ) {
            const info = JSON.parse(data)

            if (info.authentication === "OK") {
                setCookie("token", info.token);
                window.location.pathname = '/collections';
            } else if (info.authentication === "INVALID") {
                if (info.reason.length > 0) {
                    // password breach
                    errorBox.innerHTML = info.reason.replace(/\n/g, "<br />").replace("altere-a", "<a href='newPassword'>altere-a</a>");
                } else {
                    // 'normal' error
                    errorBox.innerHTML = "Usuario ou password invalidos.";
                }
            }
        })
        .fail(function() {
            errorBox.innerHTML = "Ocorreu um erro ao tentar contactar o servidor!";
        });
    }
}
