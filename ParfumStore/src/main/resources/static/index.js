const API_URL = "http://localhost:8080/api";

/**
 * Daten nach dem Laden der Seite vom Server abrufen und anzeigen. Ebenso
 * Event Handler zum Anlegen neuer Einträge registrieren.
 */
window.addEventListener("load", async () => {
    // Vorhandene Einträge abrufen und anzeigen
    let hersteller = await fetch(API_URL);
    hersteller = await hersteller.json();

    //Buttons
    let buttonHerstellerElement = document.getElementById("showHersteller");
    let buttonAddHerstellerElement = document.getElementById("addHersteller");

    //Event-Listener showHersteller
    buttonHerstellerElement.addEventListener("click", clickevent => {
        getEntries("");
        buttonHerstellerElement.style.display = "hidden";
        console.log("HerstellerShow geklickt");
    });

    //Event Listener addHersteller
    buttonAddHerstellerElement.addEventListener("click", e =>{
        showElements ();
        console.log("addHersteller geklickt");
    });
});


async function getEntries(HerstellerName) {
    let URL = API_URL + "/" + "hersteller";
    let hersteller = await fetch(URL, {
        method: "GET",
    });
    //Eintrag, der gespeichert wurde, anzeigen
    let herstellerEintraege = await hersteller.json();
    herstellerEintraege._embedded.hersteller.forEach(element => displayHersteller(element));
}

function displayHersteller(hersteller){
    let label = document.createTextNode(hersteller.name);
    label.appendChild(label);
}

async function showElements(){
    let input = document.getElementById("input-name");
    let name = input.value;
    if(name.trim() == "") return;
    input.value = "";

    let entry = await fetch(API_URL, {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({name: name})
    })

    displayHersteller(await hersteller.json());
}




