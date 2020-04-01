import java.util.Scanner;

public class TestUI {

    tTablica tablica = new tTablica();
    tLista lista = new tLista();
    tKopiec kopiec = new tKopiec();
    tDrzewo drzewo = new tDrzewo();
    tAVL avl = new tAVL();

    Scanner scanner = new Scanner(System.in);

    public void testUI() {

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
                System.exit(0);
                break;

            case 1:
                tablica.test();
                break;

            case 2:
                lista.test();
                break;

            case 3:
                kopiec.test();
                break;

            case 4:
                drzewo.test();
                break;

            case 5:
                avl.test();
                break;

            default:
                System.out.println("Podano zly numer!");
                break;

        }

    }


}
