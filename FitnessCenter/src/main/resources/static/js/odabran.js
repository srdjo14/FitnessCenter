let kapacitet = 0;
$(document).ready(function () {

    let id = localStorage.getItem('terms');
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/user/odabran/"+id,
        dataType: "json",
        success: function (response) {

                window.localStorage.setItem("naziv", response.name);
                window.localStorage.setItem("opis", response.aboutTraining);

                let row = "<tr>";
                row += "<td>" + response.id + "</td>";
                row += "<td>" + response.name + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + response.aboutTraining + "</td>";
                row += "<td>" + response.typeOfTraining + "</td>";
                row += "<td>" + response.length + "</td>";
                row += "<td>" + response.price + "</td>";
                row += "<td>" + response.trainingDay + "</td>";
                row += "<td>" + "<button class='prijava' id=" + response.id + "> Prijava </button>" + "</td>";
                row += "</tr>";
                row += "</tr>";                                     // završavamo kreiranje reda
                kapacitet = response.capacity;
            $('#trainings').append(row);                        // ubacujemo kreirani red u tabelu čiji je id = trainings
            },

        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});

$(document).on('click', '.prijava', function myFunction(event) {
    event.preventDefault();
    if(kapacitet <= 0){
        alert("Nema mjesta!");
        window.location.href = "termini.html";
    }
    else {
        console.log(localStorage.getItem("ID"),localStorage.getItem("termin"));
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/api/termini/prijavaNaTrening/"+localStorage.getItem("ID")+"/"+ localStorage.getItem("termin"),
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(),
            success: function (response) {
                console.log(response);
                alert("Uspjesno!");
            },
            error: function(response) {
                console.log("Error: \n", response);
                alert("Nije uspjesno!");
            }
        });
        window.location.href = "korisnikTermin.html";
    }
});