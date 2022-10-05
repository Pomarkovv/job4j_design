package ru.job4j.jdbc;

import java.io.FileInputStream;
import java.io.InputStream;
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
        getStatement(String.format("create table if exists %s(%s);", tableName, "id serial primary key"));
    }

    public void dropTable(String tableName) {
        getStatement(String.format("drop table %s", tableName));
    }

    public void addColumn(String tableName, String columnName, String type) {
        getStatement(String.format("alter table %s ADD %s %s", tableName, columnName, type));
    }

    public void dropColumn(String tableName, String columnName) {
        getStatement(String.format("alter table %s drop column %s", tableName, columnName));
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        getStatement(String.format("alter table %s rename column %s to %s", tableName, columnName, newColumnName));
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

    public static void main(String[] args) {
        Properties config = new Properties();
        try (InputStream fis = new FileInputStream("./src/main/resources/app.properties")) {
            config.load(fis);
            try (TableEditor testTable = new TableEditor(config)) {
                testTable.createTable("testDB");
                System.out.println(getTableScheme(testTable.connection, "testDB"));
                testTable.addColumn("testDB", "date", "date");
                System.out.println(getTableScheme(testTable.connection, "testDB"));
                testTable.dropColumn("testDB", "date");
                System.out.println(getTableScheme(testTable.connection, "testDB"));
                testTable.renameColumn("testDB", "id", "index");
                System.out.println(getTableScheme(testTable.connection, "testDB"));
                testTable.dropTable("testDB");
                System.out.println(getTableScheme(testTable.connection, "testDB"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }