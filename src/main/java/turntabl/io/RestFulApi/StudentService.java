package turntabl.io.RestFulApi;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {

    public Student registerStudent(int index){
        ArrayList<Student> listOfStudent = new ArrayList<>();
        listOfStudent.add(new Student("Addy", "CSC", 1));
        listOfStudent.add(new Student("Victor", "CSC", 2));

       return listOfStudent.stream()
                .filter(stu -> stu.getIndexNumber() == index)
                .findFirst()
               .orElse(null);


//        for (Student stu : listOfStudent){
//            if (stu.getIndexNumber() == index)
//                return stu;
//        }
//       return  null;
    }

}
