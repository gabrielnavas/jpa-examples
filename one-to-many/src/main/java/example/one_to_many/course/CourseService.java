package example.one_to_many.course;

import example.one_to_many.lesson.Lesson;
import example.one_to_many.lesson.LessonRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseWrapper courseWrapper;

    final CourseResponse save(CourseRequest request) {
        Course course = new Course();
        course.setName(request.name());

        for (LessonRequest lessonRequest : request.lessons()) {
            Lesson lesson = new Lesson();
            lesson.setName(lessonRequest.name());
            lesson.setCourse(course);
            course.getLessons().add(lesson);
        }

        course = courseRepository.save(course);
        return courseWrapper.map(course);
    }
}
