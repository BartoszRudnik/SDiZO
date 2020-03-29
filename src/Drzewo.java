public class Drzewo {

    private WezelDrzewo korzen;
    private WezelDrzewo straznik;

    private static final int czerwony = 1;
    private static final int czarny = 0;
    int rozmiar = 0;


    public Drzewo() {

        straznik = new WezelDrzewo();
        straznik.setColor(czarny);
        straznik.setlSyn(null);
        straznik.setpSyn(null);
        korzen = straznik;

    }

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

        if (wezel.getOjciec() == null) {
            korzen = pomoc;
        } else if (wezel == wezel.getOjciec().getpSyn())
            wezel.getOjciec().setpSyn(pomoc);
        else
            wezel.getOjciec().setlSyn(pomoc);

        pomoc.setpSyn(wezel);
        wezel.setOjciec(pomoc);

    }

    public final void dodajDrzewo(int wartosc) {

        WezelDrzewo wezel = new WezelDrzewo(wartosc);

        rozmiar++;

        wezel.setOjciec(null);
        wezel.setColor(czerwony);
        wezel.setpSyn(straznik);
        wezel.setlSyn(straznik);

        WezelDrzewo pomoc1 = null;
        WezelDrzewo pomoc2 = korzen;

        while (pomoc2 != straznik) {

            pomoc1 = pomoc2;

            if (wezel.getWartosc() < pomoc2.getWartosc())
                pomoc2 = pomoc2.getlSyn();
            else
                pomoc2 = pomoc2.getpSyn();

        }

        wezel.setOjciec(pomoc1);

        if (pomoc1 == null) {
            korzen = wezel;
        } else if (wezel.getWartosc() < pomoc1.getWartosc()) {
            pomoc1.setlSyn(wezel);
        } else {
            pomoc1.setpSyn(wezel);
        }

        if (wezel.getOjciec() == null) {
            wezel.setColor(czarny);
            return;
        }

        if (wezel.getOjciec().getOjciec() == null)
            return;

        odnowDrzewo(wezel);

    }

    private void odnowDrzewo(WezelDrzewo wezel) {

        WezelDrzewo pomoc1;

        while (wezel != korzen && czerwony == wezel.getOjciec().getColor()) {

            if (wezel.getOjciec() == wezel.getOjciec().getOjciec().getlSyn()) {

                pomoc1 = wezel.getOjciec().getOjciec().getpSyn();

                if (pomoc1.getColor() == czerwony) {

                    wezel.getOjciec().setColor(czarny);
                    pomoc1.setColor(czarny);
                    wezel.getOjciec().getOjciec().setColor(czerwony);
                    wezel = wezel.getOjciec().getOjciec();

                } else {

                    if (wezel == wezel.getOjciec().getpSyn()) {

                        wezel = wezel.getOjciec();
                        rotacjaLewo(wezel);

                    }

                    wezel.getOjciec().setColor(czarny);
                    wezel.getOjciec().getOjciec().setColor(czerwony);
                    rotacjaPrawo(wezel.getOjciec().getOjciec());

                }

            } else {

                pomoc1 = wezel.getOjciec().getOjciec().getlSyn();

                if (pomoc1.getColor() == czerwony) {

                    wezel.getOjciec().setColor(czarny);
                    pomoc1.setColor(czarny);
                    wezel.getOjciec().getOjciec().setColor(czerwony);
                    wezel = wezel.getOjciec().getOjciec();

                } else {

                    if (wezel == wezel.getOjciec().getlSyn()) {

                        wezel = wezel.getOjciec();
                        rotacjaPrawo(wezel);

                    }

                    wezel.getOjciec().setColor(czarny);
                    wezel.getOjciec().getOjciec().setColor(czerwony);
                    rotacjaLewo(wezel.getOjciec().getOjciec());

                }

            }

            if (wezel == korzen)
                break;

        }

        korzen.setColor(czarny);

    }

    public void wypiszPreorder(WezelDrzewo wezel) {

        if (wezel != straznik) {

            System.out.println(wezel.getWartosc() + wezel.getColor());
            wypiszPreorder(wezel.getlSyn());
            wypiszPreorder(wezel.getpSyn());

        }

    }

    public void wypiszInorder(WezelDrzewo wezel) {

        if (wezel != straznik) {

            wypiszInorder(wezel.getlSyn());
            System.out.println(wezel.getWartosc());
            wypiszInorder(wezel.getpSyn());

        }

    }

    public WezelDrzewo getKorzen() {
        return korzen;
    }

    public WezelDrzewo szukaj(WezelDrzewo wezel, int wartosc) {

        if (wezel == straznik || wezel.getWartosc() == wartosc)
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

    public void wydrukuj(WezelDrzewo wezel, String przerwa, boolean l) {


        if (wezel != straznik) {

            System.out.print(przerwa);
            if (wezel != korzen && l == true) {
                System.out.print("P----");
                przerwa += "      ";
            } else if (wezel != korzen) {
                System.out.print("L----");
                przerwa += "     ";
            }

            String color = wezel.getColor() == 0 ? "Czarny" : "Czerwony";
            System.out.println(wezel.getWartosc() + " " + color);
            wydrukuj(wezel.getlSyn(), przerwa, false);
            wydrukuj(wezel.getpSyn(), przerwa, true);

        }

    }

    private WezelDrzewo minWezel(WezelDrzewo wezel) {

        WezelDrzewo pomoc = wezel;

        while (pomoc.getlSyn() != null) {
            pomoc = pomoc.getlSyn();
        }

        return pomoc;

    }

    private WezelDrzewo nastepnik(WezelDrzewo wezel) {

        if (wezel.getpSyn() != null) {
            return minWezel(wezel.getpSyn());
        }

        WezelDrzewo pomoc = wezel.getOjciec();

        while (pomoc != null && wezel == pomoc.getpSyn()) {
            wezel = pomoc;
            pomoc = pomoc.getOjciec();
        }

        return pomoc;

    }

    public WezelDrzewo usunDrzewo(WezelDrzewo wezel, int wartosc) {

        WezelDrzewo pomoc1 = new WezelDrzewo();
        WezelDrzewo pomoc2 = new WezelDrzewo();

        if (wezel.getlSyn() == straznik || wezel.getpSyn() == straznik) {
            pomoc1 = wezel;
        } else {
            pomoc1 = nastepnik(wezel);
        }

        if (pomoc1.getlSyn() != straznik) {
            pomoc2 = pomoc1.getlSyn();
        } else {
            pomoc2 = pomoc1.getpSyn();
        }

        pomoc2.setOjciec(pomoc1.getOjciec());

        if (pomoc1.getOjciec() == straznik) {
            korzen = pomoc2;
        } else if (pomoc1 == pomoc1.getOjciec().getlSyn()) {
            pomoc1.getOjciec().setlSyn(pomoc2);
        } else {
            pomoc1.getOjciec().setpSyn(pomoc2);
        }

        if (pomoc1 != wezel) {
            wezel.setWartosc(pomoc1.getWartosc());
        }

        if (pomoc1.getColor() == czarny) {
            usunOdnow(pomoc2);
        }

        return pomoc1;

    }

    private void usunOdnow(WezelDrzewo wezel) {

        WezelDrzewo pomoc = null;

        while (wezel != korzen && wezel.getColor() == czarny) {

            if (wezel == wezel.getOjciec().getlSyn()) {

                pomoc = wezel.getOjciec().getpSyn();

                if (pomoc.getColor() == czerwony) {
                    pomoc.setColor(czarny);
                    wezel.getOjciec().setColor(czerwony);
                    rotacjaLewo(wezel.getOjciec());
                    pomoc = wezel.getOjciec().getpSyn();
                }


                if (pomoc.getlSyn().getColor() == czarny && pomoc.getpSyn().getColor() == czarny) {
                    pomoc.setColor(czerwony);
                    wezel = wezel.getOjciec();
                } else {

                    if (pomoc.getpSyn().getColor() == czarny) {
                        pomoc.getlSyn().setColor(czarny);
                        pomoc.setColor(czerwony);
                        rotacjaPrawo(pomoc);
                        pomoc = pomoc.getOjciec().getpSyn();
                    }

                    pomoc.setColor(wezel.getOjciec().getColor());
                    wezel.getOjciec().setColor(czarny);
                    pomoc.getpSyn().setColor(czarny);
                    rotacjaLewo(wezel.getOjciec());
                    wezel = korzen;

                }

            } else {

                pomoc = wezel.getOjciec().getlSyn();

                if (pomoc.getColor() == czerwony) {
                    pomoc.setColor(czarny);
                    wezel.getOjciec().setColor(czerwony);
                    rotacjaPrawo(wezel.getOjciec());
                    pomoc = wezel.getOjciec().getlSyn();
                }


                if (pomoc.getpSyn().getColor() == czarny && pomoc.getlSyn().getColor() == czarny) {
                    pomoc.setColor(czerwony);
                    wezel = wezel.getOjciec();
                } else {

                    if (pomoc.getlSyn().getColor() == czarny) {
                        pomoc.getpSyn().setColor(czarny);
                        pomoc.setColor(czerwony);
                        rotacjaLewo(pomoc);
                        pomoc = pomoc.getOjciec().getlSyn();
                    }

                    pomoc.setColor(wezel.getOjciec().getColor());
                    wezel.getOjciec().setColor(czarny);
                    pomoc.getlSyn().setColor(czarny);
                    rotacjaPrawo(wezel.getOjciec());
                    wezel = korzen;

                }

            }

            wezel.setColor(czarny);

        }
    }

}