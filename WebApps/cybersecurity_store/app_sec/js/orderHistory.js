window.onload = () => {
    checkToken();
    getOrderHistory();
};

function getOrderHistory() {
    let baseTemplate = String.raw`<div class="container-fluid tm-container-content tm-mt-60">
    <div class="row mb-4">
        <h2 class="col-6 tm-text-primary">
            O teu histórico de pedidos:
        </h2>
    </div>
    <div class="small-container cart-page">
        <table class="shop">
            <tr>
                <th>Produto</th>
                <th>Preço</th>
                <th></th>
            </tr>
            PRODUCTS
        </table>
    </div>`;

    let productTemplate = String.raw`<tr>
    <td>
        <div class="cart-info">
            <img src="IMG_PATH">
            <div>
                <p>PRODUCT_NAME</p>
                <small>Quantidade: PRODUCT_QUANTITY</small>
            </div>
        </div>
    </td>
    <td>$PRODUCT_PRICE</td>
    <td><a href="PRODUCT_URL" style="font-size: 18px;">Comprar</a></td>
    </tr>`;
    const encryptedToken = window.encryptData(getCookie("token"));
    $.post({
        url:"/orderHistory/getOrderHistory", 
        data:{"token": encryptedToken}
    }).done((data) => {
        let orderHistoryContainer = document.getElementById("ORDER_HISTORY");
        const info = JSON.parse(data);

        if (info["DONE"] === "YES") {
            let result = "";
            info["productsData"].forEach(element => {
                result += productTemplate.replace("IMG_PATH", element[0])
                                         .replace("PRODUCT_NAME", element[1])
                                         .replace("PRODUCT_QUANTITY", element[3])
                                         .replace("PRODUCT_PRICE", element[2])
                                         .replace("PRODUCT_URL", "/collections/productDetails?id=" + element[4]);
            });

            orderHistoryContainer.innerHTML = baseTemplate.replace("PRODUCTS", result) + "</div>";
        }
    })
    .fail(() => {});
}
