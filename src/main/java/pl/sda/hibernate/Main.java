package pl.sda.hibernate;

import pl.sda.hibernate.komendy.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Komenda> listaKomend = new ArrayList<>(
                List.of(
                        new KomendaDodajPojazd(),
                        new KomendaDodajMechanika(),
                        new KomendaListaPojazd(),
                        new KomendaListaMechanik(),
                        new KomendaListaSerwisPojazdu(),
                        new KomendaZnajdzPojazd(),
                        new KomendaZnajdzMechanik(),
                        new KomendaZnajdzSerwisPojazdu(),
                        new KomendaUsunPojazd(),
                        new KomendaUsunMechanik(),
                        new KomendaUsunSerwisPojazdu(),
                        new KomendaDodajSerwisPojazdu()
                )
        );

        System.out.println("Lista dostepnych komend:");
        listaKomend.forEach(komenda -> System.out.println(komenda.getKomenda()));

        System.out.println("Podaj komende");
        String komenda = Komenda.scanner.nextLine();
        for (Komenda dostepnaKomenda : listaKomend) {
            if (dostepnaKomenda.getKomenda().equalsIgnoreCase(komenda)) {
                dostepnaKomenda.obsluga();
            }
        }
    }
}
