public class Tablica {

    private int tablica[];
    private int pojemnosc;
    private int index;

    public Tablica() {

        tablica = new int[10];
        index = 0;
        pojemnosc = 10;

    }

    public void dodajKoniec(int liczba) {

        if (index >= pojemnosc) {
            powiekszTablice();
        }

        tablica[index] = liczba;
        index++;

    }

    public void usunKoniec() {

        if (index > 0) {
            tablica[index] = 0;
            index--;
        }

    }

    private void powiekszTablice() {

        int pomocnicza[] = new int[pojemnosc * 2];

        for (int i = 0; i < index; i++) {

            pomocnicza[i] = tablica[i];

        }

        pojemnosc *= 2;
        tablica = pomocnicza;

    }

    private void zmniejszTablice() {

        int pomocnicza[] = null;

        if (index > 0) {

            pomocnicza = new int[index];

            for (int i = 0; i < index; i++) {

                pomocnicza[i] = tablica[i];

            }

            pojemnosc = index;
            tablica = pomocnicza;

        }

    }

    public void wypiszTablice() {

        for (int i = 0; i < index; i++) {

            System.out.println(tablica[i]);

        }

    }

}
