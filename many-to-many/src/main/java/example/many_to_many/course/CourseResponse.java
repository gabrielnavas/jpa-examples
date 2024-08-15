package example.many_to_many.course;

import lombok.Builder;

import java.util.UUID;

@Builder
public record CourseResponse(
        UUID id,
        String name
) {
}
