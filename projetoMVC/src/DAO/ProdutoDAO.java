package DAO;

import model.Produto;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements GenericDAO {


    private Connection conn;

    public  ProdutoDAO() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }




    @Override
    public List<Object> getAll() {

        List<Object>produtoList = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM produto ORDER BY id";

        try{
            stmt = this.conn.prepareStatement(sql);
            rs= stmt.executeQuery();

            //rs.next() vai buscar o proximo registro encontrado no select anterior
            //para CADA registro encontrado, sera executado o bloco abaixo
            while (rs.next()){
                //Declaro um objeto da classe Produto para ser populado com as informações do banco
                Produto produto = new Produto();

                //Fazemos um match entre o nome da coluns no banco de dados com o nome do atributo
                //correspondente do objeto
                produto.setId(rs.getInt("id"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setStatus((rs.getBoolean("status")));
                produtoList.add(produto);
            }
        }catch ( SQLException e){
            e.printStackTrace();

        }  finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Problema ao fechar conexão. ERRO: " + e.getMessage());
                e.printStackTrace();
            }
    }
    return produtoList; }

    @Override
    public Object getByID(int id) {
        return null;
    }

    @Override
    public Boolean insert(Object object) {


        //Convertendo o objeto generico em um objeto do tipo especifico
        Produto produto = (Produto) object;

        //Intanciando um objeto da classe que 'formata ' o comando sql
        PreparedStatement stmt = null;

        //Escrevendo a sql para inserir um novo registro na tabela "produto"
        String sql = "INSERT INTO produto (descricao, preco, status) VALUES (?,?,?)";

        try {
            //Transforma a String sql em um comando válido para ser executado no banco
            stmt = this.conn.prepareStatement(sql);

            //Inserindo valor a cada ponto de interrogação de forma ssequenial
            //onde cada ? refere-se à uma coluna da tabela 'produto'
            //atentando para o tipo de cada coluna com o tipo do valor a ser enviado

            stmt.setString(1, produto.getDescricao());
            stmt.setDouble(2, produto.getPreco());
            stmt.setBoolean(3, produto.isStatus());

            //executa a sql no banco
            stmt.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Problems ao inserir produto. ERRO: " + e.getMessage());
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


    }

    @Override
    public Boolean update(Object object) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
