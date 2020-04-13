const API_URL = "http://localhost:8080/api";

/*
***Seite wird nach Laden vom Server abgerufen und angezeigt.
***Event-Handler Registrierung zum Anlegen eines neuen Parfums.
*/
window.addEventListener("load", async()=>{
    //Parfums abrufen + anzeigen
    let hersteller = await fetch(API_URL);
    hersteller= await hersteller.json();
})

/*
***Sendet GET-Request an Server, um Hersteller zu laden.
*/
async function getEntries(HerstellerName){
    //Erstellen der neuen URL
    let URL= API_URL + "/" + "hersteller";
    let hersteller = await fetch(URL, {
        method: "GET",
    })
    //Gepeicherten Eintrag anzeigen
    let herstellerEintraege = await hersteller.json();
    herstellerEintraege._embedded.hersteller.forEach(element => displayHersteller(element));
}

/*
***Ausgabe auf dem Display
*/
function displayHersteller(hersteller){
    let herstellerDiv= document.getElementById("entries");
    let label = document.createTextNode(hersteller.name);
    herstellerDiv.appendChild(label);
}