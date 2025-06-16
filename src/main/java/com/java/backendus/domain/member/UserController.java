package com.java.backendus.domain.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.backendus.global.code.RestApiResponse;

@RestController
@RequestMapping("/api/v1/point_us")
public class UserController {
	private final UserService userService;
	private static Logger log = LoggerFactory.getLogger(UserController.class);
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	public ResponseEntity<RestApiResponse> savePoint(@RequestBody SavePointReqDto savePointReqDto){
		log.info("들어오셨나 ?");
		userService.addUserPoint(savePointReqDto);
		RestApiResponse restApiResponse = new RestApiResponse(MemberCode.USER_POINT_SAVE_SUCCESS);
		return ResponseEntity.ok(restApiResponse);
	}

	@GetMapping
	public ResponseEntity<RestApiResponse> checkPoint(@PathVariable("userId")Long userId){
		log.info("들어오셨나 ?");
		int point = userService.checkUserPoint(userId);
		RestApiResponse restApiResponse = new RestApiResponse(MemberCode.USER_POINT_SAVE_SUCCESS, point);
		return ResponseEntity.ok(restApiResponse);
	}
}
