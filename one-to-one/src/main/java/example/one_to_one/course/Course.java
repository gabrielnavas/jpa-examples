package example.one_to_one.course;

import example.one_to_one.teaching_material.TeachingMaterial;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "courses") // Especifica o nome da tabela no banco de dados.
@Getter // Cria métodos getter para todos os campos da classe.
@Setter // Cria métodos setter para todos os campos da classe.
@NoArgsConstructor // Cria um construtor sem argumentos.
@AllArgsConstructor // Cria um construtor com argumentos para todos os campos.
public class Course {

    @Id // Indica que o campo `id` é a chave primária da entidade.
    @GeneratedValue(strategy = GenerationType.UUID) // Define a geração do valor da chave primária como UUID.
    private UUID id;

    @Column(length = 150, nullable = false)
    // Define a coluna `name` com comprimento máximo de 150 caracteres e não nula.
    private String name;

    @OneToOne // Define uma relação `OneToOne` com a entidade `TeachingMaterial`.
    @JoinColumn(name = "teaching_material_id")
    // Especifica a coluna `teaching_material_id` como chave estrangeira para a tabela `TeachingMaterial`.
    private TeachingMaterial teachingMaterial; // A entidade `TeachingMaterial` é referenciada pela chave estrangeira `teaching_material_id`.
}
