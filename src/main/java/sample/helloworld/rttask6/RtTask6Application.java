package sample.helloworld.rttask6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
@RestController
public class RtTask6Application {

	public static void main(String[] args) {
		SpringApplication.run(RtTask6Application.class, args);
	}

	@GetMapping("/")
	public String hello(){
		return "Hello World !";
	}

	@GetMapping("/time")
	public String showCurrentTime(){
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter jptime = DateTimeFormatter.ofPattern("yyyy 年 MM 月 dd 日 hh 時 mm 分");
		return "現在は" + now.format(jptime) + "です";
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
