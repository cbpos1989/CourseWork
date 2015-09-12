package com.github.cbpos1989.examples.basics;

/**
 * Class to demonstrate the use of labelled statements.
 * 
 * @author Colm O'Sullivan
 *
 */

public class Labels{


	public static void main(String[] args){
		Labels lb = new Labels();
		lb.labeledLoop();
	}


	void labeledLoop(){
  		int i = 0;
  	
		OUTER: while (i < 8){
    			MIDDLE: ;
    			if (i > 3){
				break OUTER;
			} else  {
				INNER: System.out.println(i);
				i++; 
			}
	  	}
	}
}