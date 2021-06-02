package turntabl.io.RestFulApi;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;

@Service
public class StudentService {

    private String uri = "https://jsonplaceholder.typicode.com";

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

   public String getPostFromFakeApi(){
        RestTemplate template = new RestTemplate();
        return template.getForObject(uri+ "/posts", String.class);
   }

   public String getPostToFakeApiUsingWebClient(){
        WebClient client = WebClient.create(uri);

        return client.get()
                .uri("/posts")
                .retrieve()
                .bodyToMono(String.class)
                .block();
   }

}
