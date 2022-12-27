package sample.helloworld.rttask6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RtTask6Application {

	public static void main(String[] args) {
		SpringApplication.run(RtTask6Application.class, args);
	}

	@GetMapping("/")
	public String hello(){
		return "Hello World!";
	}

	@GetMapping("/greeting")
	public String greeting(@RequestParam(value="country", defaultValue = "World")String country){

		String greet = country;

		if(country.equals("japan")){
			greet = "Japan";
		} else if(country.equals("us")) {
			greet = "America";
		} else if (country.equals("france")) {
			greet = "France";
		} else if (country.equals("korea")) {
			greet = "Korea";
		}

		return String.format("Hello %s!",greet);
	}

}
