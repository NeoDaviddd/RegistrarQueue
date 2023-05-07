import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelAddClient extends JPanel {
	private JTextField txtfldStudentName;
	private JTextField txtfldReference;
	public DefaultListModel<String> studentName = new DefaultListModel<String>();
	public DefaultListModel<String> studentReference = new DefaultListModel<String>();
	public DefaultListModel<Student> studentList = new DefaultListModel<Student>();

	public ArrayList<Student> students = new ArrayList<Student>();
	public int transactionNumber = 25;
	JLabel numTransactionsLeft;
	String uniqueId;
	Student student;
	boolean button;

	JButton btnAddClient;
	public PanelAddClient(CardLayout cl, Container container) {
		
		PanelEditClient panelEditClient = new PanelEditClient(cl, container);
		PanelCheckQueue panelCheckQueue = new PanelCheckQueue(cl, container);

		this.setBounds(100, 100, 919, 576);
		this.setBackground(Color.LIGHT_GRAY);
		this.setVisible(true);
		this.setOpaque(true);
		this.setLayout(null);

		container.add(this, "PanelAddClient");

		JLabel lblStudentName = new JLabel("Student Name:");
		lblStudentName.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		lblStudentName.setBounds(161, 197, 136, 23);
		add(lblStudentName);

		txtfldStudentName = new JTextField();
		txtfldStudentName.setColumns(10);
		txtfldStudentName.setBounds(298, 184, 415, 54);
		add(txtfldStudentName);

		JLabel lblReferenceNumber = new JLabel("Reference Number:");
		lblReferenceNumber.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		lblReferenceNumber.setBounds(117, 385, 180, 23);
		add(lblReferenceNumber);

		 numTransactionsLeft = new JLabel(Integer.toString(transactionNumber));
		numTransactionsLeft.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		numTransactionsLeft.setBounds(576, 444, 24, 23);
		add(numTransactionsLeft);

		 btnAddClient = new JButton("Add Client");


		studentName = new DefaultListModel<>(); // Initialize studentName

		
		JButton btnAddAgain = new JButton("Add Again");
		btnAddAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddClient.setEnabled(true);
				txtfldStudentName.setEnabled(true);
				txtfldReference.setText("");
				txtfldStudentName.setText("");
			}
		});
		btnAddAgain.setBounds(377, 319, 267, 29);
		btnAddAgain.setVisible(false);
		add(btnAddAgain);

		btnAddClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 uniqueId = String.format("%d-%04d", System.currentTimeMillis(), new Random().nextInt(10000));

				txtfldStudentName.setEnabled(false);
				btnAddClient.setEnabled(false);
				btnAddAgain.setVisible(true);
				
				//create a new student
		        student = new Student(txtfldStudentName.getText(),uniqueId);
		        
		        //We needed to create another list here in add client panel for the check queue panel to use
		        studentList.addElement(student);
		        
		        //add the new student to the student list of the panelEditCLient
		        panelEditClient.studentList.addElement(student);
		        
		        //we need this to show the names to the JList of panelEditCLient since JList cannot iterate an object
		        panelEditClient.studentNames.addElement(txtfldStudentName.getText());


		        //Set the reference JField to the generated UniqueId
		        txtfldReference.setText(uniqueId);
		        
		        //subtract the transaction number declared in the panelCheckQueue
		        panelCheckQueue.transactionNumber--;
		        
		        //set text to the subtracted transaction numner
		        panelCheckQueue.lblTransactionsLeft.setText("Number of transactions left today: "+panelCheckQueue.transactionNumber);
		       
		        //show the new number of transaction left in this panel
		        numTransactionsLeft.setText(Integer.toString(panelCheckQueue.transactionNumber));
		        
		        System.out.println(student.getName()+"'s reference: "+uniqueId);
		        
		       JOptionPane.showMessageDialog(container, txtfldStudentName.getText()+" has been added","Information", JOptionPane.INFORMATION_MESSAGE);

			}
		});

		btnAddClient.setBounds(338, 250, 338, 69);
		add(btnAddClient);

		txtfldReference = new JTextField();
		txtfldReference.setBounds(298, 372, 415, 54);
		txtfldReference.setText("");
		txtfldReference.setEnabled(false);
		add(txtfldReference);

		JLabel lblTransactionsLeft = new JLabel("Transactions Left:");
		lblTransactionsLeft.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		lblTransactionsLeft.setBounds(401, 444, 180, 23);
		add(lblTransactionsLeft);
		
		JButton bttnBack = new JButton("back");
		bttnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(container, "PanelRegistrarChoice");
			}
		});
		bttnBack.setBounds(744, 503, 117, 29);
		add(bttnBack);
		
		JLabel lblNewLabel = new JLabel("Add Client");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		lblNewLabel.setBounds(381, 98, 142, 34);
		add(lblNewLabel);
		}
}
