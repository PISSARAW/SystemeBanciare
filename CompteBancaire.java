/**
 * @author PISSARAW
 */
public class CompteBancaire implements Comparable <CompteBancaire>{

	/**
	 * Le nom du propriétaire du compte
	 */
	protected String nom;
	/**
	 * Le solde du compte
	 */
	protected float solde;
	/**
	 * Le numero du compte 
	 */
	protected final String numero;

	/**
	 * Construit une instance de CompteBancaire avec les valeurs données en
	 * paramètre.
	 * 
	 * @param nom
	 *            le nom du propriétaire
	 * @param solde
	 *            le solde du compte
	 * @param numero
	 *            le numero du compte
	 */
	public CompteBancaire(String nom, float solde, String numero) throws ExceptionNumeroCompte {
		this.nom = nom;
		this.solde = solde;
		if(!CompteBancaire.verifieNumero(numero)){
			ExceptionNumeroCompte e = new ExceptionNumeroCompte("numéro ne respecte pas le format", numero);
			throw e;
		}
		this.numero = numero;
	}

	/**
	 * Construit une instance de CompteBancaire, le solde sera à 0.
	 * 
	 * @param nom
	 *            le nom du propriétaire
	 * @param numero
	 *            le numero du compte
	 */
	public CompteBancaire(String nom, String numero) throws ExceptionNumeroCompte{
		this.nom = nom;
		this.solde = 0; // le solde sera affecté apres
		
		if(!CompteBancaire.verifieNumero(numero)){
			ExceptionNumeroCompte e = new ExceptionNumeroCompte("numéro ne respecte pas le format", numero);
				throw e;
		}
		this.numero = numero;
	}

	public String toString() {
		return new String("Compte de nom " + nom + " de solde " + solde
				+ "  de numero " + numero + "\n");
	}

	/**
	 * Retourne le nom du propriétaire
	 * 
	 * @return le nom du propriétaire
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Retourne le numéro du compte
	 * 
	 * @return le numéro du compte
	 */
	public String getNumero() {
		return this.numero;
	}

	/**
	 * Retourne le solde du compte
	 * 
	 * @return le solde du compte
	 */
	public float getSolde() {
		return this.solde;
	}

	/**
	 * Remplace le nom du propriétaire du compte par n
	 * 
	 * @param n
	 *            le nouveau nom du propriétaire
	 */
	public void setNom(String n) {
		this.nom = n;
	}

	/**
	 * Remplace le solde du compte par s
	 * 
	 * @param s
	 *            le nouveau solde du compte
	 */
	public void setSolde(float s) {
		this.solde = s;
	}

	/**
	 * ajoute une somme au solde du compte courant si le solde est positif,
	 * sinon affichage d'un message d'erreur
	 * 
	 * @param la
	 *            somme à ajouter
	 * @return false si la somme est négative, true sinon
	 */
	public boolean ajouteSolde(float ajout) {
		if (ajout >= 0) {
			this.solde += ajout;
			return true;
		} else {
			System.out.println("votre ajout est negatif !!");
			return false;
		}
	}

	/**
	 * retire retrait au solde si retrait est positif sinon affichage d'un
	 * message d'erreur
	 * 
	 * @param retrait
	 *            la somme à retirer
	 * @return false si la somme est positive, true sinon
	 */
	public boolean retireSolde(float retrait) {
		if (retrait >= 0) {
			solde = solde - retrait;
			return true;
		} else {
			System.out.println("votre retrait est negatif !");
			return false;
		}
	}
	
	/**
	 * @param s
	 * @return la valeur vérité du numéro
	 */
	static boolean verifieNumero(String s){
		if(s.length() == 10 && Character.isUpperCase(s.charAt(0)) && s.charAt(1)=='-'){
			int i;
			int verif = 0;
			for(i = 2; i<8 && Character.isDigit(s.charAt(i)); i++){
				verif++;
			}
			if(verif==6){
				return true;
			}
			
		}
		return false;
	}
	
	/**
	 * @param uneDevise
	 * @return le solde converti par la devise entrée en paramètre
	 */
	public float convertirSolde(String uneDevise){
		Float soldeConverti = AgenceBancaire.convertirSomme(uneDevise, this.solde);
		
		if(soldeConverti!=-1f) return soldeConverti;
		System.err.print("OK");
		return -1f;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(CompteBancaire o) {
		if(this.solde < o.getSolde()) return -1;
		if(this.solde == o.getSolde()) return 0;
		return 1;
	}

	
} // fin de la classe
