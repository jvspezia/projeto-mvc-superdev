package controller;

import DAO.GenericDAO;
import DAO.ProdutoDAO;
import model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoController {

    private ProdutoDAO dao ;

    public String insert (Produto produto){
        try {
            GenericDAO dao = new ProdutoDAO();

        boolean isCadastrado = dao.insert(produto);
        if (isCadastrado){
            return "Cadastro realizado com sucesso!";
        }else{
          return "Erro ao cadastrar o produto!" ;
        }
    }catch (Exception e){
            e.printStackTrace();
            return "Cadastro realizado com sucesso!";
        }
    }

    public List<Produto> getAll() throws Exception {
        List<Produto> produtoList = new ArrayList<>();
        GenericDAO dao = new ProdutoDAO();

        //obter a lista generica vinda do ProdutoDAO
        List<Object> listaGenerica = dao.getAll();


        // Converter o List<Object>, ou seja, a lista de objetos genericos
        // que é retornada em produto DAO em uma lista propriamente da
        //classe Produto

        for (Object objetoGenerico : listaGenerica) {
            //Convertendo o objeto do tipo produto
            produtoList.add((Produto) objetoGenerico);
        }

        return produtoList;


    }
}
