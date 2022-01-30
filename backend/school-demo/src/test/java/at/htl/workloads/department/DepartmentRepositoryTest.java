package at.htl.workloads.department;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThatCode;

@QuarkusTest
public class DepartmentRepositoryTest {
    @Inject
    DepartmentRepository departmentRepository;

    @Test
    public void addDepartment_and_updateDepartment_getExecutive_simple_success() {
        DepartmentExecutive ex = new DepartmentExecutive();
        ex.setFirstname("Jakob");
        ex.setLastname("Unterberger");
        ex.setTitle("Dipl.Ing.");
        Department department = new Department();
        department.setDepartmentName("Baumhaus");
        department.setHeadOfDepartment(ex);

        assertThatCode(()->departmentRepository.add(department)).doesNotThrowAnyException();

        DepartmentExecutive ex2 = new DepartmentExecutive();
        ex.setFirstname("Niklas");
        ex.setLastname("Aichinger");
        ex.setTitle("Dipl.Ing.");
        department.setHeadOfDepartment(ex2);
        assertThatCode(()->departmentRepository.update(department)).doesNotThrowAnyException();

    }
}
