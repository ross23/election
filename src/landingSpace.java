import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class landingSpace extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("WELCOME TO THE VOTING DAY!");
	private final JLabel lblNewLabel_1 = new JLabel("Identification please#");
	private final JTextField id = new JTextField();
	private final JButton cast = new JButton("Cast Vote");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					landingSpace frame = new landingSpace();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public landingSpace() {
		id.setText("vote/results");
		id.setHorizontalAlignment(SwingConstants.LEFT);
		id.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				//Press Enter from the id prompt zone
				
				String authentication = id.getText().trim();

				//When the candidate come to cast the vote
				if(authentication.equals("vote"))
				{	
					//Disposing this Window
					ignoreWindow hide = new ignoreWindow(this);
					hide.setVisible(false);
					setVisible(false);
					dispose();
				
					votingZone v = null;
					try {
						v = new votingZone();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					v.castVoting();
					
				}
				//To see the results
				else if(authentication.equals("results"))
				{
					//Disposing this Window
					ignoreWindow hide = new ignoreWindow(this);
					hide.setVisible(false);
					setVisible(false);
					dispose();
				
					votingResults result = new votingResults();
					result.ballotsCounting();
				
				}
				else
				{
					//Disposing this Window
					ignoreWindow hide = new ignoreWindow(this);
					hide.setVisible(false);
					setVisible(false);
					dispose();
				
					landingSpace.main(null);
				}				
			}
		});
		id.setFont(new Font("Bodoni MT Condensed", Font.PLAIN, 30));
		id.setForeground(new Color(0, 100, 0));
		id.setBounds(384, 393, 558, 47);
		id.setColumns(10);
		
		setTitle("Welcome to Voting Day!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		//frame.setBounds(100, 100, 1366,768 );
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0,0,screenSize.width, screenSize.height);
						
		//setBounds(100, 100, 450, 300);
		//Applet always on the top
		setAlwaysOnTop (true);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Bodoni MT Condensed", Font.PLAIN, 60));
		lblNewLabel.setBounds(314, 194, 628, 115);
		
		contentPane.add(lblNewLabel);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Bodoni MT Condensed", Font.PLAIN, 31));
		lblNewLabel_1.setBounds(373, 335, 202, 47);
		
		contentPane.add(lblNewLabel_1);
		
		contentPane.add(id);
		cast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String authentication = id.getText().trim();

				//When the candidate come to cast the vote
				if(authentication.equals("vote"))
				{	
					//Disposing this Window
					ignoreWindow hide = new ignoreWindow(this);
					hide.setVisible(false);
					setVisible(false);
					dispose();
				
					votingZone v = null;
					try {
						v = new votingZone();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					v.castVoting();
					
				}
				//To see the results
				else if(authentication.equals("results"))
				{
					//Disposing this Window
					ignoreWindow hide = new ignoreWindow(this);
					hide.setVisible(false);
					setVisible(false);
					dispose();
				
					votingResults result = new votingResults();
					result.ballotsCounting();
				
				}
				else
				{
					//Disposing this Window
					ignoreWindow hide = new ignoreWindow(this);
					hide.setVisible(false);
					setVisible(false);
					dispose();
				
					landingSpace.main(null);
				
				}
					
			}
		});
		cast.setForeground(new Color(255, 255, 255));
		cast.setBackground(new Color(65, 105, 225));
		cast.setFont(new Font("Bodoni MT Condensed", Font.PLAIN, 60));
		cast.setBounds(384, 468, 558, 69);
		
		contentPane.add(cast);
		
		//hide the border in the button
		cast.setFocusPainted(false);
				
	}
}
