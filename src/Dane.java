import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Dane {

    private static final int maxi = Integer.MAX_VALUE - 1;


    public void generuj(int tab[]) {

        Random r = new Random();

        for (int i = 0; i < tab.length; i++) {

            tab[i] = r.nextInt(maxi);

        }

    }

    public void zapisz(String nazwa, int tab[]) {

        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter(nazwa));

            bw.write(Integer.toString(tab.length));
            bw.newLine();

            for (int i = 0; i < tab.length; i++) {
                bw.write(Integer.toString(tab[i]));
                bw.newLine();
            }

            bw.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void zapisz(String nazwa, long tab[]) {

        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter(nazwa));

            bw.write(Integer.toString(tab.length));
            bw.newLine();

            for (int i = 0; i < tab.length; i++) {
                bw.write(Long.toString(tab[i]));
                bw.newLine();
            }

            bw.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
