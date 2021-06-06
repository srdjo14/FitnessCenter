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