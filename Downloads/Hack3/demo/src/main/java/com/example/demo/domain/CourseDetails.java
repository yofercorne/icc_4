package com.example.demo.domain;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")



public class CourseDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String score;
    private String section;
    private String sectionGroup;

    @OneToMany(mappedBy = "courseDetails", cascade = CascadeType.ALL)
    private Set<Student> student = new HashSet<>();;

    @OneToMany(mappedBy = "courseDetails", cascade = CascadeType.ALL)
    private Set<Professor> professor = new HashSet<>();;

    @OneToMany(mappedBy = "courseDetails", cascade = CascadeType.ALL)
    private Set<CourseAssessment> courseAssessments = new HashSet<>();;

    public CourseDetails(){}
    public CourseDetails(Long id, String score, String section, String sectioGroup, Set<Professor> professor, Set<Student> student,Set<CourseAssessment> courseAssessments){
        this.courseAssessments = courseAssessments;
        this.id = id;
        this.score = score;
        this.section = section;
        this.sectionGroup = sectioGroup;
        this.professor = professor;
        this.student = student;
        this.courseAssessments = courseAssessments;
    }


    public Set<CourseAssessment> getCourseAssessments() {
        return courseAssessments;
    }
    public Long getId() {
        return id;
    }
    public Set<Professor> getProfessor() {
        return professor;
    }
    public String getScore() {
        return score;
    }
    public String getSection() {
        return section;
    }
    public String getSectionGroup() {
        return sectionGroup;
    }
    public Set<Student> getStudent() {
        return student;
    }
    public void setCourseAssessments(Set<CourseAssessment> courseAssessments) {
        this.courseAssessments = courseAssessments;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setProfessor(Set<Professor> professor) {
        this.professor = professor;
    }
    public void setScore(String score) {
        this.score = score;
    }
    public void setSection(String section) {
        this.section = section;
    }
    public void setSectionGroup(String sectionGroup) {
        this.sectionGroup = sectionGroup;
    }
    public void setStudent(Set<Student> student) {
        this.student = student;
    }

}
