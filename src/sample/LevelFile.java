package sample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LevelFile {

    public static void createLevelFile(){
        final String lsep = System.getProperty("line.separator");
            PrintWriter pw = null;
            try {
                pw = new PrintWriter(new BufferedWriter(new FileWriter(ReadFileLevelSingleton.getInstance().fileName)));
            } catch (IOException ioe) {

            }
            pw.println("#Plik parametryczny gry." + lsep
                    + "#Komentarz zaczyna się od znaku # i obowiązuje do końca linii." + lsep
                    +  "NazwaPoziomu1=Poziom 1" +lsep
                    +  "LiczbaŻyć1=10" +lsep
                    +  "NazwaPoziomu2=Poziom 2" + lsep
                    +  "LiczbaŻyć2=10" +lsep
                    +  "NazwaPoziomu3=Poziom 3" + lsep
                    +  "LiczbaŻyć3=10");
            pw.close();

    }
}
