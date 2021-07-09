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
                window.localStorage.setItem("tip", response.typeOfTraining);
                window.localStorage.setItem("trajanje", response.length);
                window.localStorage.setItem("cena", response.price);
                window.localStorage.setItem("datum", response.trainingDay);

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

        let naziv = localStorage.getItem('naziv');
        let opis = localStorage.getItem('opis');
        let tip = localStorage.getItem('tip');
        let trajanje = localStorage.getItem('trajanje');
        let cena = localStorage.getItem('cena');
        let datum = localStorage.getItem('datum');

        let newCheck = {
            naziv,
            opis,
            tip,
            trajanje,
            cena,
            datum
        }

        console.log(localStorage.getItem('id'), localStorage.getItem('terms'))
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/api/training/addCheck/"+ localStorage.getItem('id') +"/"+ localStorage.getItem('terms'),
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(newCheck),
            success: function (response) {
                console.log(response);
                alert("Uspjesno!");
                window.location.href = "checkTraining.html"
            },
            error: function(response) {
                console.log("Error: \n", response);
                alert("Nije uspjesno!");
            }
        });
        window.location.href = "checkTraining.html";
    }
});