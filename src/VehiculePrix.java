import java.util.Objects;

abstract class VehiculePrix extends Vehicule implements InterfaceVehicule{

    public VehiculePrix(String var1, String var2, String var3, int var4) {
        super(var1, var2, var3,var4);
    }
    public VehiculePrix(String var1) {
        super(var1, "", "", -1);
    }

    public String toString() {
        return super.toString();
    }
}
