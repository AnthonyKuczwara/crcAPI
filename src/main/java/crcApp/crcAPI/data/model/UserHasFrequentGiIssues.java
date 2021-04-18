package crcApp.crcAPI.data.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;

@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "user_has_frequent_gi_issues")
@IdClass(UserHasFrequentGiIssues.class)
public class UserHasFrequentGiIssues implements Serializable {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Id
    @Column(name = "frequent_gi_issues_id")
    private Long frequentGiIssuesId;
}


