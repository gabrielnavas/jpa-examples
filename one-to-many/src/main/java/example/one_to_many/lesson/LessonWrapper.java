package example.one_to_many.lesson;


import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LessonWrapper {

    private LessonResponse map(Lesson lesson) {
        return LessonResponse.builder()
                .id(lesson.getId())
                .name(lesson.getName())
                .build();
    }

    public List<LessonResponse> map(List<Lesson> lessons) {
        return lessons.stream().map(this::map).toList();
    }
}
