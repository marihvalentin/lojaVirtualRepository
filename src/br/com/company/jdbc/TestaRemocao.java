package com.company;

import com.company.jdbc.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao
{
    public static void main(String[] args) throws SQLException
    {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.recuperarConexao();

        PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
        stm.setInt(1, 2);
        stm.execute();

        //quantas linhas foram modificadas após o uso do statement
        Integer linhasModificadas = stm.getUpdateCount();

        System.out.println("Quantidade de linhas que foram modificadas: " + linhasModificadas);
    }
}
