package com.ngm;

// import javax.persistence.*;
import jakarta.persistence.*;

@Entity
@Table(name = "contacts")
public class Contact  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String fname;

    @Column(name = "last_name")
    private String lname;

    @Column(name = "phone_number")
    private String phone;

    // Constructors, getters, and setters

    public Contact() {
    }

    public Contact(String fname, String lname, String phone) {
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
