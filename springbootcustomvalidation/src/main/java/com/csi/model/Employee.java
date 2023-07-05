package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue
    private int empId;

    @Size(min = 2, message = "Employee First Name sholuld be atleast 2 character")
    private String empFirstName;

    @Pattern(regexp="[A-Za-z]*", message="Employee Last name should not contain space and special characters")
    private String empLastName;

    private String empAddress;

    private double empSalary;

    @Range(min = 1000000000, max = 9999999999L, message = "Employee Contact Number must be 10 digit")
    @Column(unique = true)
    private long empContactNumber;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date empDOB;

    @Email(message = "Email Id must be valid")
    @Column(unique = true)
    private String empEmailId;

    @Size(min = 4, message = "Password should be atleast 4 character")
    private String empPassword;
}
