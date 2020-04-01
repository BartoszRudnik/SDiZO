import java.util.Scanner;

public class oTablica {

    Tablica tablica = new Tablica();

    private boolean proces = true;

    Scanner scanner = new Scanner(System.in);

    public void operacjeTablica() {

        while (proces) {

            System.out.println("Podaj numer operacji, ktora chcesz wykonac");
            System.out.println("1. Dodaj wartosc na poczatek tablicy");
            System.out.println("2. Dodaj wartosc na koniec tablicy");
            System.out.println("3. Dodaj wartosc na wskazana pozycje");
            System.out.println("4. Usun z poczatku tablicy");
            System.out.println("5. Usun z konca tablicy");
            System.out.println("6. Usun z wybranego miejsca tablicy");
            System.out.println("7. Znajdz element z wybranej pozycji");
            System.out.println("8. Wyswietl zawartosc tablicy");
            System.out.println("9. Wczytaj dane z pliku tekstowego");
            System.out.println("10. Zapisz dane do pliku tekstowego");
            System.out.println("11. Najwiekszy element w tablicy");
            System.out.println("12. Najmniejszy element w tablicy");
            System.out.println("13. Wyczysc tablice");
            System.out.println("0. Cofnij do menu glownego");

            int nrOperacji = scanner.nextInt();

            System.out.println();

            int wartosc, index = 0;
            String nazwa;

            switch (nrOperacji) {

                case 0:
                    proces = false;
                    break;

                case 1:
                    System.out.print("Podaj wartosc liczby: ");
                    wartosc = scanner.nextInt();
                    tablica.dodajPoczatek(wartosc);
                    System.out.println();
                    break;

                case 2:
                    System.out.print("Podaj wartosc liczby: ");
                    wartosc = scanner.nextInt();
                    tablica.dodajKoniec(wartosc);
                    System.out.println();
                    break;

                case 3:
                    System.out.println("Podaj wartosc liczby: ");
                    wartosc = scanner.nextInt();
                    System.out.println("Podaj pozycje: ");
                    index = scanner.nextInt();
                    tablica.dodaj(index, wartosc);
                    System.out.println();
                    break;

                case 4:
                    tablica.usunPoczatek();
                    tablica.zmniejszTablice();
                    System.out.println();
                    break;

                case 5:
                    tablica.usunKoniec();
                    tablica.zmniejszTablice();
                    System.out.println();
                    break;

                case 6:
                    System.out.print("Podaj pozycje: ");
                    index = scanner.nextInt();
                    tablica.usunWskazany(index);
                    tablica.zmniejszTablice();
                    System.out.println();
                    break;

                case 7:
                    System.out.print("Podaj pozycje: ");
                    index = scanner.nextInt();
                    tablica.znajdzPozycja(index);
                    System.out.println();
                    break;

                case 8:
                    tablica.wyswietlTablica();
                    System.out.println();
                    break;

                case 9:
                    scanner.nextLine();
                    System.out.println("Podaj nazwe pliku: ");
                    nazwa = scanner.nextLine();
                    tablica.wczytajTablica(nazwa);
                    System.out.println();
                    break;

                case 10:
                    scanner.nextLine();
                    System.out.println("Podaj nazwe pliku: ");
                    nazwa = scanner.nextLine();
                    tablica.zapiszTablica(nazwa);
                    System.out.println();
                    break;

                case 11:
                    tablica.maxTablica();
                    System.out.println();
                    break;

                case 12:
                    tablica.minTablica();
                    System.out.println();
                    break;

                case 13:
                    tablica.wyczysc();
                    System.out.println();
                    break;

                default:
                    System.out.println("Wybrano zly numer");
                    System.out.println();
                    break;

            }

        }

    }

}
