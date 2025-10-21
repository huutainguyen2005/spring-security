package vn.edu.fpt.musicstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import vn.edu.fpt.musicstore.entities.Artist;
import vn.edu.fpt.musicstore.services.ArtistService;

import java.util.List;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
