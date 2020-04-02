import java.util.Random;
import java.util.Scanner;

public class tDrzewo {

    private int tab1[] = new int[100];
    private int tab2[] = new int[1000];
    private int tab3[] = new int[10000];
    private int tab4[] = new int[100000];
    private int tab5[] = new int[200000];

    private long wyn1[] = new long[100];

    private Drzewo drzewo = new Drzewo();
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
            dane.zapisz("100.txt", tab1);
            dane.zapisz("1000.txt", tab2);
            dane.zapisz("10000.txt", tab3);
            dane.zapisz("100000.txt", tab4);
            dane.zapisz("200000.txt", tab5);

            Random r = new Random();
            Random index = new Random();

            int nrOperacji = scanner.nextInt();

            switch (nrOperacji) {

                case 0:
                    spr = false;
                    break;

                case 1:
                    drzewo = new Drzewo();
                    drzewo.wczytajDrzewo("100.txt");
                    dodaj(r);
                    dane.zapisz("Drzewo_1.txt", wyn1);

                    drzewo = new Drzewo();
                    drzewo.wczytajDrzewo("1000.txt");
                    dodaj(r);
                    dane.zapisz("Drzewo_1.txt", wyn1);

                    drzewo = new Drzewo();
                    drzewo.wczytajDrzewo("10000.txt");
                    dodaj(r);
                    dane.zapisz("Drzewo_1.txt", wyn1);

                    drzewo = new Drzewo();
                    drzewo.wczytajDrzewo("100000.txt");
                    dodaj(r);
                    dane.zapisz("Drzewo_1.txt", wyn1);

                    drzewo = new Drzewo();
                    drzewo.wczytajDrzewo("200000.txt");
                    dodaj(r);
                    dane.zapisz("Drzewo_1.txt", wyn1);

                    break;

                case 2:
                    drzewo = new Drzewo();
                    drzewo.wczytajDrzewo("100.txt");
                    usun(index, tab1);
                    dane.zapisz("Drzewo_2.txt", wyn1);

                    drzewo = new Drzewo();
                    drzewo.wczytajDrzewo("1000.txt");
                    usun(index, tab2);
                    dane.zapisz("Drzewo_2.txt", wyn1);

                    drzewo = new Drzewo();
                    drzewo.wczytajDrzewo("10000.txt");
                    usun(index, tab3);
                    dane.zapisz("Drzewo_2.txt", wyn1);

                    drzewo = new Drzewo();
                    drzewo.wczytajDrzewo("100000.txt");
                    usun(index, tab4);
                    dane.zapisz("Drzewo_2.txt", wyn1);

                    drzewo = new Drzewo();
                    drzewo.wczytajDrzewo("200000.txt");
                    usun(index, tab5);
                    dane.zapisz("Drzewo_2.txt", wyn1);

                    break;

                case 3:
                    drzewo = new Drzewo();
                    drzewo.wczytajDrzewo("100.txt");
                    sprawdz(r, 100);
                    dane.zapisz("Drzewo_3.txt", wyn1);

                    drzewo = new Drzewo();
                    drzewo.wczytajDrzewo("1000.txt");
                    sprawdz(r, 1000);
                    dane.zapisz("Drzewo_3.txt", wyn1);

                    drzewo = new Drzewo();
                    drzewo.wczytajDrzewo("10000.txt");
                    sprawdz(r, 10000);
                    dane.zapisz("Drzewo_3.txt", wyn1);

                    drzewo = new Drzewo();
                    drzewo.wczytajDrzewo("100000.txt");
                    sprawdz(r, 100000);
                    dane.zapisz("Drzewo_3.txt", wyn1);

                    drzewo = new Drzewo();
                    drzewo.wczytajDrzewo("200000.txt");
                    sprawdz(r, 200000);
                    dane.zapisz("Drzewo_3.txt", wyn1);

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
            drzewo.dodajDrzewo(r.nextInt(maxi));
            long fTime = System.nanoTime();
            long rTime = (fTime - sTime) / 1000;
            wyn1[i] = rTime;

        }

    }

    private void usun(Random index, int tab[]) {

        for (int i = 0; i < iloscTestow; i++) {

            long sTime = System.nanoTime();
            drzewo.usunDrzewo(tab[index.nextInt(tab.length) - 1]);
            long fTime = System.nanoTime();
            long rTime = (fTime - sTime) / 1000;
            wyn1[i] = rTime;

        }

    }

    private void sprawdz(Random r, int bound) {

        for (int i = 0; i < iloscTestow; i++) {

            long sTime = System.nanoTime();
            drzewo.sprawdzBool(drzewo.getKorzen(), r.nextInt(bound + 1));
            long fTime = System.nanoTime();
            long rTime = (fTime - sTime) / 1000;
            wyn1[i] = rTime;

        }

    }

}
