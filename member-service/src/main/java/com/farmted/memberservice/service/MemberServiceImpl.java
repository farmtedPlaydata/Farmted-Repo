package com.farmted.memberservice.service;

import com.farmted.memberservice.domain.Member;
import com.farmted.memberservice.dto.request.RequestCreateMemberDto;
import com.farmted.memberservice.dto.request.RequestUpdateMemberDto;
import com.farmted.memberservice.dto.request.SearchMemberParam;
import com.farmted.memberservice.dto.response.MemberResponseDto;
import com.farmted.memberservice.enums.RoleEnums;
import com.farmted.memberservice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    @Override
    public void createMember(RequestCreateMemberDto dto) {
        dto.setMemberRole(RoleEnums.USER);
        Member member = dto.toEntity();
        memberRepository.save(member);
    }

    @Transactional
    @Override
    public void updateMember(RequestUpdateMemberDto dto, Member member) {
        Member upMember = memberRepository.getMemberByMemberUuid(member.getMemberUuid());
        upMember.updateMember(dto);
        memberRepository.save(upMember);
    }

    @Transactional
    @Override
    public void deleteMember(String uuid) {
        memberRepository.deleteByMemberUuid(uuid);
    }

    @Transactional
    @Override
    public void grantRole(String uuid, RoleEnums role) {
        Member member = memberRepository.findByMemberUuid(uuid)
                .orElseThrow(() -> new RuntimeException("ERROR: memberservice - grantRole"));

        RoleEnums currentRole = member.getMemberRole();
        RoleEnums newRole = (currentRole == RoleEnums.USER)
                ? RoleEnums.ADMIN       // 현재 role이 USER이면 ADMIN으로 변경
                : RoleEnums.USER;       // ADMIN일 경우 USER로 변경
        member.changeRole(newRole);
    }

    @Override
    public Page<MemberResponseDto> getAllMember(SearchMemberParam param, Pageable pageable) {
        return memberRepository.findAll(param, pageable);
    }
}
