package villagegaulois;

import personnages.Druide;
import personnages.Gaulois;
import personnages.Chef;

public class Village {
	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMaximum];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public void setDruide(Druide druide) {
		this.druide = druide;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois habitant) {
		this.villageois[nbVillageois] = habitant;
		nbVillageois++;
	}
	
	public Gaulois trouverHabitant(int n) {
		return villageois[n];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le chef du chef " + chef.getNom() + " vivent les légendaires gaulois :");
		for(int i = 0; i < nbVillageois; i++) {
			System.out.println("- " + villageois[i].getNom());
		}
		System.out.println("Et le spectaculaire druide : " + this.druide.getNom());
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
		// code<Gaulois gaulois = village.trouverHabitant(30);>
		// Le villageois n°30 n'existe pas, il y a au max 30 villageois et leurs numéros commencent à 0, le dernier villageois est donc le n°29.
		Chef abraracourcix = new Chef("Abraracourcix", 6, village);
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Asterix", 8);
		village.ajouterHabitant(asterix);
		// code<Gaulois gaulois = village.trouverHabitant(1);>
		// code<System.out.println(gaulois);>
		// null est afiché, LE GAULOIS n°1 N'EXISTE PAS ! ON UTILISE DES CARDINAUX !
		Gaulois obelix = new Gaulois("Obelix", 25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
	}

	private String nom;
	private Chef chef;
	private Druide druide;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
}
