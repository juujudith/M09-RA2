public class Administracio {
    private int num_poblacio_activa = 50;
    private Treballador[] poblacio_activa = new Treballador[num_poblacio_activa];

    public Administracio() {
        for (int i = 0; i < num_poblacio_activa; i++) {
            poblacio_activa[i] = new Treballador("Ciutadà-" + i, 25000, 20, 65);
        }
    }

    
}