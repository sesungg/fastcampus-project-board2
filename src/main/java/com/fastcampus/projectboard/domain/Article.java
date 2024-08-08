package com.fastcampus.projectboard.domain;

import java.time.LocalDateTime;

public class Article {
    /** 제목 */
    private Long id;
    /** 본문 */
    private String title;
    /** 해시태그 */
    private String hashtag;

    /** 생성일시 */
    private LocalDateTime createdAt;
    /** 생성자 */
    private String createdBy;
    /** 수정일시 */
    private LocalDateTime modifiedAt;
    /** 수정자 */
    private String modifiedBy;
}
