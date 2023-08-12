package util;

import java.util.HashSet;
import java.util.Set;

public class Cars {
	private Set<Car> cars;

	public Cars(String[] carArray) {
		cars = new HashSet<>();

		for (int i = 0; i < carArray.length; i++) {
			String name = carArray[i];

			cars.add(new Car(name));
		}

		if(carArray.length != cars.size()) {
			throw new IllegalArgumentException();
		}
	}
}
