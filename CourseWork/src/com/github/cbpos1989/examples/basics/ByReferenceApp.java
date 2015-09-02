/**
 * 
 */
package com.github.cbpos1989.examples.basics;

/**
 * App to demonstrate that Objects Pass by Reference
 * 
 * @author Colm O'Sullivan
 *
 */
public class ByReferenceApp {

	
	public static void main(String[] args) {
		ByReferenceApp ra = new ByReferenceApp();
		CarClass myCar = new CarClass();
		System.out.println("Car model is: " + myCar.getModel());
		ra.changeCar(myCar);
		System.out.println("Car model is: " + myCar.getModel());
	}

	private void changeCar(CarClass car){
		car.setModel("veyron");
	}
}

class CarClass {
	private String model = "ka";

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
}
