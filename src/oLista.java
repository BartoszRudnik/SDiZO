import java.util.Scanner;

public class oLista {

    private boolean proces = true;

    Scanner scanner = new Scanner(System.in);

    Lista lista = new Lista();

    public void operacjeLista() {

        while (proces) {

            System.out.println("Podaj numer operacji, ktora chcesz wykonac:");
            System.out.println("1. Dodanie na poczatek listy");
            System.out.println("2. Dodanie na koniec listy");
            System.out.println("3. Dodanie na wybrana pozycje listy");
            System.out.println("4. Usuniecie z poczatku listy");
            System.out.println("5. Usuniecie z konca listy");
            System.out.println("6. Usuniecie z wybranej pozycji listy");
            System.out.println("7. Wyswietlenie zawartosci listy");
            System.out.println("8. Wyswietlenie elementu na wskazanej pozycji");
            System.out.println("9. Maximum z listy");
            System.out.println("10. Minimum z listy");
            System.out.println("11. Wczytaj dane z pliku tekstowego");
            System.out.println("12. Zapisz dane do pliku tekstowego");
            System.out.println("13. Wyczysc liste");
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
                    System.out.print("Podaj wartosc do dodania: ");
                    wartosc = scanner.nextInt();
                    lista.dodajPoczatek(wartosc);
                    System.out.println();
                    break;

                case 2:
                    System.out.print("Podaj wartosc do dodania: ");
                    wartosc = scanner.nextInt();
                    lista.dodajKoniec(wartosc);
                    System.out.println();
                    break;

                case 3:
                    System.out.print("Podaj wartosc do dodania: ");
                    wartosc = scanner.nextInt();
                    System.out.println();
                    System.out.print("Podaj index: ");
                    index = scanner.nextInt();
                    lista.dodaj(index, wartosc);
                    System.out.println();
                    break;

                case 4:
                    lista.usunPoczatek();
                    System.out.println();
                    break;

                case 5:
                    lista.usunKoniec();
                    System.out.println();
                    break;

                case 6:
                    System.out.print("Podaj index: ");
                    index = scanner.nextInt();
                    lista.usunWskazany(index);
                    System.out.println();
                    break;

                case 7:
                    lista.wyswietlLista();
                    System.out.println();
                    break;

                case 8:
                    System.out.print("Podaj index: ");
                    index = scanner.nextInt();
                    lista.wyswietlElement(index);
                    System.out.println();
                    break;

                case 9:
                    lista.maxLista();
                    System.out.println();
                    break;

                case 10:
                    lista.minLista();
                    System.out.println();
                    break;

                case 11:
                    scanner.nextLine();
                    System.out.println("Podaj nazwe pliku: ");
                    nazwa = scanner.nextLine();
                    lista.wczytajLista(nazwa);
                    System.out.println();
                    break;

                case 12:
                    scanner.nextLine();
                    System.out.println("Podaj nazwe pliku: ");
                    nazwa = scanner.nextLine();
                    lista.zapiszLista(nazwa);
                    System.out.println();
                    break;

                case 13:
                    lista.wyczysc();
                    System.out.println();
                    break;

                default:
                    System.out.println("Podales zly numer!");
                    System.out.println();
                    break;

            }

        }

    }

}
