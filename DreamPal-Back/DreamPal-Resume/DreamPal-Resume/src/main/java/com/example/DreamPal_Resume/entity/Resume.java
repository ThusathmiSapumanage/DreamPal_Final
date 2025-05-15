package com.example.DreamPal_Resume.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "resumes")
public class Resume {
    @Id
    private String id;

    private String userId;
    private String fullName;
    private String summary;
    private String phone;
    private String email;
    private String linkedin;

    private List<String> education;
    private List<String> experience;
    private List<String> experienceDate;
    private List<String> company;
    private List<String> skills;
    private List<String> experienceSummary;
    private List<String> projects;
    private List<String> certifications;
    private List<String> projectSummery;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSummary() {
        return summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<String> getEducation() {
        return education;
    }
    public void setEducation(List<String> education) {
        this.education = education;
    }

    public List<String> getExperience() {
        return experience;
    }
    public void setExperience(List<String> experience) {
        this.experience = experience;
    }

    public List<String> getSkills() {
        return skills;
    }
    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<String> getExperienceSummary() {
        return experienceSummary;
    }
    public void setExperienceSummary(List<String> experienceSummary) {
        this.experienceSummary = experienceSummary;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getLinkedin() {
        return linkedin;
    }
    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public List<String> getProjects() {
        return projects;
    }
    public void setProjects(List<String> projects) {
        this.projects = projects;
    }

    public List<String> getCertifications() {
        return certifications;
    }
    public void setCertifications(List<String> certifications) {
        this.certifications = certifications;
    }

    public List<String> getProjectSummery() {
        return projectSummery;
    }
    public void setProjectSummery(List<String> projectSummery) {
        this.projectSummery = projectSummery;
    }

    public List<String> getExperienceDate() {
        return experienceDate;
    }
    public void setExperienceDate(List<String> experienceDate) {
        this.experienceDate = experienceDate;
    }

    public List<String> getCompany() {
        return company;
    }
    public void setCompany(List<String> company) {
        this.company = company;
    }

    public Resume(String id, String userId, String fullName, String summary, List<String> education, List<String> experience, List<String> skills, List<String> experienceSummary, String phone, String email, String linkedin, List<String> projects, List<String> certifications, List<String> projectSummery, List<String> experienceDate, List<String> company) {
        this.id = id;
        this.userId = userId;
        this.fullName = fullName;
        this.summary = summary;
        this.education = education;
        this.experience = experience;
        this.skills = skills;
        this.experienceSummary = experienceSummary;
        this.phone = phone;
        this.email = email;
        this.linkedin = linkedin;
        this.projects = projects;
        this.certifications = certifications;
        this.projectSummery = projectSummery;
        this.experienceDate = experienceDate;
        this.company = company;
    }
}
