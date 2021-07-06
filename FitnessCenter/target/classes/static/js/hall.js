// Pregled svih fitnes centara
$(document).ready(function () {    // Čeka se trenutak kada je DOM(Document Object Model) učitan da bi JS mogao sa njim da manipuliše.
    // ajax poziv za dobavljanje svih zaposlenih sa backend-a i prikaz u tabeli
    $.ajax({
        type: "GET",                                                // HTTP metoda
        url: "http://localhost:8080/api/fit-center/hall",                 // URL koji se gađa
        dataType: "json",                                           // tip povratne vrednosti
        success: function (response) {
            // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", response);                    // ispisujemo u konzoli povratnu vrednost radi provere

            for (let fitness of response) {                        // prolazimo kroz listu svih zaposlenih
                for (let hall of fitness.hallList) {
                    let row = "<tr>";                                   // kreiramo red za tabelu
                    row += "<td>" + fitness.naziv + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                    row += "<td>" + fitness.address + "</td>";
                    row += "<td>" + fitness.contactPhone + "</td>";
                    row += "<td>" + fitness.email + "</td>";

                    row += "<td>" + hall.capacity + "</td>";
                    row += "<td>" + hall.numberOfHall + "</td>";

                    btn = "<button class='btnDelete' data-id=" + fitness.id + ">Delete</button>";
                    row += "<td>" + btn + "</td>";
                    row += "</tr>";                                     // završavamo kreiranje reda

                    $('#trainings').append(row);                        // ubacujemo kreirani red u tabelu čiji je id = trainings
                }
            }
        },
        error: function (response) {                                // ova f-ja se izvršava posle neuspešnog zahteva
            console.log("ERROR:\n", response);
        }
    });
});

$(document).on('click', '.btnDelete', function () {
    let fitId = this.dataset.id;

    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/fit-center/hall/" + fitId,
        dataType: "json",
        success: function () {
            console.log("SUCCESS");
            $('[data-id="' + fitId + '"]').parent().parent().remove();  // ukloni red tabele u kom se nalazi element sa data-id atributom = employeeId
            alert("Obrisana sala!");
        },
        error: function () {
            alert("Greška prilikom brisanja zaposlenog!");
        }
    });
});