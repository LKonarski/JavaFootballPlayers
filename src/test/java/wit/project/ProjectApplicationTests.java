package wit.project;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//@SpringBootTest
class ProjectApplicationTests {

	@Test
	void itShouldAddTwoNumbers() {
		//given
		int numberOne = 20;
		int numberTwo = 30;

		//when
		int result = underTest.add(numberOne, numberTwo);

		//then
		int expected = 50;
		assertThat(result).isEqualTo(expected);
	}

	Calculator underTest = new Calculator();

	class Calculator {
		int add(int a, int b) {
			return a + b;
		}
	}

}
