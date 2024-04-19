package models;

import daos.IntDAO;
import service.Database;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO implements IntDAO<DTO> {


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
            PreparedStatement stmt = Database.getConnection().prepareStatement("SELECT * FROM car WHERE id=" + id);
            ResultSet rs = stmt.executeQuery();
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
            PreparedStatement stmt = Database.getConnection().prepareStatement("SELECT * FROM car");
            ResultSet rs = stmt.executeQuery();

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
            PreparedStatement stmt = Database.getConnection().prepareStatement("UPDATE car SET make=?, model=?, year=?, color=? WHERE id=?");
            stmt.setString(1, dto.getMake());
            stmt.setString(2, dto.getModel());
            stmt.setInt(3, dto.getYear());
            stmt.setString(4, dto.getColor());
            stmt.setInt(5, dto.getId());
            int i = stmt.executeUpdate();
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
            PreparedStatement stmt = Database.getConnection().prepareStatement("INSERT INTO car (make, model, year, color) VALUES (?, ?, ?, ?)");
            stmt.setString(1, dto.getMake());
            stmt.setString(2, dto.getModel());
            stmt.setInt(3, dto.getYear());
            stmt.setString(4, dto.getColor());
            int i = stmt.executeUpdate();
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
            Statement stmt = Database.getConnection().createStatement();
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
