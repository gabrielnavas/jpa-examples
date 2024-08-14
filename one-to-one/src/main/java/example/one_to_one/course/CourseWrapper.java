package example.one_to_one.course;

import example.one_to_one.teaching_material.TeachingMaterial;
import example.one_to_one.teaching_material.TeachingMaterialWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourseWrapper {

    private final TeachingMaterialWrapper teachingMaterialWrapper;

    public CourseResponse map(Course course, TeachingMaterial teachingMaterial) {
        return CourseResponse.builder()
                .id(course.getId())
                .name(course.getName())
                .teachingMaterial(teachingMaterialWrapper.map(teachingMaterial))
                .build();
    }

    public Course map(CourseRequest courseRequest) {
        Course course = new Course();
        course.setName(courseRequest.name());
//        course.setTeachingMaterial(teachingMaterialWrapper.map(courseRequest.teachingMaterialRequest(), course));
        return course;
    }
}
