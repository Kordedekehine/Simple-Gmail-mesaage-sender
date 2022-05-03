package KoredeWebApp.WebAppProject.Service;

import KoredeWebApp.WebAppProject.Entity.Department;

import java.util.List;

public interface DepartmentService {

   Department saveDepartment(Department department);

    List<Department> getDepartmenList();

    Department getDepartmentById(Long departmentId);

   public void deleteDepartmentById(Long departmentId);

   public Department updateDepartment(Long departmentId, Department department);

   public Department getDepartmentByName(String departmentName);
}
