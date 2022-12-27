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

	public static String greetCountry(String country){
		return switch (country) {
			case "japan" -> "Hello Japan!";
			case "us" -> "Hello America!";
			case "france" -> "Hello France!";
			case "korea" -> "Hello Korea!";
			default -> "Hello World!";
		};
	}

	@GetMapping("/greeting")
	public String greeting(@RequestParam(value="country")String country){
		return greetCountry(country);
	}
}
