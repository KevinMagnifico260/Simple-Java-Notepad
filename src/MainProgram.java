
/*
 * 		Author : Kevin C. Magnifico
 * 
 * 		Created by : Kevin C. Magnifico
 * 
 * 		Programming language type : Java
 * 
 * 		Application type : Notepad(Word Processing)
 */

package jnotepad;

import javax.swing.UIManager;

public class MainProgram implements Runnable {
	
	// Create Thread to imporve Performance
	public void run() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			Form f = new Form();
			f.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try  {
			Thread t1 = new Thread(new MainProgram());
			t1.start();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
