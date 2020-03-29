public class WezelDrzewo {

    private int wartosc;
    private WezelDrzewo ojciec;
    private WezelDrzewo lSyn;
    private WezelDrzewo pSyn;
    private int color;

    public WezelDrzewo(int wartosc) {

        this.wartosc = wartosc;

    }

    public WezelDrzewo() {

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

    public void setColor(int color) {
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

    public int getColor() {
        return color;
    }

}
