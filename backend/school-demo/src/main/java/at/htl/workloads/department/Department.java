package at.htl.workloads.department;

import javax.persistence.*;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String departmentName;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    DepartmentExecutive headOfDepartment;

    public static Department create(String departmentName, DepartmentExecutive headOfDepartment) {
        Department department = new Department();

        department.setDepartmentName(departmentName);
        department.setHeadOfDepartment(headOfDepartment);

        return department;
    }

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
