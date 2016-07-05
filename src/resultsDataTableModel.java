import java.util.List;

import javax.swing.table.AbstractTableModel;

class resultsDataTableModel extends AbstractTableModel {

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
	private static final int Vote_Got_Col=2;
	
	private String[] columnNames = {"Marka Title",
			"Candidate Name",
			"Vote Achieved"
	};

	
	private List<resultsData> resultsVector;
	
	public resultsDataTableModel(List<resultsData> theresultData) {
		resultsVector = theresultData;
	}

		
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return resultsVector.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	public Object getValueAt(int row, int col) {

		resultsData tempresultsData = resultsVector.get(row);

		switch (col) {
		case MarkaTitle_col:
			return tempresultsData.getMarkaTitle();
		case CandidateName_Col:
			return tempresultsData.getCandidateName();
		case Vote_Got_Col:
			return tempresultsData.getVote_Got();
		case OBJECT_COL:
			return tempresultsData;	
		default:
			return tempresultsData.getMarkaTitle();
		}
	}
}
