import java.util.Scanner;

public class oTablica {

    Tablica tablica = new Tablica();

    public void operacjeTablica() {

        Scanner scanner = new Scanner(System.in);

        while (true) {

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
            System.out.println("0. Cofnij do menu glownego");

            int nrOperacji = scanner.nextInt();

            int wartosc, index = 0;
            String nazwa;

            switch (nrOperacji) {

                case 0:
                    break;

                case 1:
                    System.out.print("Podaj wartosc liczby: ");
                    wartosc = scanner.nextInt();
                    tablica.dodajPoczatek(wartosc);
                    break;

                case 2:
                    System.out.print("Podaj wartosc liczby: ");
                    wartosc = scanner.nextInt();
                    tablica.dodajKoniec(wartosc);
                    break;

                case 3:
                    System.out.println("Podaj wartosc liczby: ");
                    wartosc = scanner.nextInt();
                    System.out.println("Podaj pozycje: ");
                    index = scanner.nextInt();
                    tablica.dodaj(index, wartosc);
                    break;

                case 4:
                    tablica.usunPoczatek();
                    break;

                case 5:
                    tablica.usunKoniec();
                    break;

                case 6:
                    System.out.print("Podaj pozycje: ");
                    index = scanner.nextInt();
                    tablica.usunWskazany(index);
                    break;

                case 7:
                    System.out.print("Podaj pozycje: ");
                    index = scanner.nextInt();
                    tablica.znajdzPozycja(index);
                    break;

                case 8:
                    tablica.wyswietlTablica();
                    break;

                case 9:
                    System.out.println("Podaj nazwe pliku: ");
                    nazwa = scanner.nextLine();
                    tablica.wczytajTablica(nazwa);
                    break;

                case 10:
                    System.out.println("Podaj nazwe pliku: ");
                    nazwa = scanner.nextLine();
                    tablica.zapiszTablica(nazwa);
                    break;

                case 11:
                    tablica.maxTablica();
                    break;

                case 12:
                    tablica.minTablica();
                    break;

            }

        }

    }

}
