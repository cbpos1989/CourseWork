package com.github.cbpos1989.codingChallenge.code_parser;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private String[] keyWords = {"class", "continue", "double", "do", "int"};
	private JTextPane textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		textPane = new JTextPane();
		contentPane.add(textPane, BorderLayout.CENTER);
		
		

		start();
	}

	private void start() {
		// TODO Auto-generated method stub
		Scanner scan;
		textPane.setContentType("text/html");
		try {
			scan = new Scanner(new File("C:/Users/User1/git/CourseWork/CourseWork/src/com/github/cbpos1989/codingChallenge/code_parser/test.txt"));

			String test = "";
			String fontColourText = "<font color = \"red\">";
			while (scan.hasNext()) {
				String[] strArray = scan.nextLine().split(" ");
				for (int i=0; i<strArray.length; ++i){
					for (String keyWord: keyWords){
						if (keyWord.equals(strArray[i])){
							strArray[i] = fontColourText + strArray[i] + "</font>";
						}
					}
					test += strArray[i] + " ";
				}
				test += "<br>";
				System.out.println("debug Text: in scanner");
//				String temp = scan.nextLine();
//				for (int i=0; i<keyWords.length; ++i){
//					temp = findWord(temp, keyWords[i]) + "\n";
//				}
//				temp = temp + "<br>";
//				test += temp;
			}

			textPane.setText(test);
			
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String findWord(String line, String key) {
		// TODO Auto-generated method stub

		StringBuilder sb = new StringBuilder(line);
		int offset = 0;
		String fontColourText = "<font color = \"red\">";
		while (offset < sb.length()){
			int keyLocation = sb.indexOf(key, offset);
			if (keyLocation == -1) {
				break;
			} else {
				sb.insert(keyLocation, fontColourText);
				sb.insert((keyLocation + key.length() + fontColourText.length()) , "</font>");
				offset = keyLocation + key.length() + fontColourText.length();
			}
		}
		System.out.println(sb);
		return sb.toString();
	}
}
