package com.manuelsoft.abarrote;

import com.manuelsoft.abarrote.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest

class AbarroteApplicationTests {

	@Autowired
	private CategoryRepository categoryRepository;

	@Test
	void testFind() {

		var category = categoryRepository.findById(1L);

		assertThat(category).isNotNull();

	}

	@Test
	void testGetReference() {

		var category = categoryRepository.getReferenceById(20L);
        assertSame(2L, category.getId(), "Id es " + category.getId());

	}

}
