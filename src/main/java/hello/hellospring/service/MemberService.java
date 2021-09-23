package hello.hellospring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;

//@Service
@Transactional
public class MemberService {
	private final MemberRepository memberRepository;

	//@Autowired
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository; 
	}

	/**
	 * 회원 가입.
	 */
	public Long join(Member member) {
		// 같은 이름은 가입할 수 없도록 한다.
		/*
		Optional<Member> result = memberRepository.findByName(member.getName());

		result.ifPresent(m -> {
			throw new IllegalStateException("이미 존재하는 회원입니다.");
		});
		*/
		// 이것은 method로 뽑아주는게 좋다.
		vaildateDuplicateMember(member);
		
		memberRepository.save(member);
		return member.getId();
	}

	private void vaildateDuplicateMember(Member member) {
		memberRepository.findByName(member.getName())
		.ifPresent(m -> {
			throw new IllegalStateException("이미 존재하는 회원입니다.");
		});
	}

	/**
	 * 전체 회원 조회
	 */
	public List<Member> findMembers() {
		return memberRepository.findAll();
	}

	public Optional<Member> findOne(Long memberId) {
		return memberRepository.findById(memberId);
	}
}
