package com.example.library.Models;


import jakarta.persistence.*;




@Entity
@Table(name = "Library")
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "address", nullable = false, length = 200)
    private String address;

    @Column(name = "working_hours", nullable = false, length = 100, columnDefinition = "VARCHAR(100) DEFAULT '9:00 AM - 5:00 PM'")
    private String workingHours;

    @Column(name = "staff_count", nullable = false)
    private int staffCount;

    @Column(name = "foundation_year", nullable = false)
    private int foundationYear;

    // Конструкторы, геттеры и сеттеры

    public Library() {
    }

    public Library(String name, String address, String workingHours, int staffCount, int foundationYear) {
        this.name = name;
        this.address = address;
        this.workingHours = workingHours;
        this.staffCount = staffCount;
        this.foundationYear = foundationYear;
    }

    // Геттеры и сеттеры для всех полей

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    public int getStaffCount() {
        return staffCount;
    }

    public void setStaffCount(int staffCount) {
        this.staffCount = staffCount;
    }

    public int getFoundationYear() {
        return foundationYear;
    }

    public void setFoundationYear(int foundationYear) {
        this.foundationYear = foundationYear;
    }
}
