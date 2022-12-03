package pl.sda.hibernate.komendy;

import pl.sda.hibernate.DataAccessObject;
import pl.sda.hibernate.model.Pojazd;
import pl.sda.hibernate.model.SerwisPojazdu;

public class KomendaUsunSerwisPojazdu implements Komenda {
    private DataAccessObject<SerwisPojazdu> dataAccessObject;

    public KomendaUsunSerwisPojazdu() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "usun serwis";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id usuwanego serwisu:");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);

        if(dataAccessObject.delete(SerwisPojazdu.class, id)){
            System.out.println("Usunieto serwis");}
        else{
            System.err.println("nie udalo sie usunac serwisu");
        }
    }
}

