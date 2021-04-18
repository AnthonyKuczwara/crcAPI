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
@Table(name = "common_portion_size_unit")
public class CommonPortionSizeUnit extends AbstractEntity {


    @Column(name = "unit")
    private String unit;


}

