package personnages;

public class Gaulois {
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	private String nom;
	private int force;
	private int effetPotion;
	public String getNom() {
		return nom;
	}
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	public String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	private void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		romain.rece
	}
	public static void main(String[] args) {
		
	}
}
