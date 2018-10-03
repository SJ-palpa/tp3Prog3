//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


public abstract class Vehicule {
	public static final int TYPE_NON_DEFINI = -1;
	public static final int TYPE_VELO = 0;
	public static final int TYPE_MOTO = 1;
	public static final int TYPE_VOITURE = 2;
	private String immatriculation;
	private String nom;
	private String prenom;
	private int type;

	public Vehicule(String var1, String var2, String var3, int var4) {
		this.immatriculation = var1;
		this.nom = var2;
		this.prenom = var3;
		this.type = var4;
	}

	public Vehicule(String var1) {
		this(var1, "", "", -1);
	}

	public boolean equals(Object var1) {
		return this.immatriculation.equals(((Vehicule)var1).immatriculation);
	}

	public boolean equalsId(String var1) {
		return this.immatriculation.equals(var1);
	}

	public boolean equalsType(int var1) {
		return var1 == this.type;
	}

	public String toString() {
		return this.immatriculation + ", " + this.prenom + " " + this.nom;
	}
}
