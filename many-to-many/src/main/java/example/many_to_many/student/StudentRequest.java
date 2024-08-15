package example.many_to_many.student;

import lombok.Builder;

@Builder
public record StudentRequest(
        String name
) {
}
