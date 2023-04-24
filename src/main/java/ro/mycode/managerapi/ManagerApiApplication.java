package ro.mycode.managerapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.mycode.managerapi.repository.BookRepo;
import ro.mycode.managerapi.repository.StudentRepo;

@SpringBootApplication
public class ManagerApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(ManagerApiApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentRepo studentRepo,BookRepo bookRepo){
		return  args -> {
//			Book book=Book.builder()
//					.bookName("Math")
//					.createdAt(LocalDate.of(1993,12,12))
//					.build();
//			Book book2=Book.builder()
//					.bookName("Informatics")
//					.createdAt(LocalDate.of(1993,01,19))
//					.build();
//			Book book3=Book.builder()
//					.bookName("Java")
//					.createdAt(LocalDate.of(2000,8,23 ))
//					.build();
//
//			Book book4=Book.builder()
//					.bookName("C++")
//					.createdAt(LocalDate.of(2012,9,14))
//					.build();
//
//			Book book5=Book.builder()
//					.bookName("HTML")
//					.createdAt(LocalDate.of(2001,4,30))
//					.build();
//
//			Student student = studentRepo.findById(2L).get();
//
//			student.addBook(book);
//			student.addBook(book2);
//			student.addBook(book3);
//			student.addBook(book4);
//			student.addBook(book5);
//
//			studentRepo.saveAndFlush(student);
//
//			AddBookRequest addBookRequest = AddBookRequest.builder()
//					.bookName("HTML")
//					.createdAt(LocalDate.of(2001,4,30))
//					.studentId(2L)
//					.build();
//
//  	BookService bookService = new BookService(bookRepo,studentRepo);
//			bookService.addBookToStudent(addBookRequest);
		};
	}


}
