package example.one_to_many.lesson;

import lombok.Builder;

import java.util.UUID;

@Builder
public record LessonResponse(
        UUID id,
        String name
) {
}
