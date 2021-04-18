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
@Table(name = "frequent_gi_issues")
public class FrequentGiIssues extends AbstractEntity {


    @Column(name = "issue")
    private String issue;


}

