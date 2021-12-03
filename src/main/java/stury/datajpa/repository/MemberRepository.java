package stury.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stury.datajpa.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
