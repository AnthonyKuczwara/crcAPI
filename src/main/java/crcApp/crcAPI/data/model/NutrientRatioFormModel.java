package crcApp.crcAPI.data.model;


import lombok.*;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class NutrientRatioFormModel {

    private Long userId;

    private Long fatPercent;

    private Long proteinPercent;

    private Long carbohydratePercent;

    @Override
    public String toString() {
        return "NutrientRatioFormModel{" +
                "userId=" + userId +
                ", fatPercent=" + fatPercent +
                ", proteinPercent=" + proteinPercent +
                ", carbohydratePercent=" + carbohydratePercent +
                '}';
    }
}

