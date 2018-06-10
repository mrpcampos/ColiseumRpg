/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coliseumrpg;

import NetGames.ControladorNetGames;
import InterfaceVisual.ControladorTelas;
import Mapa.Lugar;
import Mapa.Mapa;

/**
 *
 * @author Matheus
 */
public class ColiseumRPG {

    protected ColiseumRPG instance;
    protected ControladorTelas controladorTelas;
    protected ControladorNetGames controladorNetGames;
    /*Adicionar controlar netgames*/
    
    protected Mapa mapa;
    
    public ColiseumRPG() {
        this.controladorTelas = ControladorTelas.getInstance();
    }

    public ColiseumRPG getInstance() {
        if (this.instance == null) {
            this.instance = new ColiseumRPG();
        }
        return this.instance;
    }

    public static void main(String[] args) {
        ControladorTelas.getInstance().abrirTelaInicial();
    }

}
