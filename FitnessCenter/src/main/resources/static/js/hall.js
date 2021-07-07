var object = localStorage.getItem('uloga');
if(object == 'admin') {

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

                        btn = "<button class='btnDel' data-id=" + fitness.id + ">Delete</button>";
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

    $(document).on('click', '.btnDel', function () {

        // preuzimamo vrednosti unete u formi
        let idFc = this.dataset.id;

        $.ajax({
            type: "DELETE",
            url: "http://localhost:8080/api/hall/delete/" + idFc,
            success: function (response) {
                console.log(response);
                $('[data-id="' + idFc + '"]').parent().parent().remove();
            },
            error: function () {
                console.log("Greska!");
            }
        });
    });

    $(document).on("submit", "#reff", function (event) {
        event.preventDefault();

        // preuzimamo vrednosti unete u formi
        let capacity = $("#kapacitet").val();
        let numberOfHall = $("#oznaka").val();
        let fitnessCenterId = $("#idFCentra").val();


        let newFitnesCentar = {
            capacity,
            numberOfHall,
            fitnessCenterId
        }
        console.log(newFitnesCentar);


        $.ajax({
            type: "POST",
            url: "http://localhost:8080/api/hall/add",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(newFitnesCentar),
            success: function (response) {
                console.log(response);

                alert("Sala" + response.id + " je uspešno kreirana!");
                window.location.href = "hall.html";
            },
            error: function () {
                alert("Greška prilikom kreiranja Sale!");
            }
        });
    });

    $(document).on("submit", "#registracija", function (event) {
        event.preventDefault();

        // Preuzimamo vrednosti unijete u formi
        let id = $("#id").val();
        let capacity = $("#kapacitet").val();
        let numberOfHall = $("#oznaka").val();
        let fitnessCenterId = $("#idCentra").val();

        // Kreiramo objekat fitnes centra
        let newFitnessCenter = {
            capacity,
            numberOfHall,
            fitnessCenterId
        }
        console.log(newFitnessCenter);


        $.ajax({
            type: "PUT",
            url: "http://localhost:8080/api/hall/update/" + id,
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(newFitnessCenter),
            success: function (response) {
                console.log(response);

                alert("FitnesCentar" + response.id + " je uspešno updateovan!");
                window.location.href = "hall.html";
            },
            error: function () {
                alert("Greška prilikom updateovanja fitnes centra!");
            }
        });
    });

} else {
    alert("Korisnik nema pristupa ovoj stranici!");
    window.location.href = "index.html";
}