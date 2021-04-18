package crcApp.crcAPI.web.models;

import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class UserView {

    private String email;

    private String username;

    private String firstName;

    private String lastName;

    private Long avatarId;


    private Date dateOfBirth;

    private String race;

    private String ethnicity;

    private String gender;



    private Long height;

    private Long weight;

    private Long fatPercent;

    private Long proteinPercent;

    private Long carbohydratePercent;

    private String activityLevel;


    private Boolean abdominalPain;


    private Boolean appetiteLoss;

    private Boolean bloating;

    private Boolean constipation;

    private Boolean diarrhea;

    private Boolean nausea;

    private Boolean stomaProblems;




    private Boolean colorectal;

    private Long stage;


    private Date diagnosisDate;


    private Boolean surgery;


    private Boolean chemo;


    private Boolean radiation;

    private Boolean other;

    private Boolean uncertain;

    private Boolean ostomy;


    private Boolean screenerCompleted;

}
