/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gardenapplication.entity;

/**
 *
 * @author Ste
 */
public class Pump implements IActivable{
    
    private String iTopic;
    
    public Pump(String aTopic){
        iTopic = aTopic;
    }
    
    public String getTopic(){
        return iTopic;
    }
    
}
