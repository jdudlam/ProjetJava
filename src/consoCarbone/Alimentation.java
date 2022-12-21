package consoCarbone;
/**La classe Alimentation donne le detail des repas d un utilisateur par rapport a sa consommation en viande et en repas vegetariens et calcul l impact de cet utilisateur
 * 
 * @author theo4
 *
 */
public class Alimentation extends ConsoCarbone {
	private double txBoeuf;
    private double txVege;
    private double impact;


    public Alimentation() {
    	txBoeuf = 0;
    	txVege = 0;
    	impact = 1.6;
    }

    public Alimentation(double txBoeuf, double txVege) throws  IllegalArgumentException {
    	if(0>=txBoeuf || txBoeuf>=1) {
    		throw new  IllegalArgumentException("Le taux de repas a base de boeuf n'est pas conforme(pas entre 0 et 1)");
    	}
    	if(0>=txVege || txVege>=1) {
    		throw new  IllegalArgumentException("Le taux de repas vegetariens n'est pas conforme(pas entre 0 et 1)");
    	}
        this.txBoeuf = txBoeuf;
        this.txVege = txVege;
        this.impact = 8 * txBoeuf + 1.6*(1-txVege-txBoeuf) + 0.9 * txVege;
    }

    public double getTxBoeuf() {
        return txBoeuf;
    }

    public void setTxBoeuf(double txBoeuf) throws  IllegalArgumentException {
    	if(0>=txBoeuf || txBoeuf>=1) {
    		throw new  IllegalArgumentException("Le taux de repas a base de boeuf n'est pas conforme(pas entre 0 et 1)");
    	}
        this.txBoeuf = txBoeuf;
    }

    public double getTxVege() {
        return txVege;
    }

    public void setTxVege(double txVege) throws  IllegalArgumentException {
    	if(0>=txVege || txVege>=1) {
    		throw new  IllegalArgumentException("Le taux de repas vegetariens n'est pas conforme(pas entre 0 et 1)");
    	}
        this.txVege = txVege;
    }

    @Override
    public double getImpact() {
        return impact;
    }
   
/**Cette methode affiche le detail de l empreinte moyenne des francais concernant l'alimentation
 * 
 */
    public static void detailEmpreinteAlimentation() {
    	System.out.println("Detail de l'empreinte carbonne moyenne d un francais concernant l alimentation en kg de CO2/an:"
    			+ "\n" + "-boissons : 263" + "\n" 
    			+ "-produits laitiers et oeufs : 408" 
    			+ "\n" + "-viandes et poissons : 1144" + "\n" + "-autres : 538" + "\n");
    }

/**Cette methode redefini la methode toString
 * 
 * @return la methode renvoi une chaine de caractere donnant le detail de l'alimentation de l'utilisateur et donne son impact
 */
    @Override 
    public String toString() {
    	return ("Votre taux de consomation en boeuf est de : " + txBoeuf + "\n votre taux de repas vegetarien est de ;" + txVege + "\n et votre impact est de :" + impact);
    }

/**La methode implemente l'interface Comparable et compare l'impact de deux utilisateurs concernant l'alimentation
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
