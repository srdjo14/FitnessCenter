// Pregled svih treninga
$(document).ready(function () {    // Čeka se trenutak kada je DOM(Document Object Model) učitan da bi JS mogao sa njim da manipuliše.
    // ajax poziv za dobavljanje svih zaposlenih sa backend-a i prikaz u tabeli
    $.ajax({
        type: "GET",                                                // HTTP metoda
        url: "http://localhost:8080/api/trainer",                 // URL koji se gađa
        dataType: "json",                                           // tip povratne vrednosti
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", response);                    // ispisujemo u konzoli povratnu vrednost radi provere

            for (let trainer of response) {                        // prolazimo kroz listu svih zaposlenih
                let row = "<tr>";                                   // kreiramo red za tabelu
                row += "<td>" + trainer.firstName + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + trainer.lastName + "</td>";
                row += "<td>" + trainer.username + "</td>";
                row += "<td>" + trainer.contact + "</td>"
                row += "<td>" + trainer.email + "</td>"
                row += "<td>" + trainer.active + "</td>"
                let btn = "<button class='btnSeeMore' data-id=" + trainer.id + ">Prihvati</button>";
                row += "<td>" + btn + "</td>";                      // ubacujemo button u poslednju ćeli
                row += "</tr>";                                     // završavamo kreiranje reda

                $('#requests').append(row);                        // ubacujemo kreirani red u tabelu čiji je id = trainings
            }
        },
        error: function (response) {                                // ova f-ja se izvršava posle neuspešnog zahteva
            console.log("ERROR:\n", response);
        }
    });
});