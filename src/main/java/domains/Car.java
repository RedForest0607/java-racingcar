package domains;

import util.CarUtils;

import java.util.ArrayList;
import java.util.Objects;

public class Car {
	private static final int BOUNDARY = 4;

	public String name;
	private Integer position;

	public Car(String name) {
		if(name.length() < 1 || name.length() > 5) {
			throw new IllegalArgumentException();
		}

		this.position = 0;
		this.name = name;
	}

	public Car(String name, int position) {
		this.name = name;
		this.position = position;
	}

	public static ArrayList<Car> createCars(String name) {

		String[] names = name.split(",");


		ArrayList<Car> result = new ArrayList<>();

		for (int i = 0; i < names.length; i++) {
			try {
				result.add(new Car(names[i]));
			} catch (IllegalArgumentException e) {
				throw new IllegalArgumentException();
			}
		}
		return result;
	}

	public void accelerate(int speed) {
		if (speed >= BOUNDARY) {
			this.position++;
		}
	}

	public Integer getPosition() {
		return position;
	}

	public int compare(Car comparedCar) {
		int result = 0;
		result = this.position > comparedCar.position ? 1 : -1;
		return result;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Car car = (Car)o;
		return Objects.equals(name, car.name) && Objects.equals(position, car.position);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, position);
	}
}