package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Persona p1 = new Persona("Arya", Persona.Genere.DONA, LocalDate.parse("25/12/2002",format) );
        Persona p2 = new Persona("Tyrion", Persona.Genere.HOME, LocalDate.parse("12/10/1980",format));
        Persona p3 = new Persona("Cersei", Persona.Genere.DONA, LocalDate.parse("10/01/1984",format));
        Persona p4 = new Persona("Eddard", Persona.Genere.HOME, LocalDate.parse("24/04/1974",format));
        Persona p5 = new Persona("Sansa", Persona.Genere.DONA, LocalDate.parse("24/04/1992",format));
        Persona p6 = new Persona("Jaime", Persona.Genere.HOME, LocalDate.parse("24/04/1979",format));
        Persona p7 = new Persona("Khal", Persona.Genere.HOME, LocalDate.parse("10/08/1979",format));
        Persona p8 = new Persona("Daenerys", Persona.Genere.DONA, LocalDate.parse("12/11/1992",format));
        Persona p9 = new Persona("Davos", Persona.Genere.HOME, LocalDate.parse("12/11/1965",format));
        Persona p10 = new Persona("Jon Neu", Persona.Genere.HOME, LocalDate.parse("12/11/1986",format));
        Persona p11 = new Persona("Brienne", Persona.Genere.DONA, LocalDate.parse("12/11/1989",format));

        List<Persona> llistaPersones = new ArrayList<>();
        llistaPersones.add(p1);
        llistaPersones.add(p2);
        llistaPersones.add(p3);
        llistaPersones.add(p4);
        llistaPersones.add(p5);
        llistaPersones.add(p6);
        llistaPersones.add(p7);
        llistaPersones.add(p8);
        llistaPersones.add(p9);
        llistaPersones.add(p10);
        llistaPersones.add(p11);

        // 4
        Collections.sort(llistaPersones, (o1, o2) -> {
            if (o1.getNom().charAt(0) >= o2.getNom().charAt(0)) return 1;
            else return -1;
            });

        // 5
        llistaPersones.forEach(persona -> System.out.println(persona));

        //6
        llistaPersones.sort(new Comparator<Persona>() {
            @Override
            public int compare(Persona o1, Persona o2) {
                return o2.getNom().compareTo(o1.getNom());
            }
        });

        // 7
        //substituir pel foerech amb el reference method
        llistaPersones.forEach(System.out::println);

        //8

        //9

        //10

        //11

        //12
    }
}
