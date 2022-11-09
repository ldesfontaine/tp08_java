package dialogue;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JTextField;
//import java.text.ParseException;
//permet d établir le lien avec la classe GestionDemandes
import controle.GestionDemandes;
import entite.Instrument;
import java.awt.Color;
import java.awt.Font;

public class FenInstrument extends JFrame {

	private static final long serialVersionUID = 1L;
	// propriété pour établir le lien avec la classe GestionDemandes
	private GestionDemandes gestionBD = new GestionDemandes();  //  @jve:decl-index=0:
	private JPanel jContentPane = null;

	private JButton btn_quitter = null;

	private JLabel jLabel_id = null;

	private JLabel jLabel_nom = null;

	private JLabel jLabel_couleur = null;

	private JLabel jLabel_son = null;

	private JButton btn_ajouter = null;

	private JButton btn_ok = null;

	private JButton btn_annuler = null;

	private JTextField txt_id = null;

	private JTextField txt_nom = null;

	private JTextField txt_couleur = null;

	private JTextField txt_son = null;

	private JButton btn_rechercher = null;

	private boolean estRechercher=false;

	private void raz()
	{
		txt_id.setText("");
		txt_nom.setText("");
		txt_couleur.setText("");
		txt_son.setText("");
		btn_ajouter.setEnabled(true);
		btn_rechercher.setEnabled(true);
		btn_ok.setVisible(false);
		btn_annuler.setVisible(false);
		txt_id.setEditable(false);
		txt_nom.setEditable(false);
		txt_couleur.setEditable(false);
		txt_son.setEditable(false);
		estRechercher=false;

	}
	/**
	 * This is the default constructor
	 */
	public FenInstrument() {
		super();
		initialize();

	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(480, 517);
		this.setContentPane(getJContentPane());
		this.setTitle("Fenêtre Instrument ");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel_son = new JLabel();
			jLabel_son.setBounds(new Rectangle(15, 168, 110, 30));
			jLabel_son.setText("Son");
			jLabel_couleur = new JLabel();
			jLabel_couleur.setBounds(new Rectangle(15, 135, 110, 30));
			jLabel_couleur.setText("Couleur");
			jLabel_nom = new JLabel();
			jLabel_nom.setBounds(new Rectangle(15, 100, 110, 30));
			jLabel_nom.setText("Nom");
			jLabel_id = new JLabel();
			jLabel_id.setBounds(new Rectangle(15, 65, 110, 30));
			jLabel_id.setText("Numéro");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getBtn_quitter(), null);
			jContentPane.add(jLabel_id, null);
			jContentPane.add(jLabel_nom, null);
			jContentPane.add(jLabel_couleur, null);
			jContentPane.add(jLabel_son, null);
			jContentPane.add(getBtn_ajouter(), null);
			jContentPane.add(getBtn_ok(), null);
			jContentPane.add(getBtn_annuler(), null);
			jContentPane.add(getTxt_id(), null);
			jContentPane.add(getTxt_nom(), null);
			jContentPane.add(getTxt_couleur(), null);
			jContentPane.add(getTxt_son(), null);
			jContentPane.add(getBtn_Rechercher(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes btn_quitter	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtn_quitter() {
		if (btn_quitter == null) {
			btn_quitter = new JButton();
			btn_quitter.setBounds(new Rectangle(333, 410, 110, 40));
			btn_quitter.setText("Quitter");
			btn_quitter.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) 
				{

					FenInstrument.this.dispose() ;
					// fermeture de la connexion
					controle.ControleConnexion.getControleConnexion().fermetureSession();
					System.exit(0);
				}
			});
		}
		return btn_quitter;
	}
	/**
	 * This method initializes btn_ajouter	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtn_ajouter() {
		if (btn_ajouter == null) {
			btn_ajouter = new JButton();
			btn_ajouter.setFont(new Font("Castellar", Font.PLAIN, 14));
			btn_ajouter.setForeground(Color.BLACK);
			btn_ajouter.setBackground(Color.RED);
			btn_ajouter.setBounds(new Rectangle(333, 60, 110, 40));
			btn_ajouter.setText("Ajouter");
			btn_ajouter.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					btn_ajouter.setEnabled(false);
					btn_rechercher.setEnabled(false);
					btn_ok.setVisible(true);
					btn_annuler.setVisible(true);
					txt_id.setEditable(true);
					txt_id.requestFocusInWindow();
					txt_nom.setEditable(true);
					txt_couleur.setEditable(true);
					txt_son.setEditable(true);
				}
			});
		}
		return btn_ajouter;
	}
	/**
	 * This method initializes btn_ok	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtn_ok() {
		if (btn_ok == null) {
			btn_ok = new JButton();
			btn_ok.setBounds(new Rectangle(334, 298, 109, 40));
			btn_ok.setText("OK");
			btn_ok.setVisible(false);
			btn_ok.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e)
				{
				if(!estRechercher){
					gestionBD.enregistrerinstrument(txt_id.getText(),txt_nom.getText(),txt_couleur.getText(),txt_son.getText());
						raz();
						return;
					}else{
						Instrument retourInstrument=gestionBD.rechercherinstrument(txt_id.getText());
						if(retourInstrument==null){
							JOptionPane.showMessageDialog(null,"Pas d'instrument trouvé avec le matricule "+txt_id.getText() 
									,"Erreur de numéro",JOptionPane.ERROR_MESSAGE);
							return;
						}
						// Affichage
						txt_nom.setText(retourInstrument.getNom());
						txt_couleur.setText(retourInstrument.getCouleur());
						txt_son.setText(retourInstrument.getSon());
					}
				}
			});
		}
		return btn_ok;
	}

	/**
	 * This method initializes btn_annuler	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtn_annuler() {
		if (btn_annuler == null) {
			btn_annuler = new JButton();
			btn_annuler.setBounds(new Rectangle(333, 354, 110, 40));
			btn_annuler.setText("Annuler");
			btn_annuler.setVisible(false);
			btn_annuler.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					raz();
				}
			});
		}
		return btn_annuler;
	}

	/**
	 * This method initializes txt_id	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxt_id() {
		if (txt_id == null) {
			txt_id = new JTextField();
			txt_id.setBounds(new Rectangle(150, 65, 110, 30));
			txt_id.setEditable(false);

		}
		return txt_id;
	}

	/**
	 * This method initializes txt_nom	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxt_nom() {
		if (txt_nom == null) {
			txt_nom = new JTextField();
			txt_nom.setBounds(new Rectangle(150, 100, 110, 30));
			txt_nom.setEditable(false);
		}
		return txt_nom;
	}

	/**
	 * This method initializes txt_couleur	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxt_couleur() {
		if (txt_couleur == null) {
			txt_couleur = new JTextField();
			txt_couleur.setBounds(new Rectangle(150, 135, 110, 30));
			txt_couleur.setEditable(false);

		}
		return txt_couleur;
	}

	/**
	 * This method initializes txt_son	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxt_son() {
		if (txt_son == null) {
			txt_son = new JTextField();
			txt_son.setBounds(new Rectangle(149, 170, 110, 30));
			txt_son.setEditable(false);
		}
		return txt_son;
	}

	/**
	 * This method initializes Btn_Rechercher	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtn_Rechercher() {
		if (btn_rechercher == null) {
			btn_rechercher = new JButton();
			btn_rechercher.setBounds(new Rectangle(333, 242, 110, 40));
			btn_rechercher.setText("Rechercher");
			btn_rechercher.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					estRechercher=true;
					btn_ajouter.setEnabled(false);
					btn_rechercher.setEnabled(false);
					btn_ok.setVisible(true);
					btn_annuler.setVisible(true);
					txt_id.setEditable(true);
					txt_id.requestFocusInWindow();
				}
			});
		}
		return btn_rechercher;
	}

}  //  @jve:decl-index=0:visual-constraint="16,5"
