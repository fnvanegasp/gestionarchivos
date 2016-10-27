/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import vo.Player;
import java.io.*;
import java.util.*;
/**
 *
 * @author Estudiante
 */
public class DaoPlayer {
    private File player;
    
    public DaoPlayer()throws IOException{
        this.player = new File("player.txt");
        if(this.player.exists()){
            this.player.createNewFile();
        }
    }
    
    public boolean write(ArrayList<Player> player) throws FileNotFoundException{
        PrintStream salida = new PrintStream(this.player);
        for(Player p : player){
            salida.println(p.getName() + " " + p.getEmail());
        }
        salida.close();
        return true;
    }
    
    public ArrayList<Player> read() throws FileNotFoundException{
        Scanner lectura = new Scanner(this.player);
        ArrayList<Player> resultado = new ArrayList();
        while(lectura.hasNext()){
            String name = lectura.next();
            String email = lectura.next();
            Player p = new Player(name,email);
            resultado.add(p);
        }
        lectura.close();
        return resultado;
    }
    
}
