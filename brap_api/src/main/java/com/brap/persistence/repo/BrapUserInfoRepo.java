package com.brap.persistence.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brap.entity.BrapUserInfo;

@Repository
public interface BrapUserInfoRepo extends JpaRepository<BrapUserInfo, String> {

	Optional<BrapUserInfo> findByUserId(String userName);
}
