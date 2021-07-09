// Pregled svih treninga
$(document).ready(function () {    // Čeka se trenutak kada je DOM(Document Object Model) učitan da bi JS mogao sa njim da manipuliše.
    // ajax poziv za dobavljanje svih zaposlenih sa backend-a i prikaz u tabeli

        var object = localStorage.getItem('uloga');

        if(object == 'member') {
        $.ajax({
            type: "GET",                                                // HTTP metoda
            url: "http://localhost:8080/api/user/terms",                 // URL koji se gađa
            dataType: "json",                                           // tip povratne vrednosti
            success: function (response) {
                // ova f-ja se izvršava posle uspešnog zahteva
                console.log("SUCCESS:\n", response);                    // ispisujemo u konzoli povratnu vrednost radi provere


                for (let termin of response) {                        // prolazimo kroz listu svih zaposlenih

                    let row = "<tr>";
                    row += "<td>" + termin.id + "</td>";
                    row += "<td>" + termin.name + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                    row += "<td>" + termin.aboutTraining + "</td>";
                    row += "<td>" + termin.typeOfTraining + "</td>";
                    row += "<td>" + termin.length + "</td>";
                    row += "<td>" + termin.price + "</td>";
                    row += "<td>" + termin.trainingDay + "</td>";
                    btn = "<button class='Check' data-id=" + termin.id + "> Choose </button>";
                    row += "<td>" + btn + "</td>";
                    row += "</tr>";                                     // završavamo kreiranje reda

                    $('#trainings').append(row);                        // ubacujemo kreirani red u tabelu čiji je id = trainings

                }

            },
            error: function (response) {                                // ova f-ja se izvršava posle neuspešnog zahteva
                console.log("ERROR:\n", response);
            }
        });


    $(document).on('click', '.Check', function myFunction(event) {
        event.preventDefault();
        window.localStorage.setItem('terms', this.dataset.id);
        window.location.href = "termin-odabran.html";
    });

        } else {
            alert("Korisnik nema pristup ovoj stranici!");
            history.back();
        }
});





