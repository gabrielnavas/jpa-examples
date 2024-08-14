package example.one_to_many.course;

import example.one_to_many.lesson.LessonRequest;
import example.one_to_many.lesson.LessonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CourseCommandLine implements CommandLineRunner {
    private final CourseService courseService;

    @Override
    public void run(String... args) throws Exception {
        CourseRequest courseRequest = CourseRequest.builder()
                .name("Front-end")
                .lessons(List.of(
                        LessonRequest.builder().name("Pintar botão de vermelho").build(),
                        LessonRequest.builder().name("Ajustar layout").build()
                ))
                .build();

        CourseResponse courseResponse = courseService.save(courseRequest);

        // id do course
        System.out.println(courseResponse.id());

        // id dos lessons
        for (LessonResponse lessonResponse : courseResponse.lessons()) {
            System.out.println(lessonResponse.id());
        }
    }
}
