import java.math.BigDecimal;
import java.sql.Date;

public class  pullCandidateData{

	//private byte[] Image;
	private String MarkaTitle;
	private String CandidateName; 

	public pullCandidateData(String MarkaTitle, String CandidateName) {
		super();
		
		this.setMarkaTitle(MarkaTitle);
		this.setCandidateName(CandidateName);
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
		
}
