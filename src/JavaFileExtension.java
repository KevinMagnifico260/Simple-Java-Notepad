
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

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class JavaFileExtension extends FileFilter {
	
	private String ext;
	private String description;
	
	public JavaFileExtension(String ext, String description) {
		this.ext = ext;
		this.description = description;
	}
	
	public boolean accept(File file) {
		return file.getName().endsWith(this.ext);
	}
	
	public String getDescription() {
		return description + String.format(" (*%s)", ext);
	}
}
