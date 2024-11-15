// "html" body js
const slidePage = document.querySelector(".slide-page");
const nextBtnFirst = document.querySelector(".firstNext");
const prevBtnSec = document.querySelector(".prev-1");
const nextBtnSec = document.querySelector(".pay");
const progressText = document.querySelectorAll(".step p");
const progressCheck = document.querySelectorAll(".step .check");
const bullet = document.querySelectorAll(".step .bullet");
let current = 1;

nextBtnFirst.addEventListener("click", function (event) {
    event.preventDefault();
    slidePage.style.marginLeft = "-25%";
    bullet[current - 1].classList.add("active");
    progressCheck[current - 1].classList.add("active");
    progressText[current - 1].classList.add("active");
    current += 1;
});

nextBtnSec.addEventListener("click", function (event) {
    // Obter o estado da checkbox pelo ID
    let checkboxElement = document.getElementById("minhaCheckbox");

    // Verificar se a checkbox está marcada
    if (checkboxElement.checked) {
        event.preventDefault();
        slidePage.style.marginLeft = "-50%";
        bullet[current - 1].classList.add("active");
        progressCheck[current - 1].classList.add("active");
        progressText[current - 1].classList.add("active");
        current += 1;
        //entrega de recibo e mostra-lo na pagina (com opção de download)
        payandremove();
    } else {
        alert("Por favor, aceite os Termos e Condições.");
    }
});

prevBtnSec.addEventListener("click", function (event) {
    event.preventDefault();
    slidePage.style.marginLeft = "0%";
    bullet[current - 2].classList.remove("active");
    progressCheck[current - 2].classList.remove("active");
    progressText[current - 2].classList.remove("active");
    current -= 1;
});

// Get All Receipt User Input Details From the Html Form
function getReceiptDetails() {
    let ReceiptDetails = {
        "name": document.getElementById("name").value,  // First Name
        "surname": document.getElementById("lname").value,  // Last Name
        "address": document.getElementById("address").value,  // Address
        "pcode": document.getElementById("pcode").value,    // Postal Code
        "toci": document.getElementById("ToCi").value,  // Town or City
        "core": document.getElementById("CoRe").value,  // Country or Region
        "email": document.getElementById("email").value,  // Email
        "phone": document.getElementById("phone").value,  // Phone Number
        "cowner": document.getElementById("COwner").value,  // Card Owner
        "cnumber": document.getElementById("CNumber").value,  // Card Number
        "cmonth": document.getElementById("month").value,  // Card Expiration Date
        "cyear": document.getElementById("year").value,   // Card Expiration Date
        "cvv": document.getElementById("CVV").value  // Card CVV
    }

    return ReceiptDetails;
}

// TER EM ATENÇÃO O PREÇO TOTAL
// NECESSÁRIO TESTAR COM O CART DO UTILIZADOR, DE MODO A VERIFICAR SE FICA CLEAN

