import java.util.Scanner;

public class Ui {

    private oLista lista = new oLista();
    private oTablica tablica = new oTablica();
    private oKopiec kopiec = new oKopiec();
    private oRB rb = new oRB();
    private oAVL avl = new oAVL();

    private boolean spr = true;

    public void stworz() {

        Scanner scanner = new Scanner(System.in);

        while (spr) {

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
                    spr = false;
                    break;

                case 1:
                    lista = new oLista();
                    lista.operacjeLista();
                    break;

                case 2:
                    tablica = new oTablica();
                    tablica.operacjeTablica();
                    break;

                case 3:
                    kopiec = new oKopiec();
                    kopiec.operacjeKopiec();
                    break;

                case 4:
                    rb = new oRB();
                    rb.operacjeRB();
                    break;

                case 5:
                    avl = new oAVL();
                    avl.operacjeAVL();
                    break;

                default:
                    System.out.println("Wybrano zly numer.");
                    break;

            }

        }

    }

}