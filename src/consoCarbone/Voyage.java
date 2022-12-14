package consoCarbone;

public class Voyage extends ConsoCarbone{
	private double impact;
	private int nbreVoyages;
	private MoyenTransport moyenTransport;
	
	public Voyage() {
		this.nbreVoyages = 0;
	}
	
	public Voyage(int nbreVoyages, MoyenTransport moyenTransport) {
		super();
		this.nbreVoyages = nbreVoyages;
		this.moyenTransport = moyenTransport;
		this.impact = nbreVoyages*moyenTransport.getInd();
	}
	
	
	public double getImpact() {
		return impact;
	}
	
	public int getNbreVoyages() {
		return nbreVoyages;
	}
	
	public void setNbreVoyages(int nbreVoyages) {
		this.nbreVoyages = nbreVoyages;
	}
	
	public MoyenTransport getMoyenTransport() {
		return moyenTransport;
	}
	
	public void setMoyenTransport(MoyenTransport moyenTransport) {
		this.moyenTransport = moyenTransport;
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
