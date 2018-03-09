/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coliseumrpg;

import InterfaceVisual.ControladorTelas;
import Mapa.Mapa;

/**
 *
 * @author Matheus
 */
public class ColiseumRPG {

    private ControladorTelas controladorTelas;
    private ColiseumRPG instance;
    private Mapa mapa;
    private Personagem personagens[][];
    
    private ColiseumRPG() {
        controladorTelas = new ControladorTelas();
    }

    public ColiseumRPG getInstance() {
        if (this.instance == null) {
            this.instance = new ColiseumRPG();
        }
        return this.instance;
    }

    public static void main(String[] args) {
        // TODO code application logic here
    }

}
