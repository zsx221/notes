package SpringTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@MapperScan("com.energy")
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class OpenApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenApiApplication.class, args);
    }

}
