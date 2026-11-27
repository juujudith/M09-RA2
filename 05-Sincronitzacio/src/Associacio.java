public class Associacio {
    private int numSocis = 1000;
    private Soci[] socis;

    public static void main(String[] args) {
        Associacio associacio = new Associacio();
        associacio.iniciaCompteTempsSocis();
        associacio.esperaPeriodeSocis();
        associacio.mostraBalancComptes();
    }

    public Associacio() {
        socis = new Soci[numSocis];
    }

    public void iniciaCompteTempsSocis() {
        for (int i = 0; i < numSocis; i++) {
            socis[i] = new Soci();
            socis[i].start();
        }
    }

    public void esperaPeriodeSocis() {
        for (int i = 0; i < numSocis; i++) {
            try {
                socis[i].join();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    public void mostraBalancComptes() {
        System.out.printf("Saldo: %.2f%n", Compte.getInstance().getSaldo());
    }
}