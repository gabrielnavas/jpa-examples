package example.many_to_many.student;

import lombok.Builder;

import java.util.UUID;

@Builder
public record StudentResponse(
        UUID id,
        String name
) {
}
