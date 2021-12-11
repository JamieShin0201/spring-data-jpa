package study.datajpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import study.datajpa.dto.MemberDto;
import study.datajpa.entity.Member;
import study.datajpa.repository.MemberRepository;

import javax.annotation.PostConstruct;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

//    @GetMapping("/members/{id}")
//    public String findMember(@PathVariable Long id) {
//        Member member = memberRepository.findById(id).get();
//        return member.getUsername();
//    }

    @GetMapping("/members/{id}")
    public String findMember(@PathVariable("id") Member member) {
        return member.getUsername();
    }

    @GetMapping("/members")
    public Page<Member> list(Pageable pageable) {
        Page<Member> page = memberRepository.findAll(pageable);
        return page;
    }

    // 페이지 개별 설정
    @GetMapping("/members-page")
    public Page<Member> findMembers(
            @PageableDefault(size = 12, sort = "username", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        Page<Member> page = memberRepository.findAll(pageable);
        return page;
    }

    // 접두사 활용
    @GetMapping("/members-page2")
    public Page<Member> findMembers2(
            @Qualifier("member") Pageable memberPageable,
            @Qualifier("order") Pageable orderPageable
    ) {
        Page<Member> page = memberRepository.findAll(memberPageable);
        return page;
    }

    @GetMapping("members-page-dto")
    public Page<MemberDto> findMemberDtos(Pageable pageable) {
        Page<Member> page = memberRepository.findAll(pageable);
        Page<MemberDto> pageDto = page.map(m -> new MemberDto(m.getId(), m.getUsername(), null));
        return pageDto;
    }

    @PostConstruct
    public void init() {
        memberRepository.save(new Member("member1"));
    }
}
