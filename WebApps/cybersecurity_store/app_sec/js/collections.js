window.onload = () => {
    checkToken();
    getCollectionsData();
};

function getCollectionsData() {
    possibleImgs = ["../img/html/img-03.jpg","../img/html/img-04.jpg","../img/html/img-05.jpg","../img/html/img-06.jpg","../img/html/img-01.jpg","../img/html/img-02.jpg","../img/html/img-07.jpg","../img/html/img-08.jpg","../img/html/img-09.jpg","../img/html/img-10.jpg","../img/html/img-11.jpg","../img/html/img-12.jpg","../img/html/img-13.jpg","../img/html/img-14.jpg","../img/html/img-15.jpg","../img/html/img-16.jpg"]

    // const random_index = Math.floor(Math.random() * possibleImgs.length);
    collectionTemplate = String.raw`<div class="col-xl-3 col-lg-4 col-md-6 col-sm-6 col-12 mb-5">
    <figure class="effect-ming tm-video-item">
        <img src="IMG_SOURCE" alt="Image" class="img-fluid">
        <figcaption class="d-flex align-items-center justify-content-center">
            <h2>COLLECTION_NAME</h2>
            <a href="/collections/details?id=COLLECTION_ID">View more</a>
        </figcaption>
    </figure>
    </div>`;

    imageTemplate = String.raw`<div class="col-xl-3 col-lg-4 col-md-6 col-sm-6 col-12 mb-5">
    <figure class="effect-ming tm-video-item">
        <img src="IMG_SOURCE" alt="Image" class="img-fluid">
        <figcaption class="d-flex align-items-center justify-content-center">
            <h2>IMAGE_NAME</h2>
        </figcaption>
    </figure>
    </div>`;
    const encryptedToken = window.encryptData(getCookie("token"));
    $.post({
        url:"/cromos/getImages", 
        data:{"token": encryptedToken}
    }).done(function( data ) {
        const info = JSON.parse(data)
        let imageContainer = document.getElementById("COLLECTIONS_CONTAINER");

        if (info.data.length === 0) {
            imageContainer.innerHTML = "<h6>Nao existem colecoes disponiveis.</h6>";
        } else {
            info.data.forEach(element => {
                console.log(element)
                imageContainer.innerHTML += imageTemplate.replace("IMAGE_NAME", "image")
                                                         .replace("IMG_SOURCE", element);
            });
        }
    })
    .fail(function() {
        console.log("Ocorreu um erro ao tentar comunicar com o servidor.");
    });
}
