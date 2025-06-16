package com.java.backendus.domain.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	private final UserRepository userRepository;
	private static Logger log = LoggerFactory.getLogger(UserService.class);
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	@Transactional
	public void addUserPoint(SavePointReqDto dto){
		int point = calculatePoint(dto.getPrice());
		log.info(String.valueOf(point));
		log.info(String.valueOf(dto.getUserId()));
		userRepository.addPointByUserId(dto.getUserId(), point);
	}

	public int checkUserPoint(Long userId){
		return userRepository.getPointByUserId(userId).orElseThrow();
	}

	private Integer calculatePoint(Integer price) {
		return price * 10 / 100;
	}
}
