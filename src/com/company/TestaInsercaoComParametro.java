package com.company;

import java.sql.*;

public class TestaInsercaoComParametro
{
    public static void main(String[] args) throws SQLException
    {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.recuperarConexao();
        connection.setAutoCommit(false);
        PreparedStatement stm = connection.prepareStatement
                ("INSERT INTO PRODUTO (nome, descricao) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);

        adicionarVariavel("SmartTV", "45 polegadas", stm);
        adicionarVariavel("Radio", "Radio de Bateria",stm);
        return;
    }

    private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
        stm.setString(1, nome);
        stm.setString(2, descricao);

        /*if (nome.equals("Radio"))
        {
            throw new RuntimeException("Não foi possível adicionar o produto");
        }*/

        stm.execute();

        ResultSet rst = stm.getGeneratedKeys();
        while (rst.next())
        {
            Integer id = rst.getInt(1);
            System.out.println("O ID criado foi: " + id);

        }
        rst.close();
    }
}
