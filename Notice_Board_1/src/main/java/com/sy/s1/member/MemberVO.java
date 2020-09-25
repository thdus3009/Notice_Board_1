package com.sy.s1.member;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class MemberVO {
	@NotEmpty(message = "내용이 비어있으면 안됩니다.")
	private String id;
	@NotEmpty
	@Size(min = 1, max = 4)
	private String pw;
	@NotEmpty
	private String pwCheck;
	@NotEmpty
	private String name;
	@Email
	private String email;
	private String phone;
	
	
}
