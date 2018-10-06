public class VeloPrix extends VehiculePrix implements InterfaceVehicule {

    private static final double VELO_PRIX = 0.25;

    public VeloPrix(String var1, String var2, String var3) {
        super(var1, var2, var3,Vehicule.TYPE_VELO);
    }

    @Override
    public double getPrix() {
        return VELO_PRIX;
    }

    public String toString() {
        return "Velo " + super.toString();
    }
}
