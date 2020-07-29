package br.com.company.jdbc;

import br.com.company.jdbc.dao.ProdutoDAO;
import br.com.company.jdbc.factory.ConnectionFactory;
import br.com.company.jdbc.modelo.Produto;
import java.sql.*;
import java.util.List;

public class TestaInsercaoEListagemComProduto
{
    public static void main(String[] args) throws SQLException
    {
        Produto comoda = new Produto("Cômoda","Cômoda Vertical");

        try(Connection connection = new ConnectionFactory().recuperarConexao()) {
            ProdutoDAO produtoDAO = new ProdutoDAO(connection);
            produtoDAO.salvar(comoda);
            List<Produto> listaDeProdutos = produtoDAO.listar();
            listaDeProdutos.stream().forEach(lp -> System.out.println(lp));
        }

        System.out.println(comoda);
    }
}
