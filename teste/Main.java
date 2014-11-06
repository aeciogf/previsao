package previsao.teste;

import java.io.IOException;

import previsao.util.WeldContext;


public class Main {
	
	public static void main(String[] args) throws IOException {
		
		Teste teste = WeldContext.INSTANCE.getBean(Teste.class);
		teste.executarTestes();
	}
}
