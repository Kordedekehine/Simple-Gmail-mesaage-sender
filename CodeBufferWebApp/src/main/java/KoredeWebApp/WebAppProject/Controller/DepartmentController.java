package KoredeWebApp.WebAppProject.Controller;

import KoredeWebApp.WebAppProject.Entity.Department;
import KoredeWebApp.WebAppProject.Service.DepartmentService;
import KoredeWebApp.WebAppProject.Service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/department")
    public Department saveDepartment(@RequestBody Department department){
      //  DepartmentService service = new DepartmentServiceImpl(); We don't wanna go this way,we autowire
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/department")
    public List<Department> getDepartmentList(){
        return departmentService.getDepartmenList();
    }

    @GetMapping(path = "/department/{Id}")
    public Department getDepartmentById(@PathVariable ("/department/{Id}") Long departmentId){
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("/department/{id}")
    public String deleteDepartmentById(@PathVariable ("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Successfully deletes department";
    }

    @PutMapping("/department/{id}")
    public Department updateDepartment(@PathVariable Long departmentId,
                                       @RequestBody Department department){
        return departmentService.updateDepartment(departmentId,department);
    }

    @GetMapping("/department/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.getDepartmentByName(departmentName);
    }
}
