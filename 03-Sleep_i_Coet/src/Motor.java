public class Motor extends Thread {

    private volatile int potenciaObjectiu = 0;
    private volatile int potenciaActual = 0;

    public Motor(int id) {
        super("Motor " + id);
    }

    public void setPotencia(int p) {
        potenciaObjectiu = p;
    }

    @Override
    public void run() {
        while (true) {
            if (potenciaActual != potenciaObjectiu) {
                dormir(1000 + (int) (Math.random() * 1001));

                String accio;
                if (potenciaActual < potenciaObjectiu) {
                    potenciaActual++;
                    accio = "Incre.";
                } else {
                    potenciaActual--;
                    accio = "Decre.";
                }

                if (potenciaActual == potenciaObjectiu) {
                    accio = "FerRes";
                }

                System.out.println(getName() + ": " + accio + " Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);

                if (potenciaActual == 0 && potenciaObjectiu == 0) {
                    return;
                }
            } else {
                dormir(50);
            }
        }
    }

    private void dormir(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}