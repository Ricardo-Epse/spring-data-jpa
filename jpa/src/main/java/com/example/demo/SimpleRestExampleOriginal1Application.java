package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.CourseDataRepository;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.CriteriaQueryTest;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.Jpql;
import com.example.demo.repository.NativeQueries;
import com.example.demo.repository.StudentRepository;

@SpringBootApplication
public class SimpleRestExampleOriginal1Application implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private CourseDataRepository courseDataRepository;

	@Autowired
	private Jpql pruebaP;

	@Autowired
	private NativeQueries nativeQ;
	
	@Autowired
	private CriteriaQueryTest criteriaQ;

	public static void main(String[] args) {
		SpringApplication.run(SimpleRestExampleOriginal1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		List<Review> reviews = new ArrayList<>();
//		reviews.add(new Review("5", "Great course"));
//		reviews.add(new Review("3", "Could be better"));
//		
//		courseRepository.addReviewsForCourse(10001L , reviews);
//		courseRepository.addReviewsForCourse();

//		Course course = courseRepository.findById(10001L);
//		logger.info("Couse 10001 {}", course);	
//		courseRepository.deleteById(10001L);
//		Course course1 = courseRepository.findById(10001L);
//		logger.info("Couse 10001 {}", course1)
//		courseRepository.save(new Course("CREANDO PRUEBA"));
//		
//		pruebaP.PruebaJpqlPrimero();
//		pruebaP.PruebaJpqlSegundo();
//		pruebaP.PruebaJpqlTercero();
//		pruebaP.PruebaJpqlWhere();		
//		pruebaP.PruebaJpql();
//		pruebaP.PruebaJpqlTercero();
//		nativeQ.native_queries_basic();
//		nativeQ.native_queries_with_parameter();
//		nativeQ.native_queries_with_named_parameter();
//		nativeQ.native_queries_to_update();
//		studentRepository.saveStudentWithPassport();
//		studentRepository.retrieveStudentAndPassportDetails();
//		studentRepository.retrievePassportAndAssociatedStudent();
//		studentRepository.retrieveStudentAndCourses();
//		courseRepository.EntityManagerTests();
//		studentRepository.insertStudentAndCourseOne();
//		studentRepository.insertStudentAndCourse(new Student("Diego"), new Course("Biology"));
		
//		employeeRepository.insert(new FullTimeEmployee("Ricardo", new BigDecimal("10000")));
//		employeeRepository.insert(new PartTimeEmployee("Steve", new BigDecimal("5000")));
//		
//		logger.info("All employees -> {}", employeeRepository.retrieveAllFullTimeEmployees());
//		logger.info("All employees -> {}", employeeRepository.retrieveAllPartTimeEmployees());
		
//		pruebaP.jpql_courses_without_students();
//		pruebaP.jpql_courses_with_atleast_two_students();
//		pruebaP.jpql_courses_with_ordered_by_students();
//		pruebaP.jpql_courses_with_passports_pattern();
		
//		pruebaP.join();
//		pruebaP.left_join();
//		pruebaP.cross_join();
		
//		criteriaQ.criteria_basic();
//		criteriaQ.criteria_course();
//		criteriaQ.criteria_courses_withoutStudents();
//		criteriaQ.join();
//		criteriaQ.join_left();
		
//		courseDataRepository.test1();
//		courseDataRepository.test2();
//		courseDataRepository.sort();
//		courseDataRepository.pagination();
		//courseDataRepository.findUsingName();
//		courseDataRepository.countUsingName();
//		courseDataRepository.courseWith();
//		courseDataRepository.courseWithNative();
//		
//		courseDataRepository.deleteUsingName();
//		courseDataRepository.findUsingNameAndId();
//		courseDataRepository.findUsingNameDesc();
		
		

		
	}

}
