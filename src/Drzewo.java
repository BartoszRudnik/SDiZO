public class Drzewo {

    private WezelDrzewo korzen;
    private WezelDrzewo straznik;

    private static final int czerwony = 1;
    private static final int czarny = 0;

    private void rotacjaLewo(WezelDrzewo wezel) {

        WezelDrzewo pomoc = wezel.getpSyn();
        wezel.setpSyn(pomoc.getlSyn());

        if (pomoc.getlSyn() != straznik)
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

        if (pomoc.getpSyn() != straznik) {
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

        wezel.setlSyn(straznik);
        wezel.setpSyn(straznik);

        WezelDrzewo pomoc1 = new WezelDrzewo();
        WezelDrzewo pomoc2 = new WezelDrzewo();

        pomoc2 = korzen;

        while (pomoc2 != straznik) {

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

        //odnowDrzewo();


    }


}