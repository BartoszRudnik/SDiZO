public class Kopiec {

    private int[] kopiec;
    private int index;
    private int rozmiar;

    public Kopiec() {

        rozmiar = 3;
        index = 1;
        kopiec = new int[rozmiar];

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

    public void dodajKopiec(int liczba) {

        if (getIndex() >= getRozmiar()) {
            powiekszKopiec();
        }

        kopiec[index] = liczba;
        zwiekszIndex();
        budujKopiec();

    }

    public void wyswietlKopiec() {

        for (int i = 1; i < index; i++) {
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

}
