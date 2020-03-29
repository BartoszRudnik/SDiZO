public class Main {

    public static void main(String[] args) {

        Drzewo drzewo = new Drzewo();

        drzewo.dodajDrzewo(7);
        drzewo.dodajDrzewo(6);
        drzewo.dodajDrzewo(5);
        drzewo.dodajDrzewo(4);
        drzewo.dodajDrzewo(3);
        drzewo.dodajDrzewo(2);
        drzewo.dodajDrzewo(1);

        drzewo.usunDrzewo(drzewo.getKorzen(), 5);

        drzewo.wypiszPreorder(drzewo.getKorzen());

        //drzewo.wydrukuj(drzewo.getKorzen(),"",true);

    }

}
