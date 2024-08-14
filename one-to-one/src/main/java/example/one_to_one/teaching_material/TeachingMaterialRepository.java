package example.one_to_one.teaching_material;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TeachingMaterialRepository extends JpaRepository<TeachingMaterial, UUID> {
}
