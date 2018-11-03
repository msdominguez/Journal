/**
 * jou.java - journal; saves user input to text file
 *
 * Maria Dominguez
 * September 2018
 **/

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.MatteBorder;

public class jou {

	private JFrame frmJou;
	private JTextField textFieldTitle;
	private JTextField textFieldSong;
	private JTextField textFieldTime;
	private JTextField textFieldDate;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jou window = new jou();
					window.frmJou.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public jou() {
		initialize();
	}

	private void initialize() {
		frmJou = new JFrame();
		frmJou.setTitle("jou\u2606");
		frmJou.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmJou.getContentPane().setBackground(Color.DARK_GRAY);
		frmJou.setBackground(Color.PINK);
		frmJou.setBounds(100, 100, 450, 300);
		frmJou.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJou.getContentPane().setLayout(null);
		
		JLabel lblDate = new JLabel("date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDate.setForeground(Color.PINK);
		lblDate.setBounds(175, 21, 28, 14);
		frmJou.getContentPane().add(lblDate);
		
		JLabel lblTime = new JLabel("time");
		lblTime.setForeground(Color.PINK);
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTime.setBounds(10, 21, 28, 14);
		frmJou.getContentPane().add(lblTime);
		
		textFieldTime = new JTextField();
		textFieldTime.setBackground(Color.PINK);
		textFieldTime.setBounds(38, 15, 127, 20);
		frmJou.getContentPane().add(textFieldTime);
		textFieldTime.setColumns(10);
		
		textFieldDate = new JTextField();
		textFieldDate.setBackground(Color.PINK);
		textFieldDate.setBounds(202, 15, 123, 20);
		frmJou.getContentPane().add(textFieldDate);
		textFieldDate.setColumns(10);
		
		textFieldTitle = new JTextField();
		textFieldTitle.setBackground(Color.PINK);
		textFieldTitle.setBounds(38, 46, 127, 20);
		frmJou.getContentPane().add(textFieldTitle);
		textFieldTitle.setColumns(10);
		
		JLabel lblTitle = new JLabel("title");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTitle.setForeground(Color.PINK);
		lblTitle.setBackground(Color.BLACK);
		lblTitle.setBounds(10, 49, 28, 14);
		frmJou.getContentPane().add(lblTitle);
		
		textFieldSong = new JTextField();
		textFieldSong.setBackground(Color.PINK);
		textFieldSong.setBounds(202, 46, 123, 20);
		frmJou.getContentPane().add(textFieldSong);
		textFieldSong.setColumns(10);
		
		JLabel lblSong = new JLabel("song");
		lblSong.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSong.setForeground(Color.PINK);
		lblSong.setBounds(175, 49, 28, 14);
		frmJou.getContentPane().add(lblSong);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(255, 228, 225)));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 77, 414, 173);
		frmJou.getContentPane().add(scrollPane);
		scrollPane.getVerticalScrollBar().setBackground(Color.PINK);
		scrollPane.getHorizontalScrollBar().setBackground(Color.PINK);
		
		JTextArea textAreaEntry = new JTextArea();
		scrollPane.setViewportView(textAreaEntry);
		textAreaEntry.setToolTipText("");
		textAreaEntry.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		textAreaEntry.setBackground(Color.PINK);

		JButton btnSave = new JButton("save");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSave.setForeground(Color.DARK_GRAY);
		btnSave.setBackground(Color.PINK);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title, entry, song, date, time;				
				Entry entry_obj = new Entry();
				
				title = textFieldTitle.getText();
				song = textFieldSong.getText();
				entry = textAreaEntry.getText();
					
				entry_obj.setTitle(title);
				entry_obj.setSong(song);
				entry_obj.setEntry(entry);
					
				// date and time are set upon object creation
				// but if they are manually set, take text
				if (!(textFieldDate.getText().isEmpty() && textFieldTime.getText().isEmpty())) {
					date = textFieldDate.getText();
					time = textFieldTime.getText();
						
					entry_obj.setDate(date);
					entry_obj.setTime(time);
					entry_obj.setDateTime();
				}
				
				entry_obj.writeTxt2(textAreaEntry);
			}
		});
		btnSave.setBounds(335, 15, 89, 51);
		frmJou.getContentPane().add(btnSave);
		
	}
}
