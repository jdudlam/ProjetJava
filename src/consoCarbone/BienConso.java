package consoCarbone;

public class BienConso extends ConsoCarbone {
	private double montant;
	private double impact;
	
	public BienConso() {
		montant = 0;
	}
	
	public BienConso(double montant) {
		this.montant = montant;
		this.impact = montant/1750;
	}
	
	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public double getImpact() {
		return impact;
	}

	public static void detailEmpreinteBienConso() {
    	System.out.println("Detail de l'empreinte carbonne moyenne d un francais concernant les biens et les consommations en kg de CO2/an:"
    			+ "\n" + "-habillement : 763" + "\n" 
    			+ "-achat et usage internet et technologies : 1180" 
    			+ "\n" + "-autres biens et services : 682" + "\n");
    }
	
	@Override 
    public String toString() {
    	return ("Le montant de vos depenses annuelles est de : " + montant + " euros\n et votre impact est de " + impact);
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
