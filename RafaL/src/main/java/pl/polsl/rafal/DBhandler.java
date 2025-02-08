package pl.polsl.rafal;

import java.sql.*;

public class DBhandler {
    Connection db = null;
    Statement statement = null;
    static final String DB_URL = "jdbc:mysql://157.158.57.40:3306/laboratory_db";
    static final String USER = "student";
    static final String PASS = "student";

    void connectToDB() {
        try {
            db = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Polaczono z DB!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Blad polaczenia!");
        }
    }

    void createBasicStatment() {
        try {
            statement = db.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void createTable() {

        String createTableSQL = "CREATE TABLE RG_2025 ("
                + "id INT (11), "
                + "name VARCHAR(30), "
                + "surname VARCHAR(30), "
                + "country VARCHAR(30), "
                + "age INT(11), "
                + "email VARCHAR(30))";

        try (Statement statement = db.createStatement()) {
            statement.executeUpdate(createTableSQL);
            System.out.println("Tabela zostala utworzona!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Blad podczas tworzenia tabeli!");
        }
    }

    void insertRecord(int id, String name, String surname, String country, int age, String email) {
        String insertSQL = "INSERT INTO RG_2025 (id, name, surname, country, age, email) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = db.prepareStatement(insertSQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, surname);
            preparedStatement.setString(4, country);
            preparedStatement.setInt(5, age);
            preparedStatement.setString(6, email);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rekord został wstawiony!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Blad podczas wstawiania rekordu!");
        }
    }

    void selectFromDB() {
        String QUERY_SELECT = "SELECT * FROM RG_2025";

        try (PreparedStatement preparedStatement = db.prepareStatement(QUERY_SELECT);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String country = resultSet.getString("country");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");

                System.out.println("ID: " + id + ", Name: " + name + ", Surname: " + surname +
                        ", Country: " + country + ", Age: " + age + ", Email: " + email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Blad podczas pobierania rekordów!");
        }
    }

    void updateRecord(int id, String name, String surname, String country, int age, String email) {
        String updateSQL = "UPDATE RG_2025 SET name = ?, surname = ?, country = ?, age = ?, email = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = db.prepareStatement(updateSQL)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, country);
            preparedStatement.setInt(4, age);
            preparedStatement.setString(5, email);
            preparedStatement.setInt(6, id);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rekord został zaktualizowany! Liczba zaktualizowanych wierszy: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Blad podczas aktualizacji rekordu!");
        }
    }


    void deleteRecordById(int id) {
        String deleteSQL = "DELETE FROM RG_2025 WHERE id = ?";

        try (PreparedStatement preparedStatement = db.prepareStatement(deleteSQL)) {
            preparedStatement.setInt(1, id);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Wiersz zostal usuniety! Liczba usunietych wierszy: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Blad podczas usuwania wiersza!");
        }
    }

    void dropTable() {
        String dropTableSQL = "DROP TABLE RG_2025";

        try (Statement statement = db.createStatement()) {
            statement.executeUpdate(dropTableSQL);
            System.out.println("Tabela zostala usunieta pomyslnie!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Blad podczas usuwania tabeli!");
        }
    }
}
