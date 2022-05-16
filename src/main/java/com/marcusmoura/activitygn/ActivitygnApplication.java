package com.marcusmoura.activitygn;

import com.marcusmoura.activitygn.entities.Metrics;
import com.marcusmoura.activitygn.entities.Sensor;
import com.marcusmoura.activitygn.repositories.MetricsRepository;
import com.marcusmoura.activitygn.repositories.SensorRepository;
import com.marcusmoura.activitygn.services.MetricsService;
import com.marcusmoura.activitygn.services.SensorService;
import com.marcusmoura.activitygn.services.exceptions.HttpServerErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class ActivitygnApplication implements CommandLineRunner{

    @Autowired
    private MetricsService metricsService;

    @Autowired
    private SensorService sensorService;
    private Scanner sc = new Scanner(System.in);


    private RestTemplate restTemplate = new RestTemplate();


    public static void main(String[] args) {
        SpringApplication.run(ActivitygnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        firstMenu:
        while (true) {
            System.out.println("Menu options:\n" +
                    "1: Insert new Sensor\n" +
                    "2: Update Data\n" +
                    "3: Get current temperature by sensor\n" +
                    "4: Get current humidity by sensor\n" +
                    "5: Get current wind speed by sensor\n" +
                    "6: Get average temperature of the week\n" +
                    "0: EXIT the program\n");
            int choiceFirstMenu = sc.nextInt();
            switch (choiceFirstMenu) {
                case 1:

                    Sensor s = new Sensor();
                    System.out.println("Country: ");
                    s.setCountry(sc.next());
                    System.out.println("City: ");
                    s.setCity(sc.next());
                    System.out.println("Enter URL for connections: ");
                    s.setUrl(sc.next());
                    System.out.println("SENSOR ADDED TO THE SYSTEM!!!");
                    sensorService.insert(s);
                    continue firstMenu;

                case 2:
                    System.out.println("Updating sensors");
                    System.out.println("Getting all elements");

                    List<Sensor> sensors = sensorService.findAll();


                    sensors.forEach(se -> {

                        Sensor param = restTemplate.getForObject(
                                (se.getUrl()), Sensor.class);
                        if (!Objects.equals(se.getHumidity(), param.getHumidity()) ||
                                !Objects.equals(se.getTemperature(), param.getTemperature()) ||
                                !Objects.equals(se.getWindSpeed(), param.getWindSpeed())) {
                            metricsService.insert(new Metrics(null,
                                    se));
                            System.out.println("This is se: " + se.toString());
                            System.out.println("This is param: " + param.toString());
                        }
                        sensorService.update(se);
                    });
                    continue firstMenu;

                case 3:
                    System.out.println("Type sensor id: ");
                    Integer sensorId = sc.nextInt();
                    Sensor sensor = sensorService.find(sensorId);

                    System.out.printf("The current temperature marked by the sensor %d is %f \n",
                            sensorId, sensor.getTemperature());

                    continue firstMenu;

                case 4:

                    System.out.println("Type sensor id: ");
                    sensorId = sc.nextInt();
                    sensor = sensorService.find(sensorId);

                    System.out.printf("The current humidity marked by the sensor %d is %2.2f \n",
                            sensorId, sensor.getHumidity());
                    continue firstMenu;

                case 5:
                    System.out.println("Type sensor id: ");
                    sensorId = sc.nextInt();
                    sensor = sensorService.find(sensorId);

                    System.out.printf("The current wind speed marked by the sensor %d is %2.2f \n",
                            sensorId, sensor.getWindSpeed());
                    continue firstMenu;

                case 6:
                    System.out.println("Type sensor id: ");
                    sensorId = sc.nextInt();

                    double sumWeekTemp = 0;
                    int count = 0;

                    List<Metrics> metrics =
                            metricsService.findAll();

                    for (Metrics m : metrics) {
                        if (m.getSensor().getId() == sensorId) {
                            sumWeekTemp += m.getTemperature();
                            count++;
                        }
                    }

                    System.out.println("sum of temp: " + sumWeekTemp);
                    System.out.println("count: " + count);

                    System.out.println("The average temp for the data collected during the past week is: " +
                            (sumWeekTemp / count));


                    continue firstMenu;


                case 0:
                    System.out.println("Good bye!");
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}
