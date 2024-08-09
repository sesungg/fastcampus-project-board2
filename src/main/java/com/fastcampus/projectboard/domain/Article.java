package com.fastcampus.projectboard.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "hashtag"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Article {
    /** 제목 */
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 제목 */
    @Setter @Column(nullable = false)
    private String title;

    /** 본문 */
    @Setter @Column(nullable = false, length = 10000)
    private String content;

    /** 해시태그 */
    @Setter
    private String hashtag;

    @ToString.Exclude
    @OrderBy("id")
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private final Set<ArticleComment> articleComments = new LinkedHashSet<>();

    /** 생성일시 */
    @CreatedDate @Column(nullable = false)
    private LocalDateTime createdAt;

    /** 생성자 */
    @CreatedBy @Column(nullable = false, length = 100)
    private String createdBy;

    /** 수정일시 */
    @LastModifiedDate @Column(nullable = false)
    private LocalDateTime modifiedAt;

    /** 수정자 */
    @LastModifiedBy @Column(nullable = false, length = 100)
    private String modifiedBy;

    protected Article() {}

    private Article(String title, String content, String hashtag) {
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
    }

    public static Article of(String title, String content, String hashtag) {
        return new Article(title, content, hashtag);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article article)) return false;
        return id != null && id.equals(article.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
