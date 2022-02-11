package week3.day1;

public class MyVehicle {
	final int price = 500000;
	public static void main(String[] args) {
		MyVehicle finalValueVerify = new MyVehicle();
		//Create a final variable and reassign with some values-The final field MyVehicle.price cannot be assigned
		finalValueVerify.price = 100000;
		
		Vehicle vehicle = new Vehicle();
		Car car = new Car();
		Audi audi = new Audi();
		audi.applyBrake();
		audi.soundHorn();
		audi.openDoor();
		audi.autoPark();
		//Create a static method in Car and try to override that method in Audi class
		audi.getVehicleType();
		
		car.applyBrake();
		car.soundHorn();
		car.openDoor();
		
		vehicle.applyBrake();
		vehicle.soundHorn();
	}

}
