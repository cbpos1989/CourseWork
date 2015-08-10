/**
 * 
 */
package com.github.cbpos1989.gui_tutorials;

import javax.swing.JApplet;

/**
 * @author Colm O'Sullivan
 *
 */
public class HelloWorldApplet extends JApplet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;
	private String fontName;
	private int fontSize;
	
	public void init(){
		String value;
		
		
		
		HelloWorldPanel content = new HelloWorldPanel();
		setContentPane(content);
	
	}
}
