package io.sparta.board.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

// 모든 Entity 에 들어가는 공통 컬럼 정보
@Getter
// @MappedSuperclass: JPA 의 추상클래스에 사용됨, 해당 클래스를(BaseEntity) 상속받는 클래스에서 공통된 필드와
// 매핑 정보를 재사용할 수 있다. *** 공통된 필드는 deleted, created_at, updated_at 이고, 매핑 정보는 뭘 의미?
@MappedSuperclass
// @EntityListeners: Entity 가 삽입, 삭제, 수정 등의 작업이 이루어질 때, 전, 후에 어떤 작업을 하기 위한 어노테이션
// AuditingEntityListener.class: Entity 클래스의 영속, 수정 이벤트를 감지하는 역할
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    protected boolean deleted; // *** boolean 타입인 컬럼 deleted 의 기본 값을 false 로 설정하기
    @CreationTimestamp // @TimeStamp, @CreatedDate, @CreationTimestamp 의 차이
    @Column(name = "created_at")
    protected LocalDateTime createdAt;
    @UpdateTimestamp // @TimeStamp 랑 @UpdateTimestamp 의 차이
    @Column(name = "updated_at")
    protected LocalDateTime updatedAt;
}
