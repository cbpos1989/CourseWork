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

	@SuppressWarnings("unused")
	private String message;
	@SuppressWarnings("unused")
	private String fontName;
	@SuppressWarnings("unused")
	private int fontSize;
	
	public void init(){
		String value;
		value = getParameter("message");
		
		if (value == null){
			message = "Hello World!";
		} else {
			message = value;
		} 
		
		value = getParameter("font");
		
		if(value == null){
			fontName = "SansSerif";
		} else {
			fontName = value;
		}
		
		value = getParameter("size");
		try{
			
		} catch (NumberFormatException e) {
			fontSize = 20;
		}
		
		HelloWorldPanel content = new HelloWorldPanel();
		setContentPane(content);
	
	}
}
