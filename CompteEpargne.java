/**
 * @author PISSARAW
 *
 */
public class CompteEpargne extends CompteBancaire {
	
	private float taux;

	/**
	 * @throws ExceptionNumeroCompte 
	 * 
	 */
	public CompteEpargne(String nom, float solde, String numero, float t) throws ExceptionNumeroCompte {
		super(nom, solde, numero);
		if (!(t>=0f && t<1f)) {
			ExceptionNumeroCompte e = new ExceptionNumeroCompte("erreur",numero);
			throw e;
		}
	   this.taux=t;
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * @param nom
	 * @param numero
	 * @throws ExceptionNumeroCompte
	 */
	public CompteEpargne(String nom, String numero) throws ExceptionNumeroCompte {
		super(nom, numero);
		this.taux=0f;
	}

	/**
	 * @return
	 */
	public float getTaux() {
		return taux;
	}

	/**
	 * @param taux
	 */
	public void setTaux(float taux) {
		this.taux = taux;
	}

	
	/* (non-Javadoc)
	 * @see CompteBancaire#toString()
	 */
	@Override
	public String toString() {
		String s;
		s= super.toString() + " ";
		s+="taux=" + this.taux;
		return s;
	}
	
	/**
	 * @return l'intérêt en fonction du solde et du taux
	 */
	public float caculInteret(){
		float interet;
		interet= this.solde * this.taux;
		return interet;
		
	}
	
	/**
	 * Modifie le solde en l'addition à l'intérêt
	 */
	public void ajouteInteret(){
		this.solde=this.solde+this.caculInteret();
	}
}
