package com.blog;

import com.blog.entity.Role;
import com.blog.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

import static com.blog.constant.CategoryConstant.ADMIN_USER;
import static com.blog.constant.CategoryConstant.NORMAL_USER;
import static org.slf4j.LoggerFactory.getLogger;

@SpringBootApplication
public class BlogAppApiApplication implements CommandLineRunner {
    static final Logger LOGGER = getLogger(BlogAppApiApplication.class);
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(BlogAppApiApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


    @Override
    public void run(String... args) throws Exception {
        try {
            Role role = new Role();
            role.setId(ADMIN_USER);
            role.setName("ADMIN_USER");

            Role role1 = new Role();
            role1.setId(NORMAL_USER);
            role1.setName("NORMAL_USER");

            List<Role> roles = List.of(role, role1);
            List<Role> result = this.roleRepository.saveAll(roles);

            result.forEach(r ->
                    LOGGER.info(r.getName()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
