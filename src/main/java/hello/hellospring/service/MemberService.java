package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

public class MemberService {
	private final MemberRepository memberRepository = new MemoryMemberRepository();
	
	/**
	 * 회원 가입
	 * @param member
	 * @return
	 */
	/*
	 * public Long join(Member member) { memberRepository.save(member);
	 * 
	 * return }
	 */
}
