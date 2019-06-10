package sample;

import java.io.*;
import java.util.Properties;

public class ReadFileLevelSingleton {
    private static ReadFileLevelSingleton ourInstance = new ReadFileLevelSingleton();

    public static ReadFileLevelSingleton getInstance() {
        return ourInstance;
    }
    Properties levelProp;
    String file;
    String end;
    String fileName;
    String liczbaŻyć2;
    String liczbaŻyć3;
    String liczbaŻyć1;
    String nazwaPoziomu1;
    String nazwaPoziomu2;
    String nazwaPoziomu3;

    private ReadFileLevelSingleton() {
        file=ReadFileSingleton.getInstance().nazwaBazowaPlikuZOpisemPoziomu;
        end=ReadFileSingleton.getInstance().rozszerzeniePlikuZOpisemPoziomu;
        fileName=file+"."+end;
        levelProp = new Properties();
        try (Reader r = new BufferedReader(new FileReader(fileName))) {
            levelProp.load(r);
        } catch (FileNotFoundException fnfe) {
            System.out.println("Nie znalazlem");
        }
        catch (IOException ee)
        {
            System.out.println("Cos sie stalo");
        }
        liczbaŻyć2=levelProp.getProperty("LiczbaŻyć2");
        nazwaPoziomu2 = levelProp.getProperty("NazwaPoziomu2");
        liczbaŻyć1=levelProp.getProperty("LiczbaŻyć1");
        nazwaPoziomu1 = levelProp.getProperty("NazwaPoziomu1");
        liczbaŻyć3=levelProp.getProperty("LiczbaŻyć3");
        nazwaPoziomu3 = levelProp.getProperty("NazwaPoziomu3");
    }
}
