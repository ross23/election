import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class votingZone<collectData> extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("Cast Your Vote. This is your civic rights");
	private final JButton select = new JButton("Select");
	private final JButton back = new JButton("Return");
	
	private dataCollectors dataCollectors;
	
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable table = new JTable();
	private final JLabel lblNewLabel_1 = new JLabel("Marka");
	private final JLabel lblName = new JLabel("Name");
	private final JTextField resultMarka = new JTextField();
	private final JTextField resultName = new JTextField();
	private final JButton submitVote = new JButton("Submit Your Vote");
	
	/**
	 * Launch the application.
	 */
	public void castVoting() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					votingZone<?> frame = new votingZone<Object>();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public votingZone() throws Exception {
		resultMarka.setHorizontalAlignment(SwingConstants.CENTER);
		resultMarka.setForeground(new Color(0, 0, 0));
		resultMarka.setFont(new Font("Bodoni MT", Font.PLAIN, 32));
		resultMarka.setBounds(170, 528, 518, 48);
		resultMarka.setColumns(10);
		setTitle("Cast Your Vote Carefully");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		//frame.setBounds(100, 100, 1366,768 );
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0,0,screenSize.width, screenSize.height);
						
		//setBounds(100, 100, 450, 300);
		//Applet always on the top
		setAlwaysOnTop (true);
		// create the model and update the "table"
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 45));
		lblNewLabel.setBounds(22, 11, 1078, 75);
		
		//Populate all candidates and marka in the table
		addCandidates();
		
		contentPane.add(lblNewLabel);
		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cMarka = null;
				String cName = null;
				
				// get the selected item
				int row = table.getSelectedRow();
				
				// make sure a row is selected
				if (row < 0) {
					return;
				}
				
				// get the current vote
				pullCandidateData temppullCandidate  = (pullCandidateData) table.getValueAt(row, pullCandidateDataTableModel.OBJECT_COL);
				
				cMarka=temppullCandidate.getMarkaTitle();
				cName=temppullCandidate.getCandidateName();
				
				resultMarka.setText(cMarka);
				resultName.setText(cName);
				

								
			}

			
		});
		select.setForeground(new Color(255, 255, 255));
		select.setBackground(Color.DARK_GRAY);
		select.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 45));
		select.setBounds(722, 97, 565, 383);
		
		contentPane.add(select);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Disposing this Window
				ignoreWindow hide = new ignoreWindow(this);
				hide.setVisible(false);
				setVisible(false);
				dispose();
				
				landingSpace.main(null);
			}
		});
		back.setForeground(new Color(255, 255, 255));
		back.setBackground(new Color(65, 105, 225));
		back.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 45));
		back.setBounds(722, 528, 565, 191);
		
		contentPane.add(back);
		
		//hide the border in the button
		back.setFocusPainted(false);

		select.setFocusPainted(false);		
		scrollPane.setBounds(32, 97, 656, 383);
		
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(table);
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Bodoni MT", Font.PLAIN, 32));
		lblNewLabel_1.setBounds(32, 528, 125, 48);
		
		contentPane.add(lblNewLabel_1);
		lblName.setForeground(new Color(255, 0, 0));
		lblName.setFont(new Font("Bodoni MT", Font.PLAIN, 32));
		lblName.setBounds(32, 587, 125, 48);
		
		contentPane.add(lblName);
		
		contentPane.add(resultMarka);
		resultName.setHorizontalAlignment(SwingConstants.CENTER);
		resultName.setForeground(new Color(0, 0, 0));
		resultName.setFont(new Font("Bodoni MT", Font.PLAIN, 32));
		resultName.setColumns(10);
		resultName.setBounds(170, 587, 518, 48);
		
		contentPane.add(resultName);
		submitVote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String cMarka = null;
				String cName = null;
				
				dataCollectors dC = new dataCollectors();
				
				//Getting the product information
				cMarka= resultMarka.getText();
				cName=resultName.getText();

				UIManager UI=new UIManager();
				UI.put("OptionPane.background", Color.red);
				UI.put("Panel.background", Color.white);
				UI.put("OptionPane.minimumSize",new Dimension(500,250));
				
				JFrame frmOpt = null;  //dummy JFrame
				
				if (frmOpt == null) {
			        frmOpt = new JFrame();
			    }
			    frmOpt.setVisible(true);
			    frmOpt.setLocationRelativeTo(null);
			    frmOpt.setAlwaysOnTop(true);
			    JOptionPane dialog = new JOptionPane();
			    
				int decision= dialog.showConfirmDialog(frmOpt,"                                                                  MARKA ----> " + cMarka + "\n                                                 Candidate Name ----> "+cName, "Confirming the Vote", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
				
				frmOpt.dispose();

				
				if (decision == JOptionPane.YES_OPTION)
			    {
					//JOptionPane.showConfirmDialog(null,
	                        //"Vote Submitted Successfully",
	                        //"Confirmation",
	                        //JOptionPane.WARNING_MESSAGE);
					
					JOptionPane op = new JOptionPane("                                                   Vote Submitted Successfully",JOptionPane.PLAIN_MESSAGE);
					JDialog dialog1 = op.createDialog("Confirmation");
					dialog1.setAlwaysOnTop(true); //<-- this line
					dialog1.setModal(true);
					dialog1.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog1.setVisible(true);

			    //Vote submission to the database
				//submitting vote to the database
				try {
					dC.voteSubmission(cMarka);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				}
				
				//Disposing this Window
				ignoreWindow hide = new ignoreWindow(this);
				hide.setVisible(false);
				setVisible(false);
				dispose();
				
				landingSpace.main(null);
				
			}

		});
		submitVote.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 34));
		submitVote.setForeground(Color.WHITE);
		submitVote.setBackground(Color.RED);
		submitVote.setBounds(32, 646, 656, 73);
		
		contentPane.add(submitVote);
		
		//List<pullCandidateData> transactions1 = null;
		//transactions1 = dataCollectors.;
				
		//pullCandidateDataTableModel populateTable = new pullCandidateDataTableModel(transactions1);		
		//table.setModel(populateTable);

		
		
	}

	private void addCandidates() {
	
		try {
			
			List<pullCandidateData> info = null;

			// create the DAO
			try {
					dataCollectors = new dataCollectors();
				} catch (Exception exc) {
					System.out.println("Error occured: " + exc); 
			}

			info = dataCollectors.searchCandidate();
			
			pullCandidateDataTableModel populateTable = new pullCandidateDataTableModel(info);		
			
			table.setFont(new Font("Times New Roman", Font.PLAIN, 30));
			table.setRowHeight(table.getRowHeight()+15); 
			
			table.setModel(populateTable);
			
			
			} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
