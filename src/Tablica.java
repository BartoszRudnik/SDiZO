import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

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

    public void dodajPoczatek(int liczba) {

        if ((index + 1) >= pojemnosc)
            powiekszTablice();

        int pomocnicza[] = new int[index];

        for (int i = 0; i < index; i++) {
            pomocnicza[i] = tablica[i];
        }

        for (int i = index - 1; i >= 0; i--) {
            tablica[i + 1] = pomocnicza[i];
        }

        tablica[0] = liczba;
        index++;

    }

    public void dodaj(int pozycja, int liczba) {

        if ((index + 1) >= pojemnosc) {
            powiekszTablice();
        }

        if (pozycja == 0) {
            dodajPoczatek(liczba);
        } else if (pozycja >= index) {
            dodajKoniec(liczba);
        } else {

            int pomocnicza[] = new int[index];
            for (int i = pozycja; i < index; i++) {
                pomocnicza[i] = tablica[i];
            }
            for (int i = index - 1; i >= pozycja; i--) {

                tablica[i + 1] = pomocnicza[i];

            }
            tablica[pozycja] = liczba;
            index++;
        }
    }

    public void usunKoniec() {

        if (index >= 0) {
            tablica[index - 1] = 0;
            index--;
            zmniejszTablice();
        }

    }

    public void usunPoczatek() {

        if (index >= 0) {
            for (int i = 1; i < index; i++) {

                tablica[i - 1] = tablica[i];

            }

            index--;
            zmniejszTablice();
        }

    }

    public void usun(int pozycja) {

        if (pozycja == 0) {
            usunPoczatek();
        } else if (pozycja == index) {
            usunKoniec();
        } else {
            for (int i = pozycja + 1; i < index; i++) {
                tablica[i - 1] = tablica[i];
            }
            index--;
            zmniejszTablice();
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

    public void zmniejszTablice() {

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

    public int getIndex() {
        return index;
    }

    public void setPojemnosc(int pojemnosc) {
        this.pojemnosc = pojemnosc;
    }

    public int getPojemnosc() {
        return pojemnosc;
    }

    public void wyswietlTablica() {

        for (int i = 0; i < index; i++) {

            System.out.println(tablica[i]);

        }

    }

    public void wczytajTablica(String file) {
        try {
            FileInputStream fstream = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            String line;
            int rozmiarPliku = 0;

            if ((line = br.readLine()) != null) {
                rozmiarPliku = Integer.parseInt(line);
            }

            for (int i = 0; i < rozmiarPliku; i++) {
                if ((line = br.readLine()) != null)
                    dodaj(getIndex(), Integer.parseInt(line));
            }

            fstream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
