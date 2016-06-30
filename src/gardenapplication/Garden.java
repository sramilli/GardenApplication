/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gardenapplication;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import gardenapplication.entity.Actuator;
import gardenapplication.entity.Pump;
import gardenapplication.helper.Helper;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ste
 */
public class Garden implements Runnable{
    
    Actuator iActuator;
    Pump iPump1;
    Pump iPump2;
    Pump iPump3;
    Pump iPump4;
    Pump iPump5;
    List<Pump> iPumps;
    
    private Timer iTimer;
    
    public static long REPEAT_DAILY = 24 * 60 * 60 * 1000;
    
    public Garden(){
        super();
        iActuator = new Actuator();
        iPump1 = new Pump("/anna/balcony/pump1");
        iPump2 = new Pump("/anna/balcony/pump2");
        iPump3 = new Pump("/anna/balcony/pump3");
        iPump4 = new Pump("/anna/balcony/pump4");
        iPump5 = new Pump("/anna/balcony/pump5");
        iPumps = new ArrayList<>(Arrays.asList(iPump1, iPump2, iPump3, iPump4, iPump5));
        /*iPumps = new ArrayList<>();
        iPumps.add(iPump1);
        iPumps.add(iPump2);
        iPumps.add(iPump3);
        iPumps.add(iPump4);
        iPumps.add(iPump5);*/
        iTimer = new Timer(true);

    }
    
    @Override
    public void run() {
        System.out.println("Garden Application Started!");
        //scheduleActivationAtHoursOfDay("07:00", "19:00");
        scheduleActivationAtHoursOfDay("23:53", "23:54");
    }
    
    private void scheduleActivationAtHoursOfDay(String... hours){
        for (String hour: hours){
            Calendar tActivationInstant;
            try {
                tActivationInstant = Helper.parseTime(hour);
            } catch (ParseException ex) {
                Logger.getLogger(Garden.class.getName()).log(Level.SEVERE, null, ex);
                continue;
            }
            if (tActivationInstant != null){
                if (tActivationInstant.before(Calendar.getInstance())) tActivationInstant.add(Calendar.DAY_OF_MONTH, 1);
                scheduleActivationAtHour(tActivationInstant);
            }
        }
    }
    
    private void scheduleActivationAtHour(Calendar aActivationInstant){
        Helper.printCal("CompleteWatering programmed daily starting", aActivationInstant);
        ExecuteCompleteWateringTimerTask tExecuteCompleteWateringTimerTask = new ExecuteCompleteWateringTimerTask(iActuator, iPumps);
        iTimer.scheduleAtFixedRate(tExecuteCompleteWateringTimerTask, aActivationInstant.getTime(), REPEAT_DAILY);
    }


}
