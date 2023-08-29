package util;

import static org.assertj.core.api.Assertions.*;
import static domains.Car.*;

import java.util.ArrayList;

import domains.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

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

	// @Test
	// @DisplayName("자동차를 가속 시키면 최소값과 최대값 사이의 외의 값이 들어오면 예외를 던진다.")
	// void 자동차를_가속시킬때_최대값과_최솟값_사이_외의_값이_들어오면_예외를_던진다() {
	// 	Car testCar = new Car("test");
	// 	assertThatThrownBy(() -> testCar.accelerate(Speed.SPEED_MAX.getValue() + 1))
	// 		.isInstanceOf(Exception.class);
	// 	assertThatThrownBy(() -> testCar.accelerate(Speed.SPEED_MIN.getValue() - 1))
	// 		.isInstanceOf(Exception.class);
	// }
	//
	// @Test
	// @DisplayName("자동차를 가속 시키면 최소값과 최대값 사이의 값이 랜덤하게 적용되어 가속한다.")
	// void 자동차를_가속시킬때_최대값과_최솟값_사이_값이_들어오면_정상적으로_position_값이_바뀐다() throws Exception {
	// 	int testValue = 3;
	// 	Car testCar = new Car("test");
	// 	testCar.accelerate(testValue);
	// 	assertThat(testCar.getPosition()).isEqualTo(testValue);
	// }

	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2})
	@DisplayName("자동차_속도가_3이하_정지")
	void 자동차_속도가_3이하_정지(int speed) {

		Car car = new Car("test");

		car.accelerate(speed);

		assertThat(car.getPosition()).isEqualTo(0);
	}

	@ParameterizedTest
	@ValueSource(ints = {5, 4, 9})
	@DisplayName("자동차_속도가_4이상_전진")
	void 자동차_속도가_4이상_전진(int speed) {

		Car car = new Car("test");
		car.accelerate(speed);

		assertThat(car.getPosition()).isEqualTo(1);
	}

	@Test
	@DisplayName("두 자동차의 위치를 비교하는 메서드 : 내가 빠른 경우 1, 같은경우 0, 비교하는 차가 빠른경우 -1")
	void 두대의_위치를_서로_비교하여_정수형의_값을_반환한다() {

		Car car1 = new Car("test1", 4);
		Car car2 = new Car("test2", 5);
		Car car3 = new Car("test3", 3);

		Assertions.assertAll(
			() -> assertThat(car1.compare(car2)).isEqualTo(-1),
			() -> assertThat(car1.compare(car3)).isEqualTo(1)
		);
	}
}
