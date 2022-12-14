package consoCarbone;

public class ServicesPublics extends ConsoCarbone {
	private final double impact = 1.5;
	
	public ServicesPublics() {}

	public double getImpact() {
		return impact;
	}
	
	@Override
	public int compare(ConsoCarbone o1, ConsoCarbone o2) {
		// on return 0 car ils ont toujours le meme impact 
		return 0;
	}

	
}
