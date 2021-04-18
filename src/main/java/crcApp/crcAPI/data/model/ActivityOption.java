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
@Table(name = "activity_option")
public class ActivityOption extends AbstractEntity {


    @Column(name = "type")
    private String type;

    @Column(name = "intensity")
    private Long intensity;

    @Column(name = "coefficient")
    private Double coefficient;

    @Column(name = "is_visible")
    private Boolean isVisible;




}

