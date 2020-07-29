package br.com.company.jdbc;

import br.com.company.jdbc.dao.CategoriaDAO;
import br.com.company.jdbc.factory.ConnectionFactory;
import br.com.company.jdbc.modelo.Categoria;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestaListagemDeCategorias
{
    public static void main(String[] args) throws SQLException
    {
        try(Connection connection = new ConnectionFactory().recuperarConexao())
        {
            CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
            List<Categoria> listaCategorias = categoriaDAO.listar();
            listaCategorias.stream().forEach(ct -> System.out.println(ct.getNome()));
        }
    }
}
