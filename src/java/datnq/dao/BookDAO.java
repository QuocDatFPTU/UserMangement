/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datnq.dao;

import datnq.dto.UserDTO;
import datnq.shopping.Book;
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
public class BookDAO {
     public List<Book> getListBook(String search) throws SQLException {
        List<Book> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DbUtil.getConnection();
            if (conn != null) {
                String sql = "SELECT * "
                        + " FROM tblProducts "
                        + " WHERE productName like ? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + search + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                   String productName = rs.getString("productName");
                   String description = rs.getString("description");
                   float price = rs.getFloat("price");
                   int quantity = rs.getInt("quantity");
                   Date createDate = rs.getDate("createDate");
                   String img = rs.getString("img");
                   list.add(new Book(productName, description, price, quantity, createDate, img));
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
}
