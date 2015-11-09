/**
 * 
 */
package com.github.cbpos1989.examples.callbacks;

import javax.swing.JOptionPane;

/**
 * @author User1
 *
 */
public class ActivityAExample implements CallbackListener {

	private String[][] users = {{"cbpos1989","admin1234"},{"kill3r420","blazeit"}}; 
	
	//Simulate onCreate in Android
	public ActivityAExample(){
		System.out.println("Hello there, this demo will show callbacks in a simple form");
		
		FragmentAExample fae = FragmentAExample.newInstance(this);
		fae.retrieveInformation();
		System.out.println("Callback Completed");
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ActivityAExample();
	}
	
	
	/* (non-Javadoc)
	 * @see com.github.cbpos1989.examples.callbacks.CallbackListener#checkUserPassword(java.lang.String)
	 */
	@Override
	public void checkUserPassword(String username, String password){
		for(int i = 0; i < users.length; ++i){
			if(users[i][0].equals(username)){
					if(users[i][1].equals(password)){
						JOptionPane.showMessageDialog(null, "Welcome to the program " + username);
						return;	
					} else {
						JOptionPane.showMessageDialog(null, "Incorrect password");
						return;
					}
			} else {
				JOptionPane.showMessageDialog(null, username + " is not a valid username");
				return;
			}
		}
	}

}
