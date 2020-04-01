import java.util.Scanner;

public class oAVL {

    AVL avl = new AVL();

    Scanner scanner = new Scanner(System.in);

    private boolean proces = true;

    public void operacjeAVL() {

        while (proces) {

            System.out.println("Podaj numer operacji do przetestowania:");
            System.out.println("1. Dodaj nowy element");
            System.out.println("2. Usun element");
            System.out.println("3. Wypisz Preorder");
            System.out.println("4. Wypisz Inorder");
            System.out.println("5. Wydrukuj strukture drzewa AVL");
            System.out.println("6. Najwieksza wartosc");
            System.out.println("7. Najmniejsza wartosc");
            System.out.println("8. Sprawdz czy istnieje element o podanej wartosci");
            System.out.println("9. Wczytaj dane z pliku tekstowego");
            System.out.println("10. Zapisz dane do pliku tekstowego");
            System.out.println("11. Wyczysc drzewo AVL");
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
                    avl.korzen = avl.dodaj(avl.korzen, wartosc);
                    System.out.println();
                    break;

                case 2:
                    System.out.print("Podaj wartosc: ");
                    wartosc = scanner.nextInt();
                    avl.korzen = avl.usun(avl.korzen, wartosc);
                    System.out.println();
                    break;

                case 3:
                    avl.wypiszPreorder(avl.korzen);
                    System.out.println();
                    break;

                case 4:
                    avl.wypiszInorder(avl.korzen);
                    System.out.println();
                    break;

                case 5:
                    avl.wydrukuj(avl.korzen, "", true);
                    System.out.println();
                    break;

                case 6:
                    avl.AvlMax(avl.korzen);
                    System.out.println();
                    break;

                case 7:
                    avl.AvlMin(avl.korzen);
                    System.out.println();
                    break;

                case 8:
                    System.out.print("Podaj wartosc: ");
                    wartosc = scanner.nextInt();
                    avl.sprawdz(avl.korzen, wartosc);
                    System.out.println();
                    break;

                case 9:
                    scanner.nextLine();
                    System.out.print("Podaj nazwe pliku: ");
                    nazwa = scanner.nextLine();
                    avl.wczytajAVL(nazwa);
                    System.out.println();
                    break;

                case 10:
                    scanner.nextLine();
                    System.out.print("Podaj nazwe pliku: ");
                    nazwa = scanner.nextLine();
                    avl.zapiszAvl(nazwa);
                    System.out.println();
                    break;

                case 11:
                    avl.wyczysc(avl.korzen);
                    avl = new AVL();
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
