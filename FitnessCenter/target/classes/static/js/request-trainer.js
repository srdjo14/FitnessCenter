// Pregled svih treninga
$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/trainer",
        dataType: "json",
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", response);

            for (let trainer of response) {
                let row = "<tr>";                                   // kreiramo red za tabelu
                row += "<td>" + trainer.firstName + "</td>";
                row += "<td>" + trainer.lastName + "</td>";
                row += "<td>" + trainer.username + "</td>";
                row += "<td>" + trainer.contact + "</td>"
                row += "<td>" + trainer.email + "</td>"
                row += "<td>" + trainer.active + "</td>"
                let btn = "<button class='btnSeeMore' data-id=" + trainer.id + ">Prihvati</button>";
                row += "<td>" + btn + "</td>";
                row += "</tr>";                                     // završavamo kreiranje reda

                $('#requests').append(row);
            }
        },
        error: function (response) {                                // ova f-ja se izvršava posle neuspešnog zahteva
            console.log("ERROR:\n", response);
        }
    });
});

$(document).ready(function () {
    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/api/trainer",
        dataType: "json",
        success: function(response){
            console.log("SUCCESS:\n", response);

            let log = document.getElementById('active');
            document.onclick = change;

            function change(){
                log.textContent = "true";
            }

        }
    })
});