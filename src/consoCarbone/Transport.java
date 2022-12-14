package consoCarbone;

public class Transport extends ConsoCarbone {
	private boolean possede;
	private Taille taille;
	private int kilomAnnee;
	private int amortissement;
	private double impact;
	
	public Transport() {
		possede = false;
	}
	
	public Transport(boolean possede, Taille taille, int kilomAnnee, int amortissement) {
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

	public void setKilomAnnee(int kilomAnnee) {
		this.kilomAnnee = kilomAnnee;
	}

	public int getAmortissement() {
		return amortissement;
	}

	public void setAmortissement(int amortissement) {
		this.amortissement = amortissement;
	}

	public double getImpact() {
		return impact;
	}

	public static void detailEmpreinteTransport() {
    	System.out.println("Detail de l'empreinte carbonne moyenne d un francais concernant les transports en kg de CO2/an:"
    			+ "\n" + "-trains et bus : 85" + "\n" 
    			+ "-avion : 480" 
    			+ "\n" + "-fret et messagerie : 383" + "\n" + "-voiture : 1972" + "\n");
    }
	
	@Override 
    public String toString() {
		if(possede==false)
			return("Vous ne possedez pas de voiture votre impact en terme de transport est donc nul.");
		if(taille==Taille.G)
			return("Votre voiture est de grande taille, elle a roule " + kilomAnnee + " kilometres, vous la possedez depuis " + amortissement + " ans et son impact est " + impact);
    	return ("Votre voiture est de petite taille, elle a roule " + kilomAnnee + " kilometres, vous la possedez depuis " + amortissement + " ans et son impact est " + impact);
    }
	
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
