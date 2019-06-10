package sample;


import java.io.*;
import java.util.Properties;

public class ReadFileSingleton {
    private static ReadFileSingleton istance;
    public static ReadFileSingleton getInstance() {
        if(istance==null)

        {
            istance = new ReadFileSingleton();
        }
        return istance;
    }
    Properties props;
    String nazwaGry;
    String liczbaStopniTrudnosci;
    String zmianaStopniTrudnosci;
    String początkowaSzerokośćPlanszy;
    String początkowaWysokośćPlanszy;
    String początkowaSzerokośćObiektuGryJakoProcentPoczątkowejSzerokościPlanszy;
    String tło;
    String kolorTła1;
    String kolorTła2;
    String kolorTła3;
    String obiektyGry;
    String figuraObiektuGry;
    String nazwaBazowaPlikuZOpisemPoziomu;
    String rozszerzeniePlikuZOpisemPoziomu;
    private ReadFileSingleton() {
        props = new Properties();
        try (Reader r = new BufferedReader(new FileReader("par.txt"))) {
            props.load(r);
        } catch (FileNotFoundException fnfe) {
            System.out.println("Nie znalazlem");
        }
        catch (IOException ee)
        {
            System.out.println("Cos sie zepsulo");
        }
        liczbaStopniTrudnosci = props.getProperty("liczbaStopniTrudności");
        zmianaStopniTrudnosci = props.getProperty("zmianaStopniaTrudności");
        początkowaSzerokośćPlanszy=props.getProperty("początkowaSzerokośćPlanszy");
        początkowaWysokośćPlanszy = props.getProperty("początkowaWysokośćPlanszy");
        początkowaSzerokośćObiektuGryJakoProcentPoczątkowejSzerokościPlanszy = props.getProperty("początkowaSzerokośćObiektuGryJakoProcentPoczątkowejSzerokościPlanszy");
        tło = props.getProperty("tło");
        kolorTła1 = props.getProperty("kolorTła1");
        kolorTła2 = props.getProperty("kolorTła2");
        kolorTła3 = props.getProperty("kolorTła3");
        obiektyGry = props.getProperty("obiektyGry");
        figuraObiektuGry = props.getProperty("figuraObiektuGry");
        nazwaGry = props.getProperty("nazwaGry");
        nazwaBazowaPlikuZOpisemPoziomu = props.getProperty("nazwaBazowaPlikuZOpisemPoziomu");
        rozszerzeniePlikuZOpisemPoziomu = props.getProperty("rozszerzeniePlikuZOpisemPoziomu");


    }

}
