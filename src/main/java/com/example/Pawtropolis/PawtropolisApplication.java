package com.example.Pawtropolis;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.context.support.AbstractApplicationContext;

@SpringBootApplication
public class PawtropolisApplication {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(PawtropolisApplication.class);
		ctx.close();
	}
}
