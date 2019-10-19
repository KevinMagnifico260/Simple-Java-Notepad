
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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Form extends JFrame {
	
	private final int FormWidth = 650;
	private final int FormHeight = 470;
	private JTextArea txta;
	private JScrollPane txta_scroll;
	private JMenuBar form_menu;
	private JMenu file_menu, edit_menu, about_menu;
	private JMenuItem file_new, file_save, file_open, file_exit;
	private JMenuItem edit_undo, edit_cut, edit_copy, edit_paste, edit_selectall, edit_delete, edit_clear;
	private JCheckBoxMenuItem edit_wordwrap, edit_find;
	private String space = "                                         ";
	
	public Form() throws IOException {
		super.setTitle("Kevin Java Notepad");
		super.setSize(FormWidth, FormHeight);
		super.setMinimumSize(new Dimension(200, 150));
		super.setLocationRelativeTo(null);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Add_Menu();
		Add_Component();
		Add_event_handler();
	}
	
	private void Add_Component() {
		txta = new JTextArea();
		txta.setFont(new Font(txta.getName(), Font.PLAIN, 14));
		txta.setMargin(new Insets(0, 3, 0, 0));
		txta.setBackground(new Color(245, 245, 245));
		txta_scroll = new JScrollPane(txta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		super.add(txta_scroll);
	}
	
	private void Add_Menu() {
		form_menu = new JMenuBar();
		Font f = new Font("Arial Monospace", Font.BOLD, 14);
		UIManager.put("Menu.font", f);
		form_menu.setBackground(new Color(255, 102, 102));
		/////////////////////////////////////////////////
		file_menu = new JMenu("File   ");
		file_menu.setForeground(Color.white);
		file_new = new JMenuItem("New" + space);
		file_new.setFont(new Font(file_new.getName(), Font.BOLD, 14));
		file_save = new JMenuItem("Save");
		file_save.setFont(new Font(file_save.getName(), Font.BOLD, 14));
		file_open = new JMenuItem("Open");
		file_open.setFont(new Font(file_open.getName(), Font.BOLD, 14));
		file_exit = new JMenuItem("Exit");
		file_exit.setFont(new Font(file_exit.getName(), Font.BOLD, 14));
		file_menu.add(file_new);
		file_menu.add(file_save);
		file_menu.add(file_open);
		file_menu.add(file_exit);
		/////////////////////////////////////////////////
		edit_menu = new JMenu("Edit   ");
		edit_menu.setForeground(Color.white);
		edit_undo = new JMenuItem("Undo" + space);
		edit_undo.setFont(new Font(edit_undo.getName(), Font.BOLD, 14));
		edit_cut = new JMenuItem("Cut");
		edit_cut.setFont(new Font(edit_cut.getName(), Font.BOLD, 14));
		edit_copy = new JMenuItem("Copy");
		edit_copy.setFont(new Font(edit_copy.getName(), Font.BOLD, 14));
		edit_paste = new JMenuItem("Paste");
		edit_paste.setFont(new Font(edit_paste.getName(), Font.BOLD, 14));
		edit_selectall = new JMenuItem("Select All");
		edit_selectall.setFont(new Font(edit_selectall.getName(), Font.BOLD, 14));
		edit_delete = new JMenuItem("Delete");
		edit_delete.setFont(new Font(edit_delete.getName(), Font.BOLD, 14));
		edit_find = new JCheckBoxMenuItem("Find");
		edit_find.setFont(new Font(edit_find.getName(), Font.BOLD, 14));
		edit_clear = new JMenuItem("Clear");
		edit_clear.setFont(new Font(edit_clear.getName(), Font.BOLD, 14));
		edit_wordwrap = new JCheckBoxMenuItem("Word Wrap");
		edit_wordwrap.setFont(new Font(edit_wordwrap.getName(), Font.BOLD, 14));
		edit_menu.add(edit_undo);
		edit_menu.add(edit_cut);
		edit_menu.add(edit_copy);
		edit_menu.add(edit_paste);
		edit_menu.add(edit_selectall);
		edit_menu.add(edit_delete);
		edit_menu.add(edit_find);
		edit_menu.add(edit_clear);
		edit_menu.add(edit_wordwrap);
		/////////////////////////////////////////////////
		about_menu = new JMenu("About");
		about_menu.setForeground(Color.white);
		/////////////////////////////////////////////////
		form_menu.add(file_menu);
		form_menu.add(edit_menu);
		form_menu.add(about_menu);
		super.setJMenuBar(form_menu);
	}
	
	private void Aboutme() {
		JOptionPane.showMessageDialog(this, "Title: Kevin Java notepad\nCreated by : Kevin C. Magnifico\nWritten in : Java\nVersion : 1.0.0v", "About", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void Add_event_handler() throws IOException {
		about_menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Aboutme();
			}
		});
		edit_wordwrap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (edit_wordwrap.isSelected()) {
					txta.setLineWrap(true);
				}
				else if (!edit_wordwrap.isSelected()) {
					txta.setLineWrap(false);
				}
			}
		});
		edit_cut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txta.cut();
			}
		});
		edit_copy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txta.copy();
			}
		});
		edit_paste.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txta.paste();
			}
		});
		edit_selectall.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txta.selectAll();
			}
		});
		edit_delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txta.replaceSelection("");
			}
		});
		edit_clear.addActionListener(new ActionListener() {
			@Override 
			public void actionPerformed(ActionEvent e) {
				txta.setText("");
			}
		});
		file_save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String ext;
				JFileChooser filesave = new JFileChooser();
				filesave.setDialogTitle("Save File");
				filesave.setFileFilter(new JavaFileExtension(".txt", "Text File"));
				if (filesave.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					try {
						if (filesave.getFileSelectionMode() == 0)
						{
							FileWriter fw = new FileWriter(filesave.getSelectedFile() + ".txt");
							txta.write(fw);
							fw.close();
						}
					}
					catch (IOException io_e) {
						JOptionPane.showMessageDialog(null, "Error to save file...", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		file_open.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileopen = new JFileChooser();
				fileopen.setDialogTitle("Open File");
				fileopen.setFileFilter(new JavaFileExtension(".txt", "Text Files"));
				if (fileopen.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					try {
						FileReader fr = new FileReader(fileopen.getSelectedFile());
						BufferedReader br = new BufferedReader(fr);
						String txt;
						String line = "";
						while((txt = br.readLine()) != null) {
							line = line + txt + "\n";
						}
						txta.setText(line);
						br.close();
						
					}
					catch(IOException io_e) {
						JOptionPane.showMessageDialog(null, "Error to open file...", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		file_exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				msgQuit();
			}
		});
		super.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				msgQuit();
			}
		});
		edit_find.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Highlighter hl = txta.getHighlighter();
				if (edit_find.isSelected()) {
					try {
						String find_txt = JOptionPane.showInputDialog("Find What? :");
						Matcher matcher = Pattern.compile(find_txt).matcher(txta.getText());
						while (matcher.find()) {
							if (edit_find.isSelected()) {
								hl.addHighlight(matcher.start(), matcher.end(), DefaultHighlighter.DefaultPainter);
								edit_find.setSelected(true);
							}
							else if (!edit_find.isSelected()) {
								hl.removeAllHighlights();
							}
						}
					}
					catch(Exception ex) {
						System.out.println("No Text Find Selected...");
						edit_find.setSelected(false);
						hl.removeAllHighlights();
					}
				}
				else if (!edit_find.isSelected())  {
					hl.removeAllHighlights();
				}
			 }
		});
		file_new.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txta.setText("");
			}
		});
	}
	
	private void msgQuit() {
		int msg_exit = JOptionPane.showConfirmDialog(null, "Are you sure quit this application.", "Mesage", JOptionPane.YES_NO_OPTION);
		if (msg_exit == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
		else if (msg_exit == JOptionPane.NO_OPTION) {
			setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		}
	}
}

	
	
	
	
	
	
	