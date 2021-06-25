/*
	* Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
	* Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
	* Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
	* Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
	* Vestibulum commodo. Ut rhoncus gravida arcu.
	*/

package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

/**
	* @author Madhura Bhave
	*/
@DataJpaTest
@ActiveProfiles("test")
public class CatsEntityTests {

	private final TestEntityManager entityManager;

	@Autowired
	CatsEntityTests(TestEntityManager tem) {
		this.entityManager = tem;
	}

	@Test
	void catCanBePersisted() {
		Cat toby = this.entityManager.persistFlushFind(new Cat("Toby"));
		assertThat(toby.getName()).isEqualTo("Toby");
	}
}
