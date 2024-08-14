package example.one_to_one.teaching_material;

import lombok.Builder;

@Builder
public record TeachingMaterialRequest(
        String name
) {
}
