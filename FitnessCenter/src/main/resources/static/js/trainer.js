// Kreiranje novog clana
$(document).on("submit", "#addTrainerForm", function (event) {
    event.preventDefault();

    let email =     $("#email").val();
    let firstName =       $("#name").val();
    let lastName =   $("#surname").val();
    let contact =   $("#contact").val();
    let password =  $("#password").val();
    let username =  $("#username").val();
    let  birthDate =  $("#birth").val();

    let newTrainer = {
        email,
        firstName,
        contact,
        lastName,
        password,
        username,
        birthDate,
        active : true
    }

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/trainer",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newTrainer),
        success: function (response) {
            console.log("SUCCES S:\n", response);

            alert("Novi clan" + response.id + "je uspjesno kreiran!");
            window.location.href = "index.html";
        },
        error: function (){
            alert("Greska prilikom dodavanja!")
        }
    });
});
// Pregled svih treninga
$(document).ready(function () {    // Čeka se trenutak kada je DOM(Document Object Model) učitan da bi JS mogao sa njim da manipuliše.
    // ajax poziv za dobavljanje svih zaposlenih sa backend-a i prikaz u tabeli
    $.ajax({
        type: "GET",                                                // HTTP metoda
        url: "http://localhost:8080/api/trainer/list",                 // URL koji se gađa
        dataType: "json",                                           // tip povratne vrednosti
        success: function (response) {
            // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", response);                    // ispisujemo u konzoli povratnu vrednost radi provere

            for (let fitness of response) {                        // prolazimo kroz listu svih zaposlenih

                let row = "<tr>";                                   // kreiramo red za tabelu
                row += "<td>" + fitness.firstName + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + fitness.lastName + "</td>";
                btn = "<button class='btnDelete' data-id=" + fitness.id + ">Delete</button>";
                row += "<td>" + btn + "</td>";
                row += "</tr>";                                     // završavamo kreiranje reda

                $('#trainer').append(row);                        // ubacujemo kreirani red u tabelu čiji je id = trainings
            }
        },
        error: function (response) {                                // ova f-ja se izvršava posle neuspešnog zahteva
            console.log("ERROR:\n", response);
        }
    });
});
$(document).on('click', '.btnDelete', function () {
    let trainId = this.dataset.id;

    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/trainer/" + trainId,
        dataType: "json",
        success: function () {
            console.log("SUCCESS");
            $('[data-id="' + trainId + '"]').parent().parent().remove();  // ukloni red tabele u kom se nalazi element sa data-id atributom = employeeId
        },
        error: function () {
            alert("Greška prilikom brisanja zaposlenog!");
        }
    });
});
