package pl.polsl.rafal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DBhandler dbhandler = new DBhandler();
        dbhandler.connectToDB();
        Scanner scn = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Wybierz operacje: utworz, dodaj, wyswietl, zakualizuj, usun, dropnij, wyjscie");
            String operation = scn.nextLine();

            switch (operation.toLowerCase()) {
                case "utworz":
                    dbhandler.createTable();
                    break;
                case "dodaj":
                    System.out.println("Podaj ID");
                    int id = getInt(scn);
                    System.out.println("Podaj imie:");
                    String name = scn.nextLine();
                    System.out.println("Podaj nazwisko:");
                    String surname = scn.nextLine();
                    System.out.println("Podaj kraj:");
                    String country = scn.nextLine();
                    System.out.println("Podaj wiek:");
                    int age = getInt(scn);
                    System.out.println("Podaj email:");
                    String email = scn.nextLine();
                    dbhandler.insertRecord(id, name, surname, country, age, email);
                    break;
                case "wyswietl":
                    dbhandler.selectFromDB();
                    break;
                case "zakualizuj":
                    System.out.println("Podaj id rekordu ktory zmieniasz:");
                    id = getInt(scn);
                    System.out.println("Podaj nowe imie:");
                    name = scn.nextLine();
                    System.out.println("Podaj nowe nazwisko:");
                    surname = scn.nextLine();
                    System.out.println("Podaj nowy kraj:");
                    country = scn.nextLine();
                    System.out.println("Podaj nowy wiek:");
                    age = getInt(scn);
                    System.out.println("Podaj nowy email:");
                    email = scn.nextLine();
                    dbhandler.updateRecord(id, name, surname, country, age, email);
                    break;
                case "usun":
                    System.out.println("Podaj id rekordu do usunięcia:");
                    id = getInt(scn);
                    dbhandler.deleteRecordById(id);
                    break;
                case "dropnij":
                    dbhandler.dropTable();
                    break;
                case "wyjscie":
                    running = false;
                    break;
                default:
                    System.out.println("Nieznana operacja!");
                    break;
            }
        }

        //dbhandler.createTable();

        //dbhandler.insertRecord(1, "Rafal","Graba", "Italy", 36,"zielony.banan@gmail.com");
        //dbhandler.insertRecord(2, "Raf","Gra", "New Zeland", 30,"zielona.malpa@gmail.com");
        //dbhandler.insertRecord(3, "Krzs","Graba", "Argentina", 6,"blue.moon@gmail.com");

        //dbhandler.selectFromDB();

        //dbhandler.updateRecord(2,"Emilia","Fast", "Mexico",34, "ala.ma.kota@exampl.com");

        //dbhandler.selectFromDB();

        //dbhandler.deleteRecordById(1);
        //dbhandler.deleteRecordById(2);
        //dbhandler.deleteRecordById(3);

        //dbhandler.selectFromDB();

        //dbhandler.dropTable();

        //dbhandler.selectFromDB();
    }


    private static int getInt(Scanner scn) {
        int value;
        while (true) {
            if (scn.hasNextInt()) {
                value = scn.nextInt();
                scn.nextLine();
                break;
            } else {
                System.out.println("Blad: Wprowadz liczbe calkowita.");
                scn.nextLine();
            }
        }
        return value;
    }
}
