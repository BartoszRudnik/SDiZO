public class AVL {

    WezelAvl korzen = new WezelAvl();

    private int wysokosc(WezelAvl wezel) {
        if (wezel != null)
            return wezel.getWysokosc();
        else
            return 0;
    }

    private int maksimum(int x, int y) {
        if (x > y)
            return x;
        else
            return y;
    }

    private int bilansWysokosci(WezelAvl wezel) {

        if (wezel != null) {
            return wysokosc(wezel.getlSyn()) - wysokosc(wezel.getpSyn());
        } else
            return 0;

    }

    public void wypiszAVL(WezelAvl wezel) {

        if (wezel != null) {
            System.out.println(wezel.getWartosc());
            wypiszAVL(wezel.getlSyn());
            wypiszAVL(wezel.getpSyn());
        } else
            return;

    }

    //rotacja lewa
    //rotacja prawa
    //dodawanie
    //usuwanie

}
