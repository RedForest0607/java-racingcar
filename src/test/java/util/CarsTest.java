package util;

import static org.assertj.core.api.Assertions.*;

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

	}
}
