public class WezelDrzewo {

    private int wartosc;
    WezelDrzewo ojciec;
    WezelDrzewo lSyn;
    WezelDrzewo pSyn;
    boolean color;

    public WezelDrzewo() {

        wartosc = 0;
        ojciec = null;
        lSyn = null;
        pSyn = null;
        color = false // false -> czarny, true -> czerwony

    }

    public WezelDrzewo(int wartosc) {

        this.wartosc = wartosc;
        ojciec = null;
        lSyn = null;
        pSyn = null;
        color = false;

    }

    public void setWartosc(int wartosc) {
        this.wartosc = wartosc;
    }

    public void setOjciec(WezelDrzewo ojciec) {
        this.ojciec = ojciec;
    }

    public void setlSyn(WezelDrzewo lSyn) {
        this.lSyn = lSyn;
    }

    public void setpSyn(WezelDrzewo pSyn) {
        this.pSyn = pSyn;
    }

    public void setColor(Boolean color) {
        this.color = color;
    }

    public int getWartosc() {
        return wartosc;
    }

    public WezelDrzewo getOjciec() {
        return ojciec;
    }

    public WezelDrzewo getlSyn() {
        return lSyn;
    }

    public WezelDrzewo getpSyn() {
        return pSyn;
    }

    public boolean getColor() {
        return color;
    }

}
