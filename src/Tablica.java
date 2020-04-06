import java.io.*;

public class Tablica {

    private int tablica[];
    private int pojemnosc;
    private int index;

    public void setIndex(int index) {
        this.index = index;
    }

    public void setPojemnosc(int pojemnosc) {
        this.pojemnosc = pojemnosc;
    }

    public int getIndex() {
        return index;
    }

    public int getPojemnosc() {
        return pojemnosc;
    }

    public int incIndex() {
        index++;
        return index;
    }

    public int dcIndex() {
        index--;
        return index;
    }

    public Tablica() {

        tablica = new int[10];
        index = 0;
        pojemnosc = 10;

    }

    public boolean sprawdz(int liczba) {

        for (int i = 0; i < pojemnosc; i++) {

            if (tablica[i] == liczba)
                return true;

        }

        return false;

    }

    public void dodajKoniec(int liczba) {

        if (getIndex() >= getPojemnosc()) {
            powiekszTablice();
        }

        tablica[index] = liczba;
        incIndex();

    }

    public void dodajPoczatek(int liczba) {

        if ((getIndex() + 1) >= getPojemnosc())
            powiekszTablice();

        int pomocnicza[] = new int[getIndex()];

        for (int i = 0; i < getIndex(); i++) {
            pomocnicza[i] = tablica[i];
        }

        for (int i = getIndex() - 1; i >= 0; i--) {
            tablica[i + 1] = pomocnicza[i];
        }

        tablica[0] = liczba;
        incIndex();

    }

    public void dodaj(int pozycja, int liczba) {

        if (pozycja < 0)
            return;

        if ((getIndex() + 1) >= getPojemnosc()) {
            powiekszTablice();
        }

        if (pozycja == 0) {
            dodajPoczatek(liczba);
        } else if (pozycja >= getIndex()) {
            dodajKoniec(liczba);
        } else {

            int pomocnicza[] = new int[getIndex()];
            for (int i = pozycja; i < getIndex(); i++) {
                pomocnicza[i] = tablica[i];
            }
            for (int i = getIndex() - 1; i >= pozycja; i--) {

                tablica[i + 1] = pomocnicza[i];

            }
            tablica[pozycja] = liczba;
            incIndex();
        }
    }

    public void usunKoniec() {

        if (index >= 0) {
            tablica[getIndex() - 1] = 0;
            dcIndex();
            zmniejszTablice();
        }

    }

    public void usunPoczatek() {

        if (getIndex() >= 0) {
            for (int i = 1; i < getIndex(); i++) {

                tablica[i - 1] = tablica[i];

            }

            dcIndex();
            zmniejszTablice();
        }

    }

    public void usunWskazany(int pozycja) {

        if (pozycja == 0) {
            usunPoczatek();
        } else if (pozycja == getIndex()) {
            usunKoniec();
        } else {
            for (int i = pozycja + 1; i < getIndex(); i++) {
                tablica[i - 1] = tablica[i];
            }
            dcIndex();
            zmniejszTablice();
        }

    }

    private void powiekszTablice() {

        int pomocnicza[] = new int[getPojemnosc() * 2];

        for (int i = 0; i < getIndex(); i++) {

            pomocnicza[i] = tablica[i];

        }

        setPojemnosc(getPojemnosc() * 2);
        tablica = pomocnicza;

    }

    public void zmniejszTablice() {

        int pomocnicza[] = null;

        if (getIndex() > 0) {

            pomocnicza = new int[getIndex()];

            for (int i = 0; i < getIndex(); i++) {

                pomocnicza[i] = tablica[i];

            }

            pojemnosc = getIndex();
            tablica = pomocnicza;

        }

    }

    public void znajdzPozycja(int pozycja) {
        if (pozycja < getPojemnosc())
            System.out.println(tablica[pozycja]);
        else
            System.out.println("Zla pozycja");
    }

    public void wyswietlTablica() {

        for (int i = 0; i < getIndex(); i++) {

            System.out.println(tablica[i]);

        }

    }

    public void wczytajTablica(String nazwaPliku) {

        try {
            FileInputStream fstream = new FileInputStream(nazwaPliku);
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

    public void zapiszTablica(String nazwaPliku) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(nazwaPliku));

            bw.write(Integer.toString(getIndex()));
            bw.newLine();

            for (int i = 0; i < getIndex(); i++) {
                bw.write(Integer.toString(tablica[i]));
                bw.newLine();
            }

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void maxTablica() {

        if (index == 0)
            return;

        int max = tablica[0];

        for (int i = 1; i < getIndex(); i++) {
            if (tablica[i] > max) {
                max = tablica[i];
            }
        }

        System.out.println(max);

    }

    public void minTablica() {

        if (index == 0)
            return;

        int min = tablica[0];

        for (int i = 1; i < getIndex(); i++) {
            if (tablica[i] < min) {
                min = tablica[i];
            }
        }

        System.out.println(min);

    }

    public void wyczysc() {

        while (index > 0) {
            usunKoniec();
        }

    }

}
