package com.example.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AdminRole extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	//角色id   
	private Long roleId;
	//用户id   
	private Long adminId;


}

