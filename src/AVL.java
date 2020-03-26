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
            return (wysokosc(wezel.getlSyn()) - wysokosc(wezel.getpSyn()));
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

        WezelAvl pomoc = wezel.getlSyn();
        WezelAvl pomoc2 = pomoc.getpSyn();

        pomoc.setPSyn(wezel);
        wezel.setLSyn(pomoc2);

        wezel.setWysokosc(maxWysokosc(wezel));
        pomoc.setWysokosc(maxWysokosc(pomoc));

        return pomoc;

    }

    private WezelAvl rotacjaLewo(WezelAvl wezel) {

        WezelAvl pomoc = wezel.getpSyn();
        WezelAvl pomoc2 = pomoc.getlSyn();

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

        if (wartosc > wezel.getWartosc())
            wezel.setPSyn((dodaj(wezel.getpSyn(), wartosc)));

        else if (wartosc < wezel.getWartosc())
            wezel.setLSyn(dodaj(wezel.getlSyn(), wartosc));

        else
            return wezel;

        wezel.setWysokosc(maxWysokosc(wezel));
        bilans = bilansWysokosci(wezel);

        if (bilans > 1 && wartosc < wezel.getlSyn().getWartosc()) {
            return rotacjaPrawo(wezel);
        }

        if (bilans < -1 && wartosc > wezel.getpSyn().getWartosc()) {
            return rotacjaLewo(wezel);
        }

        if (bilans > 1 && wartosc > wezel.getlSyn().getWartosc()) {
            wezel.setLSyn(rotacjaLewo(wezel.getlSyn()));
            return rotacjaPrawo(wezel);
        }

        if (bilans < -1 && wartosc < wezel.getpSyn().getWartosc()) {
            wezel.setPSyn(rotacjaPrawo(wezel.getpSyn()));
            return rotacjaLewo(wezel);
        }

        return wezel;

    }

    public WezelAvl usun(WezelAvl wezel, int wartosc) {

        int bilans;

        if (wezel == null) {
            return wezel;
        }

        if (wezel.getWartosc() > wartosc) {
            wezel.setLSyn(usun(wezel.getlSyn(), wartosc));
        } else if (wezel.getWartosc() < wartosc) {
            wezel.setPSyn(usun(wezel.getpSyn(), wartosc));
        } else {

            if (wezel.getlSyn() == null || wezel.getpSyn() == null) {

                WezelAvl pomoc = null;

                if (wezel.getlSyn() == pomoc)
                    pomoc = wezel.getpSyn();
                else
                    pomoc = wezel.getlSyn();

                if (pomoc == null) {
                    pomoc = wezel;
                    wezel = null;
                } else
                    wezel = pomoc;

            } else {

                WezelAvl pomoc = minWezel(wezel.getpSyn());

                wezel.setWartosc(pomoc.getWartosc());
                wezel.setPSyn(usun(wezel.getpSyn(), wezel.getWartosc()));

            }
        }

        if (wezel == null)
            return wezel;

        wezel.setWysokosc(maxWysokosc(wezel));
        bilans = bilansWysokosci(wezel);

        if (bilans > 1 && bilansWysokosci(wezel.getlSyn()) >= 0)
            return rotacjaPrawo(wezel);

        if (bilans > 1 && bilansWysokosci(wezel.getlSyn()) < 0) {
            wezel.setLSyn(rotacjaLewo(wezel.getlSyn()));
            return rotacjaPrawo(wezel);
        }

        if (bilans < -1 && bilansWysokosci(wezel.getpSyn()) <= 0) {
            return rotacjaLewo(wezel);
        }

        if (bilans < -1 && bilansWysokosci(wezel.getpSyn()) > 0) {
            wezel.setPSyn(rotacjaPrawo(wezel.getpSyn()));
            return rotacjaLewo(wezel);
        }

        return wezel;

    }

    private WezelAvl minWezel(WezelAvl wezel) {

        WezelAvl pomocnik = wezel;

        while (pomocnik.getlSyn() != null) {
            pomocnik = pomocnik.getlSyn();
        }

        return pomocnik;

    }


    public void AvlMin(WezelAvl wezel) {

        int min = wezel.getWartosc();

        while (wezel.getlSyn() != null) {
            min = wezel.getlSyn().getWartosc();
            wezel = wezel.getlSyn();
        }

        System.out.println(min);

    }

    public void AvlMax(WezelAvl wezel) {

        int max = wezel.getWartosc();

        while (wezel.getpSyn() != null) {
            max = wezel.getpSyn().getWartosc();
            wezel = wezel.getpSyn();
        }

        System.out.println(max);

    }

}
