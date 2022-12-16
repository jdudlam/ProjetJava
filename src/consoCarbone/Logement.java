package consoCarbone;
/** La classe Logement calcul l'impact du logement d'un utilisateur en fonction de sa superficie et de sa classe energetique  
 * 
 * @author theo4
 *
 */
public class Logement extends ConsoCarbone {
	private int superficie;
    private CE ce;
    private double impact;

	public Logement(){
		superficie = 0;
		impact =0;
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

    @Override
    public double getImpact() {
        return impact;
    }
/**Cette methode affiche le detail de l empreinte moyenne des francais concernant leur Logement
 * 
 */
    public static void detailEmpreinteLogement() {
    	System.out.println("Detail de l'empreinte carbonne moyenne d un francais concernant son logement en kg de CO2/an:"
    			+ "\n" + "-energie et utilites : 1696" + "\n" 
    			+ "-constructions et gros entretiens : 675" 
    			+ "\n" + "-equipements des logements : 335" + "\n");
    }
/**Cette methode redefini la methode toString
 * 
 * @return la methode renvoi une chaine de caractere donnant le detail du Logement de l'utilisateur et donne son impact
 */    
    @Override 
    public String toString() {
    	return ("La superficie du logement est : " + superficie + "\n sa classe energetique est : " + ce + "\n et son impact est : " + impact);
    }
/**La methode implemente l'interface Comparable et compare l'impact de deux utilisateurs concernant leur Logement
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
