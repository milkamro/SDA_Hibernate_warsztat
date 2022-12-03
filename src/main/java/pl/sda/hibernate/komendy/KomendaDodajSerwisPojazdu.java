package pl.sda.hibernate.komendy;

import pl.sda.hibernate.DataAccessObject;
import pl.sda.hibernate.model.Mechanik;
import pl.sda.hibernate.model.Pojazd;
import pl.sda.hibernate.model.SerwisPojazdu;

import java.util.Optional;

public class KomendaDodajSerwisPojazdu implements Komenda {
    private DataAccessObject<SerwisPojazdu> dataAccessObject;
    private DataAccessObject<Pojazd> dataAccessObjectPojazd;
    private DataAccessObject<Mechanik> dataAccessObjectMechanik;

    public KomendaDodajSerwisPojazdu(){
        this.dataAccessObject = new DataAccessObject<>();
        this.dataAccessObjectPojazd = new DataAccessObject<>();
        this.dataAccessObjectMechanik = new DataAccessObject<>();
    }
     @Override
    public String getKomenda() {
        return "dodaj serwis";
    }

    @Override
    public void obsluga() {

        System.out.println("Podaj id serwisowanego pojazdu:");
        String idString = Komenda.scanner.nextLine();
        Long idPojazd = Long.parseLong(idString);

        Optional<Pojazd> pojazdOptional = dataAccessObjectPojazd.find(Pojazd.class, idPojazd);
        if (pojazdOptional.isEmpty()){
            System.err.println("Pojazd nie istnieje, nie mozna dodac zlecenia serwisowego");
            return;
        }

        System.out.println("Podaj id mechanika");
        String idStringM = Komenda.scanner.nextLine();
        Long idMechanik = Long.parseLong(idStringM);

        Optional<Mechanik> mechanikOptional = dataAccessObjectMechanik.find(Mechanik.class, idMechanik);
        if (mechanikOptional.isEmpty()){
            System.err.println("Mechanik nie istnieje, nie mozna dodac zlecenia serwisowego");
            return;
        }

        System.out.println("podaj opis serwisu (co jest do zrobienia):");
        String opis = Komenda.scanner.nextLine();

        SerwisPojazdu serwisPojazdu = SerwisPojazdu.builder()
                .pojazd(pojazdOptional.get())
                .mechanik(mechanikOptional.get())
                .opis(opis)
                .build();

        dataAccessObject.insert(serwisPojazdu);
        System.out.println("Dodano serwis");
    }
}
