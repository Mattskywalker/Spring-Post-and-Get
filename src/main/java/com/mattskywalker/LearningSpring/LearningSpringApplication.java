package com.mattskywalker.LearningSpring;

import com.mattskywalker.LearningSpring.hibernate.ClienteDao;
import com.mattskywalker.LearningSpring.hibernate.ClienteDaoInterface;
import com.mattskywalker.LearningSpring.model.Cliente;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearningSpringApplication {

	public static void main(String[] args) {

		ClienteDaoInterface clienteDao = new ClienteDao();

		clienteDao.Listar().stream().forEach(cliente -> {
			System.out.println("Cliente: " + cliente);
		});

		//clienteDao.deletar(new Cliente("5"));


		SpringApplication.run(LearningSpringApplication.class, args);
	}

}
