package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clear();
    }

    @Test
    void test1() {
        Member member1 = new Member("soo");
        Member member2 = new Member("qwe");
        memberRepository.save(member1);
        memberRepository.save(member2);

        assertThat(memberRepository.findById(1).get()).isEqualTo(member1);
        assertThat(memberRepository.findById(2).get()).isEqualTo(member2);
    }

    @Test
    void test2() {
        Member member1 = new Member("soo");
        Member member2 = new Member("qwe");
        memberRepository.save(member1);
        memberRepository.save(member2);

        assertThat(memberRepository.findByName("soo").get()).isEqualTo(member1);
    }
}