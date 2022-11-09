package entite;

public class Parametres 
{
	private String nomUtilisateur;
	private String motDePasse;
	private String serveurBD;
	private String driverSGBD;
	public Parametres (){
      	nomUtilisateur = "root";
	  	motDePasse = "";		
	  	driverSGBD ="com.mysql.jdbc.Driver";
	  	serveurBD = "jdbc:mysql://localhost/orchestre";
	}
	public String getDriverSGBD() {
		return driverSGBD;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}
	public String getServeurBD() {
		return serveurBD;
	}
}

