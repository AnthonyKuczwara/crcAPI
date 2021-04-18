package crcApp.crcAPI.data.model;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "cancer_treatment")
public class CancerTreatment extends AbstractEntity {



    @Column(name = "radiation_therapy")
    private Boolean radiationTherapy;

    @Column(name = "chemo_therapy")
    private Boolean chemoTherapy;

    @Column(name = "surgery")
    private Boolean surgery;

    @Column(name = "ostomy")
    private Boolean ostomy;

    @Column(name = "other")
    private Boolean other;

    @Column(name = "uncertain")
    private Boolean uncertain;

    @Column(name = "user_id")
    private Long userId;

}

