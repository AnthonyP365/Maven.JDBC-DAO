package models;

import daos.IntDAO;
import service.Database;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO implements IntDAO<DTO> {
    private Connection connection = Database.getConnection();

    private DTO extractUserFromResultSet(ResultSet rs) throws SQLException {
        DTO dto = new DTO();

        dto.setId(rs.getInt("id"));
        dto.setMake(rs.getString("make"));
        dto.setModel(rs.getString("model"));
        dto.setYear(rs.getInt("year"));
        dto.setColor(rs.getString("color"));

        return dto;
    }

    @Override
    public DTO findById(int id) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM car WHERE id=" + id);
            if (rs.next()) {
                return extractUserFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<DTO> findAll() {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM car");

            List<DTO> listOfCars = new ArrayList<>();

            while (rs.next()) {
                DTO dto = extractUserFromResultSet(rs);
                listOfCars.add(dto);
            }
            return listOfCars;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean update(DTO dto) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE car SET make=?, model=?, year=?, color=? WHERE id=?");
            ps.setString(1, dto.getMake());
            ps.setString(2, dto.getModel());
            ps.setInt(3, dto.getYear());
            ps.setString(4, dto.getColor());
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean create(DTO dto) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO car VALUES (NULL, ?, ?, ?)");
            ps.setString(1, dto.getMake());
            ps.setString(2, dto.getModel());
            ps.setInt(3, dto.getYear());
            ps.setString(4, dto.getColor());
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean delete(int id) {
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM car WHERE id=" + id);
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
