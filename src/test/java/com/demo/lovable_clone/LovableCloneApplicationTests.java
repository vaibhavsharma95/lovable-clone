package com.demo.lovable_clone;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.TimeZone;

@SpringBootTest
@RequiredArgsConstructor
class LovableCloneApplicationTests {

	private final JdbcTemplate jdbcTemplate;

	@Test
	void testDbConnection() {
		Integer result = jdbcTemplate.queryForObject("SELECT 1", Integer.class);
		assert result != null;
		assert result == 1;
	}

}
