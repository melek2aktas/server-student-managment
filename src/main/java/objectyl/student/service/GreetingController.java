package objectyl.student.service;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@CrossOrigin
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public hello.Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new hello.Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@RequestMapping("/students")
	public List<Student> getStudents() {

		List<Student> studentList = new ArrayList<>();

		Student student = new Student();

		student.setId(1);
		student.setName("John");
		student.setSurname("Demir");

		studentList.add(student);

		Student student2 = new Student();
		student2.setId(2);
		student2.setName("Elif");
		student2.setSurname("Demir");

		studentList.add(student2);

		return studentList;


	}
}
