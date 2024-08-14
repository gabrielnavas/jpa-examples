package example.one_to_one.course;

import example.one_to_one.teaching_material.TeachingMaterialRequest;
import lombok.Builder;

@Builder
public record CourseRequest(
        String name,
        TeachingMaterialRequest teachingMaterialRequest
) {
}
