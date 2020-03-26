public class AVL {

    WezelAvl korzen;

    private int wysokosc(WezelAvl wezel) {
        if (wezel == null)
            return 0;
        else
            return wezel.getWysokosc();
    }

    private int maxWysokosc(WezelAvl wezel) {
        if (wezel != null)
            return (maksimum(wysokosc(wezel.getlSyn()), wysokosc(wezel.getpSyn())) + 1);
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
            return (maxWysokosc(wezel.getpSyn()) - maxWysokosc(wezel.getlSyn()));
        } else
            return 0;

    }

    public void wypiszAVL(WezelAvl wezel) {

        if (wezel != null) {
            System.out.println(wezel.getWartosc());
            wypiszAVL(wezel.getlSyn());
            wypiszAVL(wezel.getpSyn());
        }

    }

    private WezelAvl rotacjaPrawo(WezelAvl wezel) {

        WezelAvl pomoc;
        WezelAvl pomoc2;

        pomoc = wezel.getlSyn();
        pomoc2 = pomoc.getpSyn();

        pomoc.setPSyn(wezel);
        wezel.setLSyn(pomoc2);

        wezel.setWysokosc(maxWysokosc(wezel));
        pomoc.setWysokosc(maxWysokosc(pomoc));

        return pomoc;

    }

    private WezelAvl rotacjaLewo(WezelAvl wezel) {

        WezelAvl pomoc;
        WezelAvl pomoc2;

        pomoc = wezel.getpSyn();
        pomoc2 = pomoc.getlSyn();

        pomoc.setLSyn(wezel);
        wezel.setPSyn(pomoc2);

        wezel.setWysokosc(maxWysokosc(wezel));
        pomoc.setWysokosc(maxWysokosc(pomoc));

        return pomoc;

    }

    public WezelAvl dodaj(WezelAvl wezel, int wartosc) {

        int bilans;

        if (wezel == null)
            return (new WezelAvl(wartosc));

        if (wartosc == wezel.getWartosc())
            return wezel;

        else if (wartosc < wezel.getWartosc())
            wezel.setLSyn(dodaj(wezel.getlSyn(), wartosc));

        else
            wezel.setPSyn((dodaj(wezel.getpSyn(), wartosc)));

        wezel.setWysokosc(maxWysokosc(wezel));
        bilans = bilansWysokosci(wezel);

        if (bilans < -1 && wartosc < wezel.getlSyn().getWartosc())
            return rotacjaPrawo(wezel);

        else if (bilans < -1 && wartosc > wezel.getlSyn().getWartosc()) {
            wezel.setLSyn(rotacjaLewo(wezel.getlSyn()));
            return rotacjaPrawo(wezel);
        } else if (bilans > 1 && wartosc < wezel.getpSyn().getWartosc()) {
            wezel.setPSyn(rotacjaPrawo(wezel.getpSyn()));
            return rotacjaLewo(wezel);
        } else if (bilans > 1 && wartosc > wezel.getpSyn().getWartosc()) {
            return rotacjaLewo(wezel);
        } else {
            wezel.setWysokosc(maxWysokosc(wezel));
            return wezel;
        }
    }

    //usuwanie

}
