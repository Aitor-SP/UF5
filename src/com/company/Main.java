package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    //7 Crea un _Reference Method_i utilitza'l per imprimir totes les persones de la Collection amb foreach
    public static void imprimir(Persona p) {
        System.out.println("***************************");
        System.out.println(p);
        System.out.println("***************************");
    }

    public static void main(String[] args) {
        //1 Definir la variable format per instaciar els objectes del punt 2 (DateTimeFormatter)
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        //2 Crear
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

        //3 Crear un ArrayList d'aquestes persones (llistaPersones)
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

        //4 Canvia el següent codi per una expressió lambda:
        /*/
        Collections.sort(llistaPersones, new Comparator<Persona>() {
            @Override
            public int compare(Persona o1, Persona o2) {
                if(o1.getNom().charAt(0) >= o2.getNom().charAt(0)) return 1;
                else return -1;
            }
        });
         */
        Collections.sort(llistaPersones, (o1, o2) -> {
            if (o1.getNom().charAt(0) >= o2.getNom().charAt(0)) return 1;
            else return -1;
            });

        //5 Canvia el següent codi per una expressió lambda
        /*/
           for(Persona p: llistaPersones) {
            System.out.println(p);
           }
         */
        llistaPersones.forEach(persona -> System.out.println(persona));

        //6 Transforma la lambda en una classe anònima
        /*/
        //ordenació alfabètica inversa del nom
        llistaPersones.sort((o1,o2) -> o2.getNom().compareTo(o1.getNom()));
         */
        llistaPersones.sort(new Comparator<Persona>() {
            @Override
            public int compare(Persona o1, Persona o2) {
                return o2.getNom().compareTo(o1.getNom());
            }
        });

        //7 Crea un _Reference Method_i utilitza'l per imprimir totes les persones de la Collection amb foreach
        /*/
           //substituir pel foerech amb el reference method
            for(Persona p: llistaPersones) {
                System.out.println(p);
            }
         */
        llistaPersones.forEach(Main::imprimir);

        //8 Crea un Map de Persona on la key és l'edat i el value és quantes perones hi ha amb aquesta edat. Esbrina com fer els puts al map usant aquests mètodes computeIfPresent i putIfAbsent
        Map<Integer, Integer> mapPersones = new HashMap<>();
        for (Persona persona : llistaPersones) {
            if (mapPersones.containsKey(persona.getAge())){
                 mapPersones.putIfAbsent(persona.getAge(),1);
            } else {
                mapPersones.computeIfPresent(persona.getAge(),(key, valor) -> persona.getAge()+1);
            }
            System.out.println(llistaPersones);
        }

        /*/llistaPersones.forEach(persona -> {
            if (!mapPersones.containsKey(persona.getAge()))
                mapPersones.put(persona.getAge(),1);
            else
                mapPersones.put(persona.getAge(), mapPersones.get(persona.getAge()) + 1);
        });/*/

        llistaPersones.forEach(persona -> {
            mapPersones.computeIfPresent(persona.getAge(),(k,v) -> v + 1);
            mapPersones.putIfAbsent((persona.getAge()),1);
        });

        //9 Fes un recorregut per imprimir clau i valor del map, amb foreach i una lambda o reference method.
        mapPersones.forEach((k , v) -> {
            System.out.println("Clau: " + k + " - Valor: " + v);
        });

        //10 Treu un llistat de les persones DONA. Cal fer servir STREAM.
        llistaPersones.stream().filter(persona -> persona.getGenere().equals(Persona.Genere.DONA)).forEach(System.out::println);

        //11 Crea un List amb els menors de 25 (stream)
        llistaPersones.stream().filter(persona -> persona.getAge() < 25).forEach(System.out::println);

        //12 Llistat de Persones que tinguin una 'a' o 'A' al seu nom (stream)
        llistaPersones.stream().filter(persona -> persona.getNom().toUpperCase().contains("A")).forEach(System.out::println);

        //13 Treu un llistat dels 2 HOMES més joves. (stream)
        llistaPersones.stream().filter(persona -> persona.getGenere().equals(Persona.Genere.HOME))
                .sorted(Comparator.comparing(Persona::getAge))
                .limit(2)
                .forEach(System.out::println);

        //14 Esborrar del llistat les persones entre 30 i 40 anys (removeIf)
        llistaPersones.removeIf(persona -> persona.getAge() >= 30 && persona.getAge() <= 40);
        System.out.println(llistaPersones);

        //15 Sumar dos dias a todas las fechas de nacimiento a todos los de la lista
        llistaPersones.stream().map(persona -> persona.getDataNaixament().plusDays(2)).forEach(System.out::println);
    }
}
