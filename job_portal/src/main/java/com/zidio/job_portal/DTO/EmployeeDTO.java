package com.zidio.job_portal.DTO;

public class EmployeeDTO {

    public Long id;
    public String name;
    public String email;
    public String phone;
    public String qualification;
    public String resumeURL;
    public EmployeeDTO(){}

    public EmployeeDTO(Long id, String email, String name, String phone, String qualification, String resumeURL) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.qualification = qualification;
        this.resumeURL = resumeURL;
    }
//    public EmployeeDTO (){}

//    public EmployeeDTO(Long id, Object o) {
//    }
}
