package com.java.backendus.domain.member;

import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.backendus.global.code.RestApiResponse;

@Controller
@RestController("api/v1/point_us")
public class UserController {
	private final UserService userService;
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	public ResponseEntity<RestApiResponse> savePoint(SavePointReqDto savePointReqDto){
		userService.addUserPoint(savePointReqDto);
		RestApiResponse restApiResponse = new RestApiResponse(MemberCode.USER_POINT_SAVE_SUCCESS);
		return ResponseEntity.ok(restApiResponse);
	}

	@GetMapping
	public ResponseEntity<RestApiResponse> checkPoint(@RequestParam("userId")Long userId){
		int point = userService.checkUserPoint(userId);
		RestApiResponse restApiResponse = new RestApiResponse(MemberCode.USER_POINT_SAVE_SUCCESS, point);
		return ResponseEntity.ok(restApiResponse);
	}
}
