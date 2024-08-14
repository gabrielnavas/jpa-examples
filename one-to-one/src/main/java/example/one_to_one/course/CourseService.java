package example.one_to_one.course;

import example.one_to_one.teaching_material.TeachingMaterialRepository;
import example.one_to_one.teaching_material.TeachingMaterialWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeachingMaterialRepository teachingMaterialRepository;

    private final CourseWrapper courseWrapper;
    private final TeachingMaterialWrapper teachingMaterialWrapper;

    public CourseResponse save(CourseRequest courseRequest) {
        Course course = courseWrapper.map(courseRequest);
        course = courseRepository.save(course);
        course.setTeachingMaterial(
                teachingMaterialRepository.save(
                        teachingMaterialWrapper.map(courseRequest.teachingMaterialRequest())
                )
        );
        course.getTeachingMaterial().setCourse(course);
        return courseWrapper.map(course, course.getTeachingMaterial());
    }
}
