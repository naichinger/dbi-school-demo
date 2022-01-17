package at.htl.entity;

import javax.persistence.*;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String departmentName;
    @ManyToOne
    DepartmentExecutive headOfDepartment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public DepartmentExecutive getHeadOfDepartment() {
        return headOfDepartment;
    }

    public void setHeadOfDepartment(DepartmentExecutive headOfDepartment) {
        this.headOfDepartment = headOfDepartment;
    }
}
