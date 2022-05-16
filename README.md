# activitymay

## The code aims to insert and administrate weather sensors.

The application should be able to add sensors as well as get their newsest readings. It should also be able to provide the current temperature, wind speed and humidity marked by a sensor as well as an average of the temperature of the last week.

## How to run

The project was developed in Java 8, JPA and using the Spring framework. The IDE used was Intellij.

Whenever the project is cloned, you can follow the steps bellow:

First, on the top right side, you should be able to configure the Run Configurations.

Simply Click on Add Configuration for that. Then, on the top left side there's a plus sign. Click on it and you should be able to find and icon for spring boot. 

After that, just name the configuation and below you will set the main class that will run: ActivitygnApplication.

It should be able to find automatically after a few seconds.



https://user-images.githubusercontent.com/63955638/168576192-c33b24c8-680a-4efb-b3dc-4811c1bf3030.mp4


Finally, you can just run the application. As this is a testing environment, you'll be able to test the connections through the http://localhost:8080/ address.

Also, the database used is the H2 database. You'll be able to access the in memory database through the link http://localhost:8080/h2-console/

Note that to access it you'll need the JDBC URL, User Name, password and the Driver Class. They're all described on application.properties file, under the resources directory.

They must be configured as shown bellow:

![image](https://user-images.githubusercontent.com/63955638/168576751-a4dc7c34-7664-4c6d-8483-8dc50df461d6.png)

![image](https://user-images.githubusercontent.com/63955638/168576785-9e244997-7afc-48c9-87d1-c777c6bb6231.png)

Snipped of the application working





https://user-images.githubusercontent.com/63955638/168578559-043a2074-829e-4e6c-9a57-4627804712e5.mp4



https://user-images.githubusercontent.com/63955638/168578605-acfac052-4e9b-40c7-aa24-dedfd6b6581a.mp4


Note that, when creating the Sensor in the system, I used the own systems http address for the calls, for testing purposes. Whenever a real sensor is to be added to the system, it will have its own address that the application can get data from.

This would allow the application to retrieve the data from the sensor. It gets the data, replaces the current data of the sensor object we have in the system and saves this reading in the metrics table.

The metrics table is organised to store all the past readings. This way, the application is able to provide past readings and the average of the week, for example.

