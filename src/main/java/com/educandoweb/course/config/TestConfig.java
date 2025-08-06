package com.educandoweb.course.config;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration    // deixa explicito para o spring que essa é uma classe de configuração
@Profile("test") //diz para o spring que essa config só vai valer para quando estiver no perfil de test
public class TestConfig implements CommandLineRunner {
    @Autowired //O spring faz a injeção de dependência desse objeto com a classe testConfig
    private UserRepository userRepository; // objeto que acessa o banco de dados
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception { // método run da CommandLine executa os estiver dentro.
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);// data no padrão iso 8601
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);
        userRepository.saveAll(Arrays.asList(u1,u2)); // salva os objetos no banco de dados
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
    }
}
