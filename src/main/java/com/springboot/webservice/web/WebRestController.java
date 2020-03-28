package com.springboot.webservice.web;

import java.util.Arrays;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.webservice.domain.posts.PostsRepository;
import com.springboot.webservice.dto.posts.PostsSaveRequestDto;
import com.springboot.webservice.service.PostsService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {
	
	//private PostsRepository postsRepository;
	
	private PostsService postsService;
	private Environment env;
	
	@GetMapping("/hello")
	public String Hello() {
		return "HelloWorld";
	}
	/*
	@PostMapping("/posts")
	public void savePosts(@RequestBody PostsSaveRequestDto dto) {
		postsRepository.save(dto.toEntity());
	}*/
	
	@PostMapping("/posts")
	public long savePosts(@RequestBody PostsSaveRequestDto dto) {
		return postsService.save(dto);
	}
	
	@GetMapping("/profile")
	public String getProfile() {
		return Arrays.stream(env.getActiveProfiles())
				.findFirst()
				.orElse("");
	}
	
}
