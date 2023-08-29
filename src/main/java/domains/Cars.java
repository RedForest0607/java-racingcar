package domains;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
	private Set<Car> cars;

	public Cars(String[] carArray) {
		cars = new HashSet<>();

		for (String name : carArray) {
			cars.add(new Car(name));
		}

		if(carArray.length != cars.size()) {
			throw new IllegalArgumentException();
		}
	}

	public Cars(Set<Car> cars) {
		this.cars = cars;
	}

	public List<Car> getWinner() {
		ArrayList<Car> winners = new ArrayList<>();

		for (Car eachCar : this.cars) {
			if (winners.isEmpty() || eachCar.compare(winners.get(0)) == 1) {
				winners.clear();
				winners.add(eachCar);
			} else if (eachCar.compare(winners.get(0)) == 0) {
				winners.add(eachCar);
			}
		}

		return winners;
	}
}
