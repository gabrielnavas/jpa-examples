package example.many_to_many.student;


import example.many_to_many.class_room.ClassRoom;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "students") // Especifica o nome da tabela no banco de dados.
@Getter // Cria métodos getter para todos os campos da classe.
@Setter // Cria métodos setter para todos os campos da classe.
@NoArgsConstructor // Cria um construtor sem argumentos.
@AllArgsConstructor // Cria um construtor com argumentos para todos os campos.
public class Student {

    @Id // Indica que o campo `id` é a chave primária da entidade.
    @GeneratedValue(strategy = GenerationType.UUID) // Define a geração do valor da chave primária como UUID.
    private UUID id;

    @Column(length = 150, nullable = false)
    // Define a coluna `name` com comprimento máximo de 150 caracteres e não nula.
    private String name;

    @OneToMany(mappedBy = "student")
    private List<ClassRoom> classRooms;
}
