package telran.ashkelon2018.student.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import telran.ashkelon2018.student.dto.ScoreDto;
import telran.ashkelon2018.student.dto.StudentDto;
import telran.ashkelon2018.student.dto.StudentEditDto;
import telran.ashkelon2018.student.dto.StudentResponseDto;
import telran.ashkelon2018.student.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/student")
	public boolean addStudent(@RequestBody StudentDto studentDto) {
		return studentService.addStudent(studentDto);
	}
	
	@DeleteMapping("/student/{id}")
	public StudentResponseDto removeStudent(@PathVariable int id,
			@RequestHeader("Authorization") String token) {
		return studentService.deleteStudent(id, token);
	}
	
	@PutMapping("/student/{id}")
	public StudentDto updateStudent(@PathVariable int id, 
			@RequestBody StudentEditDto studentEditDto, 
			HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		return studentService.editStudent(id, studentEditDto, token);
	}
	
	@GetMapping("/student/{id}")
	public StudentResponseDto getStudent(@PathVariable int id) {
		return studentService.getStudent(id);
	}
	
	@PutMapping("/teacher/{id}")
	public boolean addScore(@PathVariable int id,
			@RequestBody ScoreDto scoreDto) {
		return studentService.addScore(id, scoreDto);
	}
	
	@GetMapping("/students/name/{name}")
	public List<StudentResponseDto> getStudentsByName(@PathVariable String name){
		return studentService.getStudentsByName(name);
	}
	
	@GetMapping("/students/score/{exam}/{minscore}")
	public List<StudentResponseDto> getStudentsByExam(@PathVariable String exam,
			@PathVariable int minscore){
		return studentService.getStudentsByExam(exam, minscore);
	}

}
