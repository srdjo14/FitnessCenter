// Pregled svih fitnes centara
$(document).ready(function () {    // Čeka se trenutak kada je DOM(Document Object Model) učitan da bi JS mogao sa njim da manipuliše.
    // ajax poziv za dobavljanje svih zaposlenih sa backend-a i prikaz u tabeli
    var object = localStorage.getItem('id');
    var object1 = localStorage.getItem('username');
    $.ajax({
        type: "GET",                                                // HTTP metoda
        url: "http://localhost:8080/api/training/done",                 // URL koji se gađa
        dataType: "json",                                           // tip povratne vrednosti
        success: function (response) {
            // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", response);                    // ispisujemo u konzoli povratnu vrednost radi provere

            for (let fitness of response) {                        // prolazimo kroz listu svih zaposlenih

                if(fitness.username === object1){
                    let row = "<tr>";                                   // kreiramo red za tabelu
                    row += "<td>" + object + "</td>";
                    row += "<td>" + fitness.username + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                    row += "<td>" + fitness.name + "</td>";
                    row += "<td>" + fitness.aboutTraining + "</td>";
                    row += "<td>" + fitness.typeOfTraining + "</td>";
                    row += "<td>" + fitness.trainingDay + "</td>";
                    if(fitness.grade >= 0){
                        let btn3 = "<form id='ocenjivanje'> <input type='hidden' value='" + fitness.id + "'> <input type='number' id='ocena'> <input type='submit' value='Oceni'> </form>"
                        row += "<td>" + btn3 + "</td>";
                    }
                    else{
                        row += "<td>" + fitness.grade + "</td>";
                    }
                    row += "</tr>";                                     // završavamo kreiranje reda

                    $('#trainings').append(row);     }                   // ubacujemo kreirani red u tabelu čiji je id = trainings
            }
        },
        error: function (response) {                                // ova f-ja se izvršava posle neuspešnog zahteva
            console.log("ERROR:\n", response);
        }
    });
});

$(document).on('submit','#ocenjivanje',function (e){
    e.preventDefault();

    var id = $(this).find('input:hidden').val();
    var ocena = $(this).find('#ocena').val();


    $.ajax({
        type: "GET",
        url:"http://localhost:8080/api/training/rate/?id="+id+"&grade="+ocena,
        dataType: "json",
        success: function (response){
            console.log("SUCCESS:\n",response);
            alert("Prijava je uspešno ocenjena.")
            location.reload();
        },
        error:function (response){
            console.log("ERROR:\n", response);
            alert("Zahtev nije uspešan.")
        }
    });
});