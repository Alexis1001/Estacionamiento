/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estacionamiento;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author PC
 */
public class Estacionamiento {

  
    public static void main(String[] args) throws InterruptedException {
      
        Random aleatorio=new Random(100);
        int tiempo=0;
        int capacidad=(int)(500*0.20); 
        ArrayList<Thread> autos=new ArrayList<Thread>();
        int[] estacionamientoz=new int[capacidad];
        
        for(int i=0;i<estacionamientoz.length;i++){
            estacionamientoz[i]=-1;
          }
        
        Cajones estacionamiento=new Cajones(estacionamientoz);
        estacionamiento.setCapacidad(capacidad);
        
        
        for(int i=0;i<100;i++){
            Autos Bocho=new Autos(estacionamiento);
            autos.add(Bocho);
            tiempo=100+aleatorio.nextInt(400);
            Thread.sleep(tiempo);
            autos.get(i).start();
         }
    }
    
}
