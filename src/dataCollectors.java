import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.omg.CORBA.portable.InputStream;


public class dataCollectors<balloting> {

	String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	
	private Connection myConn;
	

public List<pullCandidateData> searchCandidate() throws Exception {
		
		List<pullCandidateData> list = new ArrayList<>();
		
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/election";
		String user = "root";
		String password = "mysql501";
    	           
    	// connect to database
		myConn = DriverManager.getConnection(url, user, password);
		
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myConn.prepareStatement("select * from ballots");
			
			myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				pullCandidateData temppullCandidateData = convertRowToPullCandidateData(myRs);
				list.add(temppullCandidateData);
				System.out.println("Data collected successfully");
			}
			
			return list;
		}
		finally {
			close(myStmt, myRs);
		}
	}

	private pullCandidateData convertRowToPullCandidateData(ResultSet myRs) throws SQLException {
	
	//Database table header
	//byte image = myRs.getByte("Image"); 	
	String marka= myRs.getString("MarkaTitle");
	String name= myRs.getString("CandidateName");

	pullCandidateData temppullCandidateData = new pullCandidateData(marka,name);
	
	System.out.println("converting rows");
	
	return temppullCandidateData;
}

	//Closing the connections
	private static void close(Statement myStmt, ResultSet myRs)
			throws SQLException {

		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {	
		}
		
	}

	
	public void voteSubmission(String cMarka) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/election";
		String user = "root";
		String password = "mysql501";
		           
		// connect to database
		myConn = DriverManager.getConnection(url, user, password);
		
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myConn.prepareStatement("UPDATE vote_results "+ 
												"SET Vote_got = Vote_got + 1 " + 
													"WHERE MarkaTitle = ?"
  											);
			myStmt.setString(1, cMarka);
			
			myStmt.executeUpdate();
			
			System.out.println("Vote submitted");
			}	
		finally {
			close(myStmt, myRs);
		}
		
	}
	
public List<resultsData> castingResults() throws Exception {
		
		List<resultsData> list = new ArrayList<>();
		
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/election";
		String user = "root";
		String password = "mysql501";
    	           
		// connect to database
		myConn = DriverManager.getConnection(url, user, password);
		
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myConn.prepareStatement("select * from  vote_results");
			
			myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				resultsData tempresultsData = collectResults(myRs);
				list.add(tempresultsData);
				System.out.println("Data collected successfully");
			}
			
			return list;
		}
		finally {
			close(myStmt, myRs);
		}
	}

	private resultsData collectResults(ResultSet myRs) throws SQLException {
	
	//Database table header
	//byte image = myRs.getByte("Image"); 	
	String marka= myRs.getString("MarkaTitle");
	String name= myRs.getString("CandidateName");
	int result= myRs.getInt("Vote_Got");
	
	resultsData tempresultsData = new resultsData(marka,name,result);
	
	System.out.println("Results Zone");
	
	return tempresultsData;
}


}