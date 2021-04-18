package crcApp.crcAPI.data.model;


import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class FoodLogEntryModel extends AbstractEntity {

    private Long id;

    private String entryTime;

    private String date;

    private Long userId;

    private Long foodId;

    private Double portion;


}

