package turntabl.io.RestFulApi;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class StudentController {
    StudentService studentService;

//    public StudentController(StudentService studentService) {
//        this.studentService = studentService;
//    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable("id") int id){
        return studentService.registerStudent(id);
    }

    @GetMapping("/post")
    public String getPost(){
        return studentService.getPostFromFakeApi();
    }

    @GetMapping("/posts")
    public String getPostUsingWebClient(){
        return studentService.getPostFromFakeApi();
    }

}
