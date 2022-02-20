/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import dao.impl.EmploymentHistoryDaoImpl;
import dao.inter.EmploymentHistoryDaoInter;
import dao.inter.SkillDaoInter;
import entity.User;
import dao.inter.UserDaoInter;
import dao.inter.UserSkillDaoInter;

/**
 *
 * @author Resad
 */
public class Main {
    public static void main(String[] args) throws Exception{
        SkillDaoInter userDao=Context.instanceSkillDao();
        System.out.println(userDao.getAll());
        
    }
}
