package crcApp.crcAPI.data.model;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "weekly_goals_saved")
public class WeeklyGoalsSaved {

    @Column(name = "type")
    private String type;

    @Column(name = "goal_description")
    private String goalDescription;

    @Column(name = "help_info")
    private String help_info;

    @Column(name = "user_id")
    private Long userId;

    @Id
    private Long id;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
