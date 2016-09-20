import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@EnableAutoConfiguration
@ImportResource({"classpath:web-context.xml"})
public class ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ApplicationRunner.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.setWebEnvironment(true);
        app.run(args);
    }

}
