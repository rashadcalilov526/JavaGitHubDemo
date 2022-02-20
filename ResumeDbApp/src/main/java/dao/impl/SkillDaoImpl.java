/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import dao.inter.AbstractDAO;
import dao.inter.SkillDaoInter;
import entity.Country;
import entity.Skill;
import entity.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Resad
 */
public class SkillDaoImpl extends AbstractDAO implements SkillDaoInter
{
private Skill getSkill(ResultSet rs)throws Exception{
        String name=rs.getString("name");
        
            
            return (new Skill(name));
    }
    @Override
    public List<Skill> getAll() {
        List<Skill> result=new ArrayList<>();
        try(Connection c=connect()){
        Statement stm=c.createStatement();
        stm.execute("SELECT name FROM skill");
        
        ResultSet rs=stm.getResultSet();
        while(rs.next()){
            Skill u=getSkill(rs);
            
            result.add(u);
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

}
