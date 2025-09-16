package DAO;

import model.Funcionario;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


public class FuncionarioDao implements GenericDAO{

        private Connection conn;

        public void FuncionarioDAO() throws Exception{
            try {
                this.conn = ConnectionFactory.getConnection();
            }catch (Exception e){
                throw new Exception(e.getMessage());
            }
        }

    @Override
    public List<Object> getAll() {
        return List.of();
    }

    @Override
    public Object getById(int id) {
        return null;
    }

    @Override
    public Boolean insert(Object object) {

        //Convertendo o objeto generico em um objeto do tipo especifico ja criado anteriormente
        Funcionario funcionario = (Funcionario) object;


        //Intanciando um objeto da classe que 'formata ' o comando sql
        PreparedStatement stmt = null;

        //Escrevendo a sql para inserir um novo registro na tabela "produto"
        String sql = "INSERT INTO produto ( nome, cargo, salario) VALUES (?,?,?)";

        try{
            //Transforma a String sql em um comando válido para ser executado no banco
            stmt = this.conn.prepareStatement(sql);

            //Inserindo valor a cada ponto de interrogação de forma ssequenial
            //onde cada ? refere-se à uma coluna da tabela 'produto'
            //atentando para o tipo de cada coluna com o tipo do valor a ser enviado

            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, Funcionario.getCargo());
            stmt.setInt(3, funcionario.getSalario());

        } catch (SQLException e) {
            System.out.println("Problems ao inserir Funcionario. ERRO: " + e.getMessage());
            e.printStackTrace();
            return false;

        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception e) {
                System.out.println("Problema ao fechar conexão. ERRO: " + e.getMessage());
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public Boolean update(Object object) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}




