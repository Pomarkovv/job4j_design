package ru.job4j.jdbc;

import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) throws ClassNotFoundException, Exception {
        this.properties = properties;
        initConnection();
    }

    public void getStatement(String sql) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void initConnection() throws Exception  {
        Class.forName(properties.getProperty("driver"));
        String url = properties.getProperty("url");
        String login = properties.getProperty("login");
        String password = properties.getProperty("password");
        connection = DriverManager.getConnection(url, login, password);
    }

    public void createTable(String tableName) {
        getStatement("create table if not exists " + tableName + "(id serial primary key, name varchar(255));");
    }

    public void dropTable(String tableName) {
        getStatement("drop table " + tableName);
    }

    public void addColumn(String tableName, String columnName, String type) {
        getStatement("alter table " + tableName + " ADD " + columnName + " " + type);
    }

    public void dropColumn(String tableName, String columnName) {
        getStatement("alter table " + tableName + " drop column " + columnName);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        getStatement("alter table " + tableName + " rename column " + columnName + " to " + newColumnName);
    }


    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}