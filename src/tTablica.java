import java.util.Random;
import java.util.Scanner;

public class tTablica {

    private int tab1[] = new int[100];
    private int tab2[] = new int[1000];
    private int tab3[] = new int[10000];
    private int tab4[] = new int[100000];
    private int tab5[] = new int[200000];

    private long wyn1[] = new long[100];

    private Tablica tablica = new Tablica();
    private Dane dane = new Dane();

    Scanner scanner = new Scanner(System.in);

    private static final int maxi = Integer.MAX_VALUE - 1;
    private static final int iloscTestow = 100;

    private boolean spr = true;

    public void test() {

        while (spr) {

            System.out.println("Wybierz operacje do zmierzenia");
            System.out.println("1. Dodawanie na poczatek");
            System.out.println("2. Dodawanie na koniec");
            System.out.println("3. Dodawanie na wybrana pozycje");
            System.out.println("4. Usuwanie z poczatku");
            System.out.println("5. Usuwanie z konca");
            System.out.println("6. Usuwanie z wybranej pozycji");
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
                    tablica = new Tablica();
                    tablica.wczytajTablica("100.txt");
                    dodajPoczatek(r);
                    dane.zapisz("Tablica_1.txt", wyn1);

                    tablica = new Tablica();
                    wyn1 = new long[100];
                    tablica.wczytajTablica("1000.txt");
                    dodajPoczatek(r);
                    dane.zapisz("Tablica_1.txt", wyn1);

                    tablica = new Tablica();
                    wyn1 = new long[100];
                    tablica.wczytajTablica("10000.txt");
                    dodajPoczatek(r);
                    dane.zapisz("Tablica_1.txt", wyn1);

                    tablica = new Tablica();
                    wyn1 = new long[100];
                    tablica.wczytajTablica("100000.txt");
                    dodajPoczatek(r);
                    dane.zapisz("Tablica_1.txt", wyn1);

                    tablica = new Tablica();
                    wyn1 = new long[100];
                    tablica.wczytajTablica("200000.txt");
                    dodajPoczatek(r);
                    dane.zapisz("Tablica_1.txt", wyn1);

                    break;

                case 2:
                    tablica = new Tablica();
                    tablica.wczytajTablica("100.txt");
                    dodajKoniec(r);
                    dane.zapisz("Tablica_2.txt", wyn1);

                    tablica = new Tablica();
                    wyn1 = new long[100];
                    tablica.wczytajTablica("1000.txt");
                    dodajKoniec(r);
                    dane.zapisz("Tablica_2.txt", wyn1);

                    tablica = new Tablica();
                    wyn1 = new long[100];
                    tablica.wczytajTablica("10000.txt");
                    dodajKoniec(r);
                    dane.zapisz("Tablica_2.txt", wyn1);

                    tablica = new Tablica();
                    wyn1 = new long[100];
                    tablica.wczytajTablica("100000.txt");
                    dodajKoniec(r);
                    dane.zapisz("Tablica_2.txt", wyn1);

                    tablica = new Tablica();
                    wyn1 = new long[100];
                    tablica.wczytajTablica("200000.txt");
                    dodajKoniec(r);
                    dane.zapisz("Tablica_2.txt", wyn1);

                    break;

                case 3:
                    tablica = new Tablica();
                    tablica.wczytajTablica("100.txt");
                    dodajIndex(r, index, 100);
                    dane.zapisz("Tablica_3.txt", wyn1);

                    tablica = new Tablica();
                    wyn1 = new long[100];
                    tablica.wczytajTablica("1000.txt");
                    dodajIndex(r, index, 1000);
                    dane.zapisz("Tablica_3.txt", wyn1);

                    tablica = new Tablica();
                    wyn1 = new long[100];
                    tablica.wczytajTablica("10000.txt");
                    dodajIndex(r, index, 10000);
                    dane.zapisz("Tablica_3.txt", wyn1);

                    tablica = new Tablica();
                    wyn1 = new long[100];
                    tablica.wczytajTablica("100000.txt");
                    dodajIndex(r, index, 100000);
                    dane.zapisz("Tablica_3.txt", wyn1);

                    tablica = new Tablica();
                    wyn1 = new long[100];
                    tablica.wczytajTablica("200000.txt");
                    dodajIndex(r, index, 200000);
                    dane.zapisz("Tablica_3.txt", wyn1);

                    break;

                case 4:
                    tablica = new Tablica();
                    tablica.wczytajTablica("100.txt");
                    usunPoczatek();
                    dane.zapisz("Tablica_4.txt", wyn1);

                    tablica = new Tablica();
                    wyn1 = new long[100];
                    tablica.wczytajTablica("1000.txt");
                    usunPoczatek();
                    dane.zapisz("Tablica_4.txt", wyn1);

                    tablica = new Tablica();
                    wyn1 = new long[100];
                    tablica.wczytajTablica("10000.txt");
                    usunPoczatek();
                    dane.zapisz("Tablica_4.txt", wyn1);

                    tablica = new Tablica();
                    wyn1 = new long[100];
                    tablica.wczytajTablica("100000.txt");
                    usunPoczatek();
                    dane.zapisz("Tablica_4.txt", wyn1);

                    tablica = new Tablica();
                    wyn1 = new long[100];
                    tablica.wczytajTablica("200000.txt");
                    usunPoczatek();
                    dane.zapisz("Tablica_4.txt", wyn1);

                    break;

                case 5:
                    tablica = new Tablica();
                    tablica.wczytajTablica("100.txt");
                    usunKoniec();
                    dane.zapisz("Tablica_5.txt", wyn1);

                    tablica = new Tablica();
                    wyn1 = new long[100];
                    tablica.wczytajTablica("1000.txt");
                    usunKoniec();
                    dane.zapisz("Tablica_5.txt", wyn1);

                    tablica = new Tablica();
                    wyn1 = new long[100];
                    tablica.wczytajTablica("10000.txt");
                    usunKoniec();
                    dane.zapisz("Tablica_5.txt", wyn1);

                    tablica = new Tablica();
                    wyn1 = new long[100];
                    tablica.wczytajTablica("100000.txt");
                    usunKoniec();
                    dane.zapisz("Tablica_5.txt", wyn1);

                    tablica = new Tablica();
                    wyn1 = new long[100];
                    tablica.wczytajTablica("200000.txt");
                    usunKoniec();
                    dane.zapisz("Tablica_5.txt", wyn1);

                    break;

                case 6:
                    tablica = new Tablica();
                    tablica.wczytajTablica("100.txt");
                    usunIndex(index, 99);
                    dane.zapisz("Tablica_6.txt", wyn1);

                    tablica = new Tablica();
                    wyn1 = new long[100];
                    tablica.wczytajTablica("1000.txt");
                    usunIndex(index, 999);
                    dane.zapisz("Tablica_6.txt", wyn1);

                    tablica = new Tablica();
                    wyn1 = new long[100];
                    tablica.wczytajTablica("10000.txt");
                    usunIndex(index, 9999);
                    dane.zapisz("Tablica_6.txt", wyn1);

                    tablica = new Tablica();
                    wyn1 = new long[100];
                    tablica.wczytajTablica("100000.txt");
                    usunIndex(index, 99999);
                    dane.zapisz("Tablica_6.txt", wyn1);

                    tablica = new Tablica();
                    wyn1 = new long[100];
                    tablica.wczytajTablica("200000.txt");
                    usunIndex(index, 199999);
                    dane.zapisz("Tablica_6.txt", wyn1);

                    break;

                default:
                    System.out.println("Wybrano zly numer");
                    break;

            }

        }
    }

    private void usunKoniec() {
        for (int i = 0; i < iloscTestow; i++) {
            long sTime = System.nanoTime();
            tablica.usunKoniec();
            long fTime = System.nanoTime();
            long rTime = (fTime - sTime) / 1000;
            wyn1[i] = rTime;
        }
    }

    private void usunPoczatek() {
        for (int i = 0; i < iloscTestow; i++) {
            long sTime = System.nanoTime();
            tablica.usunPoczatek();
            long fTime = System.nanoTime();
            long rTime = (fTime - sTime) / 1000;
            wyn1[i] = rTime;
        }
    }

    private void dodajIndex(Random r, Random index, int bound) {

        for (int i = 0; i < iloscTestow; i++) {

            long sTime = System.nanoTime();
            tablica.dodaj(index.nextInt(bound + i - 1), r.nextInt(maxi));
            long fTime = System.nanoTime();
            long rTime = (fTime - sTime) / 1000;
            wyn1[i] = rTime;

        }

    }

    private void dodajKoniec(Random r) {
        for (int i = 0; i < iloscTestow; i++) {
            long sTime = System.nanoTime();
            tablica.dodajKoniec(r.nextInt(maxi));
            long fTime = System.nanoTime();
            long rTime = (fTime - sTime) / 1000;
            wyn1[i] = rTime;
        }
    }

    private void dodajPoczatek(Random r) {
        for (int i = 0; i < iloscTestow; i++) {
            long sTime = System.nanoTime();
            tablica.dodajPoczatek(r.nextInt(maxi));
            long fTime = System.nanoTime();
            long rTime = (fTime - sTime) / 1000;
            wyn1[i] = rTime;
        }
    }

    private void usunIndex(Random index, int bound) {

        for (int i = 0; i < iloscTestow; i++) {

            long sTime = System.nanoTime();
            tablica.usunWskazany(index.nextInt(bound - i));
            long fTime = System.nanoTime();
            long rTime = (fTime - sTime) / 1000;
            wyn1[i] = rTime;

        }

    }

}
