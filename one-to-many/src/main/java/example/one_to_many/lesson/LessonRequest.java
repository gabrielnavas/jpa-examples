package example.one_to_many.lesson;

import lombok.Builder;

@Builder
public record LessonRequest(
        String name
) {
}
