import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelFirst extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelFirst(CardLayout cl, Container container ) {
		this.setBounds(100, 100, 919, 576);
		this.setBackground(Color.LIGHT_GRAY);
		this.setVisible(true);
		this.setOpaque(true);
		this.setLayout(null);
		
		
		container.add(this,"PanelFirst");
		
		JButton bttnCheckQueue = new JButton("Check Queue");
		bttnCheckQueue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(container, "PanelCheckQueue");
			}
			
		});
		bttnCheckQueue.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		bttnCheckQueue.setBounds(246, 168, 421, 146);
		add(bttnCheckQueue);
		
		JButton bttnLogin = new JButton("Registrar Log in");
		bttnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(container, "PanelRegistrarLogin");

			}
		});
		bttnLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		bttnLogin.setBounds(246, 340, 421, 146);
		add(bttnLogin);
		
		JLabel lblHeader = new JLabel("Registrar Document Requests Queuing Information");
		lblHeader.setFont(new Font("Lucida Grande", Font.BOLD, 28));
		lblHeader.setBounds(112, 80, 732, 34);
		add(lblHeader);
	}
}
