package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUDMethods {
    private static final String INSERT = "INSERT INTO car_owners (login, car_brand, car_model) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE car_owners SET car_brand = ?, car_model = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM car_owners WHERE login = ?";

    public static void create(Users users) {
        try (Connection connection = DBUtils.connectToDB(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {

            preparedStatement.setString(1, users.getLogin());
            preparedStatement.setString(2, users.getCar_brand());
            preparedStatement.setString(3, users.getCar_model());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Users> read(String query) {

        List<Users> users = new ArrayList<>();

        try (Connection connection = DBUtils.connectToDB(); Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String login = rs.getString("login");
                String car_brand = rs.getString("car_brand");
                String car_model = rs.getString("car_model");

                users.add(new Users(id, login, car_brand, car_model));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;
    }

    public static void updateCar(int userID, String car_brand, String car_model) {

        try (Connection connection = DBUtils.connectToDB(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {

            preparedStatement.setString(1, car_brand);
            preparedStatement.setString(2, car_model);
            preparedStatement.setInt(3, userID);

            preparedStatement.executeUpdate();

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void delete(Users user){

        try (Connection connection = DBUtils.connectToDB(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {

            preparedStatement.setString(1, user.getLogin());

            preparedStatement.executeUpdate();

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void delete(String login){

        try (Connection connection = DBUtils.connectToDB(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {

            preparedStatement.setString(1, login);

            preparedStatement.executeUpdate();

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

