package com.example.sprint_2_api.repository.user;

import com.example.sprint_2_api.model.user.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IAppRoleRepository extends JpaRepository<AppRole, Long> {
    @Query(nativeQuery = true, value = "select * from app_role")
    List<AppRole> getAllRole();
}
