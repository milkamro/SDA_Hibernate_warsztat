package pl.sda.hibernate.komendy;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.hibernate.DataAccessObject;
import pl.sda.hibernate.HibernateUtil;
import pl.sda.hibernate.model.Mechanik;
import pl.sda.hibernate.model.Pojazd;

public class KomendaDodajMechanika implements Komenda {

    private DataAccessObject<Mechanik> dataAccessObject;
    public KomendaDodajMechanika(){
        this.dataAccessObject = new DataAccessObject<>();
    }
    @Override
    public String getKomenda() {
        return "dodaj mechanika";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj imie mechanika:");
        String imie = Komenda.scanner.nextLine();

        System.out.println("Podaj kwalifikacje mechanika:");
        String kwalifikacje = Komenda.scanner.nextLine();

        System.out.println("Podaj specjalizacje:");
        String specjalizacje = Komenda.scanner.nextLine();

        Mechanik mechanik = Mechanik.builder()
                .imie(imie)
                .kwalifikacje(kwalifikacje)
                .specjalizacje(specjalizacje)
                .build();

        dataAccessObject.insert(mechanik);
    }
}
