/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gardenapplication;

/**
 *
 * @author Ste
 */
public class GardenApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        Garden garden = new Garden();
        new Thread(garden).start();
        
        Thread.sleep(1 * 60 * 1000);
        
        garden.stop();
    }
    
}
