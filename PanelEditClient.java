import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.text.DateFormatter;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JFormattedTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelEditClient extends JPanel {
	private JTextField txtfldStudentReference;
	ButtonGroup buttons = new ButtonGroup();
	JRadioButton radioYes = new JRadioButton();
	JRadioButton radioNo = new JRadioButton();
	private JTextField txtfldSetDate;
	private boolean availability;
	private String pickupDate;
//	public DefaultListModel<String> studentName = new DefaultListModel<String>();
	public DefaultListModel<String> studentNames = new DefaultListModel<String>();
	Student student = new Student();
	public DefaultListModel<Student> studentList = new DefaultListModel<Student>();
	int selectedIndex;
	Student selectedStudent;



	
	public PanelEditClient(CardLayout cl, Container container) {
		
		this.setBounds(100, 100, 919, 576);
		this.setBackground(Color.LIGHT_GRAY);
		this.setVisible(true);
		this.setOpaque(true);
		this.setLayout(null);

		
		
		container.add(this, "PanelEditClient");
		
		
		
	
		
		JButton bttnBack = new JButton("back");
		bttnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(container,"PanelRegistrarChoice");
			}
		});
		bttnBack.setBounds(748, 514, 117, 29);
		add(bttnBack);
		



		JList<String> list = new JList<>(studentNames);
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(183, 178, 519, 58);
		add(scrollPane);
		
		list.setBounds(183, 178, 519, 58);
		
		txtfldStudentReference = new JTextField();
		txtfldStudentReference.setBounds(332, 296, 333, 46);
		txtfldStudentReference.setEnabled(false);
		add(txtfldStudentReference);
		txtfldStudentReference.setColumns(10);
		
		JLabel lblReady= new JLabel("Are the documents ready?");
		lblReady.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblReady.setBounds(183, 367, 203, 20);
		add(lblReady);
		
		JLabel lblStudents = new JLabel("Students:");
		lblStudents.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudents.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblStudents.setBounds(347, 146, 147, 20);
		add(lblStudents);
		
		txtfldSetDate = new JTextField();
		txtfldSetDate.setColumns(10);
		txtfldSetDate.setBounds(332, 419, 333, 46);
		txtfldSetDate.setEnabled(false);
		
		add(txtfldSetDate);
		

		
		
			radioYes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtfldSetDate.setEnabled(true);
					selectedStudent = studentList.get(selectedIndex);
					selectedStudent.setAvailability(true);
					System.out.println(selectedStudent.getName()+"'s availability: "+selectedStudent.getAvailability());
	
				}
			});
			
			radioYes.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
			
			radioYes.setBounds(395,365,56,23);
			radioYes.setText("Yes");
			this.add(radioYes);
			
			
			radioNo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtfldSetDate.setEnabled(false);
					selectedStudent = studentList.get(selectedIndex);
					selectedStudent.setAvailability(false);
					System.out.print(selectedStudent.getName()+"'s availability: "+selectedStudent.getAvailability());
					
	
				}
				
			});
			
			radioNo.setBounds(462,366,50,23);
			radioNo.setText("No");
			this.add(radioNo);
	
			
			buttons.add(radioYes);
			buttons.add(radioNo);
			
			
	
			
			
			JButton bttnSelect = new JButton("Select");
			bttnSelect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					selectedIndex = list.getSelectedIndex();
					System.out.println(selectedIndex);
					//System.out.println(student.get(1).getName());
					txtfldStudentReference.setText(studentList.get(selectedIndex).getReference());
					txtfldSetDate.setText(studentList.get(selectedIndex).getPickUpDate());
					txtfldSetDate.setEnabled(true);
			}
		});
		bttnSelect.setBounds(366, 248, 117, 29);
		add(bttnSelect);
		
		JLabel lblStudentReference = new JLabel("Student Reference:");
		lblStudentReference.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblStudentReference.setBounds(183, 308, 147, 20);
		add(lblStudentReference);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	pickupDate = txtfldSetDate.getText();
		    	System.out.println(selectedIndex);
		    	selectedStudent = studentList.get(selectedIndex);
		    	selectedStudent.setPickUpDate(pickupDate);
		    	txtfldSetDate.setEnabled(false);
		    	System.out.println(selectedStudent.getName()+"'s scheduled date: "+selectedStudent.getPickUpDate());
		    	
		    }
		});

		btnEdit.setBounds(380, 477, 88, 29);
		add(btnEdit);
		
		
		
	
		
		JLabel lblSetPickupDate = new JLabel("Set pick-up date:");
		lblSetPickupDate.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblSetPickupDate.setBounds(196, 431, 134, 20);
		add(lblSetPickupDate);
		
		JLabel lblEditClient = new JLabel("Edit Client");
		lblEditClient.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditClient.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		lblEditClient.setBounds(356, 50, 138, 34);
		add(lblEditClient);
		
		
		
		

	}
}
