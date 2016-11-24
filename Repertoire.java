package scandir;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Repertoire extends Noeud {
	
	private List<Noeud> enfants;

	public Repertoire(Noeud parent, File nom) {
		super(parent, nom);
		enfants = new ArrayList<Noeud>();
		getEnfants();
	}
	
	private void getEnfants() {
		for (File f : nom.listFiles()) {
			if (f.isDirectory()) 
				enfants.add(new Repertoire(this, f));
			else 
				enfants.add(new Fichier(this, f));
		}
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();;
		Iterator<Noeud> i = enfants.iterator();

		// ajouter le nom du répertoire
		sb.append("R: " + nom.toString() + "\n");
		
		// ajouter le nom des enfants
		while (i.hasNext()) {
			sb.append(i.next().toString());
		}
		
		return sb.toString();
	}
}
