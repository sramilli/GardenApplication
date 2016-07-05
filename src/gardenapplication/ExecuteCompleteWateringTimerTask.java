/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gardenapplication;

import gardenapplication.entity.Actuator;
import gardenapplication.entity.Pump;
import java.util.List;
import java.util.TimerTask;

/**
 *
 * @author Ste
 */
class ExecuteCompleteWateringTimerTask extends TimerTask {
    Actuator iActuator;
    List<Pump> iPumps;
    
    public ExecuteCompleteWateringTimerTask(Actuator aActuator, List<Pump> aPumps){
        iActuator = aActuator;
        iPumps = aPumps;
    }

    @Override
    public void run() {
        for (Pump tPump: iPumps){
            iActuator.activate(tPump);
        }
    }
    
}
