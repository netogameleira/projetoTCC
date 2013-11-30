/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vendas;

import Produto.Produto;
import Vendedor.Vendedor;
import java.sql.Date;


/**
 *
 * @author neto2_000
 */
public class Venda {
    private int idc;
    private int idp;
    private int idv;
    private String data;
    private int quantidade;
    private String nomeProduto;
    private String nomeVendedor;


    public Venda(int idc, int idp, int idv, String data, int quantidade, String nomeProduto, String nomeVendedor) {
        this.idc = idc;
        this.idp = idp;
        this.idv = idv;
        this.data = data;
        this.quantidade = quantidade;
        this.nomeProduto = nomeProduto;
        this.nomeVendedor = nomeVendedor;
    }
    
    public Venda(Produto produto, Vendedor vendedor){
    
    };

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    
    public void setIdc(int idc) {
        this.idc = idc;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    public int getIdc() {
        return idc;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getIdp() {
        return idp;
    }

    public int getIdv() {
        return idv;
    }

    public String getData() {
        return data;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public double valorTotal(Produto produto ){
        return this.quantidade* produto.getPreco();
    }
    
    @Override
    public String toString() {
        return "Compra{" + "Idc=" + idc + ", Idp=" + idp + ", idcl=" + idv + ", data=" + data + '}';
    }

}
