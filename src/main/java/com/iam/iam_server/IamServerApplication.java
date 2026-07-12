package com.iam.iam_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.iam.iam_server.entity.Permission;
import com.iam.iam_server.repository.PermissionRepository;
@SpringBootApplication
public class IamServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(IamServerApplication.class, args);
	}

}
