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

    $.ajax({
        type: "POST",                                               // HTTP metoda je POST
        url: "http://localhost:8080/api/user/login",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newUser),
        success: function (response) {
            console.log(response);

            alert("Uspesno ste se prijavili!");// prikazujemo poruku uspeha korisniku
            window.localStorage.setItem("ID", response.id);
            window.localStorage.setItem("ULOGA", response.position);
            window.location.href = "pocetna.html";
        },
        error: function () {                                        // ova f-ja se izvršava posle neuspešnog zahteva
            alert("Greška prilikom dodavanja zaposlenog!");
        }
    });
});

