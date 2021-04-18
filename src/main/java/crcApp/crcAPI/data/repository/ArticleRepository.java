package crcApp.crcAPI.data.repository;

import crcApp.crcAPI.data.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    List<Article> findAll();
    void deleteArticleById(Long id);

    List<Article> findAllByArticleAuthorLike(String searchString);

    List<Article> findAllByArticleNameLike(String searchString);

    List<Article> findAllByArticleSubjectLike(String searchString);
    

}
