/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import dao.inter.AbstractDAO;
import dao.inter.CountryDaoInter;
import entity.Country;
import entity.Skill;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Resad
 */
public class CountryDaoImpl extends AbstractDAO implements CountryDaoInter
{

    private Country getCountry(ResultSet rs)throws Exception{
        int id=rs.getInt("id");
        String name=rs.getString("name");
        String nationality=rs.getString("nationality");
        
            
            return (new Country(id,name,nationality));
    }
    @Override
    public List<Country> getAll() {
        List<Country> result=new ArrayList<>();
        try(Connection c=connect()){
        Statement stm=c.createStatement();
        stm.execute("SELECT name FROM country");
        
        ResultSet rs=stm.getResultSet();
        while(rs.next()){
            Country u=getCountry(rs);
            
            result.add(u);
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
