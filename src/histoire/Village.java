package histoire;

import java.util.Arrays;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;

public class Village {
	public String getNom() {
		return nom;
	}

	private Chef chef;
	private Druide druide;
	private Gaulois[] gaulois;
	private String nom;
}
