package controller;

import DAO.FuncionarioDao;
import DAO.GenericDAO;
import model.Funcionario;

public class FuncionarioController {

    private FuncionarioDao dao ;

    public  String insert (Funcionario funcionario){
        try {
            GenericDAO dao = new FuncionarioDao();

            boolean isCadastrado = dao.insert(funcionario);
            if (isCadastrado){
                return "Cadastro realizado com sucesso!";
            }else{
                return "Erro ao cadastrar o funcionario!" ;
            }
        }catch (Exception e){
            e.printStackTrace();
            return "Cadastro realizado com sucesso!";
        }
    }
}
