package db;

import util.CsvReader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DbWorker {
    public static void populateFromFile(String fileName) {
        List<String[]> strings = CsvReader.readCsvFile(fileName, ";");
        Connection conn = DbConnection.getConnection();
        try {
            Statement cleaner = conn.createStatement();
            System.out.println(cleaner.executeUpdate("DELETE FROM monitor"));
            System.out.println(cleaner.executeUpdate("DELETE FROM television"));
            PreparedStatement monitorSt = conn.prepareStatement(
                    "INSERT INTO monitor (model_name, diagonal, resolution,time_response) " +
                            "VALUES (?, ?, ?, ?)");
            PreparedStatement televisionSt = conn.prepareStatement(
                    "INSERT INTO television (model_name, diagonal, resolution, price, type_led) " +
                            "VALUES (?, ?, ?, ?, ?)");

            for (String[] line: strings) {
                if (line[0].equals("0")) {
                    televisionSt.setString(1, line[1]);
                    televisionSt.setDouble(2, Double.parseDouble(line[2]));
                    televisionSt.setString(3, line[3]);
                    televisionSt.setInt(4, Integer.parseInt(line[4]));;
                    televisionSt.setString(5, line[5]);
                    televisionSt.addBatch();
                } else {
                    monitorSt.setString(1, line[1]);
                    monitorSt.setDouble(2, Double.parseDouble(line[2]));
                    monitorSt.setString(3, line[3]);
                    monitorSt.setInt(4, Integer.parseInt(line[4]));
                    monitorSt.addBatch();
                }
            }
            int[] telRes = televisionSt.executeBatch();
            int[] monRes = monitorSt.executeBatch();
            for (int num: monRes) {
                System.out.println(num);
            }

            for (int num: telRes) {
                System.out.println(num);
            }
            cleaner.close();
            monitorSt.close();
            televisionSt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void demoQuery() {
        Connection conn = DbConnection.getConnection();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM monitor WHERE time_response < 10");
            while (rs.next()) {
                System.out.print(rs.getString("model_name"));
                System.out.print(" ");
                System.out.print(rs.getString("diagonal"));
                System.out.print(" ");
                System.out.println(rs.getString("resolution"));
                System.out.print(" ");
                System.out.println(rs.getString("type_led"));

            }
            rs.close();
            st.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void dirtyReadDemo() {
        Runnable first = () -> {
            Connection conn1 = DbConnection.getNewConnection();
            if (conn1 != null) {
                try {
                    conn1.setAutoCommit(false);
                    conn1.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
                    Statement upd = conn1.createStatement();
                    upd.executeUpdate("UPDATE television SET type_led='QLED' WHERE type_led='LED'");
                    Thread.sleep(2000);
                    conn1.rollback();
                    upd.close();
                    Statement st = conn1.createStatement();
                    System.out.println("In the first thread:");
                    ResultSet rs = st.executeQuery("SELECT * FROM television");
                    while (rs.next()) {
                        System.out.println(rs.getString("type_led"));
                    }
                    st.close();
                    rs.close();
                    conn1.close();
                } catch (SQLException | InterruptedException throwables) {
                    throwables.printStackTrace();
                }
            }
        };

        Runnable second = () -> {
            Connection conn2 = DbConnection.getNewConnection();
            if (conn2 != null) {
                try {
                    Thread.sleep(500);
                    conn2.setAutoCommit(false);
                    conn2.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
                    Statement st = conn2.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM television");
                    while (rs.next()) {
                        System.out.println(rs.getString("type_led"));
                    }
                    rs.close();
                    st.close();
                    conn2.close();
                } catch (SQLException | InterruptedException throwables) {
                    throwables.printStackTrace();
                }
            }
        };
        Thread th1 = new Thread(first);
        Thread th2 = new Thread(second);
        th1.start();
        th2.start();
    }
}
