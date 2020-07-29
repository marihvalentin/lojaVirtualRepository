package br.com.company.jdbc;

import br.com.company.jdbc.dao.ProdutoDAO;
import br.com.company.jdbc.factory.ConnectionFactory;
import br.com.company.jdbc.modelo.Produto;

import java.sql.*;

public class TestaInsercaoComProduto
{
    public static void main(String[] args) throws SQLException
    {
        Produto comoda = new Produto("Cômoda","Cômoda Vertical");

        try(Connection connection = new ConnectionFactory().recuperarConexao())
        {
            ProdutoDAO produtoDAO = new ProdutoDAO(connection);
            new ProdutoDAO(connection).salvar(comoda);
            //Lista = persistenciaProduto.listar();
        }

        System.out.println(comoda);
    }
}
