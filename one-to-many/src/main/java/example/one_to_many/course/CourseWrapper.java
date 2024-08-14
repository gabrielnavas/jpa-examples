package example.one_to_many.course;

import example.one_to_many.lesson.LessonWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourseWrapper {

    private final LessonWrapper lessonWrapper;

    public CourseResponse map(Course course) {
        return CourseResponse.builder()
                .id(course.getId())
                .name(course.getName())
                .lessons(lessonWrapper.map(course.getLessons()))
                .build();
    }
}
