// Pregled svih treninga
$(document).ready(function () {    // Čeka se trenutak kada je DOM(Document Object Model) učitan da bi JS mogao sa njim da manipuliše.
    // ajax poziv za dobavljanje svih zaposlenih sa backend-a i prikaz u tabeli
    $.ajax({
        type: "GET",                                                // HTTP metoda
        url: "http://localhost:8080/api/user/terms",                 // URL koji se gađa
        dataType: "json",                                           // tip povratne vrednosti
        success: function (response) {
            // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", response);                    // ispisujemo u konzoli povratnu vrednost radi provere

            for (let terms of response) {                        // prolazimo kroz listu svih zaposlenih
                    let row = "<tr>";
                    row += "<td>" + terms.id + "</td>";
                    row += "<td>" + terms.name + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                    row += "<td>" + terms.aboutTraining + "</td>";
                    row += "<td>" + terms.typeOfTraining + "</td>";
                    row += "<td>" + terms.length + "</td>";
                    row += "<td>" + terms.price + "</td>";
                    row += "<td>" + terms.trainingDay + "</td>";

                    row += "</tr>";                                     // završavamo kreiranje reda

                    $('#trainings').append(row);                        // ubacujemo kreirani red u tabelu čiji je id = trainings
                }

        },
        error: function (response) {                                // ova f-ja se izvršava posle neuspešnog zahteva
            console.log("ERROR:\n", response);
        }
    });
});

