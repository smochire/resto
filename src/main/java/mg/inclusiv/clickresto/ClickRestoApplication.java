package mg.inclusiv.clickresto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages ={ "mg.inclusiv.clickresto.controller","mg.inclusiv.clickresto.services"})
public class ClickRestoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClickRestoApplication.class, args);
	}

}
