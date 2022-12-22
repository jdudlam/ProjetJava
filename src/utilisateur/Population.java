package utilisateur;

import java.util.*;

public class Population {
	private List<Utilisateur> users;
	
	public Population() {
		users = new ArrayList<Utilisateur>();
	}
	
	public Population(List<Utilisateur> users) {
		this.users = users;
	}

	public List<Utilisateur> getUsers() {
		return users;
	}

	public void setUsers(List<Utilisateur> users) {
		this.users = users;
	}

	public void add(Utilisateur user) {
		users.add(user);
	}
	
	public void ordonnePopulation() {
		int cpt = 0;
		double alimMoy = 0;
		double bienconsoMoy = 0;
		double logMoy = 0;
		double transpMoy = 0;
		double voyMoy = 0;
		for(Utilisateur user : users) {
			cpt++;
			alimMoy =alimMoy + user.getAlimentation().getImpact();
			bienconsoMoy = bienconsoMoy + user.getBienConso().getImpact();
			logMoy = logMoy + user.getImpLogement();
			transpMoy = transpMoy + user.getImpTransport();
			voyMoy = voyMoy + user.getVoyages().getImpact();
		}
		alimMoy = alimMoy/cpt;
		bienconsoMoy = bienconsoMoy/cpt;
		logMoy = logMoy/cpt;
		transpMoy = transpMoy/cpt;
		voyMoy = voyMoy/cpt;
		
		if(alimMoy*800>2353) { //on considere que l impact est trop eleve quand il est 1,25 fois plus eleve que la moyenne des francais(fois 800 pour passer de tonnes a kilos)
			System.out.println("L'impact de cette population concernant l'alimentation est beaucoup plus eleve que la moyenne, vous devriez revoir votre alimentation par exemple en mangeant moins de viande!");
		}
		if(bienconsoMoy*800>2625) { 
			System.out.println("L'impact de cette population concernant les biens consommes est beaucoup plus eleve que la moyenne, vous devriez revoir a la baisse vos consommations diverses, par exemple les vetements ou vos outils technologiques(ne pas changer de telephone tous les ans (:! )");
		}
		if(logMoy*800>2706) { 
			System.out.println("L'impact de cette population concernant le logement est beaucoup plus eleve que la moyenne, pour faire baisser votre impact vous pouvez faire des travaux pour ameliorer la classe energetique de votre logement!");
		}
		if(transpMoy*800>2920) { 
			System.out.println("L'impact de cette population concernant les transports est beaucoup plus eleve que la moyenne, vous devriez songer a utiliser des que possible des moyens de transports ecoresponsables tels que la marche, le velo ou encore les transports en commun. Vous pouvez aussi achetez une voiture moins polluante.");
		}
		if(voyMoy*800>1500) { 
			System.out.println("L'impact de cette population concernant vos voyages est beaucoup plus eleve que la moyenne, vous devriez songer a moins voyager ou utiliser de preference des moyens de transport moins polluants.");
		}
	}
}
