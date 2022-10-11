package com.example.demo.patiens;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Patiens {
    @Id
    @SequenceGenerator(
            name = "patience_secuence",
            sequenceName = "employee_secuence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )

    private Long  id;
    private String firstName;
    private String lastName;
    private Long cedula;
    private Long phone;
    private String treatment;
    private Long price;
    private LocalDate dob;
    @Transient
    private Integer age;

    public Patiens() {
    }

    public Patiens(Long id, String firstName, String lastName, Long cedula, Long phone, String treatment, Long price, LocalDate dob) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cedula = cedula;
        this.phone = phone;
        this.treatment = treatment;
        this.price = price;
        this.dob = dob;
    }

    public Patiens(String firstName, String lastName, Long cedula, Long phone, String treatment, Long price, LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cedula = cedula;
        this.phone = phone;
        this.treatment = treatment;
        this.price = price;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Patiens{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cedula=" + cedula +
                ", phone=" + phone +
                ", treatment='" + treatment + '\'' +
                ", price=" + price +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
