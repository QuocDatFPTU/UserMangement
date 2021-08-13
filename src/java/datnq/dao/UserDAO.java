/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datnq.dao;

import datnq.dto.UserDTO;
import datnq.util.DbUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Quoc Dat
 */
public class UserDAO {

    public UserDTO checkLogin(String userID, String password) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DbUtil.getConnection();
            if (conn != null) {
                String sql = "SELECT name, roleID "
                        + " FROM tblUsers "
                        + " WHERE userID =? AND password =? AND statusID = '1' ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                stm.setString(2, password);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String fullName = rs.getString("name");
                    int roleID = rs.getInt("roleID");
                    user = new UserDTO(userID, "***", fullName, roleID);
                }
            }
        } catch (Exception e) {

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return user;
    }

    public List<UserDTO> getListUser(String search) throws SQLException {
        List<UserDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DbUtil.getConnection();
            if (conn != null) {
                String sql = "SELECT * "
                        + " FROM tblUsers "
                        + " WHERE name like ? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + search + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("userID");
                    String name = rs.getString("name");
                    String phone = rs.getString("phone");
                    String address = rs.getString("address");
                    Date createDate = rs.getDate("createDate");
                    int statusID = rs.getInt("statusID");
                    int roleID = rs.getInt("roleID");
                    String password = ("****");
                    list.add(new UserDTO(userID, name, password, phone, address, createDate, roleID, statusID));
                }
            }
        } catch (Exception e) {

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public boolean delete(String userID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DbUtil.getConnection();
            if (conn != null) {
                String sql = "update tblUsers "
                        + " Set statusID = '0'"
                        + " where userID = '" + userID + "'";
                stm = conn.prepareStatement(sql);
                check = stm.executeUpdate() == 0 ? false : true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

//    public static void main(String[] args) throws SQLException {
//        UserDAO dao = new UserDAO();
//        boolean check =dao.delete("dat@gmail.com");
//        System.out.println(check);
//    }
    public boolean update(UserDTO user) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DbUtil.getConnection();
            if (conn != null) {
                String sql = "update tblUsers\n"
                        + "Set name = ?,\n"
                        + "phone = ?,\n"
                        + "address = ?\n"
                        + "\n" +
                "where userID = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, user.getName());
                stm.setString(2, user.getPhone());
                stm.setString(3, user.getAddress());
                stm.setString(4, user.getUserID());
                check = stm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
    public boolean checkDuplicate(String userID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DbUtil.getConnection();
            if (conn != null) {
                String sql = " SELECT userID"
                        + " FROM tblUsers"
                        + " WHERE userID=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }

        }
        return check;
    }
    
    public boolean insertUser(UserDTO user) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = DbUtil.getConnection();
            String sql = " INSERT INTO tblUSers(userID, name, password, phone, address, createDate, roleID, statusID) "
                    + " VALUES(?,?,?,?,?,?,?,?) ";
            stm = conn.prepareStatement(sql);
            stm.setString(1, user.getUserID());
            stm.setString(2, user.getName());
            stm.setString(3, user.getPassword());
            stm.setString(4, user.getPhone());
            stm.setString(5, user.getAddress());
            stm.setDate(6, user.getCreateDate());
            stm.setInt(7, user.getRoleID());
            stm.setInt(8, user.getStatusID());
            check = stm.executeUpdate() > 0;
        } catch (Exception e) {
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
    
}
