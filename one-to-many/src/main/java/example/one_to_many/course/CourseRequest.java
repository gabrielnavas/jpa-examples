package example.one_to_many.course;

import example.one_to_many.lesson.LessonRequest;
import lombok.Builder;

import java.util.List;

@Builder
public record CourseRequest(
        String name,
        List<LessonRequest> lessons
) {
}
