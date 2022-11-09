package entite;
public class Instrument 
{
	private String id;
	private String nom;
	private String couleur;
	private String son ;
	
	// constructeur
	public Instrument(String wid,String wnom,String wcouleur, String wson)
	{
		id = wid;
		nom = wnom;
		couleur = wcouleur;
		son = wson;
	}
	
	public String req_InsertInstrument(){
		return "insert into instrument values('"+this.getId()+"','"+this.getNom()+"','"+this.getCouleur()+"','"+this.getSon()+"')";
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getSon() {
		return son;
	}

	public void setSon(String son) {
		this.son = son;
	}
}

