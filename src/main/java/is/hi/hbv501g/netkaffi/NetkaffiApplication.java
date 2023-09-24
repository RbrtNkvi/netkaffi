package is.hi.hbv501g.netkaffi;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.annotation.Id;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class NetkaffiApplication {
//ég er að hjálpa...
    public static void main(String[] args) {
        SpringApplication.run(NetkaffiApplication.class, args);
    }

}

