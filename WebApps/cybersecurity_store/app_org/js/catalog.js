let csrf_token = "";

$(document).ready(function() {
		info_products_list();
    }
);

function info_products_list() {

    $.get("/users/userid",{"token":getCookie("token")})
    .done(function(response){
        result = JSON.parse(response);
        if (result["id"] == 1) {
            var admindif=$("#admindif");
            var adminimage=$("<img>").attr("src","../img/admin.jpg").attr("alt","admin_logo").attr("id","admin_logo");
            admindif.append(adminimage);
        }
    });

    $.get("/catalog/show_products_info",{"token": getCookie("token")}, function(response) {
            // save csrf token
            if ("csrfToken" in response) {
                csrf_token = response["csrfToken"];
            }

            showinfo(response);
        }
    );
}

function showinfo(response) {
    products=$("#PRODUCTS_CONTAINER");
    for (var i=0; i<response.size; i++){
        var h=$("<img>").attr("src",response.path[i]).addClass("img-fluid").attr("id", response.id[i]);
        var h2=("Produto:  " + response.name[i]);
        var button = $("<button>").text("Comprar").on("click", createButtonClickHandler(response, i));
        var h3=(" Preço:  " + response.price[i] + "€");
        var h4=(" Quantidade:  " + response.quantity[i]);
        var figcaption = $(`<figcaption class='d-flex align-items-center justify-content-center'><h2>Detalhes</h2><a href="/collections/productDetails?id=${response["id"][i]}">View more</a></figcaption>`);
        var item = $("<div class='col-xl-3 col-lg-4 col-md-6 col-sm-6 col-12 mb-5'>");
        var figure = $("<figure class='effect-ming tm-video-item'>");
        figure.append(h);
        figure.append(figcaption);
        item.append(figure);
        item.append(h2);
        item.append("<br>");
        item.append(h3);
        item.append("<br>");
        item.append(h4);
        item.append("<br>");
        item.append(button);
        products.append(item);
    }
}

function search() {
    var word = document.getElementById("search-input").value;

    $.get("/catalog/search2",
        { word : word },
        function(response){
            extractValue(response);
        });
}

function extractValue(response) {
    products=$("#PRODUCTS_CONTAINER");
    products.empty();
    for (var i=0; i<response.size; i++){
        var h=$("<img>").attr("src",response.path[i]).addClass("img-fluid").attr("id", response.id[i]);
        var h2=("Produto:  " + response.name[i]);
        var button = $("<button>").text("Comprar").on("click", createButtonClickHandler(response, i));
        var h3=(" Preço:  " + response.price[i] + "€");
        var h4=(" Quantidade:  " + response.quantity[i]);
        var figcaption = $(`<figcaption class='d-flex align-items-center justify-content-center'><h2>Detalhes</h2><a href="/collections/productDetails?id=${response["id"][i]}">View more</a></figcaption>`);
        var item = $("<div class='col-xl-3 col-lg-4 col-md-6 col-sm-6 col-12 mb-5'>");
        var figure = $("<figure class='effect-ming tm-video-item'>");
        figure.append(h);
        figure.append(figcaption);
        item.append(figure);
        item.append(h2);
        item.append("<br>");
        item.append(h3);
        item.append("<br>");
        item.append(h4);
        item.append("<br>");
        item.append(button);
        products.append(item);
    }
}

function checkEnter(event) {
    if (event.key === "Enter") {
        search();
    }
}

function createButtonClickHandler(response, index) {
    if (response.quantity[index] === 0) {
        return function() {
            alert("Produto esgotado!");
        };
    }
    else{
        return function() {
            $.get("/catalog/buy", { idimag: response.id[index], token: getCookie("token"), csrfToken: csrf_token }, function (response) {
                refresh_quantity(response);
            });
        };
    }
}

function refresh_quantity(response) {
    search();
}
