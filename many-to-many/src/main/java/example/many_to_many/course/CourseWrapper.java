package example.many_to_many.course;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourseWrapper {
    public CourseResponse map(Course course) {
        return CourseResponse.builder()
                .id(course.getId())
                .name(course.getName())
                .build();
    }

    public Course map(CourseRequest courseRequest) {
        Course course = new Course();
        course.setName(courseRequest.name());
        return course;
    }
}
