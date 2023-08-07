package util;

import static util.Car.*;

import java.util.ArrayList;

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
		Assertions.assertThatThrownBy(() -> createCar(name, "5"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("자동차 이름이 없을 경우 실패한다.")
	void 자동차_이름은_최소_1글자_이상() {
		Assertions.assertThatThrownBy(() -> createCar("", "4"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("자동차의 속도가 음수인 경우 오류가 발생한다.")
	void 자동차_속도는_자연수() {
		// 다음과 같은 생성시의 이름과 속도에 대한 값들을 따로 변수로 빼 두는 것이 좋을까?
		Assertions.assertThatThrownBy(() -> createCar("car", "-1"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("자동차를 생성시, 이름과 숫자가 여러개인 경우는 파싱해서 여러개를 생성해야 한다")
	void 자동차_여러개_생성() {
		ArrayList<Car> result = createCar("car1,car2,car3", "1,2,3");

		Assertions.assertThat(result.size()).isEqualTo(3);
	}

	@Test
	@DisplayName("자동차를 여러개 생성시, 입력값의 짝이 안맞는다면 오류가 발생한다")
	void 자동차_여러개_생성시_짝이_안맞음() {
		Assertions.assertThatThrownBy(() -> createCar("car1,car2,car3", "1,2"))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
