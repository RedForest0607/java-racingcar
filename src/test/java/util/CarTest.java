package util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
	@Test
	@DisplayName("참여자를 쉼표를 기준으로 구분")
	void 참여자_구분() {
		Car car = new Car();

		String[] result = car.split("1,2,3");

		Assertions.assertThat(
			result.length
		).isEqualTo(3);
	}

	@ParameterizedTest
	@ValueSource(strings = {"박재성1234", "123456"})
	@DisplayName("자동차 이름은 5자를 초과하면 실패한다.")
	void 자동차_이름은_5자를_초과하면_실패(String name) {
		Assertions.assertThatThrownBy(() -> new Car(name))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("자동차 이름이 없을 경우 실패한다.")
	void 자동차_이름은_최소_1글자_이상() {
		Assertions.assertThatThrownBy(() -> new Car(""))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
