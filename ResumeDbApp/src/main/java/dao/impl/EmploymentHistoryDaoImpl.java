/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import dao.inter.AbstractDAO;
import dao.inter.EmploymentHistoryDaoInter;

import entity.EmploymentHistory;
import entity.User;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmploymentHistoryDaoImpl extends AbstractDAO implements EmploymentHistoryDaoInter {
    private EmploymentHistory getEmploymentHistory(ResultSet rs) throws Exception {
        String header = rs.getString("header");
        Date beginDate = rs.getDate("beginDate");
        Date endDate = rs.getDate("endDate");
        String jobDescription = rs.getString("jobDescription");
        int userId = rs.getInt("user_id");
        EmploymentHistory emp = new EmploymentHistory(null,header,beginDate,endDate,jobDescription,new User(userId));
        return emp;
    }

    @Override
    public List<EmploymentHistory> getAllEmploymetnHistoryByUserId(int userId) {
        List<EmploymentHistory> result = new ArrayList<>();
        try (Connection c = connect()) {

            PreparedStatement stmt = c.prepareStatement("SELECT * FROM employment_history WHERE user_id = ?");
            stmt.setInt(1,userId);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                EmploymentHistory emp = getEmploymentHistory(rs);
                result.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }



}