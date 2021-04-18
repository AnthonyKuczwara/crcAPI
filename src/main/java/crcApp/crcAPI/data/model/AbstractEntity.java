package crcApp.crcAPI.data.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@MappedSuperclass
@SuperBuilder
public class AbstractEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Column(name = "updated_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
}
