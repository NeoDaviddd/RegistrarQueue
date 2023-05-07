import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelTrackReference extends JPanel {
	private JTextField txtfldReference;
	private JTextField txtfldName;
	private JLabel lblNotAvailable;
	private JLabel lblAvailable;
	private JLabel lblYouMayPick;
	private JLabel lblTrackReference;
	private JButton bttnBack;

	/**
	 * Create the panel.
	 */
	public PanelTrackReference(CardLayout cl, Container container) {
		
		PanelAddClient panelAddClient = new PanelAddClient(cl, container);

		

		this.setBounds(100, 100, 919, 576);
		this.setBackground(Color.LIGHT_GRAY);
		this.setVisible(true);
		this.setOpaque(true);
		this.setLayout(null);
		
		
		container.add(this, "PanelTrackReference");
		
		txtfldReference = new JTextField();
		txtfldReference.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String referenceNumber =txtfldReference.getText();
				Student matchStudent = null;
				for(Student student:panelAddClient.students ) {
					if(student.getReference().equals(referenceNumber)) {
						matchStudent= student;
						break;
					}
				}
			}
		});
		txtfldReference.setBounds(356, 221, 443, 46);
		add(txtfldReference);
		txtfldReference.setColumns(10);
		
		JLabel lblEnterReference = new JLabel("Enter reference number: ");
		lblEnterReference.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		lblEnterReference.setBounds(95, 228, 259, 26);
		add(lblEnterReference);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		lblName.setBounds(276, 330, 67, 26);
		add(lblName);
		
		txtfldName = new JTextField();
		txtfldName.setColumns(10);
		txtfldName.setBounds(356, 323, 443, 46);
		add(txtfldName);
		
		
		lblNotAvailable = new JLabel("Your documents are not yet ready.");
		lblNotAvailable.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		lblNotAvailable.setBounds(356, 392, 392, 26);
		lblNotAvailable.setVisible(false);
		add(lblNotAvailable);
		
		lblAvailable = new JLabel("Your documents are ready.");
		lblAvailable.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		lblAvailable.setBounds(356, 392, 392, 26);
		lblAvailable.setVisible(false);
		add(lblAvailable);
		
		lblYouMayPick = new JLabel("You may pick it up on ");
		lblYouMayPick.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		lblYouMayPick.setBounds(356, 430, 512, 26);
		lblYouMayPick.setVisible(false);
		add(lblYouMayPick);
		
		
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enteredReference = txtfldReference.getText();
				System.out.println("You entered the button.");
				System.out.println(panelAddClient.studentList);

				for(int i =0; i<panelAddClient.studentList.getSize();i++) {
					if (enteredReference.equals(panelAddClient.studentList.get(i).getReference())) {
						Student matchedStudent = panelAddClient.studentList.get(i);
						txtfldName.setText(matchedStudent.getName());
						txtfldName.setEnabled(false);
						if(matchedStudent.getAvailability()) {
							lblAvailable.setVisible(true);
							lblYouMayPick.setText("You may pick it up on "+matchedStudent.getPickUpDate());
							lblYouMayPick.setVisible(true);
						} else {
							lblNotAvailable.setVisible(true);
						}
						
					} else {
						System.out.println("Wrong reference number.");
					}
				}
				
				
			}
		});
		btnEnter.setBounds(532, 269, 117, 29);
		add(btnEnter);
		
		lblTrackReference = new JLabel("Track Reference Number");
		lblTrackReference.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblTrackReference.setBounds(307, 132, 301, 31);
		add(lblTrackReference);
		
		bttnBack = new JButton("back");
		bttnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(container, "PanelCheckQueue");
			}
		});
		bttnBack.setBounds(769, 520, 117, 29);
		add(bttnBack);
		
	}
}
