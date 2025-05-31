package br.com.fiap.Gs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "SafeRoute API", description = "antes de acessar os endpoints, crie um usuario no post user e acesse o endpoint de logar no auth controller, sendo assim ira gerar o token jwt se o usuario existir, apos isso cole o token no cadeado acima de todos os endpoints, sendo assim se o token estiver certo todos os endpoints e cruds de alerta, abrigo e de rota segura estara disponiveis", version = "v1"))
public class GsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GsApplication.class, args);
	}

}
