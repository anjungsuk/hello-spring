package Hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {

		SpringApplication.run(HelloSpringApplication.class, args); //메인메소드 실행시 HelloSpringApplication이 실행된다.
	}

}
