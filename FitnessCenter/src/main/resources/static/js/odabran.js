$(document).ready(function () {
    let id = localStorage.getItem('termin');
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/termini/getAllOdabraniTermini/"+id,
        dataType: "json",
        success: function (response) {
            let row = "<tr>";
            row += "<td>" + response.id + "</td>";
            row += "<td>" + response.naziv + "</td>";
            row += "<td>" + new Date( response.pocetak).toLocaleString() + "</td>";
            row += "<td>" + response.tip + "</td>";
            row += "<td>" + response.cijena + "</td>";
            row += "<td>" + response.oznaka + "</td>";
            row += "<td>" + response.opis + "</td>";

            row += "<td>" + "<button class='prijavi' id=" + response.id + ">Prijavi se</button>" + "</td>";
            row += "</tr>";
            kap = response.kapacitet;
            $('#korisnici tbody').append(row);

        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});