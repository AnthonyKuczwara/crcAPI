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
@Table(name = "activity_level")
public class ActivityLevel extends AbstractEntity {


    @Column(name = "level")
    private String level;




}

