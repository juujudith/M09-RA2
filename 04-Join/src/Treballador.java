import java.util.Random;

public class Treballador extends Thread {
    private float sou_anual_brut;
    private int edat_inici_treball;
    private int edat_fi_treball;
    private int edat_actual;
    private float cobrat;
    private Random rnd;

    public Treballador(String nom, float sou_anual_brut, int edat_inici, int edat_fi) {
        super(nom);
        this.sou_anual_brut = sou_anual_brut;
        this.edat_inici_treball = edat_inici;
        this.edat_fi_treball = edat_fi;
        this.edat_actual = 0;
        this.cobrat = 0.0f;
        this.rnd = new Random();
    }

    public void cobra() {
        cobrat = cobrat + sou_anual_brut / 12;
    }

    public void pagaImpostos() {
        cobrat = cobrat - (sou_anual_brut / 12) * 0.24f;
    }

    @Override
    public void run() {
        edat_actual = edat_inici_treball;
        
        while (edat_actual < edat_fi_treball) {
            for (int mes = 1; mes <= 12; mes++) {
                cobra();
                pagaImpostos();
            }
            edat_actual++;
        }
    }

    public float getCobrat() { return cobrat; }
    public int getEdat() { return edat_actual; }
}