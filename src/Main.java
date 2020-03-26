public class Main {

    public static void main(String[] args) {

        AVL avl = new AVL();

        avl.korzen = avl.dodaj(avl.korzen, 10);
        avl.korzen = avl.dodaj(avl.korzen, 20);
        avl.korzen = avl.dodaj(avl.korzen, 30);
        avl.korzen = avl.dodaj(avl.korzen, 40);
        avl.korzen = avl.dodaj(avl.korzen, 50);
        avl.korzen = avl.dodaj(avl.korzen, 25);

        avl.wypiszAVL(avl.korzen);

    }

}
