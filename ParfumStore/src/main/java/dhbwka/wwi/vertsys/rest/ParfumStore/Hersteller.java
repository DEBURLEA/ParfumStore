package dhbwka.wwi.vertsys.rest.ParfumStore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

//Persistence Entity eines Herstellers
@Entity
//Annotation, die Konstruktor, Getter und Setter Methoden erzeugt
@Data

/**
 * Einfache Entityklasse für einen Hersteller
 */

public class Hersteller implements Serializable{
    //Kennzeichnet Schlüssel der Klasse Hersteller
    @Id
    //Id wird automatisch hochgezählt
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @NotNull
    private long hId;

    //Anlegen Datenbankfeld mit Länge 64
    @Column(length= 64)
    //Festlegen Minimal-/Maximallänge
    @NotNull(message="Der Name darf nicht leer sein")
    @Size(min=1, max=64, message="Der Name muss mindestens 1 und maximal 64 Zeichen haben")
    private String name;

    //definiert 1:n Beziehung zur Klasse Parfum
    @OneToMany(mappedBy = "hersteller")
    List<Parfum> parfums = new ArrayList<>();

    //Standard-Konstruktor
    public Hersteller() {
    }

    private static final List<Hersteller> HERSTELLER_LIST = new ArrayList<>();

    /**
     * Hinzufügen eines neuen Eintrags
     * @param hersteller Zu speichernder Eintrag
     */
    public void addHersteller(Hersteller hersteller) {
        HERSTELLER_LIST.add(hersteller);
    }

    /**
     * Auslesen einer Liste aller Hersteller
     * @return Liste aller gespeicherten Hersteller
     */
    public List<Hersteller> getHersteller() {
        return HERSTELLER_LIST;
    }
}
