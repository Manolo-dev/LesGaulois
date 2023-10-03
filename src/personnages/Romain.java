package personnages;

public class Romain {
	public Romain(String nom, int force) {
		this.nom = nom;
		assert force >= 0;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "«" + texte + "»");
	}
	
	public void recevoirCoup(int forceCoup) {
		assert force >= 0;
		int forcebefore = force;
		force -= forceCoup;
		if(force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		assert forcebefore > force;
	}

	public static void main(String[] args) {
		Romain bonus = new Romain("Caius Bonus", 6);
		System.out.println(bonus.prendreParole());
		bonus.parler("Salut !");
		bonus.recevoirCoup(10);
	}
	
	private String nom;
	private int force;
}
