package com.task_management.task_management.repo;

import com.task_management.task_management.entity.Cl_Md_En;
import com.task_management.task_management.entity.Cl_Md_En_Key;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClMdEnRepository extends JpaRepository<Cl_Md_En, Cl_Md_En_Key> { }
