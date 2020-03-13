import java.io.*;

public class Lista {

    private ElementLista glowa;

    public ElementLista getGlowa() {
        return glowa;
    }

    public void setGlowa(ElementLista glowa) {
        this.glowa = glowa;
    }

    public void dodajPoczatek(int liczba) {

        ElementLista element = new ElementLista(liczba);

        element.setPoprz(null);
        element.setNast(getGlowa());
        if (getGlowa() != null)
            getGlowa().setPoprz(element);
        setGlowa(element);

    }

    public void dodajKoniec(int liczba) {

        ElementLista element = new ElementLista(liczba);
        ElementLista pomocniczy;

        element.setNast(null);

        if (getGlowa() == null) {
            element.setPoprz(null);
            setGlowa(element);
            return;
        }

        pomocniczy = getGlowa();

        while (pomocniczy.getNast() != null) {
            pomocniczy = pomocniczy.getNast();
        }

        pomocniczy.setNast(element);
        element.setPoprz(pomocniczy);

    }

    public void dodaj(int pozycja, int liczba) {

        ElementLista element = new ElementLista(liczba);
        ElementLista pomocniczy = getGlowa();

        if (pozycja > rozmiarListy())
            pozycja = rozmiarListy();

        if (pozycja == 0)
            dodajPoczatek(liczba);
        else {
            for (int i = 1; i < pozycja; i++) {
                if (pomocniczy != null)
                    pomocniczy = pomocniczy.getNast();
                else
                    return;
            }

            element.setNast(pomocniczy.getNast());
            pomocniczy.setNast(element);
            element.setPoprz(pomocniczy);

            if (element.getNast() != null)
                element.getNast().setPoprz(element);
        }

    }

    private ElementLista usun(ElementLista glowa, ElementLista usuwany) {

        if (glowa == null || usuwany == null)
            return null;

        if (glowa == usuwany) {
            glowa.setNast(usuwany.getNast());
        }

        if (usuwany.getNast() != null)
            usuwany.getNast().setPoprz(usuwany.getPoprz());

        if (usuwany.getPoprz() != null)
            usuwany.getPoprz().setNast(usuwany.getNast());

        usuwany = null;

        return glowa;

    }

    public void usunPoczatek() {

        if (getGlowa() == null)
            return;

        if (getGlowa().getPoprz() != null)
            getGlowa().setPoprz(null);

        setGlowa(getGlowa().getNast());
    }

    public void usunKoniec() {

        if (getGlowa() == null)
            return;

        ElementLista element = getGlowa();

        if (element.getNast() == null)
            usunPoczatek();

        while (element.getNast() != null) {
            element = element.getNast();
        }

        if (element.getPoprz() != null)
            element.getPoprz().setNast(null);

    }

    public void usunWskazany(int pozycja) {

        if (getGlowa() == null || pozycja < 0)
            return;

        if (pozycja == 0)
            usunPoczatek();

        ElementLista element = getGlowa();

        for (int i = 1; i <= pozycja; i++) {
            if (element != null) {
                element = element.getNast();
            } else {
                return;
            }
        }

        usun(getGlowa(), element);

    }

    public void wyswietlElement(int pozycja) {

        if (getGlowa() == null || pozycja < 0)
            return;

        ElementLista element = getGlowa();

        for (int i = 0; i < pozycja; i++) {
            if (element != null)
                element = element.getNast();
            else
                return;
        }

        System.out.println(element.getWartosc());

    }


    public void wyswietlLista() {

        ElementLista testElement = getGlowa();

        while (testElement != null) {
            System.out.println(testElement.getWartosc());
            testElement = testElement.getNast();
        }

    }

    public void wyswietlLista(ElementLista element) {

        while (element != null) {
            System.out.println(element.getWartosc());
            element = element.getNast();
        }

    }

    private int rozmiarListy() {

        int rozmiar = 0;
        ElementLista element = getGlowa();

        while (element != null) {
            element = element.getNast();
            rozmiar++;
        }

        return rozmiar;

    }

    public void wczytajLista(String nazwaPliku) {

        try {
            FileInputStream fstream = new FileInputStream(nazwaPliku);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            String line;
            int rozmiarPliku = 0;

            if ((line = br.readLine()) != null) {
                rozmiarPliku = Integer.parseInt(line);
            }

            for (int i = 0; i < rozmiarPliku; i++) {
                if ((line = br.readLine()) != null) {
                    dodaj(rozmiarListy(), Integer.parseInt(line));
                }
            }

            fstream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void zapiszLista(String nazwaPliku) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(nazwaPliku));

            bw.write(Integer.toString(rozmiarListy()));
            bw.newLine();

            ElementLista element = getGlowa();

            for (int i = 0; i < rozmiarListy(); i++) {
                bw.write(Integer.toString(element.getWartosc()));
                bw.newLine();
                element = element.getNast();
            }

            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
