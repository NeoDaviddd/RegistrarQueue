import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelCheckQueue extends JPanel {

	public int transactionNumber = 25;
	JLabel lblTransactionsLeft;
	
	public PanelCheckQueue(CardLayout cl, Container container) {
		

		this.setBounds(100, 100, 919, 576);
		this.setBackground(Color.LIGHT_GRAY);
		this.setVisible(true);
		this.setOpaque(true);
		this.setLayout(null);
		
		container.add(this, "PanelCheckQueue");
		
		 lblTransactionsLeft = new JLabel("Number of transactions left today: "+transactionNumber);
		lblTransactionsLeft.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		lblTransactionsLeft.setBounds(208, 189, 488, 32);
		add(lblTransactionsLeft);
		
		JButton btnNewButton = new JButton("Track Reference Number");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cl.show(container,"PanelTrackReference" );
			}
		});
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		btnNewButton.setBounds(220, 299, 450, 100);
		add(btnNewButton);
		
		JButton bttnBack = new JButton("back");
		bttnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(container, "PanelFirst");
			}
		});
		bttnBack.setBounds(683, 496, 117, 29);
		add(bttnBack);
	}
}
