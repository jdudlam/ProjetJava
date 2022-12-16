package consoCarbone;
/**La classe ServicesPublics nous donne l'impact des services publics pour tous les utilisateurs( tous les utilisateurs ont donc le meme)
 * 
 * @author theo4
 *
 */
public class ServicesPublics extends ConsoCarbone {
	private final double impact = 1.5;
	
	public ServicesPublics() {}

	@Override
	public double getImpact() {
		return impact;
	}
/**La methode implemente l'interface Comparable et compare l'impact de deux utilisateurs concernant leur Logement
 * 
 * @return La methode renvoi 0 car ils ont toujours le meme impact
 */	
	@Override
	public int compare(ConsoCarbone o1, ConsoCarbone o2) {
		return 0;
	}

	
}
