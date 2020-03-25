public class Drzewo {

    WezelDrzewo wierzchołek;
    private boolean czerwony = true;
    private boolean czarny = false;

    public Drzewo() {

    }

    private boolean isRed(WezelDrzewo wezel) {

        if (wezel == null)
            return false;
        else if (wezel.getColor() == true)
            return true;
        else
            return false;

    }

    private int rozmiar(WezelDrzewo wezel) {

        if (wezel != null)
            return wezel.getRozmiar();
        else
            return 0;

    }

    public WezelDrzewo getWierzchołek() {
        return wierzchołek;
    }

    public void dodajDrzewo(int wartosc) {

        wierzchołek = dodaj(wierzchołek, wartosc);
        wierzchołek.setColor(czarny);

    }

    private WezelDrzewo dodaj(WezelDrzewo wezel, int wartosc) {

        if (wezel == null)
            return new WezelDrzewo(wartosc);

        if (wezel.getWartosc() < wartosc)
            wezel.setlSyn(dodaj(wezel.getlSyn(), wartosc));
        else if (wezel.getWartosc() > wartosc)
            wezel.setpSyn(dodaj(wezel.getpSyn(), wartosc));
        else
            wezel.setWartosc(wartosc);

        if (isRed(wezel.getpSyn()) == true && isRed(wezel.getlSyn()) == false)
            wezel = rotacjaLewo(wezel);

        if (isRed(wezel.getlSyn()) == true && isRed(wezel.getlSyn().getlSyn()) == true)
            wezel = rotacjaPrawo(wezel);

        if (isRed(wezel.getlSyn()) == true && isRed(wezel.getpSyn()) == true)
            kolory(wezel);

        wezel.setRozmiar(rozmiar(wezel.getpSyn()) + rozmiar(wezel.getlSyn()));

        return wezel;

    }


    private WezelDrzewo rotacjaLewo(WezelDrzewo w) {

        WezelDrzewo x = w.getpSyn();
        w.setpSyn(x.getlSyn());
        x.setlSyn(w);
        x.setColor(w.getColor());
        w.setColor(czerwony);
        return x;

    }

    private WezelDrzewo rotacjaPrawo(WezelDrzewo w) {

        WezelDrzewo x = w.getlSyn();
        w.setlSyn(x.getpSyn());
        x.setpSyn(w);
        x.setColor(w.getColor());
        w.setColor(czerwony);
        return x;

    }

    private void kolory(WezelDrzewo wezel) {

        if (wezel.getColor() == czerwony)
            wezel.setColor(czarny);
        else
            wezel.setColor(czerwony);

        if (wezel.getlSyn().getColor() == czerwony)
            wezel.getlSyn().setColor(czarny);
        else
            wezel.getlSyn().setColor(czerwony);

        if (wezel.getpSyn().getColor() == czerwony)
            wezel.getpSyn().setColor(czarny);
        else
            wezel.getpSyn().setColor(czerwony);

    }

    private boolean isNull(WezelDrzewo wezel) {

        if (wezel == null)
            return true;
        else
            return false;

    }

    public void wypisz(WezelDrzewo wezel) {

        if (wezel == null)
            return;

        System.out.println(((wezel.getColor() == czerwony) ? "Color: Red " : "Color: Black ") + " " + "Wartosc: " + wezel.getWartosc());
        wypisz(wezel.getlSyn());
        wypisz(wezel.getpSyn());

    }


}
