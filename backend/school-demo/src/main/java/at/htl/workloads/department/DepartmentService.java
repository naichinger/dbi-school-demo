package at.htl.workloads.department;

import at.htl.workloads.classroom.Classroom;

import java.util.List;

public interface DepartmentService {
    Department findById(long id);

    Department addDepartment(String departmentName, long headOfDepartmentId);

    void removeDepartment(Department department);

    Department updateDepartment(Department department, String departmentName, long headOfDepartmentId);

    DepartmentExecutive findExecutiveById(long id);

    DepartmentExecutive addDepartmentExecutive(String firstname, String lastname, String title);

    void removeDepartmentExecutive(DepartmentExecutive department);

    DepartmentExecutive updateDepartmentExecutive(DepartmentExecutive executive, String firstname, String lastname, String title);


}
