package telran.ashkelon2018.student.dao;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import telran.ashkelon2018.student.domain.Student;

public interface StudentRepository extends MongoRepository<Student, Integer> {
	Stream<Student> findAllBy();
	
	List<Student> findByNameRegex(String regex);

	@Query("{'?0':{'$gt':?1}}")
	List<Student> findByExam(String exam, int score);
}
