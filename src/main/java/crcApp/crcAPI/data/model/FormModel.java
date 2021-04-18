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
public class FormModel {

    private Long userId;

    private String birthDate;

    private String race;

    private String ethnicity;

    private String gender;

    private Long height;

    private Long weight;

    private String activityLevel;

    private String gastroIntestinalIssues;

    private Boolean colorectalCancer;

    private String colorectalStage;

    private String lastDiagDate;

    private String cancerTreatment;

}

