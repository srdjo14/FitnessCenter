$(document).ready(function () {

    let id = localStorage.getItem('done');
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/training/done/"+id,
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
            let btn = "<input type='number' id='ocena'>";
            row += "<td>" + btn + "</td>";
            row += "<td>" + "<button class='ocena' id=" + response.id + "> Ocijeni </button>" + "</td>";
            row += "</tr>";
            row += "</tr>";                                     // završavamo kreiranje reda
            kapacitet = response.capacity;
            $('#trainings').append(row);                        // ubacujemo kreirani red u tabelu čiji je id = trainings
        },

        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });

    $(document).on('click', '.ocena', function (event){

        window.location.href = "dodaj-ocjenu.html";
    });
});