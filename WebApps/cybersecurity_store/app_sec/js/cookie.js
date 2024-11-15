window.encryptData = function(data){
    const secretKey = CryptoJS.enc.Hex.parse("2b7e151628aed2a6abf7158809cf4f3c"); // Convert key to WordArray
  
    const encryptedData = CryptoJS.AES.encrypt(
      CryptoJS.enc.Utf8.parse(data),
      secretKey,
      { mode: CryptoJS.mode.ECB }
    ).toString();
  
    return encryptedData;
  }

function setCookie(name, value, days) {
    var expires = "";
    if (days) {
        var date = new Date();
        date.setTime(date.getTime() + (days*24*60*60*1000));
        expires = "; expires=" + date.toUTCString();
    }

    document.cookie = name + "=" + (value || "")  + expires + "; path=/";
    
}

function getCookie(name) {
    var nameEQ = name + "=";
    var ca = document.cookie.split(';');
    for(var i=0;i < ca.length;i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1,c.length);
        if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
    }

    return null;
}

function eraseCookie(name) {   
    document.cookie = name +'=; Path=/; Expires=Thu, 01 Jan 1970 00:00:01 GMT;';
}
