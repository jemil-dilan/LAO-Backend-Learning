package com.laoBackend.gestionaire_de_biblioteque.repository;

import com.laoBackend.gestionaire_de_biblioteque.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByEmail(String memberEmail);
}
