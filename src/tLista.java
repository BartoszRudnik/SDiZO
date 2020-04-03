import java.util.Random;
import java.util.Scanner;

public class tLista {

    private int tab1[] = new int[1000];
    private int tab2[] = new int[2000];
    private int tab3[] = new int[5000];
    private int tab4[] = new int[10000];
    private int tab5[] = new int[20000];

    private long wyn1[] = new long[100];

    private Lista lista = new Lista();
    private Dane dane = new Dane();

    Scanner scanner = new Scanner(System.in);

    private static final int maxi = Integer.MAX_VALUE - 1;
    private static final int iloscTestow = 100;

    private boolean spr = true;

    public void test() {

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

        while (spr) {

            System.out.println("Wybierz operacje do zmierzenia");
            System.out.println("1. Dodawanie na poczatek");
            System.out.println("2. Dodawanie na koniec");
            System.out.println("3. Dodawanie na wybrana pozycje");
            System.out.println("4. Usuwanie z poczatku");
            System.out.println("5. Usuwanie z konca");
            System.out.println("6. Usuwanie z wybranej pozycji");
            System.out.println("7. Przeszukiwanie");
            System.out.println("0. Cofnij do menu glownego");

            Random r = new Random();
            Random index = new Random();

            int nrOperacji = scanner.nextInt();

            switch (nrOperacji) {

                case 0:
                    spr = false;
                    break;

                case 1:
                    lista = new Lista();
                    wyn1 = new long[100];
                    lista.wczytajLista("1000.txt");
                    dodajPoczatek(r);
                    dane.zapisz("Lista_1.txt", wyn1);

                    lista = new Lista();
                    wyn1 = new long[100];
                    lista.wczytajLista("2000.txt");
                    dodajPoczatek(r);
                    dane.zapisz("Lista_1.txt", wyn1);

                    lista = new Lista();
                    wyn1 = new long[100];
                    lista.wczytajLista("5000.txt");
                    dodajPoczatek(r);
                    dane.zapisz("Lista_1.txt", wyn1);

                    lista = new Lista();
                    wyn1 = new long[100];
                    lista.wczytajLista("10000.txt");
                    dodajPoczatek(r);
                    dane.zapisz("Lista_1.txt", wyn1);

                    lista = new Lista();
                    wyn1 = new long[100];
                    lista.wczytajLista("20000.txt");
                    dodajPoczatek(r);
                    dane.zapisz("Lista_1.txt", wyn1);

                    break;

                case 2:
                    lista = new Lista();
                    wyn1 = new long[100];
                    lista.wczytajLista("1000.txt");
                    dodajKoniec(r);
                    dane.zapisz("Lista_2.txt", wyn1);

                    lista = new Lista();
                    wyn1 = new long[100];
                    lista.wczytajLista("2000.txt");
                    dodajKoniec(r);
                    dane.zapisz("Lista_2.txt", wyn1);

                    lista = new Lista();
                    wyn1 = new long[100];
                    lista.wczytajLista("5000.txt");
                    dodajKoniec(r);
                    dane.zapisz("Lista_2.txt", wyn1);

                    lista = new Lista();
                    wyn1 = new long[100];
                    lista.wczytajLista("10000.txt");
                    dodajKoniec(r);
                    dane.zapisz("Lista_2.txt", wyn1);

                    lista = new Lista();
                    wyn1 = new long[100];
                    lista.wczytajLista("20000.txt");
                    dodajKoniec(r);
                    dane.zapisz("Lista_2.txt", wyn1);

                    break;

                case 3:
                    lista = new Lista();
                    wyn1 = new long[100];
                    lista.wczytajLista("1000.txt");
                    dodajIndex(r, index, 1000);
                    dane.zapisz("Lista_3.txt", wyn1);

                    lista = new Lista();
                    wyn1 = new long[100];
                    lista.wczytajLista("2000.txt");
                    dodajIndex(r, index, 2000);
                    dane.zapisz("Lista_3.txt", wyn1);

                    lista = new Lista();
                    wyn1 = new long[100];
                    lista.wczytajLista("5000.txt");
                    dodajIndex(r, index, 5000);
                    dane.zapisz("Lista_3.txt", wyn1);

                    lista = new Lista();
                    wyn1 = new long[100];
                    lista.wczytajLista("10000.txt");
                    dodajIndex(r, index, 10000);
                    dane.zapisz("Lista_3.txt", wyn1);

                    lista = new Lista();
                    wyn1 = new long[100];
                    lista.wczytajLista("20000.txt");
                    dodajIndex(r, index, 20000);
                    dane.zapisz("Lista_3.txt", wyn1);

                    break;

                case 4:
                    lista = new Lista();
                    wyn1 = new long[100];
                    lista.wczytajLista("1000.txt");
                    usunPoczatek();
                    dane.zapisz("Lista_4.txt", wyn1);

                    lista = new Lista();
                    wyn1 = new long[100];
                    lista.wczytajLista("2000.txt");
                    usunPoczatek();
                    dane.zapisz("Lista_4.txt", wyn1);

                    lista = new Lista();
                    wyn1 = new long[100];
                    lista.wczytajLista("5000.txt");
                    usunPoczatek();
                    dane.zapisz("Lista_4.txt", wyn1);

                    lista = new Lista();
                    wyn1 = new long[100];
                    lista.wczytajLista("10000.txt");
                    usunPoczatek();
                    dane.zapisz("Lista_4.txt", wyn1);

                    lista = new Lista();
                    wyn1 = new long[100];
                    lista.wczytajLista("20000.txt");
                    usunPoczatek();
                    dane.zapisz("Lista_4.txt", wyn1);

                    break;

                case 5:
                    lista = new Lista();
                    wyn1 = new long[100];
                    lista.wczytajLista("1000.txt");
                    usunKoniec();
                    dane.zapisz("Lista_5.txt", wyn1);

                    lista = new Lista();
                    wyn1 = new long[100];
                    lista.wczytajLista("2000.txt");
                    usunKoniec();
                    dane.zapisz("Lista_5.txt", wyn1);

                    lista = new Lista();
                    wyn1 = new long[100];
                    lista.wczytajLista("5000.txt");
                    usunKoniec();
                    dane.zapisz("Lista_5.txt", wyn1);

                    lista = new Lista();
                    wyn1 = new long[100];
                    lista.wczytajLista("10000.txt");
                    usunKoniec();
                    dane.zapisz("Lista_5.txt", wyn1);

                    lista = new Lista();
                    wyn1 = new long[100];
                    lista.wczytajLista("20000.txt");
                    usunKoniec();
                    dane.zapisz("Lista_5.txt", wyn1);

                    break;

                case 6:
                    lista = new Lista();
                    wyn1 = new long[100];
                    lista.wczytajLista("1000.txt");
                    usunIndex(index, 999);
                    dane.zapisz("Lista_6.txt", wyn1);

                    lista = new Lista();
                    wyn1 = new long[100];
                    lista.wczytajLista("2000.txt");
                    usunIndex(index, 1999);
                    dane.zapisz("Lista_6.txt", wyn1);

                    lista = new Lista();
                    wyn1 = new long[100];
                    lista.wczytajLista("5000.txt");
                    usunIndex(index, 4999);
                    dane.zapisz("Lista_6.txt", wyn1);

                    lista = new Lista();
                    wyn1 = new long[100];
                    lista.wczytajLista("10000.txt");
                    usunIndex(index, 9999);
                    dane.zapisz("Lista_6.txt", wyn1);

                    lista = new Lista();
                    wyn1 = new long[100];
                    lista.wczytajLista("20000.txt");
                    usunIndex(index, 19999);
                    dane.zapisz("Lista_6.txt", wyn1);

                    break;

                case 7:
                    lista = new Lista();
                    wyn1 = new long[100];
                    lista.wczytajLista("1000.txt");
                    sprawdz(r);
                    dane.zapisz("Lista_7.txt", wyn1);

                    lista = new Lista();
                    wyn1 = new long[100];
                    lista.wczytajLista("2000.txt");
                    sprawdz(r);
                    dane.zapisz("Lista_7.txt", wyn1);

                    lista = new Lista();
                    wyn1 = new long[100];
                    lista.wczytajLista("5000.txt");
                    sprawdz(r);
                    dane.zapisz("Lista_7.txt", wyn1);

                    lista = new Lista();
                    wyn1 = new long[100];
                    lista.wczytajLista("10000.txt");
                    sprawdz(r);
                    dane.zapisz("Lista_7.txt", wyn1);

                    lista = new Lista();
                    wyn1 = new long[100];
                    lista.wczytajLista("20000.txt");
                    sprawdz(r);
                    dane.zapisz("Lista_7.txt", wyn1);

                    break;

                default:
                    System.out.println("Wybrano zly numer");
                    break;


            }

        }

    }

