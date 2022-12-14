package consoCarbone;

public enum CE {
	
	A(0.005),B(0.01),C(0.02),D(0.035),E(0.055),F(0.08),G(0.1);
	
	private double ind;
	
	CE(double ind){
		this.ind = ind;
	}
	
	public double getInd() {
		return ind;
	}

}  

