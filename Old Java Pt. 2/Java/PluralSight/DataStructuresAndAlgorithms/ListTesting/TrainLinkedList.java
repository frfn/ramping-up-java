package ListTesting;
import DataStructureList.BasicList;

public class TrainLinkedList {

	static BasicList<TrainCar> train = new BasicList<TrainCar>();
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		TrainLinkedList app = new TrainLinkedList();
		app.loadTrain();
		
		long end = System.currentTimeMillis();
		
		System.out.println("Time:" + (end-start));
		
	}
	
	public void loadTrain() {  // works without static
		TrainCar car1 = new TrainCar(CarType.BOXCAR, "Amazon Packages");
		TrainCar car2 = new TrainCar(CarType.TANKER, "Gas");
		TrainCar car3 = new TrainCar(CarType.FLATBED, "Trucks");
		TrainCar car4 = new TrainCar(CarType.BOXCAR, "Apple Packages");
		TrainCar car5 = new TrainCar(CarType.HOPPER, "Basketball Packages");
		TrainCar car6 = new TrainCar(CarType.FLATBED, "Amazon Packages");
		TrainCar car7 = new TrainCar(CarType.HOPPER, "Hopper Packages");
		
		train.add(car1);
		train.add(car2);
		train.add(car3);
		train.add(car4);
		train.add(car5);
		train.add(car6);
		train.add(car7);
		
		System.out.println(train);
	}
	
	public void testTheMethods() {
		
		
		
	}
	
	//Just an enum, type safe
	enum CarType {  
		BOXCAR, TANKER, FLATBED, HOPPER;
	}
	
	private class TrainCar {
		
		private CarType type;
		private String contents;
		
		public TrainCar(CarType type, String contents) {
			this.type = type;
			this.contents = contents;
		}
		
		public String toString() {
			return type.toString() + " - " + contents;
		}
		
	}
	
}
