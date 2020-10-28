package auth.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import auth.controller.domain.Const;
import auth.controller.dto.UserDTO;
import auth.entity.Role;
import auth.entity.User;
import auth.repository.RoleRepository;
import auth.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@PostMapping
	public ResponseEntity<User> save(@RequestBody UserDTO userDTO) {
		List<Role> roles = new ArrayList<Role>();
		userDTO.getRoles().stream().forEach(c -> roles.add(roleRepository.findByName(c)));
		
		User user = new User(userDTO.getName(), userDTO.getEmail(), userDTO.getPassword(), roles);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user = this.userRepository.save(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@Secured({ Const.ROLE_ADMIN })
	@PutMapping
	public ResponseEntity<User> edit(@RequestBody User user) {
		roleRepository.saveAll(user.getRoles());
		user = this.userRepository.save(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@Secured({ Const.ROLE_CLIENT, Const.ROLE_ADMIN })
	@GetMapping
	public ResponseEntity<Page<User>> list(@RequestParam("page") int page, @RequestParam("size") int size) {
		Pageable pageable = PageRequest.of(page, size, Sort.by("name"));
		return new ResponseEntity<Page<User>>(userRepository.findAll(pageable), HttpStatus.OK);
	}

}
