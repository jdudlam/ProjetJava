package utilisateur;

import consoCarbone.Alimentation;
import consoCarbone.BienConso;
import consoCarbone.Logement;
import consoCarbone.ServicesPublics;
import consoCarbone.Transport;

public class Utilisateur {
	public Alimentation alimentation;
	public BienConso bienConso;
	public Logement logement;
	public Transport transport;
	public ServicesPublics services;
	
	public Utilisateur() {
		alimentation = new Alimentation();
		bienConso = new BienConso();
		logement = new Logement();
		transport = new Transport();
		services = new ServicesPublics();
	}
	
	public Utilisateur(Alimentation alimentation, BienConso bienConso, Logement logement, Transport transport,
			ServicesPublics services) {
		this.alimentation = alimentation;
		this.bienConso = bienConso;
		this.logement = logement;
		this.transport = transport;
		this.services = services;
	}

	public Alimentation getAlimentation() {
		return alimentation;
	}

	public void setAlimentation(Alimentation alimentation) {
		this.alimentation = alimentation;
	}

	public BienConso getBienConso() {
		return bienConso;
	}

	public void setBienConso(BienConso bienConso) {
		this.bienConso = bienConso;
	}

	public Logement getLogement() {
		return logement;
	}

	public void setLogement(Logement logement) {
		this.logement = logement;
	}

	public Transport getTransport() {
		return transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	public ServicesPublics getServices() {
		return services;
	}

	public void setServices(ServicesPublics services) {
		this.services = services;
	}

	
	
	
	public double calculerEmpreinte() {
		return alimentation.getImpact() + bienConso.getImpact() + logement.getImpact() + transport.getImpact() + services.getImpact();
	}
	
	public void detaillerEmpreinte() {
		System.out.println("Voici le detail de la consommation globale de l utilisateur:\n" + alimentation.toString() + bienConso.toString() + logement.toString() + transport.toString() + "Et enfin l impact concernant les services publics est de 1.5 TCO2eq");
	}
	
}