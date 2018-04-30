package afc;

import org.afc.util.ClasspathUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebServer implements CommandLineRunner {

	@Override
	public void run(String... arg0) throws Exception {
	}

	public static void main(String[] args) throws Exception {
		ClasspathUtil.addSystemClasspath("target/javascript");
		SpringApplication.run(WebServer.class, args);
	}
}
