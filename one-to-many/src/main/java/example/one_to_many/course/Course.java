package example.one_to_many.course;

import example.one_to_many.lesson.Lesson;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity // Marca a classe como uma entidade JPA
@Table(name = "course") // Especifica o nome da tabela no banco de dados
@Getter // Gera automaticamente os métodos getter para todos os campos
@Setter // Gera automaticamente os métodos setter para todos os campos
@NoArgsConstructor // Gera um construtor sem argumentos
@AllArgsConstructor // Gera um construtor com argumentos para todos os campos
public class Course {

    @Id // Indica que o campo 'id' é a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.UUID) // Gera automaticamente um UUID para o campo 'id'
    private UUID id;

    @Column(length = 150, nullable = false)
    // Define a coluna com tamanho máximo de 150 caracteres e não permite valor nulo
    private String name;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    // Define uma relação One-to-Many com a entidade 'Lesson'
    // 'mappedBy = "course"' indica que 'Lesson' possui o campo 'course' que é a chave estrangeira
    // 'cascade = CascadeType.ALL' faz com que operações em 'Course' sejam aplicadas em cascata em 'lessons'
    // 'orphanRemoval = true' remove lições órfãs do banco de dados
    private List<Lesson> lessons = new ArrayList<>();
}
