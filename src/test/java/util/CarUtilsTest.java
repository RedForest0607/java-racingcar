package util;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarUtilsTest {

	private final CarUtils carUtils = new CarUtils();

	@Test
	@DisplayName("이름 확인 성공")
	void 이름_검증() {
		boolean result = carUtils.checkCarName("hello");
		assertThat(result).isTrue();
	}

	@Test
	@DisplayName("이름 확인 실패")
	void 이름_검증_실패() {

		assertThat(carUtils.checkCarName("")).isFalse();
		assertThat(carUtils.checkCarName("helloWorldEveryOne")).isFalse();
	}
}