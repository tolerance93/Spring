package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// interface만으로도 개발이 끝남!!. 단순한 80프로는 인터페스로 해결. 나머지 20프로에 집중할 수 있다.
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // JPQL selete m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);
}
