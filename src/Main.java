public class Main {

    public static void main(String[] args) {

        /*
        -Usuwanie z kopca
        -Zapis i odczyt do pliku
        -Wyszukanie dowolnego elementu kopca
         */

        Kopiec kopiec = new Kopiec();

        kopiec.dodajKopiec(22);
        kopiec.dodajKopiec(11);
        kopiec.dodajKopiec(41);
        kopiec.dodajKopiec(12);
        kopiec.dodajKopiec(120);
        kopiec.dodajKopiec(551);
        kopiec.dodajKopiec(412);
        kopiec.dodajKopiec(0);
        kopiec.dodajKopiec(212);
        kopiec.dodajKopiec(111);

        kopiec.wyswietlKopiec();


    }

}
