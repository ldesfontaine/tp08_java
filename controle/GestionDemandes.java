package controle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import entite.Instrument;

public class GestionDemandes
{

	public boolean enregistrerinstrument(String wid,String wnom,String wcouleur,
			String wson)
	{
		Instrument linstrument = new Instrument(wid,wnom,wcouleur,wson);
		
		String requete = linstrument.req_InsertInstrument();
		return executeReq(requete);
	}
	public Instrument rechercherinstrument(String id){
		String requete="select * from instrument where id='"+id+"'";
		System.out.println("requete rechercher= "+requete);
		try
		{
			Statement state = ControleConnexion.getControleConnexion().getConnexion()
								.createStatement();
			ResultSet result=state.executeQuery(requete);
			if(!result.next())
				return null;
			
			Instrument retourInstrument = null;
			Instrument linstrument= new Instrument(result.getString(1),result.getString(2),result.getString(3),result.getString(4));
			retourInstrument = linstrument;
			state.close();
			return retourInstrument;
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, "Erreur sur la requete: "+e.getMessage(), "ALERTE"
					, JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			return null;
		}
	}
	
	private boolean executeReq(String req){
		try
		{
			Statement state = ControleConnexion.getControleConnexion().getConnexion()
								.createStatement();
			state.executeUpdate(req);
			state.close();
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, "Erreur sur la requete: "+e.getMessage(), "ALERTE"
					, JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
}

