package com.java.backendus.domain.member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	@Modifying
	@Query("UPDATE User u SET u.point = u.point + :point WHERE u.id = :userId")
	void addPointByUserId(@Param("userId") Long userId, @Param("point") int point);

	@Query("SELECT u.point FROM User u WHERE u.id = :userId")
	Optional<Integer> getPointByUserId(@Param("userId") Long userId);

}
