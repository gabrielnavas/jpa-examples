package example.many_to_many.course;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    private final CourseWrapper courseWrapper;

    public CourseResponse save(CourseRequest courseRequest) {
        Course course = courseWrapper.map(courseRequest);
        course = courseRepository.save(course);
        return courseWrapper.map(course);
    }
}
