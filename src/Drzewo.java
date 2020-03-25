public class Drzewo {

    WezelDrzewo wierzchołek;
    private boolean czerwony = true;
    private boolean czarne = false;

    int rozmiar = 0;

    public Drzewo() {
        wierzchołek.setOjciec(null);
        wierzchołek.setpSyn(null);
        wierzchołek.setlSyn(null);
    }

    public void dodaj(int wartosc) {

        WezelDrzewo dodaj = new WezelDrzewo(wartosc);
        WezelDrzewo lewe = new WezelDrzewo();
        WezelDrzewo prawe = new WezelDrzewo();

        rozmiar++;

        if (wierzchołek == null) {

            wierzchołek = dodaj;
            wierzchołek.setColor(czarne);
            wierzchołek.setlSyn(lewe);
            wierzchołek.setpSyn(prawe);
            lewe.setOjciec(wierzchołek);
            prawe.setOjciec(wierzchołek);

        } else {
            dodaj.setColor(czerwony);
            while (true) {
                if (wartosc < dodaj.getOjciec().getWartosc()) {

                    if (dodaj.getOjciec().getlSyn() == null) {
                        dodaj.getOjciec().setlSyn(dodaj);
                        break;
                    } else
                        dodaj.setOjciec(dodaj.getOjciec().getlSyn());
                } else {
                    if (dodaj.getOjciec().getpSyn() == null) {
                        dodaj.getOjciec().setpSyn(dodaj);
                        break;
                    } else
                        dodaj.setOjciec(dodaj.getOjciec().getlSyn());
                }
            }
        }

        dodajOdnow(dodaj);

    }

    private WezelDrzewo dodajOdnow(WezelDrzewo dodaj) {

        WezelDrzewo pomoc1 = new WezelDrzewo();
        WezelDrzewo pomoc2 = new WezelDrzewo();

        if (wierzchołek == dodaj) {
            dodaj.setColor(czarne);
        } else {

        }

    }


    public WezelDrzewo rotacjaLewo(WezelDrzewo w) {

        WezelDrzewo x = w.getpSyn();
        w.setpSyn(x.getlSyn());
        x.setlSyn(w);
        x.setColor(w.getColor());
        w.setColor(czerwony);
        return x;

    }

    public WezelDrzewo rotacjaPrawo(WezelDrzewo w) {

        WezelDrzewo x = w.getlSyn();
        w.setlSyn(x.getpSyn());
        x.setpSyn(w);
        x.setColor(w.getColor());
        w.setColor(czerwony);
        return x;

    }

    private boolean isNull(WezelDrzewo wezel) {

        if (wezel == null)
            return true;
        else
            return false;

    }

}
