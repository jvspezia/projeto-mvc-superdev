package model;


public class Funcionario {
 private int id;
 private String nome;
 private static String cargo;
 private  int salario;

 public Funcionario (){

 }

 public Funcionario ( int id, String nome, String cargo, int salario){
     this.id= id;
     this.nome = nome;
     this.cargo = cargo;
     this.salario = salario;
 }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public static String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}