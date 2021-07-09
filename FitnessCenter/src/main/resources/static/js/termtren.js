var object = localStorage.getItem('uloga');
if(object == 'trainer') {

// Dodavanje novog zaposlenog
$(document).on("submit", "#addFitCentForm", function (event) {
    event.preventDefault();

    // Preuzimamo vrednosti unijete u formi
    let price = $("#name").val();
    let trainingDay = $("#about").val();
    let fitnessCenter = $("#tip").val();
    let hall = $("#duration").val();
    let training  = $("#price").val();
    let numberCheckedUser = $("#date").val();

    // Kreiramo objekat fitnes centra
    let newFitness = {
        price,
        trainingDay,
        fitnessCenter,
        hall,
        training,
        numberCheckedUser
    }

    // ajax poziv za kreiranje novog termina
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/user/termsSe",                 // URL na koji se šalju podaci
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newFitness),
        success: function (response) {                              // ova f-ja se izvršava posle uspješnog zahteva
            console.log(response);

            alert("Novi fitnes centar " + response.id + " je uspešno kreiran!");
            window.location.href = "termini.html";
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
