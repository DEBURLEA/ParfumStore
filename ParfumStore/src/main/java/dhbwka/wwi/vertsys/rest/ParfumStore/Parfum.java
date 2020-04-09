package dhbwka.wwi.vertsys.rest.ParfumStore;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

//Persistence Entity eines Herstellers
@Entity
//Annotation, die Konstruktor, Getter und Setter Methoden erzeugt
@Data

/**
 * Einfache Entityklasse für ein Parfum
 */

public class Parfum implements Serializable{

    //Kennzeichnet Schlüssel der Klasse Parfum
    @Id
    //Id wird automatisch hochgezählt
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    //Feld darf beim Erzeugen nicht leer sein
    @NotNull
    private long pId;

    //definiert n:1 Beziehung zur Klasse Hersteller
    @ManyToOne
    private Hersteller hersteller;

    //Anlegen Datenbankfeld mit Länge 64
    @Column(length= 64)
    @NotNull(message="Der Name darf nicht leer sein")
    //Festlegen Minimal-/Maximallänge
    @Size(min=1, max=64, message="Der Name muss mindestens 1 und maximal 64 Zeichen haben")
    private String name;

    //Anlegen Datenbankfeld mit Länge 64
    @Column(length= 64)
    @NotNull(message="Es muss ein Preis definiert sein")
    private double preis;

    //Anlegen Datenbankfeld mit Länge 64
    @Column(length= 64)
    @NotNull(message="Es muss eine Größenangabe vorliegen")
    private int groesse;

    //Anlegen Datenbankfeld mit Länge 64
    @Column(length= 64)
    @NotNull(message="Die Beschreibung darf nicht leer sein")
    //Festlegen Minimal-/Maximallänge
    @Size(min=1, max=64, message="Die Beschreibung muss mindestens 1 und maximal 64 Zeichen haben")
    private String beschreibung;

    //Standard-Konstruktor
    public Parfum() {

    }
}