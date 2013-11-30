/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Produto;

/**
 *
 * @author neto2_000
 */
public class Produto {
    private int idp; 
    private String nome;
    private int estoque;
    private double preco;

    public Produto(int idp, String nome, int estoque, double preco) {
        this.idp = idp;
        this.nome = nome;
        this.estoque = estoque;
        this.preco = preco;
    }

    public Produto(String nome, int estoque, double preco) {
        this.nome = nome;
        this.estoque = estoque;
        this.preco = preco;
    }
    
    public int getIdp() {
        return idp;
    }

    public String getNome() {
        return nome;
    }

    public int getEstoque() {
        return estoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" + "idp=" + idp + ", nome=" + nome + ", estoque=" + estoque + ", preco=" + preco + '}';
    }
    
}
