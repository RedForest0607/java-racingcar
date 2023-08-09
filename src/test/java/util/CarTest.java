package util;

import static org.assertj.core.api.Assertions.*;
import static util.Car.*;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import Constants.Speed;

public class CarTest {

	@Test
	@DisplayName("참여자를 쉼표를 기준으로 구분")
	void 참여자_구분() {
		Car car = new Car();

		String[] result = car.split("1,2,3");

		assertThat(
			result.length
		).isEqualTo(3);
	}

	@ParameterizedTest
	@ValueSource(strings = {"박재성1234", "123456"})
	@DisplayName("자동차 이름은 5자를 초과하면 실패한다.")
	void 자동차_이름은_5자를_초과하면_실패(String name) {
		assertThatThrownBy(() -> createCars(name))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("자동차 이름이 없을 경우 실패한다.")
	void 자동차_이름은_최소_1글자_이상() {
		assertThatThrownBy(() -> createCars(""))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("자동차를 생성시, 이름과 숫자가 여러개인 경우는 파싱해서 여러개를 생성해야 한다")
	void 자동차_여러개_생성() {
		ArrayList<Car> result = createCars("car1,car2,car3");

		assertThat(result.size()).isEqualTo(3);
	}

	@Test
	@DisplayName("자동차를 여러개 생성시, 입력값의 안맞는다면 오류가 발생한다")
	void 자동차_여러개_생성시_안맞음() {
		assertThatThrownBy(() -> createCars(",car2,car3"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("자동차를 가속 시키면 최소값과 최대값 사이의 외의 값이 들어오면 예외를 던진다.")
	void 자동차를_가속시킬때_최대값과_최솟값_사이_외의_값이_들어오면_예외를_던진다() {
		Car testCar = new Car("test");
		assertThatThrownBy(() -> testCar.accelerate(Speed.SPEED_MAX.getValue() + 1))
			.isInstanceOf(Exception.class);
		assertThatThrownBy(() -> testCar.accelerate(Speed.SPEED_MIN.getValue() - 1))
			.isInstanceOf(Exception.class);
	}

	@Test
	@DisplayName("자동차를 가속 시키면 최소값과 최대값 사이의 값이 랜덤하게 적용되어 가속한다.")
	void 자동차를_가속시킬때_최대값과_최솟값_사이_값이_들어오면_정상적으로_position_값이_바뀐다() throws Exception {
		int testValue = 3;
		Car testCar = new Car("test");
		testCar.accelerate(testValue);
		assertThat(testCar.getPosition()).isEqualTo(testValue);
	}
}
