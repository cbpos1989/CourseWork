/**
 * 
 */
package com.github.cbpos1989.codingChallenge.code_parser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;

/**
 * @author Alex Scanlan, Seamus O'Toole, Colm O'Sullivan, Marie Archbold
 *
 */
public class CodeParserHandler implements ActionListener, Runnable {

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */

	private ArrayList<String> keyWords = new ArrayList<String>();
	private CodeParserGUI cpg;

	public CodeParserHandler(CodeParserGUI cpg) {
		this.cpg = cpg;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				String choice = e.getActionCommand();
//				
//				switch(choice){
//					case "Load File": getFile();
//				
//				}
		
		Thread thread = new Thread(new CodeParserHandler(cpg), "Thread1");
		thread.start();
	}

	void start_old(File file) {
		// TODO Auto-generated method stub
		loadKeywords();

		Scanner scan = null;
		cpg.textPane.setContentType("text/html");
		try {
			scan = new Scanner(file);

			String test = "";

			while (scan.hasNext()) {
				//System.out.println("debug Text: in scanner");
				String[] temp = scan.nextLine().split("\\s+");

				for (int i=0; i<temp.length; ++i){
					//temp[i] = findWord(temp[i], keyWords.get(i)) + "\n";
				}
				//temp = temp + "<br>";
				test += temp;
			}

			cpg.textPane.setText(test);

		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(scan != null) scan.close();
		}
	}

	private void loadKeywords() {
		// TODO Auto-generated method stub
		Scanner scan = null;
		try {
			scan = new Scanner(new File("C:\\Users\\User1\\Desktop\\java.txt"));
			//String test = "";

			while (scan.hasNext()) {
				//System.out.println("debug Text: in scanner");
				//String temp = scan.nextLine();
				//for (int i=0; i<keyWords.length; ++i){
				//	temp = findWord(temp, keyWords[1][i]) + "\n";
				//}
				//temp = temp + "<br>";
				//test += temp;
				keyWords.add(scan.nextLine());
			}

			System.out.println("debug: keyword added");
			//cpg.textPane.setText(test);

		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(scan != null) scan.close();
		}
	}

	//	private String findWord(String line, String key) {
	//		// TODO Auto-generated method stub
	//		StringBuilder sb = new StringBuilder(line);
	//		int offset = 0;
	//		String fontColourText = "<font color = \"red\">";
	//		while (offset < sb.length()){
	//			int keyLocation = sb.indexOf(key, offset);
	//			if (keyLocation == -1) {
	//				break;
	//			} else {
	//				sb.insert(keyLocation, fontColourText);
	//				sb.insert((keyLocation + key.length() + fontColourText.length()) , "</font>");
	//				offset = keyLocation + key.length() + fontColourText.length();
	//			}
	//		}
	//		//System.out.println(sb);
	//		return sb.toString();
	//	}

	//	private String findWord(String line, String key){
	//		StringBuilder sb = new StringBuilder(line);
	//		
	//		if(line.equals(key)){
	//			String fontColourText = "<font color = \"red\">";
	//			sb.insert(0, fontColourText);
	//			sb.insert((line.length() + fontColourText.length()) , "</font>");
	//		}
	//		
	//		return sb.toString();
	//		
	//		
	//	}

	void start(File file) {
		// TODO Auto-generated method stub
		loadKeywords();
		Scanner scan;
		cpg.textPane.setContentType("text/html");
		try {
			scan = new Scanner(file);

			String test = "";
			String fontColourText = "<font color = \"red\">";
			while (scan.hasNext()) {
				String[] strArray = scan.nextLine().split("[^A-Za-z0-9]");

				for (int i=0; i<strArray.length; ++i){
					for (String keyWord: keyWords){
						if (keyWord.equals(strArray[i])){
							strArray[i] = fontColourText + strArray[i] + "</font>";
						}
					}
					test += strArray[i] + " ";
				}
				test += "<br>";
				//				System.out.println("debug Text: in scanner");
				//				String temp = scan.nextLine();
				//				for (int i=0; i<keyWords.length; ++i){
				//					temp = findWord(temp, keyWords[i]) + "\n";
				//				}
				//				temp = temp + "<br>";
				//				test += temp;
			}

			cpg.textPane.setText(test);

		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void start_old2(File file){
		loadKeywords();
		Scanner scan;
		cpg.textPane.setContentType("text/html");
		try {
			scan = new Scanner(file);

			String test = "";
			String fontColourText = "<font color = \"red\">";
			while (scan.hasNext()) {

				String s = scan.nextLine();
				String word = "";
				
				int temp = 0;
				
				for(int i = 0; i < keyWords.size(); ++i){
					if(s.indexOf(keyWords.get(i)) != -1){
						if(s.indexOf(keyWords.get(i)) - 1 > 0 && s.indexOf(keyWords.get(i)) + 1 < s.length()){
							if(!Character.isAlphabetic(s.indexOf(keyWords.get(i)) - 1) && !Character.isAlphabetic(s.indexOf(keyWords.get(i)) + 1)){
								if(!Character.isDigit(s.indexOf(keyWords.get(i)) - 1) && !Character.isDigit(s.indexOf(keyWords.get(i)) + 1)){
									word = fontColourText + s.substring(s.indexOf(keyWords.get(i)), s.indexOf(keyWords.get(i)) + keyWords.get(i).length()) + "</font>";
									i = s.indexOf(keyWords.get(i)) + 1;
									s = s.replace(keyWords.get(i), word);
								}
							}
						}
					}
				}
				test += s + "<br>";
			}

			cpg.textPane.setText(test);

		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showOpenDialog(cpg.btnLoadFile);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			this.start(file);
		}
	}
}