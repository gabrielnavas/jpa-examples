package example.many_to_many.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentWrapper {
    public StudentResponse map(Student student) {
        return StudentResponse.builder()
                .id(student.getId())
                .name(student.getName())
                .build();
    }

    public Student map(StudentRequest studentRequest) {
        Student student = new Student();
        student.setName(studentRequest.name());
        return student;
    }
}
