/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.DaoPlayer;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import vo.Player;
/**
 *
 * @author Estudiante
 */
public class viewPlayer {
    private DaoPlayer dao;
    private ArrayList<Player> player = new ArrayList<Player>();
    
    public viewPlayer() {
        try{
            this.dao = new DaoPlayer();
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null,"no se pudo abrir");
        }
    }
    
    public void menu(){
        String opcion = 
                JOptionPane.showInputDialog(null,"1. Crear\n 2.Guardar\n 3.Leer");
        if(opcion.equals("1")){
            String name = JOptionPane.showInputDialog(null,"Name");
            String email = JOptionPane.showInputDialog(null,"Email");
            Player player = new Player(name,email);
            this.player.add(player);
        }else if(opcion.equals("3")){
            try{
                ArrayList<Player> players = this.dao.read();
                for (Player player1 : players) {
                    System.out.println(player1);
                }
            }catch(FileNotFoundException ex){
                JOptionPane.showMessageDialog(null, "Error de lectura");
            }
        }else if(opcion.equals("2")){
            try{
                this.dao.write(player);
            }catch(FileNotFoundException ex){
                JOptionPane.showMessageDialog(null, "Error de escritura");
            }
        }
    }
    
}
