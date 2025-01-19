package ch.gdevxy.jlb;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	@PostMapping("/persons")
	@ResponseStatus(HttpStatus.CREATED)
	public Person save(@RequestBody Person person) {

		// delegate creation

		System.out.printf("Saved person [%s]%n", person);

		return person;
	}

	@Getter
	@Builder
	@Jacksonized
	@ToString
	public static class Person {

		@Builder.Default
		private final Gender gender = Gender.U;
		private final String name;
		private final LocalDate birthDate;

		enum Gender {
			M,
			F,
			U
		}

	}

}
