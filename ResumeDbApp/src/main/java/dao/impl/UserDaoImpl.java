/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import entity.Country;
import entity.Skill;
import entity.User;
import entity.UserSkill;
import dao.inter.AbstractDAO;
import dao.inter.UserDaoInter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Resad
 */
public class UserDaoImpl extends AbstractDAO implements UserDaoInter {
    private User getUser(ResultSet rs)throws Exception{
        int id=rs.getInt("id");
            String name=rs.getString("name");
            String surname=rs.getString("surname");
            String phone=rs.getString("phone");
            String email=rs.getString("email");
            int nationalityId=rs.getInt("nationality_id");
            int birthplaceId=rs.getInt("birthplace_id");
            String nationalityStr=rs.getString("nationality");
            String birthPlaceStr=rs.getString("birthplace");
            Date birthDate=rs.getDate("birthdate");
            Country nationality=new Country(nationalityId,null,nationalityStr);
            Country birthplace=new Country(birthplaceId,birthPlaceStr,null);
            
            return (new User(id,name,surname,phone,email,birthDate,nationality,birthplace));
    }

    @Override
    public List<User> getAll(){
        List<User> result=new ArrayList<>();
        try(Connection c=connect()){
        Statement stm=c.createStatement();
        stm.execute("SELECT u.*, " +
"n.nationality, " +
"c.name as birthplace " +
"from user u " +
"left join country n on u.nationality_id=n.id  " +
"LEFT JOIN country c on u.birthplace_id =c.id");
        
        ResultSet rs=stm.getResultSet();
        while(rs.next()){
            User u=getUser(rs);
            
            result.add(u);
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        return result; 
    }

    @Override
    public boolean updateUser(User u) {
        try(Connection c=connect()) {
       
            PreparedStatement stm=c.prepareStatement("update user set name=?,surname=?,phone=?,email=? where id=?");
            stm.setString(1, u.getName());
            stm.setString(2, u.getSurname());
            stm.setString(3, u.getPhone());
            stm.setString(4, u.getEmail());
            
            stm.setInt(5, u.getId());
            return stm.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
         }
    }

    @Override
    public boolean removeUser(int id) {
        try(Connection c=connect()) {
            
            Statement stm=c.createStatement();
           return stm.execute("delete from user where id = "+id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
         } }

    @Override
    public User getById(int userId) {
        User result=null;
        try(Connection c=connect()){
        Statement stm=c.createStatement();
        stm.execute("SELECT u.*, " +
"n.nationality, " +
"c.name as birthplace " +
"from user u " +
"left join country n on u.nationality_id=n.id  " +
"LEFT JOIN country c on u.birthplace_id =c.id where u.id="+userId);
        ResultSet rs=stm.getResultSet();
        while(rs.next()){
            
            result=getUser(rs);
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        return result; 
        }

    @Override
    public boolean addUser(User u) {
        try(Connection c=connect()) {
       
            PreparedStatement stm=c.prepareStatement("insert into user(name,surname,phone,email) values(?,?,?,?)");
            stm.setString(1, u.getName());
            stm.setString(2, u.getSurname());
            stm.setString(3, u.getPhone());
            stm.setString(4, u.getEmail());
            
            return stm.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
   
    
    
    
   
}}}
