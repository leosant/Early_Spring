package principal;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import service.UsuarioServico;
import teste.Usuario;

@Configuration
@ComponentScan("service")
public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner lerDados = new Scanner(System.in);
        Usuario usuario = new Usuario("Leonardo dos Santos",
          "leonardo@exemplo.com", "leo0153");

        System.out.println("Deseja recuperar a senha (S/N)?");
        String resposta = lerDados.nextLine();
        if (resposta.equalsIgnoreCase("S")) {
            ApplicationContext context = new
             AnnotationConfigApplicationContext(Programa.class);
            UsuarioServico usuarioServico =
             context.getBean(UsuarioServico.class);

            usuarioServico.setUsuario(usuario);
            usuarioServico.lembrarSenhaPorEmail();
        }
	}

}
