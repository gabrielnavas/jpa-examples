package example.one_to_one.course;

import example.one_to_one.teaching_material.TeachingMaterialRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourseCommandLine implements CommandLineRunner {
    private final CourseService courseService;

    @Override
    public void run(String... args) {
        TeachingMaterialRequest teachingMaterialRequest = TeachingMaterialRequest.builder()
                .name("Caderno")
                .build();

        CourseRequest courseRequest = CourseRequest.builder()
                .name("Back-end")
                .teachingMaterialRequest(teachingMaterialRequest)
                .build();

        CourseResponse courseResponse = courseService.save(courseRequest);
        System.out.println(courseResponse.id());
        System.out.println(courseResponse.teachingMaterial().id());
    }
}
