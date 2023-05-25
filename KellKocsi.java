package kellkocsi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KellKocsi {

    static ArrayList<Autok> autok = new ArrayList<Autok>();
    static ArrayList<Berles> berles = new ArrayList();
    
    public static void main(String[] args) throws IOException, ParseException {
        boolean megnyit=true;
        BufferedReader brAutok=null;
        BufferedReader brBerles=null;
        
        try {
            brAutok = new BufferedReader(new FileReader("c:/adat/autok.csv"));
        } catch (FileNotFoundException ex) {
            System.out.println("Az autok.csv-t nem sikerült megnyitni!");
            megnyit=false;
        }
        try {
            brBerles = new BufferedReader(new FileReader("c:/adat/Berles.csv"));
        } catch (FileNotFoundException ex) {
            System.out.println("Az Berles.csv-t nem sikerült megnyitni!");
            megnyit=false;
        }
        
        if (megnyit)
        {
            String sor = brAutok.readLine();
            while (sor !=null)
            {
                autok.add(new Autok(sor));
                sor = brAutok.readLine();
            }
            brAutok.close();
            
            sor = brBerles.readLine();
            while (sor !=null)
            {
                berles.add(new Berles(sor));
                sor=brBerles.readLine();
            }
            brBerles.close();
            
            System.out.println("1. feladat");
            System.out.println("Az adott ügyfélhet "+berles.size()+" bérlési esemény tartozok.");
            System.out.println("Az adott ügyfélhet "+autok.size()+" lülönböző autót bérelt.");
            
            Collections.sort(autok);
//            for (Autok auto: autok) {
//                System.out.println(auto);
//            }
            Collections.sort(berles);
            for (Berles egyBerles: berles) {
                System.out.println(egyBerles);
            }
            
            Scanner sc = new Scanner(System.in);
            System.out.print("Adja meg a rendszámot: ");
            String rendSzam = sc.nextLine();
            
            int berletiDij =-1000;
            for (Autok auto: autok) {
//                System.out.println(auto.getRendszam());
//                System.out.println(rendSzam);
                if (auto.getRendszam().equals(rendSzam)){
                    berletiDij=auto.getBerletiDij();
                    
                }
            }
            if (berletiDij>=0)
            {
                 for (Berles egyBerles: berles) {
                     if(egyBerles.getRendszam().equals(rendSzam))
                     {
                         SimpleDateFormat sdf= new SimpleDateFormat("yyyy.MM.dd", Locale.ENGLISH); 
                         Date kezdet = sdf.parse(egyBerles.getkDatum());
                         Date veg = sdf.parse(egyBerles.getvDatum());
                         System.out.println(kezdet);
                         System.out.println(veg);
                         long kulonbseg = veg.getTime()-kezdet.getTime();
                         long nap = TimeUnit.DAYS.convert(kulonbseg, TimeUnit.MILLISECONDS);
                         System.out.println(nap);
                     }
            }
            }
            else System.out.println("NIncs ilyen auto!");
            
            
            
        }
        
        
        
    }
    
}
