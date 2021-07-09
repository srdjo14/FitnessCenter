$(document).ready(function () {    // Čeka se trenutak kada je DOM(Document Object Model) učitan da bi JS mogao sa njim da manipuliše.
    // ajax poziv za dobavljanje svih zaposlenih sa backend-a i prikaz u tabeli
    var object = localStorage.getItem('id');
    var object1 = localStorage.getItem('username');
    $.ajax({
        type: "GET",                                                // HTTP metoda
        url: "http://localhost:8080/api/training/rate",                 // URL koji se gađa
        dataType: "json",                                           // tip povratne vrednosti
        success: function (response) {
            // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", response);                    // ispisujemo u konzoli povratnu vrednost radi provere

            for (let fitness of response) {                        // prolazimo kroz listu svih zaposlenih

                if(fitness.username === object1){
                    let row = "<tr>";                                   // kreiramo red za tabelu
                    row += "<td>" + object + "</td>";
                    row += "<td>" + fitness.username + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                    row += "<td>" + fitness.name + "</td>";
                    row += "<td>" + fitness.aboutTraining + "</td>";
                    row += "<td>" + fitness.typeOfTraining + "</td>";
                    row += "<td>" + fitness.grade + "</td>";
                    row += "</tr>";                                     // završavamo kreiranje reda

                    $('#trainings').append(row);     }                   // ubacujemo kreirani red u tabelu čiji je id = trainings
            }
        },
        error: function (response) {                                // ova f-ja se izvršava posle neuspešnog zahteva
            console.log("ERROR:\n", response);
        }
    });
});