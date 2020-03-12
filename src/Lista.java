public class Lista {

    class Element {

        private int wartosc;
        private Element nast;
        private Element poprz;

        Element(int wartosc) {
            this.wartosc = wartosc;
        }

        public void setWartosc(int wartosc) {
            this.wartosc = wartosc;
        }

        public void setNast(Element e) {
            nast = e;
        }

        public void setPoprz(Element e) {
            poprz = e;
        }

        public int getWartosc() {
            return wartosc;
        }

        public Element getNast() {
            return nast;
        }

        public Element getPoprz() {
            return poprz;
        }

    }

    Element head;

    public void dodajPoczatek(int liczba) {

        Element element = new Element(liczba);

        element.setPoprz(null);
        element.setNast(head);
        if (head != null)
            head.setPoprz(element);
        head = element;

    }

    public void dodajKoniec(int liczba) {

        Element element = new Element(liczba);
        Element pomocniczy;

        element.setNast(null);

        if (head == null) {
            element.setPoprz(null);
            head = element;
            return;
        }

        pomocniczy = head;

        while (pomocniczy.getNast() != null) {
            pomocniczy = pomocniczy.getNast();
        }

        pomocniczy.setNast(element);
        element.setPoprz(pomocniczy);

    }

    public void dodaj(int index, int liczba) {

    }

    public void usunPoczatek() {

    }

    public void usunKoniec() {

    }

    public void usun(int index) {

    }


    public void wyswietlLista() {

        Element testElement = head;

        while (testElement != null) {
            System.out.println(testElement.getWartosc());
            testElement = testElement.getNast();
        }

    }

}
