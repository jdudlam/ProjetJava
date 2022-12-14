package consoCarbone;

public class Alimentation extends ConsoCarbone {
	private double txBoeuf;
    private double txVege;
    private double impact;


    public Alimentation(){
    	txBoeuf = 0;
    	txVege = 0;
    }

    public Alimentation(double txBoeuf, double txVege){
        this.txBoeuf = txBoeuf;
        this.txVege = txVege;
        this.impact = 8 * txBoeuf + 1.6*(1-txVege-txBoeuf) + 0.9 * txVege;
    }

    public double getTxBoeuf() {
        return txBoeuf;
    }

    public void setTxBoeuf(double txBoeuf) {
        this.txBoeuf = txBoeuf;
    }

    public double getTxVege() {
        return txVege;
    }

    public void setTxVege(double txVege) {
        this.txVege = txVege;
    }

    public double getImpact() {
        return impact;
    }
    
    public static void detailEmpreinteAlimentation() {
    	System.out.println("Detail de l'empreinte carbonne moyenne d un francais concernant l alimentation en kg de CO2/an:"
    			+ "\n" + "-boissons : 263" + "\n" 
    			+ "-produits laitiers et oeufs : 408" 
    			+ "\n" + "-viandes et poissons : 1144" + "\n" + "-autres : 538" + "\n");
    }

    @Override 
    public String toString() {
    	return ("Votre taux de consomation en boeuf est de : " + txBoeuf + "\n votre taux de repas vegetarien est de ;" + txVege + "\n et votre impact est de :" + impact);
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
