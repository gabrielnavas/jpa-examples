package example.many_to_many.class_room;

import example.many_to_many.course.CourseRequest;
import example.many_to_many.course.CourseResponse;
import example.many_to_many.course.CourseService;
import example.many_to_many.student.StudentRequest;
import example.many_to_many.student.StudentResponse;
import example.many_to_many.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClassRoomCommandLine implements CommandLineRunner {
    private final CourseService courseService;
    private final StudentService studentService;
    private final ClassRoomService classRoomService;

    @Override
    public void run(String... args) {
        CourseRequest courseRequest = CourseRequest.builder().name("Back-end").build();
        CourseResponse courseResponse = courseService.save(courseRequest);

        StudentRequest studentRequest = StudentRequest.builder().name("John").build();
        StudentResponse studentResponse = studentService.save(studentRequest);

        ClassRoomRequest classRoomRequest = ClassRoomRequest.builder()
                .roomId("AB12")
                .studentId(studentResponse.id())
                .courseId(courseResponse.id())
                .build();

        ClassRoomResponse classRoomResponse = classRoomService.save(classRoomRequest);
        System.out.println(classRoomResponse.id());
    }
}
