package consoCarbone;

public enum MoyenTransport {
	Avion(10),Train(2),Bateau(5);
	
private double ind;
	
	MoyenTransport(double ind){
		this.ind = ind;
	}
	
	public double getInd() {
		return ind;
	}
}
