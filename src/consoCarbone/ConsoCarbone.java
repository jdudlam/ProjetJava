package consoCarbone;
import java.util.Scanner;

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
    	Alimentation.detailEmpreinteAlimentation();
    	Logement.detailEmpreinteLogement();
    	Transport.detailEmpreinteTransport();
    	BienConso.detailEmpreinteBienConso();
    	
    	Scanner sc = new Scanner(System.in);
    	
    	//Classe logement 
    	
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
    	sc.nextLine();
    	System.out.println("Possedez vous une voiture(veuillez repondre par oui ou par non)?");
    	String possede = sc.nextLine();
    	Transport transport;
    	switch(possede) {
    	case "non":
    		transport = new Transport();
    		System.out.println(transport.toString());
    		break;
    	case "oui":    	
    		System.out.println("Votre voiture est-elle petite ou grande?");
    		String taille = sc.nextLine();
    		System.out.println("Combien de kilometres parcourez-vous par an?");
    		int kilomannee = sc.nextInt();
    		System.out.println("Depuis combien d annee possedez-vous votre voiture?");
    		int amortissement = sc.nextInt();
    		switch(taille) {
    		case "petite":
    			transport = new Transport(true, Taille.P, kilomannee, amortissement);
    			System.out.println(transport.toString());
    			break;
    		case "grande":
    			transport = new Transport(true, Taille.G, kilomannee, amortissement);
    			System.out.println(transport.toString());
    			break;
    		default:
    			System.out.println("Vous avez saisi de mauvaises informations!!");
    			break;
    		}
    		break;
    	default:
    		System.out.println("Vous avez saisi de mauvaises informations!!!");
    		break;
    	}
    	
    	sc.close();
	}
}