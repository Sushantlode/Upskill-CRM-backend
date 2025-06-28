package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
  StudentRepository repo;

  

    public Student createStudent(Student student) {
        return repo.save(student);
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student getStudentById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Student updateStudent(Long id, Student updated) {
        Student existing = getStudentById(id);

        // 🔄 Set fields manually
        existing.setStudentName(updated.getStudentName());
        existing.setEnrollmentDate(updated.getEnrollmentDate());
        existing.setBatchType(updated.getBatchType());
        existing.setStatus(updated.getStatus());
        existing.setEmail(updated.getEmail());
        existing.setMobileNo(updated.getMobileNo());
        existing.setFeesType(updated.getFeesType());
        existing.setCourseName(updated.getCourseName());
        existing.setBatchStartDate(updated.getBatchStartDate());
        existing.setEnquirySource(updated.getEnquirySource());
        existing.setCounselor(updated.getCounselor());
        existing.setTotalFees(updated.getTotalFees());
        existing.setDiscountGiven(updated.getDiscountGiven());
        existing.setChargedFees(updated.getChargedFees());
        existing.setRegistrationAmount(updated.getRegistrationAmount());

        existing.setFirstInstallmentDate(updated.getFirstInstallmentDate());
        existing.setFirstInstallmentAmount(updated.getFirstInstallmentAmount());
        existing.setSecondInstallmentDate(updated.getSecondInstallmentDate());
        existing.setSecondInstallmentAmount(updated.getSecondInstallmentAmount());
        existing.setThirdInstallmentDate(updated.getThirdInstallmentDate());
        existing.setThirdInstallmentAmount(updated.getThirdInstallmentAmount());
        existing.setFourthInstallmentDate(updated.getFourthInstallmentDate());
        existing.setFourthInstallmentAmount(updated.getFourthInstallmentAmount());

        existing.setBalanceFees(updated.getBalanceFees());
        existing.setQualification(updated.getQualification());
        existing.setPassoutYear(updated.getPassoutYear());
        existing.setCollegeName(updated.getCollegeName());
        existing.setParentName(updated.getParentName());
        existing.setParentMobile(updated.getParentMobile());
        existing.setRemark(updated.getRemark());
        existing.setInternshipId(updated.getInternshipId());
        existing.setDob(updated.getDob());
        existing.setImage(updated.getImage());
        existing.setImageType(updated.getImageType());

        return repo.save(existing);
    }


    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }
}
