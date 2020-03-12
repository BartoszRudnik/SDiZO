public class Main {

    public static void main(String[] args) {

        Tablica tablica = new Tablica();

        tablica.dodajKoniec(100);
        tablica.wczytajTablica("wejscie.txt");
        tablica.zmniejszTablice();
        tablica.wyswietlTablica();
        tablica.wypiszTablice("wyjscie.txt");

        System.out.println();
        System.out.println(tablica.getIndex());
        System.out.println(tablica.getPojemnosc());
    }

}
