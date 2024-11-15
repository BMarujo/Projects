window.onload = () => {
    checkToken();   // this needs to be here in order to get the function of encryption in cookie.js
    user_comment_input = document.getElementById("imageComment");
};

function addComment() {
    const product_id = new URLSearchParams(window.location.search).get('id');
    const comment_error_box = document.getElementById("comment_errorBox");
    const encryptedToken = window.encryptData(getCookie("token"));

    if (user_comment_input.value === "") {
        comment_error_box.innerHTML = "Por favor insira um comentario.";
    } else {
        $.post( {
            url: "/products/addComment",
            data: {"token": encryptedToken, "product_id": product_id, "comment": user_comment_input.value}, 
        
        success: function( _ ) {
            comment_error_box.innerHTML = "O comentario foi adicionado.";
            window.location.reload();
        }
        });
    }
}


function addToCart() {
    const product_id = new URLSearchParams(window.location.search).get('id');
    const encryptedToken = window.encryptData(getCookie("token"));

    if (document.getElementById("PRODUCT_QUANTITY").innerHTML == 0) {
        alert("Produto esgotado!");
    }
    else{
        $.post({
            url:"/catalog/buy", 
            data: {
            "idimag": product_id,
            "token": encryptedToken,
            "csrfToken": "NO_TOKEN"},
        success: function( _ ){
            // update product data for the user
            document.getElementById("PRODUCT_COMMENTS").innerHTML = '<h3 class="tm-text-gray-dark mb-3">Comentários</h3>';
            getProductData();
        }
        }).fail(() => {})
    }
}

function getProductData() {
    const product_id = new URLSearchParams(window.location.search).get('id');
    let comment_tamplate = String.raw`<p style="margin-left: 15px;">COMMENT</p>`;
    const encryptedToken = window.encryptData(getCookie("token"));

    $.post({
        url:"/products/getProductData", 
        data:{
            "token": encryptedToken,
            "product_id": product_id
        }
    }).done(function( data ) {
        const info = JSON.parse(data);

        if (info["DONE"] == "YES") {
            document.getElementById("PRODUCT_NAME").innerHTML = info["productData"][4];
            document.getElementById("PRODUCT_DESCRIPTION").innerHTML = info["productData"][2];
            document.getElementById("PRODUCT_PRICE").innerHTML = info["productData"][5] + "€";
            document.getElementById("PRODUCT_IMAGE").src = info["productData"][0];
            document.getElementById("PRODUCT_QUANTITY").innerHTML = info["productData"][3];

            // comments
            let comments_html_element = document.getElementById("PRODUCT_COMMENTS");
            if (info["productData"][1][0] === "") {
                comments_html_element.innerHTML += '<p style="margin-left: 15px;">Nao existem comentários disponiveis.</p>';
            } else {
                info["productData"][1].forEach(element => {
                    comments_html_element.innerHTML += comment_tamplate;
                    comments_html_element.lastElementChild.innerText = element;
                });
            }
        }
    })
    .fail(() => {});
}
