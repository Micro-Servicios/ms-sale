package arquitectura.software.mssale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsSaleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsSaleApplication.class, args);
	}

}