function payandremove() {
    let ReceiptDetails = getReceiptDetails();
    //console.log(ReceiptDetails);
    valid = verifyReceiptDetails(ReceiptDetails);
    let ReceiptContainer = document.getElementById("RECEIPT_CONTAINER");
    if (valid) {
        console.log("Valid Receipt Details");

        let ReceiptBaseTemplate = String.raw`
                                    <div style="box-shadow: 0 0 1in -0.25in rgba(0, 0, 0, 0.5);
                                    padding:2mm;
                                    margin: 0 auto;
                                    width: 100mm;
                                    background: #fff;">

                                <center style="border-bottom: 1px solid #EEE;min-height: 100px;">
                                      <div style="
                                      height: 60px;
                                      width: 60px;
                                      background-size: 60px 60px;"><img src="../img/html/icon.ico" style="width:100%;"</img></div>
                                      <div style="display: block;
                                      margin-left: 0;"> 
                                          <h2 style="font-size: .9em;color:#000;">DetInventory</h2>
                                      </div>
                                </center>
                                
                                <div style="border-bottom: 1px solid #EEE;min-height: 80px;">
                                <div style="display: block;
                                margin-left: 0;">
                                      <br>
                                      <h2 style="font-size: .9em;color:#000; text-align:left"><strong>Info de Contacto<strong></h2>
                                      <p style="font-size: .7em;
                                      color: #666;
                                      line-height: 1.2em; text-align:left"> 
                                        <strong>Morada:</strong> CUSTOMER_ADDRESS<br>
                                        <strong>Código Postal:</strong> CUSTOMER_PCODE<br>
                                        <strong>Vila ou Cidade:</strong> CUSTOMER_TOCI<br>
                                        <strong>País ou Região:</strong> CUSTOMER_CORE<br>
                                        <strong>Nome:</strong> CUSTOMER_NAME<br>
                                        <strong>Sobrenome:</strong> CUSTOMER_SURNAME<br>
                                        <strong>Email:</strong> CUSTOMER_EMAIL<br>
                                        <strong>Telefone:</strong> CUSTOMER_PHONE<br>
                                      </p>
                                </div>
                                </div>

                                <div style="border-bottom: 1px solid #EEE;min-height: 80px;">
                                <div style="display: block;
                                margin-left: 0;">
                                      <br>
                                      <h2 style="font-size: .9em;color:#000; text-align:left"><strong>Info de Pagamento<strong></h2>
                                      <p style="font-size: .7em;
                                      color: #666;
                                      line-height: 1.2em; text-align:left"> 
                                        <strong>Método de Pagamento:</strong> 
                                        Cartão de Crédito | CUSTOMER_CNUMBER | Exp.: CUSTOMER_CMONTH / CUSTOMER_CYEAR <br>
                                      </p>
                                </div>
                                </div>
                                
                                <div style="border-bottom: 1px solid #EEE;min-height: 50px;">
                                  <div style="display: block;
                                  margin-left: 0;">
                                        <br>
                                        <h2 style="font-size: .9em;color:#000; text-align:left"><strong>Info do Pedido<strong></h2>
                                  </div>
                                </div>    

                                <div style="border-bottom: 1px solid #EEE;min-height: 50px;">

                                                  <div style="width: 100%;
                                border-collapse: collapse;">
                                                      <table style="margin-left: auto;
                                                      margin-right: auto;width: 100%">
                                                        <tr style="
                                                        font-size: .5em;
                                                        background: #EEE;">
                                                              <td style="border: 0.5px solid #000;width: 24mm;" ><h2 style="font-size: .9em;color:#000;">Item</h2></td>
                                                              <td style="border: 0.5px solid #000;" ><h2 style="font-size: .9em;color:#000;">Qty</h2></td>
                                                              <td style="border: 0.5px solid #000;" ><h2 style="font-size: .9em;color:#000;">Sub Total</h2></td>
                                                        </tr>

                                                        PRODUCTS

                                                        <tr style="
                                                        font-size: .5em;
                                                        background: #EEE;">
                                                              <td style="background: #fff"></td>
                                                              <td style="border: 0.5px solid #000;" ><h2 style="font-size: .9em;color:#000;">Tax</h2></td>
                                                              <td style="border: 0.5px solid #000;" ><h2 style="font-size: .9em;color:#000;">$PRODUCTSTOTALTAX</h2></td>
                                                        </tr>

                                                        <tr style="
                                                        font-size: .5em;
                                                        background: #EEE;">
                                                              <td style="background: #fff"></td>
                                                              <td style="border: 0.5px solid #000;" ><h2 style="font-size: .9em;color:#000;">Total</h2></td>
                                                              <td style="border: 0.5px solid #000;" ><h2 style="font-size: .9em;color:#000;">$PRODUCTSTOTAL</h2></td>
                                                        </tr>

                                                        

                                                      </table>
                                                  </div>

                                                  <div style="margin-top: 5mm;">
                                                      <p style="font-size: .7em;
                                                      color:#000;
                                                      line-height: 1.2em;"><strong>Obrigado pela sua compra!</strong>   
                                                      </p>
                                                  </div>

                                            </div>
                                </div>
                                      </div>
                                      </div>
                                    </form>
                                </div>
                                </div>
                            `;
        let ReceiptProductTemplate = String.raw`
                              <tr style="border-bottom: 1px solid #EEE;">
                                  <td style="border: 1px solid #fff;border: 0.5px solid #000;" ><p style="font-size: .5em;
                                      color: #666;
                                      line-height: 1.2em;">PRODUCT_NAME</p></td>
                                  <td style="border: 1px solid #fff;border: 0.5px solid #000;" ><p style="font-size: .5em;
                                      color: #666;
                                      line-height: 1.2em;">PRODUCT_QUANTITY</p></td>
                                  <td style="border: 1px solid #fff;border: 0.5px solid #000;" ><p style="font-size: .5em;
                                      color: #666;
                                      line-height: 1.2em;">$PRODUCT_TPRICE</p></td>
                              </tr>
                              `;

        // Replace placeholders in the ReceiptBaseTemplate
        ReceiptBaseTemplate = ReceiptBaseTemplate.replace("CUSTOMER_NAME", ReceiptDetails.name);
        ReceiptBaseTemplate = ReceiptBaseTemplate.replace("CUSTOMER_SURNAME", ReceiptDetails.surname);
        ReceiptBaseTemplate = ReceiptBaseTemplate.replace("CUSTOMER_EMAIL", ReceiptDetails.email);
        ReceiptBaseTemplate = ReceiptBaseTemplate.replace("CUSTOMER_PHONE", ReceiptDetails.phone);
        ReceiptBaseTemplate = ReceiptBaseTemplate.replace("CUSTOMER_ADDRESS", ReceiptDetails.address);
        ReceiptBaseTemplate = ReceiptBaseTemplate.replace("CUSTOMER_PCODE", ReceiptDetails.pcode);
        ReceiptBaseTemplate = ReceiptBaseTemplate.replace("CUSTOMER_TOCI", ReceiptDetails.toci);
        ReceiptBaseTemplate = ReceiptBaseTemplate.replace("CUSTOMER_CORE", ReceiptDetails.core);
        ReceiptBaseTemplate = ReceiptBaseTemplate.replace("CUSTOMER_COWNER", ReceiptDetails.cowner);
        // last 4 digits of the card number
        ReceiptBaseTemplate = ReceiptBaseTemplate.replace("CUSTOMER_CNUMBER", ReceiptDetails.cnumber.slice(-4));
        ReceiptBaseTemplate = ReceiptBaseTemplate.replace("CUSTOMER_CMONTH", ReceiptDetails.cmonth);
        ReceiptBaseTemplate = ReceiptBaseTemplate.replace("CUSTOMER_CYEAR", ReceiptDetails.cyear);
        ReceiptBaseTemplate = ReceiptBaseTemplate.replace("CUSTOMER_CVV", ReceiptDetails.cvv);

        // ReceiptContainer.innerHTML = "<h6>HELLO IM HERE</h6>";
        const encryptedToken = window.encryptData(getCookie("token"));
        $.post({
            url:"/products/getUserProducts", 
            data:{"token": encryptedToken}
        }).done((data) => {
            info = JSON.parse(data);
            let RproductRow = "";
            let total = 0;
            let tax = 0;
            if (info.data.length === 0) {
                ReceiptContainer.innerHTML = String.raw`<h6>Nao existem produtos no seu carrinho.</h6>
                                      <div class="field btns">
                                          <button class="prev-2 prev">Anterior</button>
                                      </div>`;

                const prevBtnThird = document.querySelector(".prev-2");
                prevBtnThird.addEventListener("click", function (event) {
                    event.preventDefault();
                    slidePage.style.marginLeft = "-25%";
                    bullet[current - 2].classList.remove("active");
                    progressCheck[current - 2].classList.remove("active");
                    progressText[current - 2].classList.remove("active");
                    current -= 1;
                });

            } else {
                info.data.forEach(element => {
                    // element = [product_name, image_path, quantity, price,id]
                    RproductRow += ReceiptProductTemplate.replace("PRODUCT_NAME", element[0])
                        .replace("PRODUCT_QUANTITY", element[2])
                        .replace("PRODUCT_ID", element[4])
                        .replace("PRODUCT_TPRICE", element[3] * element[2]);

                    total += element[3] * element[2];
                });

                tax = total * 0.23;
                total += tax;
                tax = tax.toFixed(2);
                total = total.toFixed(2);
                ReceiptContainer.innerHTML = ReceiptBaseTemplate.replace("PRODUCTS", RproductRow).replace("PRODUCTSTOTALTAX", tax).replace("PRODUCTSTOTAL", total) + "</div>";
                addOrder(info.data);
                removealluserproducts();
            }
        }).fail(function () {
            console.log("Erro ao obter produtos do utilizador")
        });
    } else {
        console.log("Invalid Receipt Details");
        ReceiptContainer.innerHTML = String.raw`<h6>Por favor preencha todos os campos do recibo.</h6>
                                            <div class="field btns">
                                                <button class="prev-2 prev">Anterior</button>
                                            </div>`;
        const prevBtnThird = document.querySelector(".prev-2");
        prevBtnThird.addEventListener("click", function (event) {
            event.preventDefault();
            slidePage.style.marginLeft = "-25%";
            bullet[current - 2].classList.remove("active");
            progressCheck[current - 2].classList.remove("active");
            progressText[current - 2].classList.remove("active");
            current -= 1;
        });
    }
}

// Verify if the Receipt User Input Details are Valid
function verifyReceiptDetails(ReceiptDetails) {
    let valid = true;
    for (const [key, value] of Object.entries(ReceiptDetails)) {
        if (value === "") {
            valid = false;
            break;
        }
    }
    return valid;
}

function addOrder(data) {
    const encryptedToken = window.encryptData(getCookie("token"));
    $.post({
        url:"/orderHistory/addOrder", 
        data:{
            "token": encryptedToken,
            "data": JSON.stringify(data)
        }
    }).done((data) => {
        const info = JSON.parse(data);
        if (info["DONE"] === "YES") {
            console.log("Pedido adicionado ao historico de pedidos");
        }
    }).fail(function () {
        console.log("Erro ao adicionar pedido ao historico de pedidos")
    });
}

function removealluserproducts() {
    const encryptedToken = window.encryptData(getCookie("token"));
    $.post("/products/removeAllUserProducts", {
        "token": encryptedToken
    }).done((data) => {
        console.log("Produtos do utilizador removidos");
    }).fail(function () {
        console.log("Erro ao remover produtos do utilizador")
    });
}
