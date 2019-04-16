/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estacionamiento;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;




public class Autos extends Thread{
    
    Random aleatorio=new Random();
    int tiempo=0;
    Cajones cajon;

    public Autos(Cajones cajon){
      this.cajon=cajon;
    }
    
    @Override
    public void run(){
        
        try{
         cajon.autosLlegando();
         cajon.entrada();
         tiempo=100+aleatorio.nextInt(1000);
         Thread.sleep(tiempo);
         cajon.salida();
        }catch(Exception e){
         System.out.println("error "+e); 
        }
        
          
        
         
       
     }
    
    
    

}
