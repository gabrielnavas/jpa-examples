package example.many_to_many.class_room;

import lombok.Builder;

import java.util.UUID;

@Builder
public record ClassRoomResponse(
        UUID id,
        String roomId
) {
}
