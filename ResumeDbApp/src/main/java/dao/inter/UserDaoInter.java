/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.inter;

import entity.User;
import entity.UserSkill;
import java.util.List;

/**
 *
 * @author Resad
 */
public interface UserDaoInter {
    public List<User> getAll();
    public User getById(int id);
    public boolean addUser(User u);
    public boolean updateUser(User u);
    public boolean removeUser(int id);
}
