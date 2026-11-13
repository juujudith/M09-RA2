public class Futbolista extends Thread {
    public static final int NUM_JUGADORS = 11;
    public static final int NUM_TIRADES = 20;
    public static final float PROBABILITAT = 0.5f;

    private int nGols;
    private int nTirades;

    public Futbolista(String nom) {
        super(nom);
        nGols = 0;
        nTirades = 0;
    }

    @Override
    public void run() {
        for (int i = 0; i < NUM_TIRADES; i++) {
            nTirades++;

            if (Math.random() < PROBABILITAT) {
                nGols++;
            }
        }
    }

    public int getNGols() { return nGols; }
    public int getNTirades() { return nTirades; }


    public static void main(String[] args) throws InterruptedException {
        String[] noms = {"Piqué", "Vinicius", "Torres", "Ramos", "Ronaldo", "Lewan", "Belli", "Arnau", "Aspas", "Messi", "MBapé"};

        Futbolista[] jugadors = new Futbolista[NUM_JUGADORS];

        for (int i = 0; i < NUM_JUGADORS; i++) {
            jugadors[i] = new Futbolista(noms[i]);
        }

        System.out.println("Inici dels xuts --------------------");
        for (Futbolista f : jugadors) {
            f.start();
        }

        for (Futbolista f : jugadors) {
            f.join();
        }
        System.out.println("Fi dels xuts -----------------------");

        System.out.println("--- Estadístiques ------");
        for (Futbolista f : jugadors) {
            System.out.printf("%-8s -> %2d gols%n", f.getName(), f.getNGols());
        }
    }
}