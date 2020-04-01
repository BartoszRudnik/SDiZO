import java.util.Scanner;

public class Ui {

    private oLista lista = new oLista();
    private oTablica tablica = new oTablica();
    private oKopiec kopiec = new oKopiec();
    private oRB rb = new oRB();
    private oAVL avl = new oAVL();

    public void stworz() {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Wybierz strukture do testowania:");
            System.out.println("1. Lista");
            System.out.println("2. Tablica");
            System.out.println("3. Kopiec");
            System.out.println("4. Drzewo czerwono-czarne");
            System.out.println("5. Drzewo AVL");
            System.out.println("0. Wyjscie");

            int nrStruktury = scanner.nextInt();

            switch (nrStruktury) {

                case 0:
                    System.exit(0);
                    break;

                case 1:
                    lista.operacjeLista();
                    break;

                case 2:
                    tablica.operacjeTablica();
                    break;

                case 3:
                    kopiec.operacjeKopiec();
                    break;

                case 4:
                    rb.operacjeRB();
                    break;

                case 5:
                    avl.operacjeAVL();
                    break;

                default:
                    System.out.println("Wybrano zly numer.");
                    break;

            }

        }

    }

}