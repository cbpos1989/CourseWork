package com.github.cbpos1989.examples.conditional;
/**
 * App to demonstrate the valid and invalid use of the break keyword
 * 
 * @author Colm O'Sullivan
 *
 */
class BreakTest{   
	public static void main(String args[]){      
 		int k = 9, s = 5;       
		
		switch(k){         
 		default :        
 			if ( k == 10) { 
				s = s*2;
			}else {           
  				s = s+4;            
 				break;         
 			}        
  		case 7 : 
			s = s+3;     
		}       
		
		
		if(s < 10){
			System.out.println(s);
		} else {
			System.out.println("Over Ten");
			//Can't be used outside switch or loop
			//break;
		}  
 	} 
}
