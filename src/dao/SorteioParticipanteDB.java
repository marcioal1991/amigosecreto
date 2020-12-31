/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Participante;
import model.Sorteio;
import model.SorteioParticipante;

/**
 *
 * @author marcio
 */
public class SorteioParticipanteDB {
    public void insert(SorteioParticipante sorteio_participante) {
         
        String sql = "insert into sorteio_participante(id_participante, id_sorteio) values (?, ?)";
        PreparedStatement ps;
        
        try {
            ps = DB.getConnection().prepareStatement(sql);
            ps.setInt(1, sorteio_participante.getIdParticipante());
            ps.setInt(2, sorteio_participante.getIdSorteio());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ParticipanteDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<SorteioParticipante> selectAllFromSorteio(Sorteio sorteio) {
        String sql = "select SP.*, P.nome, P.email from sorteio_participante as SP"
                + "inner join participante as P on P.id_participante = SP.id_participante"
                + "where SP.id_sorteio = ?";
        
        PreparedStatement ps;
        ArrayList<SorteioParticipante> sorteios_participantes = new ArrayList<SorteioParticipante>();
        
        try {
             ps = DB.getConnection().prepareStatement(sql);
             ResultSet results = ps.executeQuery();
             
             while (results.next()) {
                 SorteioParticipante sorteio_participante = new SorteioParticipante();
                 sorteio_participante.setId(results.getInt("id"));
                 sorteio_participante.setIdParticipante(results.getInt("id_participante"));
                 sorteio_participante.setIdSorteio(results.getInt("id_sorteio"));
                 
                 Participante participante = new Participante();
                 participante.setId(sorteio_participante.getIdParticipante());
                 participante.setNome(results.getString("nome"));
                 participante.setEmail(results.getString("email"));
                 
                 sorteio_participante.setSorteio(sorteio);
                 sorteio_participante.setParticipante(participante);
                 sorteios_participantes.add(sorteio_participante);
             }
             
        } catch (SQLException ex) {
            Logger.getLogger(ParticipanteDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return sorteios_participantes;
    }
    
    public void delete(SorteioParticipante sorteio_participante) {
        String sql = "delete from sorteio_participante where id = ?";
        PreparedStatement ps;
        
        try {
            ps = DB.getConnection().prepareStatement(sql);
            ps.setInt(1, sorteio_participante.getId());
            ps.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(SorteioDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
