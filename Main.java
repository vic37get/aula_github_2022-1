import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		Menu mainMenu = new Menu("Menu Principal", Arrays.asList("Conta", "Cliente", "Operacoes"));
		mainMenu.MenuIniciar();
		// System.out.println(mainMenu.getSelection() + "foi selecionada");
		System.out.println("Fim");
	}

}
