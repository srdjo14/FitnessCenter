var object = localStorage.getItem('uloga');
if(object == 'admin') {
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
        url: "http://localhost:8080/api/fit-center/add",                 // URL na koji se šalju podaci
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

// Pregled svih fitnes centara
$(document).ready(function () {    // Čeka se trenutak kada je DOM(Document Object Model) učitan da bi JS mogao sa njim da manipuliše.
    // ajax poziv za dobavljanje svih zaposlenih sa backend-a i prikaz u tabeli
    $.ajax({
        type: "GET",                                                // HTTP metoda
        url: "http://localhost:8080/api/fit-center/fit",                 // URL koji se gađa
        dataType: "json",                                           // tip povratne vrednosti
        success: function (response) {
            // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", response);                    // ispisujemo u konzoli povratnu vrednost radi provere

            for (let fitness of response) {                        // prolazimo kroz listu svih zaposlenih

                    let row = "<tr>";                                   // kreiramo red za tabelu
                    row += "<td>" + fitness.naziv + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                    row += "<td>" + fitness.address + "</td>";
                    row += "<td>" + fitness.contactPhone + "</td>";
                    row += "<td>" + fitness.email + "</td>";
                btn = "<button class='btnDel' data-id=" + fitness.id + ">Delete</button>";
                row += "<td>" + btn + "</td>";
                    row += "</tr>";                                     // završavamo kreiranje reda

                    $('#trainings').append(row);                        // ubacujemo kreirani red u tabelu čiji je id = trainings
                }
        },
        error: function (response) {                                // ova f-ja se izvršava posle neuspešnog zahteva
            console.log("ERROR:\n", response);
        }
    });
});

$(document).on("submit", "#reg", function (event) {
    event.preventDefault();

    // Preuzimamo vrednosti unijete u formi
    let id = $("#id").val();
    let naziv = $("#ime").val();
    let address = $("#adresa").val();
    let contactPhone = $("#kontakt").val();
    let email = $("#email").val();

    // Kreiramo objekat fitnes centra
    let newFitnessCenter = {
        id,
        naziv,
        address,
        contactPhone,
        email
    }
    console.log(newFitnessCenter);


    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/api/fit-center/update/" + id,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newFitnessCenter),
        success: function (response) {
            console.log(response);

            alert("FitnesCentar" + response.id + " je uspešno updateovan!");
            window.location.href = "lista-fitnesa.html";
        },
        error: function () {
            alert("Greška prilikom updateovanja fitnes centra!");
        }
    });
});

$(document).on('click', '.btnDel', function () {

    // preuzimamo vrednosti unete u formi
    let idFc = this.dataset.id;


    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/fit-center/delete/"+ idFc,
        success: function (response) {
            console.log(response);

            $('[data-id="' + idFc + '"]').parent().parent().remove();
        },
        error: function () {
            console.log("Greska!");
            // window.location.href = "adminHomePage.html";
        }
    });
});

} else {
    alert("Korisnik nema pristupa ovoj stranici!");
    history.back();
}
