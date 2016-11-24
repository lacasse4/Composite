package scandir;

import java.io.File;

public class Fichier extends Noeud {
	
	public Fichier(Noeud parent, File nom) {
		super(parent, nom);
	}
	
	public String toString() {
		return "F: " + nom.toString() + "\n";
	}
}
