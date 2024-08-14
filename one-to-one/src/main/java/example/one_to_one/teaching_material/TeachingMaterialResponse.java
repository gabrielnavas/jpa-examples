package example.one_to_one.teaching_material;

import lombok.Builder;

import java.util.UUID;

@Builder
public record TeachingMaterialResponse(
        UUID id,
        String name
) {
}
