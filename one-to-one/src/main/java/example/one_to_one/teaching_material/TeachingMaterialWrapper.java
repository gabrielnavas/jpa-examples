package example.one_to_one.teaching_material;

import org.springframework.stereotype.Component;

@Component
public class TeachingMaterialWrapper {
    public TeachingMaterial map(TeachingMaterialRequest teachingMaterialRequest) {
        TeachingMaterial teachingMaterial = new TeachingMaterial();
        teachingMaterial.setName(teachingMaterialRequest.name());
        return teachingMaterial;
    }

    public TeachingMaterialResponse map(TeachingMaterial teachingMaterial) {
        return TeachingMaterialResponse.builder()
                .id(teachingMaterial.getId())
                .name(teachingMaterial.getName())
                .build();
    }
}
