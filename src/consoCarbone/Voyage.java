package consoCarbone;

/**La classe voyage detail le nombre de voyages d un utilisateur sur une annee et son moyen de transport le plus utiliser pour voyager et calcul l impact en CO2 de l utilisateur
 * 
 * @author theo4
 */
public class Voyage extends ConsoCarbone{
	private double impact;
	private int nbreVoyages;
	private MoyenTransport moyenTransport;
	
	public Voyage() {
		this.impact = 0;
		this.nbreVoyages = 0;
	}
	
	public Voyage(int nbreVoyages, MoyenTransport moyenTransport) throws  IllegalArgumentException {
		if(nbreVoyages<0) {
			throw new  IllegalArgumentException("Le nombre de voyages realises en une annee ne doit pas etre negatif.");
		}
		this.nbreVoyages = nbreVoyages;
		this.moyenTransport = moyenTransport;
		this.impact = nbreVoyages*moyenTransport.getInd();
	}
	
	@Override
	public double getImpact() {
		return impact;
	}
	
	public int getNbreVoyages() {
		return nbreVoyages;
	}
	
	public void setNbreVoyages(int nbreVoyages) throws  IllegalArgumentException {
		if(nbreVoyages<0) {
			throw new  IllegalArgumentException("Le nombre de voyages realises en une annee ne doit pas etre negatif.");
		}
		this.nbreVoyages = nbreVoyages;
	}
	
	public MoyenTransport getMoyenTransport() {
		return moyenTransport;
	}
	
	public void setMoyenTransport(MoyenTransport moyenTransport) {
		this.moyenTransport = moyenTransport;
	}
	
/**Cette methode redefini la methode toString
 *  
 * @return la methode renvoi une chaine de caractere donnant le detail des Voyages de l'utilisateur et donne son impact
 */		
	@Override 
    public String toString() {
		if(nbreVoyages==0)
			return("Vous n'avez pas voyage cette annee , donc votre consomation est nulle");
		else
			return("Vous avez effectue " + nbreVoyages + " voyages , et votre moyen de transport prefere est le  " + moyenTransport + " et donc votre impact est de  " + impact);
    }
	
/**La methode implemente l'interface Comparable et compare l'impact de deux utilisateurs concernant leur Voyage
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
