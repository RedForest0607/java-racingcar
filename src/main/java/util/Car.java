package util;

public class Car {
	private String name;

	public Car() {
		name = "";
	}

	public Car(String name) {
		if(name.length() < 1 || name.length() > 5) {
			throw new IllegalArgumentException();
		}

		this.name = name;
	}

	public String[] split(String s) {
		return s.split(",");
	}
}
