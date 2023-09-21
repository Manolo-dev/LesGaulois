package personnages;

public class Gaulois {
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		romain.recevoirCoup((force * effetPotion) / 3);
	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "«" + texte + "»");
	}
	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est" + forcePotion + "fois décuplée. ");
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		System.out.println(asterix);
		System.out.println(asterix.prendreParole());
		asterix.parler("Salut !");
		Romain minux = new Romain("Caligula Minus", 8);
		asterix.frapper(minux);
		asterix.boirePotion(7);
		asterix.frapper(minux);
	}
	
	private String nom;
	private int force;
	private int effetPotion = 1;
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
}
