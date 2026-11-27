import java.util.Random;

public class Soci extends Thread {
    private Compte compte;
    private float aportacio = 10f;
    private int esperaMax = 100;
    private Random random = new Random();
    private int maxAnys = 10;

    public Soci() {
        this.compte = Compte.getInstance();
    }

    public Compte getCompte() { return compte; }

    @Override
    public void run() {
        for (int mes = 1; mes <= maxAnys * 12; mes++) {
            synchronized (compte) {
                if (mes % 2 == 0) {
                    compte.setSaldo(compte.getSaldo() + aportacio);
                } else {
                    compte.setSaldo(compte.getSaldo() - aportacio);
                }
            }

            try {
                Thread.sleep(random.nextInt(esperaMax));
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}