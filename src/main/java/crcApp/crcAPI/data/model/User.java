package crcApp.crcAPI.data.model;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "user")
public class User extends AbstractEntity {
//public class User extends AbstractEntity implements UserDetails, CredentialsContainer {

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "avatar_id")
    private Long avatarId;

    @Column(name = "colorectal")
    private Boolean colorectal;

    @Column(name = "stage")
    private Long stage;

    @Column(name = "diagnosis_date")
    private Date diagnosisDate;

    @Column(name = "height")
    private Long height;

    @Column(name = "weight")
    private Long weight;

    @Column(name = "fat_percent")
    private Long fatPercent;

    @Column(name = "protein_percent")
    private Long proteinPercent;

    @Column(name = "carbohydrate_percent")
    private Long carbohydratePercent;

    @Column(name = "activity_level_id")
    private Long activityLevelId;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "race")
    private String race;

    @Column(name = "ethnicity")
    private String ethnicity;

    @Column(name = "gender")
    private String gender;

    @Column(name = "screener_completed")
    private Boolean screenerCompleted;


}

