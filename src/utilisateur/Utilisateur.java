package utilisateur;
import java.io.*;
import java.util.*;

import consoCarbone.Alimentation;
import consoCarbone.BienConso;
import consoCarbone.Logement;
import consoCarbone.ServicesPublics;
import consoCarbone.Transport;
import consoCarbone.Voyage;

public class Utilisateur {
	private Alimentation alimentation;
	private BienConso bienConso;
	private List<Logement> logement;
	private List<Transport> transport;
	private ServicesPublics services;
	private Voyage voyages;
	private double impLogement = 0;
	private double impTransport = 0;
	
	
	public Utilisateur() {
		alimentation = new Alimentation();
		bienConso = new BienConso();
		logement = new ArrayList<Logement>();
		transport = new ArrayList<Transport>();
		services = new ServicesPublics();
		voyages = new Voyage();
	}
	
	public Utilisateur(Alimentation alimentation, BienConso bienConso, List<Logement> logement, List<Transport> transport,
			ServicesPublics services, Voyage voyages) {
		this.alimentation = alimentation;
		this.bienConso = bienConso;
		this.logement = logement;
		this.transport = transport;
		this.services = services;
		this.voyages = voyages;
		for(Logement L:logement) {
			impLogement += L.getImpact();
		}
		for(Transport T:transport) {
			impTransport += T.getImpact();
		}
	}

	public Utilisateur(String f) {
		try {
			FileInputStream fis = new FileInputStream(new File(f));
			
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
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

	public List<Logement> getLogement() {
		return logement;
	}

	public void setLogement(List<Logement> logement) {
		this.logement = logement;
	}

	public List<Transport> getTransport() {
		return transport;
	}

	public void setTransport(List<Transport> transport) {
		this.transport = transport;
	}

	public ServicesPublics getServices() {
		return services;
	}

	public void setServices(ServicesPublics services) {
		this.services = services;
	}
	
	public Voyage getVoyages() {
		return voyages;
	}

	public void setVoyages(Voyage voyages) {
		this.voyages = voyages;
	}

	
	public double calculerEmpreinte() {
		return alimentation.getImpact() + bienConso.getImpact() + impLogement + impTransport + services.getImpact() + voyages.getImpact();
	}
	
	public void detaillerEmpreinte() {
		System.out.println("Voici le detail de la consommation globale de l utilisateur:\n" + alimentation.toString() + bienConso.toString() + logement.toString() + transport.toString() + voyages.toString() +  "Et enfin l impact concernant les services publics est de 1.5 TCO2eq");
		
	}
	
	public void ordonneImpact() {
		List<Double> impacts = new ArrayList<>();
		impacts.add(alimentation.getImpact());
		impacts.add(bienConso.getImpact());
		impacts.add(impLogement);
		impacts.add(impTransport);
		impacts.add(services.getImpact());
		impacts.add(voyages.getImpact());
		detaillerEmpreinte();
		if(impacts.get(0)*800>2353) { //on considere que l impact est trop eleve quand il est 1,25 fois plus eleve que la moyenne des francais(fois 800 pour passer de tonnes a kilos)
			System.out.println("Votre impact concernant l'alimentation est beaucoup plus élevé que la moyenne, vous pouvez revoir votre alimentation par exemple en mangeant moins de viande!");
		}
		if(impacts.get(1)*800>2625) { 
			System.out.println("Votre impact concernant les biens consommés est beaucoup plus élevé que la moyenne, vous devriez revoir a la baisse vos consommations diverses, par exemple les vetements ou vos outils technologiques(ne pas changer de telephone tous les ans (:! )");
		}
		if(impacts.get(2)*800>2706) { 
			System.out.println("Votre impact concernant le logment est beaucoup plus élevé que la moyenne, pour faire baisser votre impact vous pouvez faire des travaux pour ameliorer la classe energetique de votre logement!");
		}
		if(impacts.get(3)*800>2920) { 
			System.out.println("Votre impact concernant les transports est beaucoup plus élevé que la moyenne, vous devriez songer a utiliser des que possible des moyens de transports ecoresponsables tels que la marche, le velo ou encore les transports en commun. Vous pouvez aussi achetez une voiture moins polluante.");
		}
		if(impacts.get(5)*800>1500) { 
			System.out.println("Votre impact concernant vos voyages est beaucoup plus élevé que la moyenne, vous devriez songer a moins voyager ou utiliser de preference des moyens de transport moins polluants.");
		}
	}
		
}