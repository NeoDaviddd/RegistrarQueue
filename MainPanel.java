import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MainPanel {

	JFrame frame;
	CardLayout cl = new CardLayout();
    private DefaultListModel<String> studentListModel;
    PanelEditClient panelEditClient;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPanel window = new MainPanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 919, 576);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(cl);
		frame.setLocationRelativeTo(null);

		
	
		
		PanelFirst panelFirst = new PanelFirst(cl, frame.getContentPane());
		PanelCheckQueue panelCheckQueue = new PanelCheckQueue(cl, frame.getContentPane());
		PanelRegistrarLogin panelRegistrarLogin = new PanelRegistrarLogin(cl, frame.getContentPane()) ;
		PanelRegistrarChoice panelRegistrarChoice = new PanelRegistrarChoice(cl, frame.getContentPane() );
        PanelAddClient panelAddClient = new PanelAddClient(cl, frame.getContentPane());
		PanelEditClient panelEditClient = new PanelEditClient(cl, frame.getContentPane());
		PanelTrackReference panelTrackReference = new PanelTrackReference(cl,frame.getContentPane());

	

	
		
		
		
		
	}
}

