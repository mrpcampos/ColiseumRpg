package coliseumrpg;

import Erros.SemRecursoParaAtoException;
import NetGames.Time;

/**
 *
 * @author Matheus
 */
public class Turno {

    private final Time time;
    private final Personagem personagem;
    private boolean AtoMaior;
    private boolean AtoMenor;
    private boolean turnoAtivo;

    public Turno(Time time, Personagem personagem) {
        this.personagem = personagem;
        this.time = time;
        this.AtoMaior = true;
        this.AtoMenor = true;
        this.turnoAtivo = true;
    }

    public Time getTime() {
        return time;
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public boolean hasAtoMaior() {
        return AtoMaior;
    }

    public boolean hasAtoMenor() {
        return AtoMenor;
    }

    public void usarAtoMaior() {
        if (hasAtoMaior()) {
            this.AtoMaior = false;
        } else {
            throw new SemRecursoParaAtoException("Você ja gastou seu Ato maior nesse turno.");
        }
    }

    public void usarAtoMenor() {
        if (hasAtoMenor()) {
            this.AtoMenor = false;
        } else {
            throw new SemRecursoParaAtoException("Você ja gastou seu Ato menor nesse turno.");
        }
    }

    public boolean isTurnoAtivo() {
        return turnoAtivo;
    }

    public void encerrar() {
        if(isTurnoAtivo()){
        personagem.passarTempo();
        }
        turnoAtivo = false;
    }

}
