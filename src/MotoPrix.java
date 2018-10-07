public class MotoPrix extends VehiculePrix implements InterfaceVehicule{

    private static final double MOTO_PRIX = 0.75;

    public MotoPrix(String var1, String var2, String var3) {
        super(var1, var2, var3,Vehicule.TYPE_MOTO);
    }

    public MotoPrix(String var1) {
        super(var1, "", "", -1);
    }

    @Override
    public double getPrix() {
        return MOTO_PRIX;
    }

    public String toString() {
        return "Moto " + super.toString();
    }
}
