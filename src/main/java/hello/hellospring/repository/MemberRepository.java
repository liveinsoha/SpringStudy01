package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemberRepository implements Repository {

    static MemberRepository Instance = new MemberRepository();
    private Map<Long, Member> repository = new HashMap<>();
    private static long sequence = 0L;

    MemberRepository() {

    }

    public static MemberRepository getInstance() {
        return Instance;
    }

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        repository.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(long id) {
        return Optional.ofNullable(repository.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return repository.values().stream().filter(member -> member.getName().equals(name)).findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(repository.values());
    }

    public void clear() {
        repository.clear();
    }
}
