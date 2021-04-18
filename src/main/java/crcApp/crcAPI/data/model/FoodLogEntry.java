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
@Table(name = "food_log_entry")
public class FoodLogEntry extends AbstractEntity {

    @Column(name = "entry_time")
    private Date entryTime;

    @Column(name = "date")
    private Date date;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "food_id")
    private Long foodId;

    @Column(name = "portion")
    private Double portion;

    @Override
    public String toString() {
        return "FoodLogEntry{" +
                "entryTime=" + entryTime +
                ", date=" + date +
                ", userId=" + userId +
                ", foodId=" + foodId +
                ", portion=" + portion +
                '}';
    }

}

