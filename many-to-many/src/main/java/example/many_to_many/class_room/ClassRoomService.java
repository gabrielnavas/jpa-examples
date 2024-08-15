package example.many_to_many.class_room;

import example.many_to_many.course.Course;
import example.many_to_many.course.CourseRepository;
import example.many_to_many.student.Student;
import example.many_to_many.student.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassRoomService {

    private final ClassRoomRepository classRoomRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;


    public ClassRoomResponse save(ClassRoomRequest classRoomRequest) {
        Optional<Student> optionalStudent = studentRepository.findById(classRoomRequest.studentId());
        if (optionalStudent.isEmpty()) {
            throw new RuntimeException("student not found by id " + classRoomRequest.studentId());
        }

        Optional<Course> optionalCourse = courseRepository.findById(classRoomRequest.courseId());
        if (optionalCourse.isEmpty()) {
            throw new RuntimeException("course not found by id " + classRoomRequest.courseId());
        }

        ClassRoom classRoom = new ClassRoom();
        classRoom.setRoomId(classRoomRequest.roomId());
        classRoom.setStudent(optionalStudent.get());
        classRoom.setCourse(optionalCourse.get());

        classRoom = classRoomRepository.save(classRoom);

        return ClassRoomResponse.builder()
                .id(classRoom.getId())
                .roomId(classRoom.getRoomId())
                .build();
    }
}
