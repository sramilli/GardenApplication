/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gardenapplication.entity;

import gardenapplication.properties.GardenProperties;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 *
 * @author Ste
 */
public class Actuator {
    int iQos;
    String iBroker;
    String iClientId;
    MemoryPersistence iPersistence;
    
    public Actuator(){
        super();
        iQos = GardenProperties.MQTT_QOS;
        iBroker = GardenProperties.MQTT_BROKER;
        iClientId = GardenProperties.CLIENT_ID;
        iPersistence = new MemoryPersistence();
    }
    
    public void activate(IActivable aActivable, int aMinutes){
        String topic = aActivable.getTopic();
        String content = (new Integer(aMinutes)).toString();

        try {
            MqttClient sampleClient = new MqttClient(iBroker, iClientId, iPersistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: "+iBroker);
            sampleClient.connect(connOpts);
            System.out.println("Connected");
            System.out.println("Publishing message: " +topic +"    " +content);
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(iQos);
            sampleClient.publish(topic, message);
            System.out.println("Message published");
            sampleClient.disconnect();
            System.out.println("Disconnected");
            System.out.println("");
        } catch(MqttException me) {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
            System.out.println("");

        }
    }
}