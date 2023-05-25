package kellkocsi;

public class Autok implements Comparable<Autok>{
   private String rendszam;
   private int utasokSzama;
   private String tipus;
   private int berletiDij;

    public Autok(String sor) {
        String[] t= sor.split(",");
        this.rendszam = t[0];
        this.utasokSzama= Integer.parseInt(t[1]);
        this.tipus = t[2];
        this.berletiDij= Integer.parseInt(t[3]);
    }

    @Override
    public String toString() {
        return "Autok{" + "rendszam=" + rendszam + ", utasokSzama=" + utasokSzama + ", tipus=" + tipus + ", berletiDij=" + berletiDij + '}';
    }

    @Override
    public int compareTo(Autok o) {
         return this.rendszam.compareTo(o.rendszam);    
    }

    public String getRendszam() {
        return rendszam;
    }

    public void setRendszam(String rendszam) {
        this.rendszam = rendszam;
    }

    public int getUtasokSzama() {
        return utasokSzama;
    }

    public void setUtasokSzama(int utasokSzama) {
        this.utasokSzama = utasokSzama;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public int getBerletiDij() {
        return berletiDij;
    }

    public void setBerletiDij(int berletiDij) {
        this.berletiDij = berletiDij;
    }
   
    
    
   
}
