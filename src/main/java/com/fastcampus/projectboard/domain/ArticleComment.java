package com.fastcampus.projectboard.domain;

import java.time.LocalDateTime;

public class ArticleComment {
    private Long id;
    /** 게시글 */
    private Article article;
    /** 본문 */
    private String content;

    /** 생성일시 */
    private LocalDateTime createdAt;
    /** 생성자 */
    private String createdBy;
    /** 수정일시 */
    private LocalDateTime modifiedAt;
    /** 수정자 */
    private String modifiedBy;
}
