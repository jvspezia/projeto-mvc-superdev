import controller.ProdutoController;
import model.Produto;

import javax.swing.*;
import java.util.List;

public class ProjetoMVC {

    public static void main(String[] args) throws Exception {

        ProdutoController controller = new ProdutoController();

        StringBuilder menu = new StringBuilder();
        menu.append("*** MENU DO SISTEMA ***");
        menu.append("\n [1] Cadastrar");
        menu.append("\n [2] Listar");
        menu.append("\n [3] Listar por id");
        menu.append("\n [0] Sair");
        menu.append("\n\nSelecione uma opção");


        int opcao = -1;
        while(opcao !=0) {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            List<Produto> produtoList = controller.getAll();

            //Crio uma variavel para construir a mensagem de saida de dados
            StringBuilder listaImprimir = new StringBuilder();

            switch (opcao) {
                case 1:
                    String descicao = JOptionPane.showInputDialog("Descrição do produto");
                    Double preco = Double.parseDouble(JOptionPane.showInputDialog("Preço do produto"));

                    Produto novoProduto= new Produto();
                    novoProduto.setDescricao(descicao);
                    novoProduto.setPreco(preco);
                    novoProduto.setStatus(true);

                    String mensagemInsert = controller.insert(novoProduto);
                    JOptionPane.showMessageDialog(null,mensagemInsert);

                    break;


                case 2:


                    //Para cada elemento encontrado na lista de produtos, montar o texto
                    //que será apresentado no painel com os atributos do objeto
                    for(Produto produto : produtoList){
                        listaImprimir.append(produto.getDescricao());
                        listaImprimir.append(" - ");
                        listaImprimir.append(produto.getPreco());
                        listaImprimir.append("\n");
                    }
                    //imprimir na tela a lista de produtos
                    JOptionPane.showMessageDialog(
                            null,
                            listaImprimir.toString());

                    break;
                case 3:
                    Double pesquisa = Double.parseDouble(JOptionPane.showInputDialog("Diga o id do usuario"));
                    for (Produto produto : produtoList){
                        if (pesquisa == produto.getId()){



                            //imprimir na tela a lista de produtos
                            JOptionPane.showMessageDialog(
                                    null,
                                    listaImprimir.toString());
                        }else{
                            JOptionPane.showMessageDialog(null,"Id invalido");
                        }
                    }
                    break;
            }
        }

    }


}
