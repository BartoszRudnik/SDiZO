import java.util.Scanner;

public class oRB {

    Drzewo drzewo = new Drzewo();

    Scanner scanner = new Scanner(System.in);

    private boolean proces = true;

    public void operacjeRB() {

        while (proces) {

            System.out.println("Wybierz numer operacji do przetestowania: ");
            System.out.println("1. Dodaj nowy element");
            System.out.println("2. Usun element o podanej wartosci");
            System.out.println("3. Wypisz Preorder");
            System.out.println("4. Wypisz Inorder");
            System.out.println("5. Sprawdz czy istnieje wskazany element");
            System.out.println("6. Wydrukuj strukture drzewa RB");
            System.out.println("7. Najwieksza wartosc");
            System.out.println("8. Najmniejsza wartosc");
            System.out.println("9. Wczytaj dane z pliku tekstowego");
            System.out.println("10. Zapisz dane do pliku tekstowego");
            System.out.println("11. Wyczysc drzewo RB");
            System.out.println("0. Cofnij do menu glownego");

            int nrOperacji = scanner.nextInt();

            System.out.println();

            int wartosc = 0;
            String nazwa;

            switch (nrOperacji) {

                case 0:
                    proces = false;
                    break;

                case 1:
                    System.out.print("Podaj wartosc: ");
                    wartosc = scanner.nextInt();
                    drzewo.dodajDrzewo(wartosc);
                    System.out.println();
                    break;

                case 2:
                    System.out.print("Podaj wartosc: ");
                    wartosc = scanner.nextInt();
                    drzewo.usunDrzewo(wartosc);
                    System.out.println();
                    break;

                case 3:
                    drzewo.wypiszPreorder(drzewo.getKorzen());
                    System.out.println();
                    break;

                case 4:
                    drzewo.wypiszInorder(drzewo.getKorzen());
                    System.out.println();
                    break;

                case 5:
                    System.out.print("Podaj szukana wartosc: ");
                    wartosc = scanner.nextInt();
                    drzewo.sprawdz(drzewo.getKorzen(), wartosc);
                    System.out.println();
                    break;

                case 6:
                    drzewo.wydrukuj(drzewo.getKorzen(), "", true);
                    System.out.println();
                    break;

                case 7:
                    drzewo.maximum(drzewo.getKorzen());
                    System.out.println();
                    break;

                case 8:
                    drzewo.minimum(drzewo.getKorzen());
                    System.out.println();
                    break;

                case 9:
                    scanner.nextLine();
                    System.out.print("Podaj nazwe pliku:");
                    nazwa = scanner.nextLine();
                    drzewo.wczytajDrzewo(nazwa);
                    System.out.println();
                    break;

                case 10:
                    scanner.nextLine();
                    System.out.print("Podaj nazwe pliku:");
                    nazwa = scanner.nextLine();
                    drzewo.zapiszDrzewo(nazwa);
                    System.out.println();
                    break;

                case 11:
                    drzewo = new Drzewo();
                    System.out.println();
                    break;

                default:
                    System.out.println("Podano zly numer!");
                    System.out.println();
                    break;

            }

        }

    }

}
