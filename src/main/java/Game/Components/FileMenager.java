package Game.Components;

import java.io.*;
import java.util.Scanner;

public class FileMenager {
    String obecnaLokacja;
    String nazwa;
    File plik;

    FileMenager() throws IOException {
        obecnaLokacja = new File(".").getCanonicalPath();
        System.out.println(obecnaLokacja);
        otworzPlik();
    }

    private void otworzPlik() {//nazwa pliku config
        nazwa = "config";
        try {
            plik = new File(obecnaLokacja, "\\" + "Pliki" + "\\" + nazwa + ".txt");
            if (!plik.exists()) {
                plik.createNewFile();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(plik);
    }

    String[][] wczytaj() {
        String dane[][] = new String[10][2];
        int licznik = 0;
        Scanner wpliku = null;
        try {
            wpliku = new Scanner(plik);
            while (wpliku.hasNextLine()) {

                dane[licznik][0] = wpliku.nextLine();
                dane[licznik][1] = wpliku.nextLine();
                licznik++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        wpliku.close();
        return dane;
    }
}

