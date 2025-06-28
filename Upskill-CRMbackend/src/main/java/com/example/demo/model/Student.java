package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "students")
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
    
    public Student() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(LocalDate enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	public String getBatchType() {
		return batchType;
	}

	public void setBatchType(String batchType) {
		this.batchType = batchType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getFeesType() {
		return feesType;
	}

	public void setFeesType(String feesType) {
		this.feesType = feesType;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public LocalDate getBatchStartDate() {
		return batchStartDate;
	}

	public void setBatchStartDate(LocalDate batchStartDate) {
		this.batchStartDate = batchStartDate;
	}

	public String getEnquirySource() {
		return enquirySource;
	}

	public void setEnquirySource(String enquirySource) {
		this.enquirySource = enquirySource;
	}

	public String getCounselor() {
		return counselor;
	}

	public void setCounselor(String counselor) {
		this.counselor = counselor;
	}

	public Double getTotalFees() {
		return totalFees;
	}

	public void setTotalFees(Double totalFees) {
		this.totalFees = totalFees;
	}

	public Double getDiscountGiven() {
		return discountGiven;
	}

	public void setDiscountGiven(Double discountGiven) {
		this.discountGiven = discountGiven;
	}

	public Double getChargedFees() {
		return chargedFees;
	}

	public void setChargedFees(Double chargedFees) {
		this.chargedFees = chargedFees;
	}

	public Double getRegistrationAmount() {
		return registrationAmount;
	}

	public void setRegistrationAmount(Double registrationAmount) {
		this.registrationAmount = registrationAmount;
	}

	public LocalDate getFirstInstallmentDate() {
		return firstInstallmentDate;
	}

	public void setFirstInstallmentDate(LocalDate firstInstallmentDate) {
		this.firstInstallmentDate = firstInstallmentDate;
	}

	public Double getFirstInstallmentAmount() {
		return firstInstallmentAmount;
	}

	public void setFirstInstallmentAmount(Double firstInstallmentAmount) {
		this.firstInstallmentAmount = firstInstallmentAmount;
	}

	public LocalDate getSecondInstallmentDate() {
		return secondInstallmentDate;
	}

	public void setSecondInstallmentDate(LocalDate secondInstallmentDate) {
		this.secondInstallmentDate = secondInstallmentDate;
	}

	public Double getSecondInstallmentAmount() {
		return secondInstallmentAmount;
	}

	public void setSecondInstallmentAmount(Double secondInstallmentAmount) {
		this.secondInstallmentAmount = secondInstallmentAmount;
	}

	public LocalDate getThirdInstallmentDate() {
		return thirdInstallmentDate;
	}

	public void setThirdInstallmentDate(LocalDate thirdInstallmentDate) {
		this.thirdInstallmentDate = thirdInstallmentDate;
	}

	public Double getThirdInstallmentAmount() {
		return thirdInstallmentAmount;
	}

	public void setThirdInstallmentAmount(Double thirdInstallmentAmount) {
		this.thirdInstallmentAmount = thirdInstallmentAmount;
	}

	public LocalDate getFourthInstallmentDate() {
		return fourthInstallmentDate;
	}

	public void setFourthInstallmentDate(LocalDate fourthInstallmentDate) {
		this.fourthInstallmentDate = fourthInstallmentDate;
	}

	public Double getFourthInstallmentAmount() {
		return fourthInstallmentAmount;
	}

	public void setFourthInstallmentAmount(Double fourthInstallmentAmount) {
		this.fourthInstallmentAmount = fourthInstallmentAmount;
	}

	public Double getBalanceFees() {
		return balanceFees;
	}

	public void setBalanceFees(Double balanceFees) {
		this.balanceFees = balanceFees;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public Integer getPassoutYear() {
		return passoutYear;
	}

	public void setPassoutYear(Integer passoutYear) {
		this.passoutYear = passoutYear;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getParentMobile() {
		return parentMobile;
	}

	public void setParentMobile(String parentMobile) {
		this.parentMobile = parentMobile;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getInternshipId() {
		return internshipId;
	}

	public void setInternshipId(String internshipId) {
		this.internshipId = internshipId;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Student(Long id, String studentName, LocalDate enrollmentDate, String batchType, String status, String email,
			String mobileNo, String feesType, String courseName, LocalDate batchStartDate, String enquirySource,
			String counselor, Double totalFees, Double discountGiven, Double chargedFees, Double registrationAmount,
			LocalDate firstInstallmentDate, Double firstInstallmentAmount, LocalDate secondInstallmentDate,
			Double secondInstallmentAmount, LocalDate thirdInstallmentDate, Double thirdInstallmentAmount,
			LocalDate fourthInstallmentDate, Double fourthInstallmentAmount, Double balanceFees, String qualification,
			Integer passoutYear, String collegeName, String parentName, String parentMobile, String remark,
			String internshipId, String imageType, byte[] image, LocalDate dob) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.enrollmentDate = enrollmentDate;
		this.batchType = batchType;
		this.status = status;
		this.email = email;
		this.mobileNo = mobileNo;
		this.feesType = feesType;
		this.courseName = courseName;
		this.batchStartDate = batchStartDate;
		this.enquirySource = enquirySource;
		this.counselor = counselor;
		this.totalFees = totalFees;
		this.discountGiven = discountGiven;
		this.chargedFees = chargedFees;
		this.registrationAmount = registrationAmount;
		this.firstInstallmentDate = firstInstallmentDate;
		this.firstInstallmentAmount = firstInstallmentAmount;
		this.secondInstallmentDate = secondInstallmentDate;
		this.secondInstallmentAmount = secondInstallmentAmount;
		this.thirdInstallmentDate = thirdInstallmentDate;
		this.thirdInstallmentAmount = thirdInstallmentAmount;
		this.fourthInstallmentDate = fourthInstallmentDate;
		this.fourthInstallmentAmount = fourthInstallmentAmount;
		this.balanceFees = balanceFees;
		this.qualification = qualification;
		this.passoutYear = passoutYear;
		this.collegeName = collegeName;
		this.parentName = parentName;
		this.parentMobile = parentMobile;
		this.remark = remark;
		this.internshipId = internshipId;
		this.imageType = imageType;
		this.image = image;
		this.dob = dob;
	}

    
    
    
	




}
