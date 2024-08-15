package example.many_to_many.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    private final StudentWrapper studentWrapper;

    public StudentResponse save(StudentRequest studentRequest) {
        Student student = studentWrapper.map(studentRequest);
        student = studentRepository.save(student);
        return studentWrapper.map(student);
    }
}
