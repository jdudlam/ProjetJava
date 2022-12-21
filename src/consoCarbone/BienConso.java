package consoCarbone;
/**La classe BienConso donne le montant en euros des biens consommer par un utilisateur et calcul une approximation de l impact de cet utilisateur
 * 
 * @author theo4
 *
 */
public class BienConso extends ConsoCarbone {
	private double montant;
	private double impact;
	
	public BienConso() {
		montant = 0;
		impact = 0;
	}
	
	public BienConso(double montant) throws  IllegalArgumentException {
		if(montant<0) {
			throw new  IllegalArgumentException("Le montant de vos dépenses en bien consommés est negatif.");
		}
		this.montant = montant;
		this.impact = montant/1750;
	}
	
	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) throws  IllegalArgumentException {
		if(montant<0) {
			throw new  IllegalArgumentException("Le montant de vos dépenses en bien consommés est negatif.");
		}
		this.montant = montant;
	}

	@Override
	public double getImpact() {
		return impact;
	}

/**Cette methode affiche le detail de l empreinte moyenne des francais concernant les Biens Conso
 * 
 */
	public static void detailEmpreinteBienConso() {
    	System.out.println("Detail de l'empreinte carbonne moyenne d un francais concernant les biens et les consommations en kg de CO2/an:"
    			+ "\n" + "-habillement : 763" + "\n" 
    			+ "-achat et usage internet et technologies : 1180" 
    			+ "\n" + "-autres biens et services : 682" + "\n");
    }
/**Cette methode redefini la methode toString
 *  
 * @return la methode renvoi une chaine de caractere donnant le detail des Biens Conso de l'utilisateur et donne son impact
 */	
	@Override 
    public String toString() {
    	return ("Le montant de vos depenses annuelles est de : " + montant + " euros\n et votre impact est de " + impact);
    }
/**La methode implemente l'interface Comparable et compare l'impact de deux utilisateurs concernant leur Biens Conso
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
