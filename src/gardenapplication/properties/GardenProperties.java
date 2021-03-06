/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gardenapplication.properties;

/**
 *
 * @author Ste
 */
public class GardenProperties {
    
    public static String ACTUATOR_CLIENT_ID = "ActuatorMqttClient";
    public static String SENSOR_LOGGER_CLIENT_ID = "SensorLoggerMqttClient";
    public static String MQTT_BROKER = "tcp://192.168.0.25:1883";
    public static int MQTT_QOS_2 = 2;
    public static String SENSOR_DATA_LOGGER_TOPIC = "/anna/balcony/sensor-readings";
    
    public static String MORNING_WATERING_TIME = "21:15";
    public static String EVENING_WATERING_TIME = "21:16";
    
    public static String TOPIC_PUMP_1 = "/anna/balcony/pump1";
    public static String TOPIC_PUMP_2 = "/anna/balcony/pump2";
    public static String TOPIC_PUMP_3 = "/anna/balcony/pump3";
    public static String TOPIC_PUMP_4 = "/anna/balcony/pump4";
    public static String TOPIC_PUMP_5 = "/anna/balcony/pump5";
    public static int CALIBRATION_PUMP_1 = 1;
    public static int CALIBRATION_PUMP_2 = 1;
    public static int CALIBRATION_PUMP_3 = 1;
    public static int CALIBRATION_PUMP_4 = 1;
    public static int CALIBRATION_PUMP_5 = 1;
    public static int DEFAULT_QUANTITY_PUMP_1 = 1;
    public static int DEFAULT_QUANTITY_PUMP_2 = 2;
    public static int DEFAULT_QUANTITY_PUMP_3 = 3;
    public static int DEFAULT_QUANTITY_PUMP_4 = 4;
    public static int DEFAULT_QUANTITY_PUMP_5 = 5;
    public static boolean PUMP_1_PLUGGED = true;
    public static boolean PUMP_2_PLUGGED = true;
    public static boolean PUMP_3_PLUGGED = true;
    public static boolean PUMP_4_PLUGGED = true;
    public static boolean PUMP_5_PLUGGED = true;
    
    public static boolean PERSIST_TEMPERATURES = true;
    
}
