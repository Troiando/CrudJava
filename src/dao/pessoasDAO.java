package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.ConnectionBD;
import model.Pessoas;

public class pessoasDAO {

    /*
     * CRUD
     * c create
     * r read
     * u update
     * d delete
     */

    public void save(Pessoas pSave) {

        String sql = "INSERT INTO pessoas(nome, idade) VALUES (?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        //Criar conexao com BD
        try {
            conn = ConnectionBD.createConnectionToMySQL();

            // Criamos uma PreparedStatement, para executar um a query
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            //Add Valores
            pstm.setString(1, pSave.getNome());
            pstm.setInt(2, pSave.getIdade());

            //EXE query
            pstm.execute();

        } catch (Exception e) {
        } finally {
            //Fechar programa
            try {

                if (conn != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void head() {
        String sql = "SELECT * FROM pessoas";

        Connection conn = null;
        PreparedStatement pstm = null;

        //Criar conexao com BD
        try {
            conn = ConnectionBD.createConnectionToMySQL();

            // Criamos uma PreparedStatement, para executar um a query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                System.out.printf("Id: %s, Nome: %s, Idade: %s%n",
                        rs.getInt("Id"), rs.getString("nome"), rs.getInt("idade"));
            }

        } catch (Exception e) {
        } finally {
            //Fechar programa
            try {
                if (conn != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void update(Pessoas pUp) {
        String sql = "UPDATE pessoas SET nome = ?, idade = ? "+" WHERE Id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        //Criar conexao com BD
        try {
            //Criar Conexao com o banco
            conn = ConnectionBD.createConnectionToMySQL();

            // Criamos uma PreparedStatement, para executar um a query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            //Adicionar os valores para atualizar
            pstm.setString(1, pUp.getNome());
            pstm.setInt(2, pUp.getIdade());

            //Qual id do registro para atualizar?
            pstm.setInt(3, pUp.getId());

            //Executar a query
            pstm.execute();

        } catch (Exception e) {
        } finally {
            //Fechar programa
            try {

                if (conn != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void delete(Pessoas pDelete){

        String sql = "DELETE FROM pessoas"+" WHERE Id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        //Criar conexao com BD
        try {
            //Criar Conexao com o banco
            conn = ConnectionBD.createConnectionToMySQL();

            // Criamos uma PreparedStatement, para executar um a query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            //Qual id do registro para deleta
            pstm.setInt(1, pDelete.getId());

            //Executar a query
            pstm.execute();

        } catch (Exception e) {
        } finally {
            //Fechar programa
            try {

                if (conn != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}







