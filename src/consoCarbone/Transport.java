package consoCarbone;
/**La classe Transport calcul l'impact ecologique d'un utilisateur en fonction de si il possede une voiture et de son utilisation(frequemment , taille et son amortissement) 
 * 
 * @author theo4
 *
 */
public class Transport extends ConsoCarbone {
	private boolean possede;
	private Taille taille;
	private int kilomAnnee;
	private int amortissement;
	private double impact;
	
	public Transport() {
		possede = false;
		impact = 0;
	}
	
	public Transport(boolean possede, Taille taille, int kilomAnnee, int amortissement) throws  IllegalArgumentException{
		if(kilomAnnee<0) {
			throw new  IllegalArgumentException("Le nombre de kilometre parcouru dans l'annee est negatif.");
		}
		if(amortissement<0) {
			throw new  IllegalArgumentException("Une voiture ne peut pas etre possede depuis un nombre negatif d'annees.");
		}
		this.possede = possede;
		this.taille = taille;
		this.kilomAnnee = kilomAnnee;
		this.amortissement = amortissement;
		if(possede == false) {
			this.impact = 0;
		}
		else {
			switch(taille) {
			case P:
				this.impact = kilomAnnee * 1.93 * 1e-4 + 4.2/amortissement;
				break;
			case G:
				this.impact = kilomAnnee * 1.93 * 1e-4 +  19.0/amortissement;
				break;
			}
		}
	}

	public boolean isPossede() {
		return possede;
	}

	public void setPossede(boolean possede) {
		this.possede = possede;
	}

	public Taille getTaille() {
		return taille;
	}

	public void setTaille(Taille taille) {
		this.taille = taille;
	}

	public int getKilomAnnee() {
		return kilomAnnee;
	}

	public void setKilomAnnee(int kilomAnnee) throws  IllegalArgumentException {
		if(kilomAnnee<0) {
			throw new  IllegalArgumentException("Le nombre de kilometre parcouru dans l'annee est negatif.");
		}
		this.kilomAnnee = kilomAnnee;
	}

	public int getAmortissement() {
		return amortissement;
	}

	public void setAmortissement(int amortissement) throws  IllegalArgumentException {
		if(amortissement<0) {
			throw new  IllegalArgumentException("Une voiture ne peut pas etre possede depuis un nombre negatif d'annees.");
		}
		this.amortissement = amortissement;
	}

	@Override
	public double getImpact() {
		return impact;
	}
/**Cette methode affiche le detail de l empreinte moyenne des francais concernant leur Transport(voiture)
 * 
 */
	public static void detailEmpreinteTransport() {
    	System.out.println("Detail de l'empreinte carbonne moyenne d un francais concernant les transports en kg de CO2/an:"
    			+ "\n" + "-trains et bus : 85" + "\n" 
    			+ "-avion : 480" 
    			+ "\n" + "-fret et messagerie : 383" + "\n" + "-voiture : 1972" + "\n");
    }
	/**Cette methode redefini la methode toString
	 *  
	 * @return la methode renvoi une chaine de caractere donnant le detail du Transport(voiture) de l'utilisateur et donne son impact
	 */		
	@Override 
    public String toString() {
		if(possede==false)
			return("Vous ne possedez pas de voiture votre impact en terme de transport est donc nul.");
		if(taille==Taille.G)
			return("Votre voiture est de grande taille, elle a roule " + kilomAnnee + " kilometres, vous la possedez depuis " + amortissement + " ans et son impact est " + impact);
    	return ("Votre voiture est de petite taille, elle a roule " + kilomAnnee + " kilometres, vous la possedez depuis " + amortissement + " ans et son impact est " + impact);
    }
	/**La methode implemente l'interface Comparable et compare l'impact de deux utilisateurs concernant leur Transport(voiture)
	 * 
	 * @return La methode renvoi 0 si les deux utilisateurs ont le meme impact, 1 si le premier utilisateur passé en argument a un plus gros impact et 2 sinon
	 */	
	@Override
	public int compare(ConsoCarbone o1, ConsoCarbone o2) {
		if(o1.getImpact()>o2.getImpact()) {
			return 1;
		}
		if(o2.getImpact()>o1.getImpact()) {
			return 2;
		}
		return 0;
	}
	
}
