package study.datajpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.entity.Member;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void testMember() {
//        System.out.println(memberRepository.getClass()); // Proxy
        Member member = new Member("memberA");
        Member savedMember = memberRepository.save(member);

        Member foundMember = memberRepository.findById(savedMember.getId()).get();

        assertThat(foundMember.getId()).isEqualTo(member.getId());
        assertThat(foundMember.getUsername()).isEqualTo(member.getUsername());
        assertThat(foundMember).isEqualTo(member);
    }
}