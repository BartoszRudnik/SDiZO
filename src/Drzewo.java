public class Drzewo {

    WezelDrzewo korzen;

    private static final int czerwony = 1;
    private static final int czarny = 0;

    public Drzewo() {

        korzen = new WezelDrzewo();

    }

    private void rotacjaLewo(WezelDrzewo wezel) {

        WezelDrzewo pomoc = wezel.getpSyn();
        wezel.setpSyn(pomoc.getlSyn());

        if (pomoc.getlSyn() != null)
            pomoc.getlSyn().setOjciec(wezel);

        pomoc.setOjciec(wezel.getOjciec());

        if (wezel.getOjciec() == null)
            korzen = pomoc;
        else if (wezel == wezel.getOjciec().getlSyn())
            wezel.getOjciec().setlSyn(pomoc);
        else
            wezel.getOjciec().setpSyn(pomoc);

        pomoc.setlSyn(wezel);
        wezel.setOjciec(pomoc);

    }

    private void rotacjaPrawo(WezelDrzewo wezel) {

        WezelDrzewo pomoc = wezel.getlSyn();
        wezel.setlSyn(pomoc.getpSyn());

        if (pomoc.getpSyn() != null) {
            pomoc.getpSyn().setOjciec(wezel);
        }

        pomoc.setOjciec(wezel.getOjciec());

        if (wezel.getOjciec() != null) {
            korzen = pomoc;
        } else if (wezel == wezel.getOjciec().getpSyn())
            wezel.getOjciec().setpSyn(pomoc);
        else
            wezel.getOjciec().setlSyn(pomoc);

        pomoc.setpSyn(wezel);
        wezel.setOjciec(pomoc);

    }

    public void dodajDrzewo(int wartosc) {

        WezelDrzewo wezel = new WezelDrzewo(wartosc);

        wezel.setlSyn(null);
        wezel.setpSyn(null);

        WezelDrzewo pomoc1 = new WezelDrzewo();
        WezelDrzewo pomoc2 = new WezelDrzewo();

        pomoc2 = korzen;

        while (pomoc2 != null) {

            pomoc1 = pomoc2;

            if (wezel.getWartosc() > pomoc2.getWartosc())
                pomoc2 = pomoc2.getpSyn();
            else
                pomoc2 = pomoc2.getlSyn();

        }

        wezel.setOjciec(pomoc1);

        if (wezel.getWartosc() < pomoc1.getWartosc())
            pomoc1.setlSyn(wezel);
        else if (wezel.getWartosc() > pomoc1.getWartosc())
            pomoc1.setpSyn(wezel);
        else
            korzen = wezel;

        if (wezel.getOjciec() == null) {
            wezel.setColor(czarny);
            return;
        }

        if (wezel.getOjciec().getOjciec() == null)
            return;

        wezel.setColor(czerwony);

        while (wezel != korzen && wezel.getOjciec().getColor() == czerwony) {

            if (wezel.getOjciec() == wezel.getOjciec().getOjciec().getlSyn()) {

                pomoc1 = wezel.getOjciec().getOjciec().getpSyn();
                if (pomoc1.getColor() == czerwony) {
                    wezel.getOjciec().setColor(czarny);
                    pomoc1.setColor(czarny);
                    wezel.getOjciec().getOjciec().setColor(czerwony);
                    wezel = wezel.getOjciec().getOjciec();
                } else if (wezel == wezel.getOjciec().getpSyn()) {
                    wezel = wezel.getOjciec();
                    rotacjaLewo(wezel);
                }
                wezel.getOjciec().setColor(czarny);
                wezel.getOjciec().getOjciec().setColor(czerwony);
                rotacjaPrawo(wezel.getOjciec().getOjciec());

            } else {

                pomoc1 = wezel.getOjciec().getOjciec().getlSyn();
                if (pomoc1 != null && pomoc1.getColor() == czerwony) {
                    wezel.getOjciec().setColor(czarny);
                    pomoc1.setColor(czarny);
                    wezel.getOjciec().getOjciec().setColor(czerwony);
                    wezel = wezel.getOjciec().getOjciec();
                } else if (wezel == wezel.getOjciec().getlSyn()) {
                    wezel = wezel.getOjciec();
                    rotacjaPrawo(wezel);
                }
                if (wezel.getOjciec() != null) {
                    wezel.getOjciec().setColor(czarny);
                    wezel.getOjciec().getOjciec().setColor(czerwony);
                    rotacjaLewo(wezel.getOjciec().getOjciec());
                }

            }

        }

        korzen.setColor(czarny);

    }

    public void wypiszPreorder(WezelDrzewo wezel) {

        if (wezel != null) {

            System.out.println(wezel.getWartosc() + wezel.getColor());
            wypiszPreorder(wezel.getlSyn());
            wypiszPreorder(wezel.getpSyn());

        }

    }

    public void wypiszInorder(WezelDrzewo wezel) {

        if (wezel != null) {

            wypiszInorder(wezel.getlSyn());
            System.out.println(wezel.getWartosc());
            wypiszInorder(wezel.getpSyn());

        }

    }

    public WezelDrzewo szukaj(WezelDrzewo wezel, int wartosc) {

        if (wezel == null || wezel.getWartosc() == wartosc)
            return wezel;

        else if (wezel.getWartosc() < wartosc)
            return szukaj(wezel.getlSyn(), wartosc);

        else
            return szukaj(wezel.getpSyn(), wartosc);

    }

    public int maximum(WezelDrzewo wezel) {

        while (wezel.getpSyn() != null)
            wezel = wezel.getpSyn();

        return wezel.getWartosc();

    }

    public int minimum(WezelDrzewo wezel) {

        while (wezel.getlSyn() != null)
            wezel = wezel.getlSyn();

        return wezel.getWartosc();

    }

}