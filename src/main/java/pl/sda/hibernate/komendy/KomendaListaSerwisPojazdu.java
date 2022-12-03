package pl.sda.hibernate.komendy;

import pl.sda.hibernate.DataAccessObject;
import pl.sda.hibernate.model.Pojazd;
import pl.sda.hibernate.model.SerwisPojazdu;

import java.util.List;

public class KomendaListaSerwisPojazdu implements Komenda {
private DataAccessObject<SerwisPojazdu> dataAccessObject;

    public KomendaListaSerwisPojazdu() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "lista serwisow";
    }

    @Override
    public void obsluga() {
        List<SerwisPojazdu> serwisyPojazdow = dataAccessObject.findAll(SerwisPojazdu.class);
        serwisyPojazdow.forEach(System.out::println);
    }
}
