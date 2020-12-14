package com.assignments.assignment5.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignments.assignment5.models.AccountHolder;

public interface AccountHolderRepository extends JpaRepository<AccountHolder, Integer>{

	List<AccountHolder> findByFirstName(String firstName);
}
