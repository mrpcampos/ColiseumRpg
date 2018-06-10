/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NetGames;

import coliseumrpg.Personagem;

/**
 *
 * @author Matheus
 */
public class Jogador {
    
    private final Time time;
    private final Personagem personagens[];
    private Turno turno;

    public Jogador(Time time, Personagem primeiroPersonagem, Personagem segundoPersonagem) {
        this.time = time;
        personagens = new Personagem[2];
        personagens[0] = primeiroPersonagem;
        personagens[1] = segundoPersonagem;
    }

    public Time getTime() {
        return time;
    }
    
    public void passarVez(){
        this.turno.encerrar();
    }
    
    public void tomarVez(){
        Personagem p;
        if(turno.getPersonagem()==personagens[0]){
            if(personagens[1].estaVivo()){
                p=personagens[1];
            } else{
                p=personagens[0];
            }
        } else{
            if(personagens[0].estaVivo()){
                p=personagens[0];
            }else{
                p=personagens[1];
            }
        }
        this.turno=new Turno(this, p);
    }
}