public class Fil extends Thread {
    private final int pausaMs;
    private final String missatgeFinal;
    
    public Fil(String nom, int prioritat, int pausaMs, String missatgeFinal) {
        super(nom);
        setPriority(prioritat);
        this.pausaMs = pausaMs;
        this.missatgeFinal = missatgeFinal;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 9; i++) {
            System.out.println(getName() + " " + i);

            if (pausaMs > 0) {
                try {
                    Thread.sleep(pausaMs);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }

            } else {
                long suma = 0;
                for (int j = 1; j <= 1000; j++) {
                    suma = suma + j;
                }
            }
        }
        System.out.println(missatgeFinal + " " + getName());
    }
}