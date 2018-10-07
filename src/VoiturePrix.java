import java.util.Objects;

public class VoiturePrix extends VehiculePrix implements InterfaceVehicule {

    private static final double VOITURE_PRIX = 3;

    public VoiturePrix(String var1, String var2, String var3) {
        super(var1, var2, var3,Vehicule.TYPE_VOITURE);
    }

    public VoiturePrix(String var1) {
        super(var1, "", "", -1);
    }

    @Override
    public double getPrix() {
        return VOITURE_PRIX;
    }

    public String toString() {
        return "Voiture  " + super.toString();
    }
}
