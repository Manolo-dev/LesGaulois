package personnages;

public class Romain {
	public Romain(String nom, int force) {
		this.nom = nom;
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
		force -= forceCoup;
		if(force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
	}

	public static void main(String[] args) {
		Romain bonus = new Romain("Caius Bonus", 8);
		System.out.println(bonus.prendreParole());
		bonus.parler("Salut !");
		bonus.recevoirCoup(10);
	}
	
	private String nom;
	private int force;
}
