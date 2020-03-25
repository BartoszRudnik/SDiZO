public class Main {

    public static void main(String[] args) {

        Drzewo drzewo = new Drzewo();


        int tablica[] = new int[6];

        tablica[0] = 5;
        tablica[1] = 31;
        tablica[2] = 51;
        tablica[3] = 57;
        tablica[4] = 23;
        tablica[5] = 91;

        for (int i = 0; i < 6; i++) {
            drzewo.dodajDrzewo(tablica[i]);
        }

        drzewo.wypisz(drzewo.getWierzchołek());

    }

}
