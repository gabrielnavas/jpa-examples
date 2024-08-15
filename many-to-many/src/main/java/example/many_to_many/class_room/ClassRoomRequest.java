package example.many_to_many.class_room;

import lombok.Builder;

import java.util.UUID;

@Builder
public record ClassRoomRequest(
        String roomId,
        UUID studentId,
        UUID courseId
) {
}
