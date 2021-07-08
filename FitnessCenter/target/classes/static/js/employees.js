// Prikaz detalja o odabranom zaposlenom
$(document).ready(function () {            // kada je kliknut button čija je klasa class = btnSeeMore
    let employeesDiv = $("#allEmployees");                      // dobavljamo element čiji je id = allEmployees  (pogledati html)
    employeesDiv.hide();                                        // sakrivamo taj element

    // this je referenca na HTML element koji predstavlja kliknuto dugme See More
    // dataset je kolekcija svih custom data atributa datog HTML elementa iz koje uzimamo id
    // više o data atributima na: https://css-tricks.com/a-complete-guide-to-data-attributes/
    let id = localStorage.getItem('id');

    // ajax poziv za dobavljanje traženog zaposlenog sa backend-a i prikaz na stranici
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/user/jedan/" + id ,
        dataType: "json",
        success: function (response) {                          // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", response);                // ispisujemo u konzoli povratnu vrednost radi provere

            $('#firstName').text(response.firstName);
            $('#lastName').text(response.lastName);
            $('#position').text(response.position);

            let employeeDiv = $("#oneEmployee");                // dobavljamo element čiji je id = oneEmployee
            employeeDiv.show();                                 // prikazujemo taj element
        },
        error: function (response) {                            // ova f-ja se izvršava posle neuspešnog zahteva
            console.log("ERROR:\n", response);
        }
    });
});