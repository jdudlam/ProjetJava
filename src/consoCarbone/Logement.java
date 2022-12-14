package consoCarbone;

public class Logement extends ConsoCarbone {
	private int superficie;
    private CE ce;
    private double impact;

	public Logement(){
		superficie = 0;
	}

    public Logement(int superficie, CE ce){
        this.superficie = superficie;
        this.ce = ce;
        this.impact = ce.getInd() * superficie;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public CE getCe() {
        return ce;
    }

    public void setCe(CE ce) {
        this.ce = ce;
    }

    public double getImpact() {
        return impact;
    }
    
    public static void detailEmpreinteLogement() {
    	System.out.println("Detail de l'empreinte carbonne moyenne d un francais concernant son logement en kg de CO2/an:"
    			+ "\n" + "-energie et utilites : 1696" + "\n" 
    			+ "-constructions et gros entretiens : 675" 
    			+ "\n" + "-equipements des logements : 335" + "\n");
    }
    
    @Override 
    public String toString() {
    	return ("La superficie du logement est : " + superficie + "\n sa classe energetique est : " + ce + "\n et son impact est : " + impact);
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
