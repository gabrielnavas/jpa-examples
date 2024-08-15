package example.many_to_many.course;

import lombok.Builder;

@Builder
public record CourseRequest(
        String name
) {
}