    private void dodajPoczatek(Random r) {

        for (int i = 0; i < iloscTestow; i++) {

            long sTime = System.nanoTime();
            lista.dodajPoczatek(r.nextInt(maxi));
            long fTime = System.nanoTime();
            long rTime = (fTime - sTime);
            wyn1[i] = rTime;

        }

    }

    private void dodajKoniec(Random r) {

        for (int i = 0; i < iloscTestow; i++) {

            long sTime = System.nanoTime();
            lista.dodajKoniec(r.nextInt(maxi));
            long fTime = System.nanoTime();
            long rTime = (fTime - sTime);
            wyn1[i] = rTime;

        }

    }

    private void dodajIndex(Random r, Random index, int bound) {

        for (int i = 0; i < iloscTestow; i++) {

            long sTime = System.nanoTime();
            lista.dodaj(index.nextInt(bound + i - 1), r.nextInt(maxi));
            long fTime = System.nanoTime();
            long rTime = (fTime - sTime);
            wyn1[i] = rTime;

        }

    }

    private void usunPoczatek() {

        for (int i = 0; i < iloscTestow; i++) {

            long sTime = System.nanoTime();
            lista.usunPoczatek();
            long fTime = System.nanoTime();
            long rTime = (fTime - sTime);
            wyn1[i] = rTime;

        }

    }

    private void usunKoniec() {

        for (int i = 0; i < iloscTestow; i++) {

            long sTime = System.nanoTime();
            lista.usunKoniec();
            long fTime = System.nanoTime();
            long rTime = (fTime - sTime);
            wyn1[i] = rTime;

        }

    }

    private void usunIndex(Random index, int bound) {

        for (int i = 0; i < iloscTestow; i++) {

            long sTime = System.nanoTime();
            lista.usunWskazany(index.nextInt(bound - i + 1));
            long fTime = System.nanoTime();
            long rTime = (fTime - sTime);
            wyn1[i] = rTime;

        }

    }

    private void sprawdz(Random r) {

        for (int i = 0; i < iloscTestow; i++) {

            long sTime = System.nanoTime();
            lista.sprawdz(r.nextInt(maxi));
            long fTime = System.nanoTime();
            long rTime = (fTime - sTime);
            wyn1[i] = rTime;

        }

    }

}
