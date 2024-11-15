let totalSum = 0;
window.onload = () => {
    checkToken();
    showProducts();
    const closeModalButtons = document.querySelectorAll('[data-close-button]');
    closeModalButtons.forEach(button => {
        button.addEventListener('click', () => {
            const modal = button.closest('.modal2');
            closeModal(modal);
        })
    })
    
};
function showProducts() {
    const encryptedToken = window.encryptData(getCookie("token"));
    $.post({
        url:"/products/getUserProducts", 
        data:{"token": encryptedToken}
    }).done(function( data ) {
        info = JSON.parse(data)
        let productsContainer = document.getElementById("products-container");
        //console.log(productsContainer)
        if (info.data.length === 0) {
            productsContainer.innerHTML = "<h6>Nao existem produtos disponiveis.</h6>";
        } else {
            info.data.forEach(element => {
                const productRow = document.createElement("tr");
                // element = [product_name, image_path, quantity, price,id]
                const productName = element[0];
                const imagePath = element[1];
                const quantity = element[2];
                const price = element[3];
                const productId = element[4];
                const maxQuantity = element[5]+quantity;
                productRow.innerHTML = `
                    <td>
                        <div class="cart-info">
                            <img src="${imagePath}" alt="Product Image" class="img-fluid">
                            <p>${productName}</p>
                            <br>
                            <a href="#" onclick="removeProduct(${productId})" class="remove-product">Remove</a>
                        </div>
                    </td>
                    <td><input onchange="quantityChange(${quantity},${price},${productId},this)" type="number" value="${quantity}" data-product-id="${productId}" style="width: 60px;" min="1" max="${maxQuantity}"></td>
                    <td id="quantityInput">$${(price*quantity).toFixed(2)}</td>
                `;
                productsContainer.appendChild(productRow);
           
                // Update the total sum
                totalSum += price * quantity;                
            });

            productsContainer.innerHTML += ` 
            <div class="total">
            <table>
                <tr>
                    <td></td>
                    <td>Total</td>
                    <td id="totalSum"></td>
                </tr>
                <tr>
                    <td></td>
                    <td>Pagar</td>
                    <td><button data-modal-target="#modal2" onclick="openModal()" style="border-radius: 15px;" class="btn btn-outline-success tm-search-btn" type="button"><i class="fa-solid fa-tag"></i></button></td>
                </tr>
            </table>
        </div>`
        
        //<td><button onclick="redirectToCheckout()" style="border-radius: 15px;" class="btn btn-outline-success tm-search-btn" type="submit"><i class="fa-solid fa-tag"></i></button></td>
        // Display the total sum
        const totalSumElement = document.getElementById("totalSum");
        totalSumElement.textContent = "$" + totalSum.toFixed(2);
        }
    })
    .fail(function() {
        console.log("ocorreu um erro ao tentar comunicar com o servidor")
    });
}


document.addEventListener("input", function(event) {
    console.log("input");
    const input = event.target;
    if (input.tagName === "INPUT" && input.getAttribute("type") === "number") {
        const newValue = parseFloat(input.value);
        if (isNaN(newValue) || newValue < 1) {
            input.value = 1;
        }
    }
});

// Function to remove the product and update the database
function removeProduct(productId) {
    // Send an AJAX request to the server to remove the product and update the database
    console.log("removeProduct");
    const encryptedToken = window.encryptData(getCookie("token"));
    $.post({
        url:"/products/removeUserProduct", 
        data:{ "token": encryptedToken, "productId": productId }
    })
        .done(function (data) {
            console.log("Product removed successfully.");
            // Update the UI by removing the product row from the list
            const productRow = document.querySelector(`[data-product-id="${productId}"]`).closest('tr');
            productRow.remove();
            
            //update the total sum
            const sumElements = document.querySelectorAll("#quantityInput");
            totalSum = 0;
            sumElements.forEach(td => {
                totalSum += parseFloat(td.textContent.replace("$", ""));
            });
            const totalSumElement = document.querySelector("#totalSum");
            totalSumElement.textContent = "$" + totalSum.toFixed(2);
            location.reload();
        })
        .fail(function () {
            console.log("Failed to remove the product.");
        });
}

function quantityChange(oldQuantity,price,productId,input){ // this function will update the userProducts table with the new quantity of the product and will update the Products table with the new quantity of the product
    if(parseInt(input.value) > parseInt(input.max)){
        info.data.forEach(element => {
            if (element[4] === productId) {
                input.value = element[2];   // if the user tries to put a quantity bigger than the stock, the quantity will be the same as before. It won't change
            }
        });
        
        alert("Quantidade inválida, o stock é de " + input.max + " unidades");
        return;
    }

    $.get({
        url:"/products/getquantity", 
        data:{id: productId}
    }, function (response){
        console.log("quantityChange");
        let newQuantity = input.value;      // quantity is the new quantity that the user wants
        const quantity=response.quantity;
        
        if (quantity >= 0){
            console.log("newQuantity: " + newQuantity);
            info.data.forEach(element => {
                if (element[4] === productId) {
                    element[2] = newQuantity;
                }
            }); // update the quantity of the product in the info.data, which means, it is going to update element[2] of the product with id productId so that my math in the begining doesn't get messed up
            const encryptedToken = window.encryptData(getCookie("token"));
            $.post({
                url:"/products/updateUserQuantity", 
                data:{ "token": encryptedToken, "productId": productId, "quantity": newQuantity }
            })
                .done(function (data) {
                    if (data.data == "Quantidade Inválida"){
                        alert(data.data);
                    }
                    if (data.data == "Quantidade Atualizada"){
                        console.log(data.data);
                    }
                    console.log("Product updated successfully.");

                    // Update the UI by giving the new price of the product
                    const productRow = document.querySelector(`[data-product-id="${productId}"]`).closest('tr');
                    productRow.querySelector("#quantityInput").innerHTML = "$" + (price*newQuantity).toFixed(2);

                    // Update the UI by giving the new total price of the products
                    console.log("totalSum: " + totalSum);
                    console.log("oldQuantity: " + oldQuantity);
                    console.log("newQuantity: " + newQuantity);
                    const sumElements = document.querySelectorAll("#quantityInput");
                    totalSum = 0;
                    sumElements.forEach(td => {
                        totalSum += parseFloat(td.textContent.replace("$", ""));
                    });
                    const totalSumElement = document.querySelector("#totalSum");
                    totalSumElement.textContent = "$" + totalSum.toFixed(2);
                })
                .fail(function () {
                    console.log("Failed to update the quantity of the product.");
                });
        }
        else{
            alert("Quantidade inválida");
        }
    });
}


function openModal() {
    const modal = document.getElementById("modal2");
    if(modal == null) return;
    modal.classList.add('active');
    overlay.classList.add('active');
}

function closeModal(modal) {
    if(modal == null) return;
    modal.classList.remove('active');
    overlay.classList.remove('active');
}

function check(){
    const input = document.getElementById("pass");
    const encryptedToken = window.encryptData(getCookie("token"));
    $.post({
        url:"/users/reverification", 
        data:{"password": input.value, "token": encryptedToken}
    }).done(function( data ) {
        info = JSON.parse(data)
        if (info.DONE === "NO") {
            alert("Password incorreta");
        } else {
            const modal = document.getElementById("modal2");
            if(modal == null) return;
            modal.classList.remove('active');
            overlay.classList.remove('active');
            redirectToCheckout();
        }
    })
}