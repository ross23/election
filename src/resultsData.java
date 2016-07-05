import java.math.BigDecimal;
import java.sql.Date;

public class  resultsData{

	//private byte[] Image;
	private String MarkaTitle;
	private String CandidateName;
	private int Vote_Got;

	public resultsData(String MarkaTitle, String CandidateName, int Vote_Got) {
		super();
		
		this.setMarkaTitle(MarkaTitle);
		this.setCandidateName(CandidateName);
		this.setVote_Got(Vote_Got);
	}

	public String getMarkaTitle() {
		return MarkaTitle;
	}

	public void setMarkaTitle(String MarkaTitle) {
		this.MarkaTitle = MarkaTitle;
	}

	public String getCandidateName() {
		return CandidateName;
	}

	public void setCandidateName(String CandidateName) {
		this.CandidateName = CandidateName;
	}

	public int getVote_Got() {
		return Vote_Got;
	}

	public void setVote_Got(int vote_Got) {
		Vote_Got = vote_Got;
	}

		
}
