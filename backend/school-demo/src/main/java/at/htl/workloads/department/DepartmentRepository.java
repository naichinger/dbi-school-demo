package at.htl.workloads.department;

public interface DepartmentRepository {
    Department findById(long id);

    DepartmentExecutive findExecutiveById(long headOfDepartmentId);

    Department add(Department department);

    void remove(Department department);

    Department update(Department department);

    DepartmentExecutive addExecutive(DepartmentExecutive executive);

    void removeExecutive(DepartmentExecutive departmentExecutive);

    DepartmentExecutive updateExecutive(DepartmentExecutive executive);
}
