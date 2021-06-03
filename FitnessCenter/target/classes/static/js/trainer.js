// Kreiranje novog trenera
$(document).on("submit", "#addTrainerForm", function (event) {
    event.preventDefault();

    let email =     $("#email").val();
    let ime =       $("#name").val();
    let prezime =   $("#surname").val();
    let telefon =   $("#contact").val();
    let password =  $("#password").val();
    let username =  $("#username").val();
    let datum =     $("#birth").val();

    let newMember = {
        email,
        ime,
        telefon,
        prezime,
        password,
        username,
        datum,
        position: 1,
        aktivan: true
    }

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/trainer",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newMember),
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