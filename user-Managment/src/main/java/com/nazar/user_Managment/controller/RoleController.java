package com.nazar.user_Managment.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nazar.user_Managment.entity.Role;
import com.nazar.user_Managment.service.RoleService;

@RestController
@RequestMapping("/persons/{personId}/roles")
public class RoleController {
	
	private final RoleService roleService;
	
	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}
	
	@PostMapping
	public void addRole(@PathVariable Long personId , @RequestBody Role role) {
		//add role by persons id
		roleService.addRole(personId, role);
	}
}
