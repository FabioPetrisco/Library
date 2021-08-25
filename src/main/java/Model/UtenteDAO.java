package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtenteDAO {

    public static Utente doRetrieveById(int id){
        try(Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM  utente WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Utente u = new Utente();
                u.setId(rs.getInt(1));
                u.setEmail(rs.getString(2));
                u.setPassword(rs.getString(3));
                u.setNome(rs.getString(4));
                u.setCognome(rs.getString(5));
                u.setVia(rs.getString(6));
                u.setCap(rs.getString(7));
                u.setPaese(rs.getString(8));
                u.setNumero(rs.getString(9));
                u.setAdmin(rs.getBoolean(10));
                return u;
            }
            return null;
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }

    public static List<Utente> doRetrieveAll(){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT * FROM utente");
            ResultSet rs = ps.executeQuery();
            List<Utente> lista = new ArrayList<>();
            while(rs.next()){
                Utente u = new Utente();
                u.setId(rs.getInt(1));
                u.setEmail(rs.getString(2));
                u.setPassword(rs.getString(3));
                u.setNome(rs.getString(4));
                u.setCognome(rs.getString(5));
                u.setVia(rs.getString(6));
                u.setCap(rs.getString(7));
                u.setPaese(rs.getString(8));
                u.setNumero(rs.getString(9));
                u.setAdmin(rs.getBoolean(10));
                lista.add(u);
            }
            if(lista.size() > 0)
                return lista;
            else
                return null;
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }

    public static Utente doRetrieveByEmailPassword(String email, String password){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT * FROM " +
                    "utente WHERE email=? AND passwordHash=?");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Utente u = new Utente();
                u.setId(rs.getInt(1));
                u.setEmail(rs.getString(2));
                u.setNome(rs.getString(3));
                u.setCognome(rs.getString(4));
                u.setPassword(rs.getString(5));
                u.setVia(rs.getString(6));
                u.setCap(rs.getString(7));
                u.setPaese(rs.getString(8));
                u.setNumero(rs.getString(9));
                u.setAdmin(rs.getBoolean(10));
                return u;
            }
            return null;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static void doSave(Utente utente){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO utente (email, passwordHash, nome, cognome, via, cap, paese, numero) VALUES(?,?,?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, utente.getEmail());
            ps.setString(2, utente.getPassword());
            ps.setString(3, utente.getNome());
            ps.setString(4, utente.getCognome());
            ps.setString(5, utente.getVia());
            ps.setString(6, utente.getCap());
            ps.setString(7, utente.getPaese());
            ps.setString(8, utente.getNumero());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            utente.setId(id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void doUpdate(Utente utente, int id){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE utente SET nome = ?, cognome = ?, via = ?, cap = ?, paese = ?, numero = ? WHERE id=?",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, utente.getNome());
            ps.setString(2, utente.getCognome());
            ps.setString(3, utente.getVia());
            ps.setString(4, utente.getCap());
            ps.setString(5, utente.getPaese());
            ps.setString(6, utente.getNumero());
            ps.setInt(7, id);
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("UPDATE error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void doSaveListaDesideri(Utente utente, int idProdotto){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO desideri (idUtente, idProdotto) VALUES(?,?)",
                Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, utente.getId());
            ps.setInt(2, idProdotto);

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void doDeleteListaDesideri(int idUtente, int idProdotto) {
        try (Connection connection = ConPool.getConnection()) {
            PreparedStatement ps;
            ps = connection.prepareStatement("delete from desideri where idUtente=? and idProdotto=?");
            ps.setInt(1, idUtente);
            ps.setInt(2, idProdotto);
            ps.execute();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    public static List<Integer> doRetrieveIdListaDesideriById(int id){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT * FROM desideri WHERE idUtente=?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            List<Integer> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(rs.getInt(3));
            }
            return lista;
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }

}
