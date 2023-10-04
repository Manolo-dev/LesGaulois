package personnages;

public class Romain {
	public Romain(String nom, int force) {
		this.nom = nom;
		if(force < 0) {
			throw new IllegalArgumentException("The force must be positive");
		}
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
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
				System.out.println(pres + nom + " possède déjà un " + equip);
				break;
			}
		case 0:
			equipements[0] = equip;
			System.out.println(pres + nom + " s'équipe avec un " + equip);
			nbEquipement++;
			break;
		case 2:
			System.out.println(pres + nom + " est déjà bien protégé !");
			break;
		default:
			throw new IndexOutOfBoundsException("There cannot be more than two pieces of equipment");
		}
	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
	    Equipement[] equipementEjecte = null;
	    if(force <= 0) {
	    	throw new IllegalStateException("Precondition not respected");
	    }
	    int oldForce = force;
	    forceCoup = calculResistanceEquipement(forceCoup);
	    force -= forceCoup;
	    if(force == 0)
	        parler("Aïe");
        equipementEjecte = ejecterEquipement();
        parler("J'abandonne...");
	    if(force >= oldForce) {
	    	throw new IllegalStateException("Postcondition not respected");
	    }
	    return equipementEjecte;
	}
	
	private int calculResistanceEquipement(int forceCoup) {
	    String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
	    int resistanceEquipement = 0;
	    if(nbEquipement != 0) {
	        texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
	        for(int i = 0; i < nbEquipement; i++) {
	            if((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
	                resistanceEquipement += 8;
	            } else {
	                System.out.println("Equipement casque");
	                resistanceEquipement += 5;
	            }
	        }
	        texte += resistanceEquipement + "!";
	    }
	    parler(texte);
	    forceCoup -= resistanceEquipement;
	    if(forceCoup < 0) {
	    	forceCoup = 0;
	    }
	    return forceCoup;
	}
	
	private Equipement[] ejecterEquipement() {
	    Equipement[] equipementEjecte = new Equipement[nbEquipement];
	    System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
	    int nbEquipementEjecte = 0;
	    for(int i = 0; i < nbEquipement; i++) {
	        if(equipements[i] != null) {
	            equipementEjecte[nbEquipementEjecte] =
	            equipements[i];
	            nbEquipementEjecte++;
	            equipements[i] = null;
	        }
	    }
	    return equipementEjecte;
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
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	private static String pres = "Le soldat ";
}
