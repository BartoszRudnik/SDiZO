public class Main {

    public static void main(String[] args) {

        Tablica tablica = new Tablica();

        tablica.dodajKoniec(100);
        tablica.wczytajTablica("plik.txt");
        tablica.zmniejszTablice();
        tablica.wyswietlTablica();

        System.out.println();
        System.out.println(tablica.getIndex());
        System.out.println(tablica.getPojemnosc());
    }

}
