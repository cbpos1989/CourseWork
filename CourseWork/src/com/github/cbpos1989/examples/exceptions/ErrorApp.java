/**
 * 
 */
package com.github.cbpos1989.examples.exceptions;

public class ErrorApp{
	
	BouncingBall[][][][][][][] balls = new BouncingBall[10][10][10][10][10][10][10];

	public static void main(String[] arg){
		ErrorApp ea = new ErrorApp();
		ea.startProgram();
	}

	private void startProgram(){
		//System.out.println("ErrorApp working");
		infiniteLoop();
	}

	private void infiniteLoop(){
		while(true){
			System.out.println("When will this loop ever end");
			for(int i =0; i < balls.length; ++i){
				for(int j = 0; j < balls[i].length; ++j){
					for(int k = 0; k < balls[i][j].length; ++k){
						for(int l = 0;l < balls[i][j][k].length; ++l){
							for(int m = 0; m < balls[i][j][k][l].length; ++m){
								for(int n = 0; n < balls[i][j][k][l][m].length; ++n){
									for(int o = 0;o < balls[i][j][k][l][m][n].length;++o){
										balls[i][j][k][l][m][n][o] = new BouncingBall(5);
									}
								}
							}
						}
					}
				}
			}
			//startProgram();
		}
	}

}

class BouncingBall{

		private double volume;

		public BouncingBall(){
			this(0);
		}

		public BouncingBall(int radius){
			this.volume =  (double)4.19 * Math.pow(radius, 3);
		}
}