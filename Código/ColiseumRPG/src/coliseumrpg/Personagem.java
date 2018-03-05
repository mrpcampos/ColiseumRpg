/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coliseumrpg;

/**
 *
 * @author Matheus
 */
public class Personagem {
    String nome;
    private int velocidade;
    private int vida;
    private int dano;
    private int alcance;
    
    private Especialidade especialidade;
    
    public Personagem(String nome, int vida, int velocidade, int alcance, int dano) {
        this.nome=nome;
        this.vida = vida;
        this.velocidade = velocidade;
        this.alcance = alcance;
        this.dano = dano;
    }
    
    public void defineClasse(Especialidade especialidade){
        this.especialidade=especialidade;
    }

    public void receberDano(int dano){
        
    }

    public void atacar(){
        
    }
    
    public void declararMorte(){
        //Insira código aqui
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }
    
    public void setDano(int dano){
        this.dano=dano;
    }
    
    public void setAlcance(int alcance){
        this.alcance=alcance;
    }
}
