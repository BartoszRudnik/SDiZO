import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AVL {

    WezelAvl korzen;

    private List<Integer> zapisPlik = new ArrayList<Integer>();

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

    public void wypiszPreorder(WezelAvl wezel) {

        if (wezel != null) {
            System.out.println(wezel.getWartosc());
            wypiszPreorder(wezel.getlSyn());
            wypiszPreorder(wezel.getpSyn());
        }

    }

    public void wypiszInorder(WezelAvl wezel) {

        if (wezel != null) {
            wypiszInorder(wezel.getlSyn());
            System.out.println(wezel.getWartosc());
            wypiszInorder(wezel.getpSyn());
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

    private void zapisPlik(WezelAvl wezel) {

        if (wezel != null) {
            zapisPlik.add(wezel.getWartosc());
            zapisPlik(wezel.getlSyn());
            zapisPlik(wezel.getpSyn());
        }

    }

    public void wczytajAVL(String nazwaPliku) {

        try {
            FileInputStream fstream = new FileInputStream(nazwaPliku);
            BufferedReader br = new BufferedReader((new InputStreamReader(fstream)));

            String line;
            int rozmiarPliku = 0;

            if ((line = br.readLine()) != null) {
                rozmiarPliku = Integer.parseInt(line);
            }

            for (int i = 0; i < rozmiarPliku; i++) {

                if ((line = br.readLine()) != null) {
                    korzen = dodaj(korzen, Integer.parseInt(line));
                }

            }

            fstream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void zapiszAvl(String nazwaPliku) {

        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter(nazwaPliku));

            zapisPlik(korzen);

            bw.write(Integer.toString(zapisPlik.size()));
            bw.newLine();

            for (int i = 0; i < zapisPlik.size(); i++) {
                bw.write(Integer.toString((Integer) zapisPlik.get(i)));
                bw.newLine();
            }

            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void odwrotneInorder(WezelAvl wezel) {

        if (wezel != null) {

            odwrotneInorder(wezel.getpSyn());
            System.out.println(wezel.getWartosc());
            odwrotneInorder(wezel.getlSyn());

        }

    }

    public void wydrukuj(WezelAvl wezel, String przerwa, boolean l) {

        if (wezel != null) {

            System.out.print(przerwa);
            if (wezel != korzen && l == true) {
                System.out.print("P----");
                przerwa += "    ";
            } else if (wezel != korzen) {
                System.out.print("L----");
                przerwa += "    ";
            } else
                przerwa += "    ";

            System.out.println(wezel.getWartosc());
            wydrukuj(wezel.getlSyn(), przerwa, false);
            wydrukuj(wezel.getpSyn(), przerwa, true);

        }

    }

}
