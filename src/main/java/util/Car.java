package util;

import static java.lang.Integer.*;

import java.util.ArrayList;

public class Car {
	private String name;
	private int speed;

	public Car() {
		name = "";
	}

	public Car(String name, int speed) {
		if(name.length() < 1 || name.length() > 5 || speed < 0) {
			throw new IllegalArgumentException();
		}

		this.name = name;
		this.speed = speed;
	}

	public String[] split(String s) {
		return s.split(",");
	}

	public static ArrayList<Car> createCar(String name, String speed) {

		String[] names = name.split(",");
		String[] speedList = speed.split(",");

		if (names.length != speedList.length) {
			throw new IllegalArgumentException();
		}

		ArrayList<Integer> integerSpeedList = new ArrayList<>();
		for (int i = 0; i < speedList.length; i++) {
			try {
				integerSpeedList.add(Integer.parseInt(speedList[i]));
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException();
			}
		}

		ArrayList<Car> result = new ArrayList<>();

		for (int i = 0; i < names.length; i++) {
			try {
				result.add(new Car(names[i], integerSpeedList.get(i)));
			} catch (IllegalArgumentException e) {
				throw new IllegalArgumentException();
			}
		}
		return result;
	}
}