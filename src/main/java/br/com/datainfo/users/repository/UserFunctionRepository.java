package br.com.datainfo.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFunctionRepository extends JpaRepository<UserFunction, Long>, JpaSpecificationExecutor<UserFunction> {

}
