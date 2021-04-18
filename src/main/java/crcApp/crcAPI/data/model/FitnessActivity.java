package crcApp.crcAPI.data.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "fitness_activity")
public class FitnessActivity extends AbstractEntity implements Comparable<FitnessActivity> {

    @Column(name = "type")
    private String type;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "minutes")
    private String minutes;

    @Column(name = "intensity")
    private String intensity;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Override
    public int compareTo(FitnessActivity o) {
        return o.getDateTime().compareTo(getDateTime());
//        return getDateTime().compareTo(o.getDateTime());
    }
}
