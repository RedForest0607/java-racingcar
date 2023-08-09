package Constants;

public enum Speed {
	SPEED_MIN (0),
	SPEED_MAX (5);

	private final int value;

	Speed(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
