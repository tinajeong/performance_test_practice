package world.migu.payment.jmeter.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import world.migu.payment.jmeter.data.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
