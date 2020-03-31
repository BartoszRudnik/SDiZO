import java.io.*;
import java.util.Arrays;

public class Kopiec {

    private int[] kopiec;
    private int index;
    private int rozmiar;

    public Kopiec() {

        rozmiar = 3;
        index = 1;
        kopiec = new int[rozmiar + 1];

    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setRozmiar(int rozmiar) {
        this.rozmiar = rozmiar;
    }

    public int getIndex() {
        return index;
    }

    public int getRozmiar() {
        return rozmiar;
    }

    private void zwiekszIndex() {
        index++;
    }

    private void zmniejszIndex() {
        index--;
    }

    private int indexRodzic(int pozycja) {
        return (pozycja / 2);
    }

    private int indexLDziecko(int pozycja) {
        return (2 * pozycja);
    }

    private int indexPDziecko(int pozycja) {
        return (2 * pozycja + 1);
    }

    private void kopcuj(int pozycja) {

        int l = indexLDziecko(pozycja);
        int p = indexPDziecko(pozycja);
        int max;

        if (l < getRozmiar() && kopiec[l] > kopiec[pozycja]) {
            max = l;
        } else
            max = pozycja;

        if (p < getRozmiar() && kopiec[p] > kopiec[max]) {
            max = p;
        }

        if (max != pozycja) {
            int pomoc;
            pomoc = kopiec[pozycja];
            kopiec[pozycja] = kopiec[max];
            kopiec[max] = pomoc;
            kopcuj(max);
        }

    }

    private void budujKopiec() {

        setRozmiar(getIndex());
        for (int i = getRozmiar() / 2; i >= 1; i--) {
            kopcuj(i);
        }

    }

    public void dodaj(int liczba) {

        if (getIndex() >= getRozmiar()) {
            powiekszKopiec();
        }

        kopiec[index] = liczba;
        zwiekszIndex();
        budujKopiec();

    }

    public void usun(int liczba) {

        zmniejszKopiec(liczba);
        zmniejszIndex();
        budujKopiec();

    }

    public void usunKorzen() {

        zmniejszKopiec(kopiec[1]);
        zmniejszIndex();
        budujKopiec();

    }

    public void wyswietlKopiec() {

        for (int i = 1; i < getRozmiar(); i++) {
            System.out.println(kopiec[i]);
        }

    }

    private void powiekszKopiec() {

        int pomocnicza[] = new int[getRozmiar() + 1];

        for (int i = 1; i < getRozmiar(); i++) {

            pomocnicza[i] = kopiec[i];

        }

        setRozmiar(getRozmiar() + 1);

        kopiec = pomocnicza;

    }

    private void zmniejszKopiec(int liczba) {

        int pomocnicza[] = new int[getRozmiar() - 1];

        for (int i = 1; i < getRozmiar(); i++) {

            if (kopiec[i] == liczba) {

                for (int j = 1; j < i; j++) {
                    pomocnicza[j] = kopiec[j];
                }

                for (int k = (i + 1); k < getRozmiar(); k++) {
                    pomocnicza[k - 1] = kopiec[k];
                }

            }

        }

        setRozmiar(getRozmiar() - 1);
        kopiec = pomocnicza;

    }

    public boolean znajdzKopiec(int liczba) {

        int i = 1;

        while (i < getRozmiar()) {

            if (kopiec[i] == liczba)
                return true;
            i++;

        }

        return false;

    }

    public void zapiszKopiec(String nazwaPliku) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(nazwaPliku));

            bw.write(Integer.toString(getRozmiar() - 1));
            bw.newLine();

            for (int i = 1; i < getRozmiar(); i++) {
                bw.write(Integer.toString(kopiec[i]));
                bw.newLine();
            }

            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void wczytajKopiec(String nazwaPliku) {

        try {
            FileInputStream fstream = new FileInputStream(nazwaPliku);
            BufferedReader br = new BufferedReader((new InputStreamReader(fstream)));

            String line;
            int rozmiarPliku = 0;

            if ((line = br.readLine()) != null) {
                rozmiarPliku = Integer.parseInt(line);
            }

            for (int i = 1; i <= rozmiarPliku; i++) {
                if ((line = br.readLine()) != null)
                    dodaj(Integer.parseInt(line));
            }

            fstream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int maxKopiec() {
        return kopiec[1];
    }

    public int minKopiec() {

        int min = kopiec[1];

        for (int i = 2; i < getRozmiar(); i++) {
            if (kopiec[i] < min)
                min = kopiec[i];
        }

        return min;

    }

    private int log2(int x) {
        return (int) (Math.log(x) / Math.log(2));
    }

    private String stringOfSize(int size, char ch) {
        char[] a = new char[size];
        Arrays.fill(a, ch);
        return new String(a);
    }

    public void wydrukuj(int v, String przerwa, boolean l) {

        if (v < getRozmiar()) {

            System.out.print(przerwa);
            if (v > 1 && l == true) {
                System.out.print("P----");
                przerwa += "    ";
            } else if (v > 1) {
                System.out.print("L----");
                przerwa += "    ";
            } else
                przerwa += "    ";

            System.out.println(kopiec[v]);
            wydrukuj(indexLDziecko(v), przerwa, false);
            wydrukuj(indexPDziecko(v), przerwa, true);

        }

    }

}
