/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author marcio
 */
public class SorteioParticipante {
    private int id;
    private int id_participante;
    private int id_sorteio;
    private Sorteio sorteio;
    private Participante participante;
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setIdParticipante(int id) {
        this.id_participante = id;
    }
    
    public void setIdSorteio(int id) {
        this.id_sorteio = id;
    }

    public void setSorteio(Sorteio sorteio) {
        this.sorteio = sorteio;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }
    
    public int getId() {
        return this.id;
    }
    
    public int getIdParticipante() {
        return this.id_participante;
    }
    
    public int getIdSorteio() {
        return this.id_sorteio;
    }
    
    public Sorteio getSorteio() {
        return this.sorteio;
    }
    
    public Participante getParticipante() {
        return this.participante;
    }
}
