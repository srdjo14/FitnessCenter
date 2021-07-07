// Login
$(document).on("submit", "#loginUser", function (event) {
    event.preventDefault();

    // preuzimamo vrednosti unete u formi
    let username = $("#username").val();
    let password = $("#password").val();

    // kreiramo objekat
    // nazivi svih atributa moraju se poklapati sa nazivima na backend-u
    let newUser = {
        username,
        password
    }

    console.log(newUser);
    $.ajax({
        type: "POST",                                               // HTTP metoda je POST
        url: "http://localhost:8080/api/user/login",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newUser),
        success: function (response) {

            window.localStorage.setItem("id", response.id);
            window.localStorage.setItem("uloga", response.position);
            if(response.position=="member"){
                window.location.href = "pocetnaUser.html";
                return;
            }
            if(response.position=="trainer"){
                window.location.href = "pocetnaTrener.html";
                return;
            }
            if(response.position=="admin"){
                window.location.href = "pocetnaAdmin.html";
                return;
            }

            window.location.href = "pocetna.html";
        },
        error: function () {                                        // ova f-ja se izvršava posle neuspešnog zahteva
            alert("Greška prilikom dodavanja zaposlenog!");
        }
    });
});

