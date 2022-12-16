package consoCarbone;

public enum MoyenTransport {
	Avion(0.5),Train(0.1),Bateau(0.25);
	
private double ind;
	
	MoyenTransport(double ind){
		this.ind = ind;
	}
	
	public double getInd() {
		return ind;
	}
}
