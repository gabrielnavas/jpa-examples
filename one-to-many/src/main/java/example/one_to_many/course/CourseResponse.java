package example.one_to_many.course;

import example.one_to_many.lesson.LessonResponse;
import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record CourseResponse(
        UUID id,
        String name,
        List<LessonResponse> lessons
) {}
