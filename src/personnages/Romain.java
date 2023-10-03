package personnages;

public class Romain {
	public Romain(String nom, int force) {
		this.nom = nom;
		assert force >= 0;
		this.force = force;
		this.equipements = new Equipement[2];
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
	
	public void sEquiper(Equipement equip) {
		switch(nbEquipement) {
		case 1:
			if(equip == equipements[0]) {
				System.out.println("Le soldat " + nom + " possède déjà un " + equip);
				break;
			}
		case 0:
			equipements[0] = equip;
			System.out.println("Le soldat " + nom + " s'équipe avec un " + equip);
			nbEquipement++;
			break;
		case 2:
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
		}
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
		Romain minus = new Romain("Minus", 6);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
	}
	
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement = 0;
}
