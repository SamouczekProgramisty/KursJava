package pl.samouczekprogramisty.kursjava.junit5.exchange;


import java.util.*;

    public class Currency {
        public static final String ADD_NAME = "1";
        public static final String EXIT = "-";


        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Set<String> nameSet = new HashSet<>();
            String name;
            String option;
            boolean input = true;
            while (input) {
                System.out.println("Wybierz opcje:\n\"1\" Dodaj imię do zbioru\n\"-\" Zakończ dodawanie imion i zamknij zbiór");
                option = sc.nextLine();
                switch (option) {
                    case ADD_NAME:
                        System.out.println("Wprowadź imię:");
                        name = sc.nextLine();
                        nameSet.add(name);
                        System.out.println("Dodano imię " + name + " do listy");
                        break;
                    case EXIT:
                        System.out.println("Zakończono dodawanie imion. Zbiór został zamknięty!");
                        input = false;
                        break;
                    default:
                        System.out.println("Błędny wybór, spróbuj jeszcze raz!");
                }

            }
            sc.close();
            System.out.println("Wprowadzono następujące imiona do zbioru:");
            int counter = 0;

            for (String item : nameSet) {
                counter++;
                System.out.println(counter + ". " + item);
            }
            System.out.println("Liczba imion w zbiorze: " + counter);
        }
    }
