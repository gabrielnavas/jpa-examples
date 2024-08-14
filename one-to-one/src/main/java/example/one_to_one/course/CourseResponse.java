package example.one_to_one.course;

import example.one_to_one.teaching_material.TeachingMaterialResponse;
import lombok.Builder;

import java.util.UUID;

@Builder
public record CourseResponse(
        UUID id,
        String name,
        TeachingMaterialResponse teachingMaterial
) {
}
