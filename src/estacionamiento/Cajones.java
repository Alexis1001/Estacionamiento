/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estacionamiento;

/**
 *
 * @author PC
 */
public class Cajones {
    int capacidad=0;  
    int totalcoches=0;
    int[] estacionamiento;
    int  Lugarvacio=-1;
    int  CochesSaliendo=0;
    int  CochesEntrando=1;
    int  Ocupado=100;
    
    int CochesSalidaEsperando=0;
    int CochesEntradaEsperando=0;
    int entrando=0;
    
    public  Cajones(int []estacinamiento){
     this.estacionamiento=estacinamiento;
      
     }
    
    public void setCapacidad(int capacidad){
      this.capacidad=capacidad;
     }
    
    public  int getCapacidad(){
        return capacidad;
     }
    
    public synchronized void autosLlegando() throws InterruptedException{
           
        while(totalcoches>=getCapacidad()){
            System.out.println(Thread.currentThread().getName() + "Esperando" );
              wait();
            }
        totalcoches++;
        //notifyAll();
    }
    
    public synchronized void entrada()throws InterruptedException{
  
        while(CochesSaliendo>0){
            this.CochesEntradaEsperando++;
            wait();
       }
       
        if(this.CochesEntradaEsperando>1){
           this.CochesEntrando=1; 
           this.CochesEntradaEsperando--;
           cocheBuscandoLugar();
           entrando++;
           notifyAll();
        }
        
        else{
         this.CochesEntrando=0;
         cocheBuscandoLugar();
         entrando++;
         notifyAll();
        }
     }
  
    public synchronized  void  salida()throws InterruptedException{
        
      while(CochesEntrando>0){
            this.CochesSalidaEsperando++;
            wait();
        }
       
      
        if(this.CochesSalidaEsperando>1){
           this.CochesSaliendo=1;
           this.CochesSalidaEsperando--;
           cochesSaliendo();
           notifyAll();
        }
        
        else{
         this.CochesSaliendo=0;
         cochesSaliendo();
         notifyAll();
        }
        
        
     } 
    
    
    public void cocheBuscandoLugar(){
        for(int i=0;i<this.estacionamiento.length;i++){
             if(this.estacionamiento[i]==this.Lugarvacio){
                 this.estacionamiento[i]=this.entrando;
                 System.out.println("Coche : estacionado "+entrando);
                 break;
                 }
        }  
    }
  
    public void cochesSaliendo(){
       for(int i=0;i<this.estacionamiento.length;i++){
             if(this.estacionamiento[i]>=0){
                 System.out.println("Coche : Saliendo "+this.estacionamiento[i]);
                 this.estacionamiento[i]=this.Lugarvacio;
    
                 
                 this.totalcoches--;
                 
                 break;
                }
        }  
    }
    
    
    
}
