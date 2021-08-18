package wecancatchit.werehooked;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import wecancatchit.werehooked.Storage.StorageProperties;
import wecancatchit.werehooked.Storage.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class WerehookedApplication {

	public static void main(String[] args) {
		SpringApplication.run(WerehookedApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			// storageService.deleteAll();
			storageService.init();
		};
	}
}
