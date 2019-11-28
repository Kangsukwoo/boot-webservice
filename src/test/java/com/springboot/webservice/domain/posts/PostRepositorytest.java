package com.springboot.webservice.domain.posts;

import static org.hamcrest.CoreMatchers.is;

import java.util.List;
import org.junit.runner.RunWith;
import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.webservice.domain.posts.Posts;
import com.springboot.webservice.domain.posts.PostsRepository;

import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositorytest {
	
	@Autowired
	PostsRepository postsRepository;
	
	//repository초기화
	@After
	public void cleanUp() {
		postsRepository.deleteAll();
	}
	
	@Test
	public void saveContent_load() {
		
		//given
		postsRepository.save(Posts.builder()
				.title("testTitle")
				.content("testContent")
				.author("xialk4@gmail.com")
				.build());
		
		//when
		List<Posts> postsList = postsRepository.findAll();
		
		//then
		Posts posts = postsList.get(0);
		assertThat(posts.getTitle(),is("testTitle"));
		assertThat(posts.getContent(),is("testContent"));
		
	}

}
