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
@Table(name = "article")
public class Article extends AbstractEntity  {

    @Column(name = "article_name")
    private String articleName;

    @Column(name = "article_author")
    private String articleAuthor;

    @Column(name = "article_subject")
    private String articleSubject;

    @Column(name = "article_type")
    private String articleType;

    @Column(name = "data")
    private byte[] data;

    @Column(name = "is_visible")
    private boolean isVisible;

}
