package dialogue;

import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
//permet l affichage des boîtes de dialogue

//permet d établir le lien avec la classe ControleConnexion
import controle.ControleConnexion;
public class FenConnexion extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JButton btn_connecter = null;

	private JButton btn_quitter = null;

	private JLabel jLabe_indentifiant = null;

	private JLabel jLabel_mdp = null;

	private JLabel jLabel_BD = null;

	private JLabel jLabel_driver = null;

	private JTextField txt_login = null;

	private JPasswordField txt_mdp = null;

	private JLabel lbl_serverBD = null;

	private JLabel lbl_driverSGBD = null;

	/**
	 * This method initializes Btn_connecter	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtn_connecter() {
		if (btn_connecter == null) {
			btn_connecter = new JButton();
			btn_connecter.setBounds(new Rectangle(313, 9, 164, 33));
			btn_connecter.setText("Connexion");
			btn_connecter.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) 
				{
							
				if(ControleConnexion.getControleConnexion().controle(txt_login.getText(),String.valueOf(txt_mdp.getPassword())))
				{
					ControleConnexion.getControleConnexion().connect();
					if(ControleConnexion.getControleConnexion().getEtatControleConnexion())
					{				
						FenConnexion.this.dispose() ;
						FenInstrument LaFenInstrument = new FenInstrument() ;
						LaFenInstrument.setVisible(true) ;
					}

				}
			}});
		}
		return btn_connecter;
	}

	/**
	 * This method initializes Btn_quitter	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtn_quitter() {
		if (btn_quitter == null) {
			btn_quitter = new JButton();
			btn_quitter.setBounds(new Rectangle(313, 58, 164, 33));
			btn_quitter.setText("Quitter");
			btn_quitter.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					FenConnexion.this.dispose() ;
					System.exit(0); 
				}
			});
			btn_quitter.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) 
				{
					if (e.getKeyCode()==10) 
					{
						FenConnexion.this.dispose() ;
						System.exit(0) ;
					}

				}
			});
		}
		return btn_quitter;
	}

	
	/**
	 * This method initializes Txt_identifiant	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxt_login() {
		if (txt_login == null) {
			txt_login = new JTextField();
			txt_login.setBounds(new Rectangle(130, 10, 150, 30));
		}
		return txt_login;
	}

	/**
	 * This method initializes Txt_mdp	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getTxt_mdp() {
		if (txt_mdp == null) {
			txt_mdp = new JPasswordField();
			txt_mdp.setBounds(new Rectangle(130, 60, 150, 30));
		}
		return txt_mdp;
	}

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FenConnexion thisClass = new FenConnexion();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public FenConnexion() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(514, 249);
		this.setContentPane(getJContentPane());
		this.setTitle("Fenêtre Connnexion");
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowOpened(java.awt.event.WindowEvent e) {
				entite.Parametres lecontroleParametres = ControleConnexion.getControleConnexion().getParametres();
				lbl_serverBD.setText(lecontroleParametres.getServeurBD());
				lbl_driverSGBD.setText(lecontroleParametres.getDriverSGBD());
				
			}
		});
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			lbl_driverSGBD = new JLabel();
			lbl_driverSGBD.setBounds(new Rectangle(130, 160, 347, 30));
			lbl_driverSGBD.setText("");
			lbl_serverBD = new JLabel();
			lbl_serverBD.setBounds(new Rectangle(130, 110, 334, 30));
			lbl_serverBD.setText("");
			jLabel_driver = new JLabel();
			jLabel_driver.setBounds(new Rectangle(10,160, 100,30));
			jLabel_driver.setText("Driver");
			jLabel_BD = new JLabel();
			jLabel_BD.setBounds(new Rectangle(10, 110, 134, 30));
			jLabel_BD.setText("Base de données");
			jLabel_mdp = new JLabel();
			jLabel_mdp.setBounds(new Rectangle(10, 60, 100, 30));
			jLabel_mdp.setText("Mot de passe");
			jLabe_indentifiant = new JLabel();
			jLabe_indentifiant.setBounds(new Rectangle(10, 10, 100, 30));
			jLabe_indentifiant.setText("Identifiant");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getBtn_connecter(), null);
			jContentPane.add(getBtn_quitter(), null);
			jContentPane.add(jLabe_indentifiant, null);
			jContentPane.add(jLabel_mdp, null);
			jContentPane.add(jLabel_BD, null);
			jContentPane.add(jLabel_driver, null);
			jContentPane.add(getTxt_login(), null);
			jContentPane.add(getTxt_mdp(), null);
			jContentPane.add(lbl_serverBD, null);
			jContentPane.add(lbl_driverSGBD, null);
		}
		return jContentPane;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
