/**
 * 
 */
package com.github.cbpos1989.examples.callbacks;

import javax.swing.JOptionPane;

/**
 * @author Colm O'Sullivan
 *
 */
public class FragmentAExample {
	
	private CallbackListener mListener;
	
	public FragmentAExample(){}
	
	/**
	 * Factory Method for creating instances of our Fragment.
	 * This method will define the state required to create a fragment.
	 * @param listener
	 * @return FragmentAExample
	 */
	public static FragmentAExample newInstance(CallbackListener listener){
		FragmentAExample fae = new FragmentAExample();
		fae.mListener = listener;
		return fae;
	}
	
	public void retrieveInformation(){
		//Get user input
		String username = JOptionPane.showInputDialog("Hello, please enter your username: ");
		String password = JOptionPane.showInputDialog("Hello " + username + " please enter your password");
		
		//Send user information to the callback method in the activity that implements the CallbackListener Interface
		mListener.checkUserPassword(username, password);
	}
}
