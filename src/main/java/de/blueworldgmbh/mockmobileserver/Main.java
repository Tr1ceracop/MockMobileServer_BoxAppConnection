package de.blueworldgmbh.mockmobileserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@RestController
@RequestMapping("/events")
public class Main {

    public static void main(String [] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping
    public List<String> eventsGet()
    {
        System.out.println("Received get request");
        return Collections.emptyList();
    }

    @PostMapping
    public void eventsPost(@RequestBody String data)
    {
        System.out.println("Received post request with payload=" + data);
    }
}