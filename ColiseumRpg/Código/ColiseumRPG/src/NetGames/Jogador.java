package NetGames;

import coliseumrpg.Turno;
import coliseumrpg.Personagem;

public class Jogador {

    private final Time time;
    private Personagem personagens[];
    private Turno turno;

    public Jogador(Time time, Personagem primeiroPersonagem, Personagem segundoPersonagem) {
        this.time = time;
        personagens = new Personagem[2];
        personagens[0] = primeiroPersonagem;
        personagens[1] = segundoPersonagem;
    }
    
    /**
     * Deve ser chamado quando o turno antigo ja estiver encerrado, pede para o
     * jogador gerar um turno para o proximo personagem dele.
     * 
     * @return o novo turno com as informações do personagem da vez.
     */
    public Turno tomarVez() {
        Personagem p;
        if (this.turno == null) {
            this.turno = new Turno(time, personagens[0]);
        } else {
            if (turno.getPersonagem() == personagens[0]) {
                if (personagens[1].estaVivo()) {
                    p = personagens[1];
                } else {
                    p = personagens[0];
                }
            } else {
                if (personagens[0].estaVivo()) {
                    p = personagens[0];
                } else {
                    p = personagens[1];
                }
            }
            this.turno = new Turno(getTime(), p);
        }
        return turno;
    }

    public Time getTime() {
        return time;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setPersonagens(Personagem[] personagens) {
        this.personagens = personagens;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public Personagem[] getPersonagens() {
        return personagens;
    }

}
