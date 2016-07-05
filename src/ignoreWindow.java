//This class is responsible for dispose the main window

import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class ignoreWindow extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public ignoreWindow(ActionListener actionListener) {
		// TODO Auto-generated constructor stub
		disposeWindow();
	}

	public void disposeWindow()
	{
            landingSpace Mform = new landingSpace();
	    Mform.setVisible(false);
	    setVisible(false);
	    dispose();
	}
}
