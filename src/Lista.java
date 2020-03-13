class Element {

    private int wartosc;
    private Element nast;
    private Element poprz;

    Element(int wartosc) {
        this.wartosc = wartosc;
        nast = null;
        poprz = null;
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

public class Lista {

    private Element glowa;

    public Element getGlowa() {
        return glowa;
    }

    public void setGlowa(Element glowa) {
        this.glowa = glowa;
    }

    public void dodajPoczatek(int liczba) {

        Element element = new Element(liczba);

        element.setPoprz(null);
        element.setNast(getGlowa());
        if (getGlowa() != null)
            getGlowa().setPoprz(element);
        setGlowa(element);

    }

    public void dodajKoniec(int liczba) {

        Element element = new Element(liczba);
        Element pomocniczy;

        element.setNast(null);

        if (getGlowa() == null) {
            element.setPoprz(null);
            setGlowa(element);
            return;
        }

        pomocniczy = getGlowa();

        while (pomocniczy.getNast() != null) {
            pomocniczy = pomocniczy.getNast();
        }

        pomocniczy.setNast(element);
        element.setPoprz(pomocniczy);

    }

    public void dodaj(Element poprzednik, int liczba) {

        Element element = new Element(liczba);

        if (poprzednik == null) {
            dodajKoniec(liczba);
        } else {
            element.setNast(poprzednik.getNast());
            poprzednik.setNast(element);
            element.setPoprz(poprzednik);
            if (element.getNast() != null)
                element.getNast().setPoprz(element);
        }

    }

    private Element usun(Element glowa, Element usuwany) {

        if (glowa == null || usuwany == null)
            return null;

        if (glowa == usuwany) {
            glowa.setNast(usuwany.getNast());
        }

        if (usuwany.getNast() != null)
            usuwany.getNast().setPoprz(usuwany.getPoprz());

        if (usuwany.getPoprz() != null)
            usuwany.getPoprz().setNast(usuwany.getNast());

        usuwany = null;

        return glowa;

    }

    public void usunPoczatek() {

        if (getGlowa() == null)
            return;

        if (getGlowa().getPoprz() != null)
            getGlowa().setPoprz(null);

        setGlowa(getGlowa().getNast());
    }

    public void usunKoniec() {

        if (getGlowa() == null)
            return;

        Element element = getGlowa();

        if (element.getNast() == null)
            usunPoczatek();

        while (element.getNast() != null) {
            element = element.getNast();
        }

        if (element.getPoprz() != null)
            element.getPoprz().setNast(null);

    }

    public void usunWskazany(int pozycja) {

        if (getGlowa() == null || pozycja < 0)
            return;

        if (pozycja == 0)
            usunPoczatek();

        Element element = getGlowa();

        for (int i = 1; i <= pozycja; i++) {
            if (element != null) {
                element = element.getNast();
            } else {
                return;
            }
        }

        usun(getGlowa(), element);

    }


    public void wyswietlLista() {

        Element testElement = getGlowa();

        while (testElement != null) {
            System.out.println(testElement.getWartosc());
            testElement = testElement.getNast();
        }

    }

    public void wyswietlLista(Element element) {

        while (element != null) {
            System.out.println(element.getWartosc());
            element = element.getNast();
        }

    }
}
