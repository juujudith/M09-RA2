import java.util.Scanner;

public class Coet {

    private Motor[] motors = new Motor[4];

    public static void main(String[] args) {
        
        Coet coet = new Coet();
        coet.arranca();

        Scanner sc = new Scanner(System.in);

        int potencia = -1;

        while (potencia != 0) {
            potencia = sc.nextInt();

            try {
                coet.passaAPotencia(potencia);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }

    public Coet() {
        for (int i = 0; i < motors.length; i++) {
            motors[i] = new Motor(i);
        }
    }

    public void passaAPotencia(int potencia) {
        if (potencia < 0 || potencia > 10) {
            System.out.println("Error de valor: la potència ha d'estar entre 0 i 10");
            return;
        }

        System.out.println("Passant a potència " + potencia);
        
        for (int i = 0; i < motors.length; i++) {
            motors[i].setPotencia(potencia);
        }
    }

    public void arranca() {
        for (int i = 0; i < motors.length; i++) {
            motors[i].start();
        }
    }
}