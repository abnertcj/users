package br.com.datainfo.functions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFunctionRepository extends JpaRepository<UserFunction, Long>, JpaSpecificationExecutor<UserFunction> {

	@Query("from UserFunction where code = ?1")
	public UserFunction findByCode(Integer code);

}
