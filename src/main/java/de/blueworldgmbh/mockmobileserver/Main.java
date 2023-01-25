package de.blueworldgmbh.mockmobileserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@RestController
@RequestMapping("/events")
public class Main {

    private static String sSsid = null;
    private static String sKey = null;
    private static String sDeviceImei = null;
    private static String sApiToken = null;

    private final DateFormat format;

    public Main()
    {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"); // Quoted "Z" to indicate UTC, no timezone offset
        format.setTimeZone(tz);
    }

    public static void main(String [] args) {
        //sSsid = args[0];
        //sKey = args[1];
        //sDeviceImei = args[2];
        //sApiToken = args[3];
        SpringApplication app = new SpringApplication(Main.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "8001"));
        app.run(args);
    }

    @GetMapping
    public List<String> eventsGet()
    {
        System.out.println("[" + format.format(new Date()) + "] Received get request");
        return Collections.emptyList();
    }

    @PostMapping
    public void eventsPost(@RequestBody String data)
    {
        System.out.println("[" + format.format(new Date()) + "] Received post request with payload=" + data);
    }
}