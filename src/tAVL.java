import java.util.Random;
import java.util.Scanner;

public class tAVL {

    private int tab1[] = new int[1000];
    private int tab2[] = new int[2000];
    private int tab3[] = new int[5000];
    private int tab4[] = new int[10000];
    private int tab5[] = new int[20000];

    private long wyn1[] = new long[100];

    private AVL avl = new AVL();
    private Dane dane = new Dane();

    Scanner scanner = new Scanner(System.in);

    private static final int maxi = Integer.MAX_VALUE - 1;
    private static final int iloscTestow = 100;

    private boolean spr = true;

    public void test() {

        while (spr) {

            System.out.println("Wybierz operacje do zmierzenia");
            System.out.println("1. Dodawanie");
            System.out.println("2. Usuwanie");
            System.out.println("3. Przeszukiwanie");
            System.out.println("0. Cofnij do menu glownego");

            dane.generuj(tab1);
            dane.generuj(tab2);
            dane.generuj(tab3);
            dane.generuj(tab4);
            dane.generuj(tab5);
            dane.zapisz("1000.txt", tab1);
            dane.zapisz("2000.txt", tab2);
            dane.zapisz("5000.txt", tab3);
            dane.zapisz("10000.txt", tab4);
            dane.zapisz("20000.txt", tab5);

            Random r = new Random();
            Random index = new Random();

            int nrOperacji = scanner.nextInt();

            switch (nrOperacji) {

                case 0:
                    spr = false;
                    break;

                case 1:
                    avl = new AVL();
                    wyn1 = new long[100];
                    avl.wczytajAVL("1000.txt");
                    dodaj(r);
                    dane.zapisz("AVL_1.txt", wyn1);

                    avl = new AVL();
                    wyn1 = new long[100];
                    avl.wczytajAVL("2000.txt");
                    dodaj(r);
                    dane.zapisz("AVL_1.txt", wyn1);

                    avl = new AVL();
                    wyn1 = new long[100];
                    avl.wczytajAVL("5000.txt");
                    dodaj(r);
                    dane.zapisz("AVL_1.txt", wyn1);

                    avl = new AVL();
                    wyn1 = new long[100];
                    avl.wczytajAVL("10000.txt");
                    dodaj(r);
                    dane.zapisz("AVL_1.txt", wyn1);

                    avl = new AVL();
                    wyn1 = new long[100];
                    avl.wczytajAVL("20000.txt");
                    dodaj(r);
                    dane.zapisz("AVL_1.txt", wyn1);

                    break;

                case 2:
                    avl = new AVL();
                    wyn1 = new long[100];
                    avl.wczytajAVL("1000.txt");
                    usun(index, tab1);
                    dane.zapisz("AVL_2.txt", wyn1);

                    avl = new AVL();
                    wyn1 = new long[100];
                    avl.wczytajAVL("2000.txt");
                    usun(index, tab2);
                    dane.zapisz("AVL_2.txt", wyn1);

                    avl = new AVL();
                    wyn1 = new long[100];
                    avl.wczytajAVL("5000.txt");
                    usun(index, tab3);
                    dane.zapisz("AVL_2.txt", wyn1);

                    avl = new AVL();
                    wyn1 = new long[100];
                    avl.wczytajAVL("10000.txt");
                    usun(index, tab4);
                    dane.zapisz("AVL_2.txt", wyn1);

                    avl = new AVL();
                    wyn1 = new long[100];
                    avl.wczytajAVL("20000.txt");
                    usun(index, tab5);
                    dane.zapisz("AVL_2.txt", wyn1);

                    break;

                case 3:
                    avl = new AVL();
                    wyn1 = new long[100];
                    avl.wczytajAVL("1000.txt");
                    sprawdz(r);
                    dane.zapisz("AVL_3.txt", wyn1);

                    avl = new AVL();
                    wyn1 = new long[100];
                    avl.wczytajAVL("2000.txt");
                    sprawdz(r);
                    dane.zapisz("AVL_3.txt", wyn1);

                    avl = new AVL();
                    wyn1 = new long[100];
                    avl.wczytajAVL("5000.txt");
                    sprawdz(r);
                    dane.zapisz("AVL_3.txt", wyn1);

                    avl = new AVL();
                    wyn1 = new long[100];
                    avl.wczytajAVL("10000.txt");
                    sprawdz(r);
                    dane.zapisz("AVL_3.txt", wyn1);

                    avl = new AVL();
                    wyn1 = new long[100];
                    avl.wczytajAVL("20000.txt");
                    sprawdz(r);
                    dane.zapisz("AVL_3.txt", wyn1);

                    break;

                default:
                    System.out.println("Wybrano zly numer");
                    break;

            }

        }

    }

    private void dodaj(Random r) {

        for (int i = 0; i < iloscTestow; i++) {

            long sTime = System.nanoTime();
            avl.korzen = avl.dodaj(avl.korzen, r.nextInt(maxi));
            long fTime = System.nanoTime();
            long rTime = (fTime - sTime);
            wyn1[i] = rTime;

        }

    }

    private void usun(Random index, int tab[]) {

        for (int i = 0; i < iloscTestow; i++) {

            long sTime = System.nanoTime();
            avl.korzen = avl.usun(avl.korzen, tab[index.nextInt(tab.length) - 1]);
            long fTime = System.nanoTime();
            long rTime = (fTime - sTime);
            wyn1[i] = rTime;

        }

    }

    private void sprawdz(Random r) {

        for (int i = 0; i < iloscTestow; i++) {

            long sTime = System.nanoTime();
            avl.sprawdzBool(avl.korzen, r.nextInt(maxi));
            long fTime = System.nanoTime();
            long rTime = (fTime - sTime);
            wyn1[i] = rTime;

        }

    }

}
