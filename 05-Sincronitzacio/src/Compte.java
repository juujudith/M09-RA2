public class Compte {
    private static Compte instancia;
    private float saldo;

    private Compte() { }

    public static synchronized Compte getInstance() {
        if (instancia == null) {
            instancia = new Compte();
        }
        return instancia;
    }
    
    public float getSaldo() { return saldo; }
    public void setSaldo(float saldo) { this.saldo = saldo; }
}