import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;

public class PanelRegistrarLogin extends JPanel {
	private JTextField txtfldUsername;
	private JPasswordField passwordField;
	private String enteredUsername;
	private String enteredPassword;
	private String[] username = {"neo", "idk"};
	private String[] password = {"123", "345"};


	
	
	/**
	 * Create the panel.
	 */
	public PanelRegistrarLogin(CardLayout cl, Container container) {
		
		this.setBounds(100, 100, 919, 576);
		this.setBackground(Color.LIGHT_GRAY);
		this.setLayout(null);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnEnter)
				  enteredUsername = txtfldUsername.getText();
					enteredPassword = passwordField.getText();
					
					boolean usernameMatch = false;
					boolean passwordMatch = false;
					
					for (int i = 0; i<username.length;i++) {
						if (enteredUsername.equals(username[i])) {
							usernameMatch = true;	

						} if (enteredPassword.equals(password[i])) {
							passwordMatch = true;

						}
						break;


				
					}
					  if (usernameMatch && passwordMatch) {
				            cl.show(container, "PanelRegistrarChoice");;
				        } 
					

			}
		});
		btnEnter.setBounds(337, 349, 338, 69);
		this.add(btnEnter);
		this.setVisible(true);
		
		container.add(this, "PanelRegistrarLogin");  // Add the panel to the parent container
		
		txtfldUsername = new JTextField();
		txtfldUsername.setBounds(299, 211, 415, 54);
		add(txtfldUsername);
		txtfldUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		lblUsername.setBounds(194, 224, 93, 23);
		add(lblUsername);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(299, 283, 415, 54);
		add(passwordField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		lblPassword.setBounds(194, 296, 93, 23);
		add(lblPassword);
		
		JLabel lblRegistrarLogIn = new JLabel("Registrar Log In");
		lblRegistrarLogIn.setFont(new Font("Lucida Grande", Font.PLAIN, 29));
		lblRegistrarLogIn.setBounds(377, 123, 221, 35);
		add(lblRegistrarLogIn);
		
		JButton bttnBack = new JButton("back");
		bttnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cl.show(container, "PanelFirst");
			}
		});
		bttnBack.setBounds(734, 506, 117, 29);
		add(bttnBack);

	}
}
