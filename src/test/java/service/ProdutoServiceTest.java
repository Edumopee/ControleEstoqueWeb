package service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProdutoServiceTest {

    @Test
    public void testCalcularValorTotalEstoque() {
        System.out.println("Executando: testCalcularValorTotalEstoque");
        ProdutoService instance = new ProdutoService();
        
        double valor = 100.0;
        int quantidade = 5;
        double expResult = 500.0;
        
        double result = instance.calcularValorTotalEstoque(valor, quantidade);
        
        assertEquals(expResult, result, 0.01, "O cálculo do valor total deve ser exato.");
    }

    @Test
    public void testCalcularEstoqueNegativo() {
        System.out.println("Executando: testCalcularEstoqueNegativo");
        ProdutoService instance = new ProdutoService();
        
        // Verifica se o sistema lança a exceção correta ao receber valor negativo
        assertThrows(IllegalArgumentException.class, () -> {
            instance.calcularValorTotalEstoque(10.0, -1);
        });
    }
}