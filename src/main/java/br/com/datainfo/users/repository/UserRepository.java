package br.com.datainfo.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

	@Query("from User where cpf = ?1")
	public User findByCpf(String cpf);

	@Query("delete from User u where u.cpf = ?1")
	public void deleteByCpf(String cpf);

}
