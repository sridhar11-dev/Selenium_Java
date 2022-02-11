package week3.day1;

public class Audi extends Car{
	public void autoPark() {
		System.out.println("AutoPark - Audi");
	}
	
	public void applyBrake() {
		System.out.println("Apply ABS brake");
	}
	
	public static void getVehicleType() {
		System.out.println("Two wheeler");
	}
	
	//Create a final method in the Car classand try overriding in Audi-Cannot override the final method from Car
	public final void gearType() {
		
	}

}
