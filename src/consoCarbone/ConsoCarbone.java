package consoCarbone;
import java.util.Scanner;
import utilisateur.Utilisateur;
import utilisateur.Population;
import java.util.*;



/**ConsoCarbone est la classe mere , elle resume l'impact total d'un utilisateur en fonction des impacts donnés par ses classes filles
 * 
 * @author theo4
 *
 */
public abstract class ConsoCarbone implements Comparable<ConsoCarbone> {
	protected double impact;
	private final int id;
	private static int cpt;
	
	public ConsoCarbone() {
		impact = 0;
		id = ++cpt;
	}
	
	public ConsoCarbone(double impact) {
		this.impact = impact;
		this.id = ++cpt;
	}

	public double getImpact() {
		return impact;
	}

	public int getId() {
		return id;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Population population = new Population();
		int exe = 0;
		do {
			System.out.println("-------------");
			System.out.println("Voici le menu");
			System.out.println("-------------\n");
			System.out.println("Tapez 0 pour sortir du menu.");
			System.out.println("Tapez 1 pour afficher le detail des l'empreintes des francais.");
			System.out.println("Tapez 2 pour remplir vos informations concernant vos differentes consommations carbones.");
			System.out.println("Tapez 3 pour creer votre profil d'utilisateur a partir d'un fichier .txt respectant les instructions donnees dans le fichier ReadMe.");
			System.out.println("Tapez 4 pour avoir un apercu des ameliorations que la population devrait realiser pour ameliorer son impact carbone moyen.");
			
			exe = sc.nextInt();
			
			switch(exe) {
			case 0:
				break;
			case 1:
				Alimentation.detailEmpreinteAlimentation();
		    	Logement.detailEmpreinteLogement();
		    	Transport.detailEmpreinteTransport();
		    	BienConso.detailEmpreinteBienConso();
		    	break;
			case 2:
				//Classe logement 
				
				List<Logement> maisons = new ArrayList<Logement>();
		    	System.out.println("Combien de logement possedez vous?");
		    	int nbrLog = sc.nextInt();
		    	int a = 0;
		    	while(a<nbrLog) {
		    		System.out.println("Veuillez saisir la superficie de votre logement :");
			    	int superf = sc.nextInt();
		    		System.out.println("Veuillez saisir la classe energetique de votre logement :");
		    		sc.nextLine();
		    		String str = sc.nextLine();
		    		CE ce = CE.A;
		    		switch(str){
		        		case "A":
		        			ce = CE.A;
		        			break;
		        		case "B":
		        			ce = CE.B;
		        			break;
		        		case "C":
		        			ce = CE.C;
		        			break;
		        		case "D":
		        			ce = CE.D;
		        			break;
		        		case "E":
		        			ce = CE.E;
		        			break;
		        		case "F":
		        			ce = CE.F;
		        			break;
		        		case "G":
		        			ce = CE.G;
		        			break;
		    		}
		    		Logement logement = new Logement(superf, ce);
		    		System.out.println(logement.toString());
		    		a++;
		    		maisons.add(logement);
		    	}
		    
		    	//classe Alimentation
		    
		    	System.out.println("Veuillez saisir votre taux de repas a base de boeuf (entre 0 et 1):");
		    	double txBoeuf = sc.nextDouble();
		    	System.out.println("Veuillez saisir votre taux de repas vegetariens :");
		    	double txVege = sc.nextDouble();
		    	Alimentation aliment = new Alimentation(txBoeuf, txVege);
		    	System.out.println(aliment.toString());
			
		    	//classe BienConso
			
		    	System.out.println("Veuillez saisir votre montant de depenses annuelles : ");
		    	double montant = sc.nextDouble();
		    	BienConso bienconso = new BienConso(montant);
		    	System.out.println(bienconso.toString());
		    
		    	//classe Transport
		    	List<Transport> transp = new ArrayList<Transport>();
		    	sc.nextLine();
		    	System.out.println("Possedez vous une ou plusieurs voiture(s) (veuillez repondre par 'oui' ou par 'non')?");
		    	String possede = sc.nextLine();
		    	Transport transport;
		    	switch(possede) {
		    	case "non":
		    		transport = new Transport();
		    		transp.add(transport);
		    		System.out.println(transport.toString());
		    		break;
		    	case "oui":
		    		System.out.println("Si oui combien en possedez vous?");
			    	int nbrvoit = sc.nextInt();
			    	int cpt = 0;
		    		while(cpt<nbrvoit) {
		    			System.out.println("Votre voiture est-elle petite ou grande(veuillez repondre par 'petite' ou par 'grande')?");
		    			sc.nextLine();
		    			String taille = sc.nextLine();
		    			System.out.println("Combien de kilometres parcourez-vous par an?");
		    			int kilomannee = sc.nextInt();
		    			System.out.println("Depuis combien d annee possedez-vous votre voiture?");
		    			int amortissement = sc.nextInt();
		    			switch(taille) {
		    			case "petite":
		    				transport = new Transport(true, Taille.P, kilomannee, amortissement);
		    				System.out.println(transport.toString());
		    				transp.add(transport);
		    				break;
		    			case "grande":
		    				transport = new Transport(true, Taille.G, kilomannee, amortissement);
		    				System.out.println(transport.toString());
		    				transp.add(transport);
		    				break;
		    			default:
		    				System.out.println("Vous avez saisi de mauvaises informations!!");
		    				break;
		    			}
		    			cpt++;
		    		}
		    		break;
		    	default:
		    		System.out.println("Vous avez saisi de mauvaises informations!!!");
		    		break;
		    	}
		    	
		    	//Voyages
		    	
		    	System.out.println("Veuillez saisir le nombre de voyages que vous avez realise cette annee : ");
		    	int nbrVoy = sc.nextInt();
		    	Voyage voyage = new Voyage();
		    	if(nbrVoy == 0) {
		    		System.out.println(voyage.toString());
		    	}
		    	else {
		    		sc.nextLine();
		    		System.out.println("Veuillez saisir votre moyen de transport le plus utilise pour voyager : ");
		    		String moyTransp = sc.nextLine();
		    		MoyenTransport mT;
					switch(moyTransp) {
					case "Train":
						mT = MoyenTransport.Train;
						voyage = new Voyage(nbrVoy, mT);
						System.out.println(voyage.toString());
						break;
					case "Bateau":
						mT = MoyenTransport.Bateau;
						voyage = new Voyage(nbrVoy, mT);
						System.out.println(voyage.toString());
						break;
					case "Avion":
						mT = MoyenTransport.Avion;
						voyage = new Voyage(nbrVoy, mT);
						System.out.println(voyage.toString());
						break;
					}
		    	}
		    	population.add(new Utilisateur(aliment, bienconso, maisons, transp, new ServicesPublics(), voyage));
		    	break;
			case 3:
				System.out.println("Veuillez saisir le nom de votre fichier comme ceci : nomFichier.txt");
				sc.nextLine();
				String f = sc.nextLine();
				Utilisateur user = new Utilisateur(f);
				int exe2 = 0;
				do {
					System.out.println("-------------");
					System.out.println("Voici le menu de l'utilisateur");
					System.out.println("-------------\n");
					System.out.println("Tapez 0 pour sortir du menu de l'utilisateur.");
					System.out.println("Tapez 1 pour afficher le calcul de votre empreinte carbone total.");
					System.out.println("Tapez 2 pour obtenir le detail de votre empreinte carbone.");
					System.out.println("Tapez 3 pour connaitre nos recommendations.");
					exe2 = sc.nextInt();
				
					switch(exe2) {
					case 0:
						break;
					case 1:
						System.out.println("Votre empreinte carbone globale est de  :");
						System.out.println(user.calculerEmpreinte());
						break;
					case 2:
						user.detaillerEmpreinte();
						break;
					case 3:
						user.ordonneImpact();
						break;
					}
				}while(exe2!=0);
				population.add(user);
				break;
			case 4:
				population.ordonnePopulation();
				break;
			}
		}while(exe!=0);
    	
    	
    	
    	
    	sc.close();
	}
}