package util;

import static Constants.Speed.*;

import java.util.ArrayList;
import java.util.Random;

public class Car {

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

	public String[] split(String s) {
		return s.split(",");
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

	public void accelerate(int speed) throws Exception{
		if (carUtils.isValidSpeed(speed)) {
			this.position += speed;
		} else {
			throw new Exception();
		}
	}

	public void accelerate() {
		this.position += carUtils.randomIntGeneratorInBound();
	}

	public Integer getPosition() {
		return position;
	}
}