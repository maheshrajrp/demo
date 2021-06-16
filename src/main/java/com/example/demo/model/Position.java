package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Position {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "positionname")
    private String positionName;
    @OneToOne(mappedBy = "position",cascade=CascadeType.ALL)
    private Employee employee;

    public Position(int id, String positionName, Employee employee) {
        this.id = id;
        this.positionName = positionName;
        this.employee = employee;
    }

    public Position() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", positionName='" + positionName + '\'' +
                ", employee=" + employee +
                '}';
    }
}
