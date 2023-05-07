import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelRegistrarChoice extends JPanel {

	
		public PanelRegistrarChoice(CardLayout cl, Container container) {
		
		this.setBounds(100, 100, 919, 576);
		this.setBackground(Color.LIGHT_GRAY);
		this.setVisible(true);
		this.setOpaque(true);
		this.setLayout(null);
		
		JButton btnNewButton = new JButton("Add Client");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(container, "PanelAddClient");
	
			}

		});
		
		container.add(this, "PanelRegistrarChoice");
		
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 31));
		btnNewButton.setBounds(219, 132, 483, 134);
		add(btnNewButton);
		
		JButton btnEditClient = new JButton("Edit Client");
		btnEditClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(container, "PanelEditClient");
			}
		});
		btnEditClient.setFont(new Font("Lucida Grande", Font.PLAIN, 31));
		btnEditClient.setBounds(219, 292, 483, 134);
		add(btnEditClient);
		
		JButton bttnBack = new JButton("back");
		bttnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(container,"PanelFirst");
			}
		});
		bttnBack.setBounds(747, 509, 117, 29);
		add(bttnBack);
	}
}
