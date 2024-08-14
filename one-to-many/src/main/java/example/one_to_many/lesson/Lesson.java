package example.one_to_many.lesson;

import example.one_to_many.course.Course;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Entity // Marca a classe como uma entidade JPA
@Table(name = "lessons") // Especifica o nome da tabela no banco de dados
@Getter // Gera automaticamente os métodos getter para todos os campos
@Setter // Gera automaticamente os métodos setter para todos os campos
@NoArgsConstructor // Gera um construtor sem argumentos
@AllArgsConstructor // Gera um construtor com argumentos para todos os campos
public class Lesson {

    @Id // Indica que o campo 'id' é a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.UUID) // Gera automaticamente um UUID para o campo 'id'
    private UUID id;

    @Column(length = 150, nullable = false)
    // Define a coluna com tamanho máximo de 150 caracteres e não permite valor nulo
    private String name;

    @ManyToOne // Define uma relação Many-to-One com a entidade 'Course'
    @JoinColumn(name = "course_id") // Especifica a coluna 'course_id' como a chave estrangeira
    private Course course;
}