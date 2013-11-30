/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vendedor;

/**
 *
 * @author neto2_000
 */
public class Vendedor {
    private int Idv;
    private String senha;
    private String login;
    private String nome;

    public Vendedor(String senha, String login, String nome) {
        this.senha = senha;
        this.login = login;
        this.nome = nome;
    }

    public Vendedor(int Idv,String nome, String login, String senha) {
        this.Idv = Idv;
        this.senha = senha;
        this.login = login;
        this.nome = nome;
    }
    
    public String getLogin() {
        return login;
    }
    
    public String getSenha() {
        return senha;
    }

    public int getIdv() {
        return Idv;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setIdv(int Idv) {
        this.Idv = Idv;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Vendedor{" + "Idcl=" + Idv + ", senha=" + senha + ", login=" + login + ", nome=" + nome + '}';
    }
}
