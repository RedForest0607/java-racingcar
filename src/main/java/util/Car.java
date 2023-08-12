package util;

import static Constants.Speed.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Car {
	private static final int BOUNDARY = 4;

	private String name;
	private Integer position;
	private CarUtils carUtils;

	public Car() {
		name = "";
	}

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
		comparedCar.position
		return -10;
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