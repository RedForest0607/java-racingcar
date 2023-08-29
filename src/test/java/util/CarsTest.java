package util;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import domains.Car;
import domains.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
	@Test
	@DisplayName("자동차 검증: 중복 이름 허용X")
	void 중복된_자동차명이_있을_경우_예외_발생() {
		String carNames = "철수,영수,미영,철수";

		String[] carArray = carNames.split(",");

		assertThatThrownBy(
			() -> new Cars(carArray)
		).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("우승자 검증")
	void 누가_우승했는지_확인헀나() {

		//테스트를 위한 차 목록은 어떤식으로 만들 것 인가.
		Car car1 = new Car("test1", 4);
		Car car2 = new Car("test2", 5);
		Car car3 = new Car("test3", 3);
		Set carSet = new HashSet<Car>(){{
			add(car1);
			add(car2);
			add(car3);
		}};
		Cars cars = new Cars(carSet);

		assertThat(cars.getWinner()).contains(car2);
	}
}
