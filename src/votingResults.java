import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.List;


public class votingResults extends JFrame {

	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("VOTING RESULTS");
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable table = new JTable();
	private final JButton returns = new JButton("Returning to the Headquarter");
	
	private dataCollectors dataCollectors;
	private final JButton btnNewButton = new JButton("Print");
	/**
	 * Launch the application.
	 */
	public void ballotsCounting(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					votingResults frame = new votingResults();
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
	public votingResults() {
		
		setTitle("Results incoming from casting on ballots");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		//frame.setBounds(100, 100, 1366,768 );
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0,0,screenSize.width, screenSize.height);
						
		//setBounds(100, 100, 450, 300);
		//Applet always on the top
		setAlwaysOnTop (false);
		// create the model and update the "table"
		
		//Populate all candidates and marka in the table
		displayResults();
				
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Bodoni MT Condensed", Font.PLAIN, 62));
		lblNewLabel.setBounds(294, 167, 841, 65);
		
		contentPane.add(lblNewLabel);
		scrollPane.setBounds(294, 243, 841, 300);
		
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(table);
		returns.setHorizontalAlignment(SwingConstants.RIGHT);
		returns.setForeground(new Color(255, 255, 255));
		returns.setBackground(new Color(65, 105, 225));
		returns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Disposing this Window
				ignoreWindow hide = new ignoreWindow(this);
				hide.setVisible(false);
				setVisible(false);
				dispose();
				
				landingSpace.main(null);
				
			}
		});
		returns.setFont(new Font("Bodoni MT Condensed", Font.PLAIN, 60));
		returns.setBounds(550, 565, 585, 86);
		
		contentPane.add(returns);
		
		//hide the border in the button
		returns.setFocusPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				 	MessageFormat header = new MessageFormat("Election Results");
			        MessageFormat footer = new MessageFormat("{0,number,integer}");
			        
			        PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
			        
			        try {
						table.print(JTable.PrintMode.FIT_WIDTH, header, footer, false, set, false);
					} catch (HeadlessException e1) {
						e1.printStackTrace();
					} catch (PrinterException e1) {
						e1.printStackTrace();
					}
			       				

				
			}
		});
		btnNewButton.setFont(new Font("Bodoni MT Condensed", Font.PLAIN, 60));
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(294, 565, 216, 86);
		
		contentPane.add(btnNewButton);

		
	}

	private void displayResults() {
			
		try {
			
			List<resultsData> info = null;

			
			// create the DAO
			try {
					dataCollectors = new dataCollectors();
				} catch (Exception exc) {
					System.out.println("Error occured: " + exc); 
			}

			info = dataCollectors.castingResults();
			
			resultsDataTableModel populateTable = new resultsDataTableModel(info);		
			
			table.setFont(new Font("Times New Roman", Font.PLAIN, 30));
			table.setRowHeight(table.getRowHeight()+15); 
			
			table.setModel(populateTable);
			
			
			} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
}
