package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    private String studentName;
    private LocalDate enrollmentDate;
    private String batchType;
    private String status;
    private String email;
    private String mobileNo;
    private String feesType;
    private String courseName;
    private LocalDate batchStartDate;
    private String enquirySource;
    private String counselor;
    private Double totalFees;
    private Double discountGiven;
    private Double chargedFees;
    private Double registrationAmount;

    private LocalDate firstInstallmentDate;
    private Double firstInstallmentAmount;

    private LocalDate secondInstallmentDate;
    private Double secondInstallmentAmount;

    private LocalDate thirdInstallmentDate;
    private Double thirdInstallmentAmount;

    private LocalDate fourthInstallmentDate;
    private Double fourthInstallmentAmount;

    private Double balanceFees;

    private String qualification;
    private Integer passoutYear;
    private String collegeName;

    private String parentName;
    private String parentMobile;

    private String remark;
    private String internshipId;

    // Optional: Profile picture
    private String imageType;

    @Lob
    private byte[] image;

    private LocalDate dob;

	@ManyToOne
	@JsonManagedReference
@JoinColumn(name = "batch_name", referencedColumnName = "batch_name")
private Batch batch;

    
 
	




}
