package teste;
import javax.swing.*;
import controller.FuncionarioController;
import model.Funcionario;
import model.Produto;

public class FuncionarioTeste {
        public static void main(String[] args)throws Exception {

            FuncionarioController controller = new FuncionarioController();

            model.Funcionario novoFuncionario = new model.Funcionario();
            novoFuncionario.setId(1);
            novoFuncionario.setNome("Garrafinha de inox 500ml");
            novoFuncionario.setCargo("Adestrador de periquitas ");
            novoFuncionario.setSalario(1999);
        }
;

    }

