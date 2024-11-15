window.onload = () => {
    const usernameInput = document.getElementById("username");
    const passwordInput = document.getElementById("password");

    usernameInput.addEventListener("keyup", (event) => {
        if (event.key === "Enter") {
            tryRegister();
        }
    });

    passwordInput.addEventListener("keyup", (event) => {
        if (event.key === "Enter") {
            tryRegister();
        }
    });
};

function tryRegister() {
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let checkboxElement = document.getElementById("minhaCheckbox");
    let errorBox = document.getElementById("errorBox");

    if (username === "" || password === "" || checkboxElement.checked === false) {
        errorBox.innerHTML = "Por favor preencha todos os campos e aceite os termos e condições (caso não o tenha feito)!";
    } else {
        $.post("users/register", { username: username, password: password })
        .done(function( data ) {
            const info = JSON.parse(data)

            if (info["DONE"] === "YES") {
                setCookie("token", info.token);
                get_totp();
                
            } else {
                errorBox.innerHTML = info["ERROR"];
            }
        })
        .fail(function() {
            errorBox.innerHTML = "Ocorreu um erro ao tentar contactar o servidor!";
        });
    }
}

function get_totp() {
    let username = document.getElementById("username").value;
    $.post("totp/generate_totp", {
        "username": username
    }).done(function( data ) {

        prompt("Use este código na aplicação Google Authenticator, você precisará do código TOTP que aparece na aplicação para poder fazer o login! Depois de fechar esta caixa, ela nunca mais aparecerá!", data.totp);
        window.location.pathname = '/collections'; // change page

    })
    .fail(function() {
        document.getElementById("totp").innerHTML = "Ocorreu um erro ao tentar contactar o servidor!";
    });
}
