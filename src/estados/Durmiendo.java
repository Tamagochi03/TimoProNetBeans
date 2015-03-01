/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package estados;

import javax.swing.JLabel;
import logica.MaquinaTamagochi;
import manejo3d.AnimacionDurmiendo;

/**
 *
 * @author Shinsnake
 */
public class Durmiendo extends EstadoGeneral implements Estado, Runnable {
    AnimacionDurmiendo animacion;
    public Durmiendo(MaquinaTamagochi tamagochi, JLabel mensajePensamiento) {
        setTama(tamagochi);
        setMensajePensamiento(mensajePensamiento);
        animacion = new AnimacionDurmiendo(getTama().getTg());
    }

    @Override
    public void dormir() {
        getMensajePensamiento().setText("ZzZzZzZz....ñam...ñam");
    }

    @Override
    public void jugar() {
        getMensajePensamiento().setText("No me despiertes!");
    }

    @Override
    public void comer() {
        getMensajePensamiento().setText("ZzZzZz...comida...ñam");
    }
    
    @Override
    public void runThread(){
        Thread hilo;
        hilo = new Thread(this);
        hilo.start();
    }
    
    @Override
    public void run(){
         try{
             //TODO: Añadir aquí transformación sobre el modelo
            getTama().setTg(animacion.estadoDurmiendo());
            //
            Thread.sleep(5000);
            getTama().getHiloEneregia().incremento(30);
            getTama().getHiloSueno().decremento(50);
            setEstado(getTama().getNormal());
        }catch (Exception e){
            System.out.println("Error al dormir el hilo"); //TODO: delete , este metodo es solo para debug del manejo de hilos
        }
    }
}
