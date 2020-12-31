package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Participante;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marcio
 */
public class ParticipanteDB {
    public void insert(Participante participante) {
        
        String sql = "insert into participante(nome, email) values (?, ?)";
        PreparedStatement ps;
        
        try {
            ps = DB.getConnection().prepareStatement(sql);
            ps.setString(1, participante.getNome());
            ps.setString(2, participante.getEmail());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ParticipanteDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(Participante participante) {
        String sql = "update participante set nome = ?, email = ? where id = ?";
        PreparedStatement ps;
        
        try {
            ps = DB.getConnection().prepareStatement(sql);
            ps.setString(1, participante.getNome());
            ps.setString(2, participante.getEmail());
            ps.setInt(3, participante.getId());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ParticipanteDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(Participante participante) {
        String sql = "delete from participante where id = ?";
        PreparedStatement ps;
        
        try {
            ps = DB.getConnection().prepareStatement(sql);
            ps.setInt(1, participante.getId());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ParticipanteDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Participante selectOne(int id) {
        String sql = "select * from participante where id = ?";
        PreparedStatement ps;
        Participante participante = new Participante();
        
        try {
            ps = DB.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet results = ps.executeQuery();
            
            while (results.next()) {
                participante.setId(results.getInt("id"));
                participante.setNome(results.getString("nome"));
                participante.setEmail(results.getString("email"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ParticipanteDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return participante;
    }
    
    public ArrayList<Participante> selectAll() {
        String sql = "select * from participante";
        PreparedStatement ps;
        ArrayList<Participante> participantes = new ArrayList<Participante>();
        
        try {
             ps = DB.getConnection().prepareStatement(sql);
             ResultSet results = ps.executeQuery();
             
             while (results.next()) {
                 Participante participante = new Participante();
                 
                 participante.setId(results.getInt("id"));
                 participante.setNome(results.getString("nome"));
                 participante.setEmail(results.getString("email"));
                 participantes.add(participante);
             }
             
        } catch (SQLException ex) {
            Logger.getLogger(ParticipanteDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return participantes;
    }
}
