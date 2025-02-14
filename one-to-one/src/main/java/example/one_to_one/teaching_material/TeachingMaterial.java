package example.one_to_one.teaching_material;

import example.one_to_one.course.Course;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Entity
@Table // Se não for especificado, o nome da tabela será o mesmo da classe (em minúsculas).
@Getter // Cria métodos getter para todos os campos da classe.
@Setter // Cria métodos setter para todos os campos da classe.
@NoArgsConstructor // Cria um construtor sem argumentos.
@AllArgsConstructor // Cria um construtor com argumentos para todos os campos.
public class TeachingMaterial {

    @Id // Indica que o campo `id` é a chave primária da entidade.
    @GeneratedValue(strategy = GenerationType.UUID) // Define a geração do valor da chave primária como UUID.
    private UUID id;

    @Column(nullable = false, length = 150)
    // Define a coluna `name` com comprimento máximo de 150 caracteres e não nula.
    private String name;

    @OneToOne(mappedBy = "teachingMaterial")
    // Define uma relação `OneToOne` com a entidade `Course`, sendo que `Course` é o dono da relação.
    private Course course; // A entidade `Course` é responsável por mapear a relação.
}