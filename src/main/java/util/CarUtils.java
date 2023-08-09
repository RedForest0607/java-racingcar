package util;

import static Constants.Speed.*;

import java.util.Random;

public class CarUtils {

	public boolean checkCarName(String name) {
		return name.length() >= 1 && name.length() <= 5;
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
