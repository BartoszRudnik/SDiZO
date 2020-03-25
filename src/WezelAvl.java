public class WezelAvl {

    private int wartosc;
    private int wysokosc;
    private WezelAvl lSyn;
    private WezelAvl pSyn;

    WezelAvl(int wartosc) {
        this.wartosc = wartosc;
        wysokosc = 1;
    }

    WezelAvl() {

    }

    public void setWartosc(int wartosc) {
        this.wartosc = wartosc;
    }

    public void setWysokosc(int wysokosc) {
        this.wysokosc = wysokosc;
    }

    public void setLSyn(WezelAvl wezel) {
        lSyn = wezel;
    }

    public void setPSyn(WezelAvl wezel) {
        pSyn = wezel;
    }

    public int getWartosc() {
        return wartosc;
    }

    public int getWysokosc() {
        return wysokosc;
    }

    public WezelAvl getlSyn() {
        return lSyn;
    }

    public WezelAvl getpSyn() {
        return pSyn;
    }

}
