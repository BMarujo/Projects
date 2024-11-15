let errorBox = null;
window.onload = () => {
    const usernameInput       = document.getElementById("username");
    const passwordInput       = document.getElementById("password");
    const newPasswordInput    = document.getElementById("new-password");
    const repeatPasswordInput = document.getElementById("repeat-password");
    errorBox = document.getElementById("errorBox");

    usernameInput.addEventListener("keyup",       (e) => {if (e.key === "Enter") {change_password();}});
    passwordInput.addEventListener("keyup",       (e) => {if (e.key === "Enter") {change_password();}});
    newPasswordInput.addEventListener("keyup",    (e) => {if (e.key === "Enter") {change_password();}});
    repeatPasswordInput.addEventListener("keyup", (e) => {if (e.key === "Enter") {change_password();}});
}

function change_password() {
    let username = document.getElementById("username").value;
    let current_password = document.getElementById("password").value;
    let new_password = document.getElementById("new-password").value;
    let totp_key = document.getElementById("totp_key").value;

    if (new_password !== document.getElementById("repeat-password").value) {
        errorBox.innerText = "As palavras-passe nao são iguais.";
        return;
    }

    $.get("/profile/change_password", {"username": username, "password": current_password, "newPassword": new_password}).done((result) => {
        const data = JSON.parse(result);
        if (data["DONE"] === "NO") {
            // something went wrong so tell the user
            errorBox.innerText = data["ERROR"];
        } else {
            // everything is ok, get new token and redirect user to main page
            $.get("/totp/auth", {"username": username, "password": new_password, totp_key:totp_key}).done((data) => {
                const info = JSON.parse(data);
                if (info.authentication === "OK") {
                    setCookie("token", info.token);
                    window.location.pathname = "/collections";
                } else {
                    if (info.reason.length > 0) {
                        // password breach
                        errorBox.innerHTML = info.reason.replace(/\n/g, "<br />").replace("altere-a", "<a href='newPassword'>altere-a</a>");
                    } else {
                        errorBox.innerHTML = "Ocorreu um erro ao tentar contactar o servidor!";
                    }
                }
            });
        }
    });
}
