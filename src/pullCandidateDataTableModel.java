import java.util.List;

import javax.swing.table.AbstractTableModel;

class pullCandidateDataTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public static final int OBJECT_COL = -1;
	private static final int MarkaTitle_col =0;		
	private static final int CandidateName_Col=1;
	
	private String[] columnNames = {"Marka Title",
			"Candidate Name"
	};

	
	private List<pullCandidateData> candidatedata;
	
	public pullCandidateDataTableModel(List<pullCandidateData> thePullCandidateData) {
		candidatedata = thePullCandidateData;
	}

		
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return candidatedata.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	public Object getValueAt(int row, int col) {

		pullCandidateData temppullCandidateData = candidatedata.get(row);

		switch (col) {
		case MarkaTitle_col:
			return temppullCandidateData.getMarkaTitle();
		case CandidateName_Col:
			return temppullCandidateData.getCandidateName();
		case OBJECT_COL:
			return temppullCandidateData;	
		default:
			return temppullCandidateData.getMarkaTitle();
		}
	}
}
