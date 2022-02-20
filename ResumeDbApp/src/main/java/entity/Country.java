/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Resad
 */
public class Country {
    private int id;
    private String name;
    private String nationalty;

    public Country() {
    }

    public Country(int id, String name, String nationalty) {
        this.id = id;
        this.name = name;
        this.nationalty = nationalty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationalty() {
        return nationalty;
    }

    public void setNationalty(String nationalty) {
        this.nationalty = nationalty;
    }

    @Override
    public String toString() {
        return "Country{" + "id=" + id + ", name=" + name + ", nationalty=" + nationalty + '}';
    }

  
    
}
