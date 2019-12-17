package objectyl.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@CrossOrigin
public class GreetingController {

	@Autowired
	private StudentRepository studentRepository;

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public hello.Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new hello.Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@RequestMapping("/students")
	public List<Student> getStudents() {

		List<Student> studentList = new ArrayList<>();

		studentList = studentRepository.findAll();

		return studentList;

	}

	@RequestMapping("/create")
	public Student createStudent() {

		Student student = new Student();

		student.id = UUID.randomUUID();
		student.firstName = "Mark";
		student.lastName = "Jorge";
		student.address = "London";

		studentRepository.save(student);

		return student;

	}

	@RequestMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") UUID id) {

		studentRepository.deleteById(id);

		return "Student deleted";

	}
}
