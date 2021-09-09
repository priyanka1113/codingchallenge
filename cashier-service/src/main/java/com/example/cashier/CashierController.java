package com.example.cashier;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cashier.exception.ResourceNotFoundException;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class CashierController {

	@Autowired
	private CashierService cashierService;

	@GetMapping("/cashier")
	public List<Cashier> getCashiers() throws Exception {
		return cashierService.getCashiers();
	}

	@GetMapping("/cashier/{id}")
	public ResponseEntity<Cashier> getCashierById(@PathVariable("id") int id) {
		Cashier cashier= cashierService.getCashierById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cashier Not found with id = " + id));
		return new ResponseEntity<> (cashier,HttpStatus.OK);
	}

	@PostMapping("/cashier")
	public Cashier createCashierTerminal(@RequestBody Cashier cashier) {
		cashierService.createCashierTerminal(cashier);
		return cashier;
	}

	
	@PostMapping("/cashierlogin")
	public Cashier login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
		
		String token = getJWTToken(username);
		Cashier cashier = new Cashier();
		cashier.setUser(username);
		cashier.setToken(token);		
		return cashier;
		
	}
	
	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("1")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Pass " + token;
	}
}
