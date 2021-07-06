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


$(document).ready(function () {    // Čeka se trenutak kada je DOM(Document Object Model) učitan da bi JS mogao sa njim da manipuliše.
    // ajax poziv za dobavljanje svih zaposlenih sa backend-a i prikaz u tabeli
    $.ajax({
        type: "GET",                                                // HTTP metoda
        url: "http://localhost:8080/api/trainer/list",                 // URL koji se gađa
        dataType: "json",                                           // tip povratne vrednosti
        success: function (response) {
            // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", response);                    // ispisujemo u konzoli povratnu vrednost radi provere

            for (let fitnesss of response) {                        // prolazimo kroz listu svih zaposlenih

                let row = "<tr>";                                // kreiramo red za tabelu
                row += "<td>" + fitnesss.firstName + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + fitnesss.lastName + "</td>";
                btn = "<button class='btnDel' data-id=" + fitnesss.id + ">Delete</button>";
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

$(document).on('click', '.btnDel', function () {

    // preuzimamo vrednosti unete u formi
    let idFc = this.dataset.id;

    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/trainer/delete/" + idFc,
        success: function (response) {
            console.log(response);
            $('[data-id="' + idFc + '"]').parent().parent().remove();
        },
        error: function () {
            console.log("usao sam u error");
            // window.location.href = "adminHomePage.html";
        }
    });
});



