package com.example.Pawtropolis;

import com.example.Pawtropolis.game.service.GameManager;
import com.example.Pawtropolis.game.model.Player;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.context.support.AbstractApplicationContext;

@SpringBootApplication
public class PawtropolisApplication {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(PawtropolisApplication.class);
		for(String beanName : ctx.getBeanDefinitionNames()){
			System.out.println("Bean ----> " + beanName);
		}
		GameManager gameManager = ctx.getBean(GameManager.class);
		ctx.getBean(Player.class).setName("Aldo");
		gameManager.runGame();
		ctx.close();
	}
}
