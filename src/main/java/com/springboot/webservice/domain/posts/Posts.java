package com.springboot.webservice.domain.posts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.springboot.webservice.domain.BaseTimeEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//JPA Entity Class
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Posts extends BaseTimeEntity{
	
	@Id //PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) //PK생성규칙, default = Auto
	private long id;
	
	@Column(length = 500, nullable = false) //테이블의 컬럼
	private String title;
	
	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;
	private String author;
	
	@Builder //해당 클래스의 빌더패턴 클래스 생성
	public Posts(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}

}
