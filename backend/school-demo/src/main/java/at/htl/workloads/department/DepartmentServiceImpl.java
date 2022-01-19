package at.htl.workloads.department;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department findById(long id) {
        return departmentRepository.findById(id);
    }

    @Override
    public Department addDepartment(String departmentName, long headOfDepartmentId) {
        DepartmentExecutive executive = findExecutiveById(headOfDepartmentId);
        Department department = Department.create(departmentName, executive);
        return departmentRepository.add(department);
    }

    @Override
    public DepartmentExecutive findExecutiveById(long headOfDepartmentId) {
        return departmentRepository.findExecutiveById(headOfDepartmentId);
    }

    @Override
    public DepartmentExecutive addDepartmentExecutive(String firstname, String lastname, String title) {
        DepartmentExecutive executive = DepartmentExecutive.create(firstname,lastname,title);
        return departmentRepository.addExecutive(executive);
    }

    @Override
    public void removeDepartmentExecutive(DepartmentExecutive departmentExecutive) {
        departmentRepository.removeExecutive(departmentExecutive);
    }

    @Override
    public DepartmentExecutive updateDepartmentExecutive(DepartmentExecutive executive, String firstname, String lastname, String title) {
        executive.setFirstname(firstname);
        executive.setLastname(lastname);
        executive.setTitle(title);
        return departmentRepository.updateExecutive(executive);
    }

    @Override
    public void removeDepartment(Department department) {
        departmentRepository.remove(department);
    }

    @Override
    public Department updateDepartment(Department department, String departmentName, long headOfDepartmentId) {
        DepartmentExecutive executive = findExecutiveById(headOfDepartmentId);
        department.setDepartmentName(departmentName);
        department.setHeadOfDepartment(executive);
        return departmentRepository.update(department);
    }
}
