package util;

import static constants.Speed.*;

import java.util.Random;

public class CarUtils {

	public boolean checkCarName(String name) {
		return name.length() >= 1 && name.length() <= 5;
	}

	public String[] split(String s) {
		return s.split(",");
	}

	public boolean isValidSpeed(int speed) {
		return speed > SPEED_MIN.getValue() && speed < SPEED_MAX.getValue();
	}

	public Integer randomIntGeneratorInBound() {
		Random random = new Random();
		return random.ints(SPEED_MIN.getValue(), SPEED_MAX.getValue())
			.findFirst()
			.getAsInt();
	}
}
