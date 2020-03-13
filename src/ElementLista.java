public class ElementLista {

    private int wartosc;
    private ElementLista nast;
    private ElementLista poprz;

    ElementLista(int wartosc) {
        this.wartosc = wartosc;
        nast = null;
        poprz = null;
    }

    public void setWartosc(int wartosc) {
        this.wartosc = wartosc;
    }

    public void setNast(ElementLista e) {
        nast = e;
    }

    public void setPoprz(ElementLista e) {
        poprz = e;
    }

    public int getWartosc() {
        return wartosc;
    }

    public ElementLista getNast() {
        return nast;
    }

    public ElementLista getPoprz() {
        return poprz;
    }

}


