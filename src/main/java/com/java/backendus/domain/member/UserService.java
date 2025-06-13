package com.java.backendus.domain.member;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void addUserPoint(SavePointReqDto dto){
		int point = calculatePoint(dto.getPrice());
		userRepository.addPointByUserId(dto.getUserId(), point);
	}

	public int checkUserPoint(Long userId){
		return userRepository.getPointByUserId(userId).orElseThrow();
	}

	private Integer calculatePoint(Integer price) {
		return price * 10 / 100;
	}
}
