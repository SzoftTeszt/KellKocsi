
package kellkocsi;


public class Berles implements Comparable<Berles>{
    private String kDatum;
    private String vDatum;
    private String atvetel;
    private String leadas;
    private String rendszam;

    public Berles(String sor) {
        String[] t= sor.split(",");
        this.kDatum=t[0];
        this.vDatum=t[1];
        this.atvetel=t[2];
        this.leadas=t[3];
        this.rendszam=t[4];        
    }

    @Override
    public String toString() {
        return "Berles{" + "kDatum=" + kDatum + ", vDatum=" + vDatum + ", atvetel=" + atvetel + ", leadas=" + leadas + ", rendszam=" + rendszam + '}';
    }

    @Override
    public int compareTo(Berles o) {
        if (this.rendszam.compareTo(o.rendszam)==0)
            return this.kDatum.compareTo(o.kDatum);
        return this.rendszam.compareTo(o.rendszam);       
    }

    public String getkDatum() {
        return kDatum;
    }

    public void setkDatum(String kDatum) {
        this.kDatum = kDatum;
    }

    public String getvDatum() {
        return vDatum;
    }

    public void setvDatum(String vDatum) {
        this.vDatum = vDatum;
    }

    public String getAtvetel() {
        return atvetel;
    }

    public void setAtvetel(String atvetel) {
        this.atvetel = atvetel;
    }

    public String getLeadas() {
        return leadas;
    }

    public void setLeadas(String leadas) {
        this.leadas = leadas;
    }

    public String getRendszam() {
        return rendszam;
    }

    public void setRendszam(String rendszam) {
        this.rendszam = rendszam;
    }
    
    
    
    
    
    
    
    
}
