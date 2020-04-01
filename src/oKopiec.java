import java.util.Scanner;

public class oKopiec {

    private boolean proces = true;

    Kopiec kopiec = new Kopiec();

    Scanner scanner = new Scanner(System.in);

    public void operacjeKopiec() {

        while (proces) {

            System.out.println("Podaj numer operacji do przetestowania:");
            System.out.println("1. Dodaj nowy element do kopca");
            System.out.println("2. Usun element o podanej wartosci");
            System.out.println("3. Usun korzen kopca");
            System.out.println("4. Wyswietl zawartosc kopca");
            System.out.println("5. Sprawdz czy w kopcu znajduje sie element o podanej wartosci");
            System.out.println("6. Zapisz kopiec do pliku tekstowego");
            System.out.println("7. Wczytaj kopiec z pliku tekstowego");
            System.out.println("8. Najwieksza wartosc kopca");
            System.out.println("9. Najmniejsza wartosc kopca");
            System.out.println("0. Cofnij do menu glownego");

            int nrOperacji = scanner.nextInt();

            int wartosc = 0;
            String nazwa;

            switch (nrOperacji) {

                case 0:
                    proces = false;
                    break;

                case 1:
                    System.out.print("Podaj wartosc do dodania: ");
                    wartosc = scanner.nextInt();
                    kopiec.dodaj(wartosc);
                    break;

                case 2:
                    System.out.print("Podaj wartosc do usuniecia: ");
                    wartosc = scanner.nextInt();
                    kopiec.usun(wartosc);
                    break;

                case 3:
                    kopiec.usunKorzen();
                    break;

                case 4:
                    kopiec.wydrukuj(0, " ", true);
                    break;

                case 5:
                    System.out.print("Podaj szukana wartosc: ");
                    wartosc = scanner.nextInt();
                    kopiec.znajdzKopiec(wartosc);
                    break;

                case 6:
                    scanner.nextLine();
                    System.out.println("Podaj nazwe pliku: ");
                    nazwa = scanner.nextLine();
                    kopiec.zapiszKopiec(nazwa);
                    break;

                case 7:
                    scanner.nextLine();
                    System.out.println("Podaj nazwe pliku: ");
                    nazwa = scanner.nextLine();
                    kopiec.wczytajKopiec(nazwa);
                    break;

                case 8:
                    kopiec.maxKopiec();
                    break;

                case 9:
                    kopiec.minKopiec();
                    break;

                default:
                    System.out.println("Podano zly numer!");
                    break;

            }

        }

    }

}
