package com.project.epermit.dao;

import com.project.epermit.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Repository
@Transactional
public interface UsersDao extends JpaRepository<Users,Long> {
    @Query(value = "SELECT * FROM USERS t WHERE t.USERNAME = :username AND t.PASSWORD = :password AND t.APPROVED = 'Y'",nativeQuery=true)
    Users findByUsernameAndPassword(@Param("username") String username, @Param("password") String Password);
    @Query(value = "SELECT t.ROLE FROM USERS t WHERE t.USERNAME = :username ",nativeQuery=true)
    String findUserRoleByUsername(@Param("username") String username);
    @Query(value = "SELECT * FROM USERS t WHERE t.APPROVED = 'N' AND t.REJECTED = 'N' AND t.CREATOR <> :username",nativeQuery = true)
    List<Users> fetchUnverifiedUsers(@Param("username" )String username);
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query(value = "UPDATE USERS t SET t.APPROVED = 'Y', t.APPROVED_BY = :adminuser, t.APPROVED_DATE = NOW() WHERE t.USERNAME = :user  ", nativeQuery = true)
    int verifyUser(@Param("adminuser") String adminuser, @Param("user") String user);

    Users findByUsername(String user);

    @Query(value = "SELECT NOW()",nativeQuery = true)
    String getDatabaseDate();
    @Query(value = "SELECT * FROM USERS t WHERE t.REJECTED = 'Y' AND t.REJECTED_BY <> :username",nativeQuery = true)
    List<Users> fetchRejectedUsers(@Param("username")  String username);

    void deleteByUsername(@Param("username") String username);
    @Query(value = "SELECT COUNT(*) FROM USERS t WHERE t.APPROVED = 'Y'",nativeQuery = true)
    Long fetchNumberofVerifiedUsers();
    @Query(value = "SELECT COUNT(*) FROM USERS t WHERE t.REJECTED = 'Y'",nativeQuery = true)
    Long fetchAllRejectedUser();
    @Query(value = "SELECT COUNT(*) FROM USERS t",nativeQuery = true)
    Long findNumberofAllUsers();
    @Query(value = "SELECT COUNT(*) FROM USERS t WHERE t.APPROVED = 'N'",nativeQuery = true)
    Long fetchAllUnverifiedUsers();
}
