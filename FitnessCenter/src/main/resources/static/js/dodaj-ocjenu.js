$(document).on("submit", "#reff", function (event) {
    event.preventDefault();

    // preuzimamo vrednosti unete u formi
    let grade = $("#ocjena").val();
    let member = localStorage.getItem('id');
    let terms = localStorage.getItem('done');

    let newFitnesCentar = {
        grade,
        member,
        terms
    }
    console.log(newFitnesCentar);


    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/training/rate/add",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newFitnesCentar),
        success: function (response) {
            console.log(response);

            alert("Uspjesno ocijenjeno!");
            window.location.href = "rate-training.html";
        },
        error: function () {
            alert("Greška prilikom ocjenjivanja!");
        }
    });
});