package com.demo.lovable_clone.dto.member;

import com.demo.lovable_clone.enums.ProjectRole;

public record InviteMemberRequest (String email, ProjectRole role){
}
