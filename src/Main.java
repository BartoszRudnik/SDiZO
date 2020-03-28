public class Main {

    public static void main(String[] args) {

        Drzewo drzewo = new Drzewo();

        drzewo.dodajDrzewo(31);
        drzewo.dodajDrzewo(412);
        drzewo.dodajDrzewo(516);
        drzewo.dodajDrzewo(77);
        drzewo.dodajDrzewo(91);
        drzewo.dodajDrzewo(710);
        drzewo.dodajDrzewo(11);
        drzewo.dodajDrzewo(22);

        drzewo.wypiszPreorder(drzewo.korzen);


    }

}
