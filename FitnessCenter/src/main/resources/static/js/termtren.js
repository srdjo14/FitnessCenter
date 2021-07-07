var object = localStorage.getItem('uloga');
if(object == 'trainer') {

// Dodavanje novog zaposlenog
$(document).on("submit", "#addFitCentForm", function (event) {
    event.preventDefault();

    // Preuzimamo vrednosti unijete u formi
    let naziv = $("#name").val();
    let about = $("#about").val();
    let tip = $("#tip").val();
    let duration = $("#duration").val();
    let price  = $("#price").val();
    let date = $("#date").val();

    // Kreiramo objekat fitnes centra
    let newFitnessCenter = {
        naziv,
        about,
        tip,
        duration,
        price,
        date
    }

    // ajax poziv za kreiranje novog termina
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/fit-center",                 // URL na koji se šalju podaci
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newFitnessCenter),
        success: function (response) {                              // ova f-ja se izvršava posle uspješnog zahteva
            console.log(response);

            alert("Novi fitnes centar " + response.id + " je uspešno kreiran!");
            window.location.href = "lista-fitnesa.html";
        },

        error: function () {                                        // ova f-ja se izvršava poslije neuspješnog zahteva
            alert("Greška prilikom dodavanja novog fitnes centra!");
        }
    });
});
} else {
    alert("Korisnik nema pristup ovoj stranici!");
    window.location.href = "index.html";
}
