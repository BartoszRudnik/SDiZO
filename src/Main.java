public class Main {

    public static void main(String[] args) {

        Tablica tablica = new Tablica();

        tablica.wczytajTablica("wejscie.txt");
        tablica.zmniejszTablice();

        tablica.wyswietlTablica();
        tablica.zapiszTablice("wyjscie.txt");

        System.out.println();
        System.out.println(tablica.getPojemnosc());
        System.out.println(tablica.getIndex());


    }

}
