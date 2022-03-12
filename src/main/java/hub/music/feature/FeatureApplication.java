package hub.music.feature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class FeatureApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeatureApplication.class, args);
	}
}
