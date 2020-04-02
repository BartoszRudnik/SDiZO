import java.util.Scanner;

public class TestUI {

    private tTablica tablica = new tTablica();
    private tLista lista = new tLista();
    private tKopiec kopiec = new tKopiec();
    private tDrzewo drzewo = new tDrzewo();
    private tAVL avl = new tAVL();

    Scanner scanner = new Scanner(System.in);

    private boolean spr = true;

    public void testUI() {

        while (spr) {

            System.out.println("Wybierz strukture do przeprowadzenia pomiarow");
            System.out.println("1. Tablica");
            System.out.println("2. Lista");
            System.out.println("3. Kopiec");
            System.out.println("4. Drzewo czerwono-czarne");
            System.out.println("5. Drzewo AVL");
            System.out.println("0. Wyjdz");

            int nrStruktury = scanner.nextInt();

            switch (nrStruktury) {

                case 0:
                    spr = false;
                    break;

                case 1:
                    tablica = new tTablica();
                    tablica.test();
                    break;

                case 2:
                    lista = new tLista();
                    lista.test();
                    break;

                case 3:
                    kopiec = new tKopiec();
                    kopiec.test();
                    break;

                case 4:
                    drzewo = new tDrzewo();
                    drzewo.test();
                    break;

                case 5:
                    avl = new tAVL();
                    avl.test();
                    break;

                default:
                    System.out.println("Podano zly numer!");
                    break;

            }

        }

    }

}
