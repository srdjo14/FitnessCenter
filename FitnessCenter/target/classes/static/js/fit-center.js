// Dodavanje novog zaposlenog
$(document).on("submit", "#addFitCentForm", function (event) {
    event.preventDefault();

    // Preuzimamo vrednosti unijete u formi
    let naziv = $("#Name").val();
    let address = $("#address").val();
    let contactPhone = $("#contact").val();
    let email = $("#email").val();


    // Kreiramo objekat fitnes centra
    let newFitnessCenter = {
        naziv,
        address,
        contactPhone,
        email
    }

    // ajax poziv za kreiranje novog fitnes centra
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/fit-center",                 // URL na koji se šalju podaci
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newFitnessCenter),
        success: function (response) {                              // ova f-ja se izvršava posle uspješnog zahteva
            console.log(response);

            alert("Novi fitnes centar " + response.id + " je uspešno kreiran!");
            window.location.href = "index.html";
        },

        error: function () {                                        // ova f-ja se izvršava poslije neuspješnog zahteva
            alert("Greška prilikom dodavanja novog fitnes centra!");
        }
    });
});