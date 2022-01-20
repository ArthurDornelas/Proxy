package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import padrao.proxy.BD;
import padrao.proxy.Cliente;
import padrao.proxy.Produto;
import padrao.proxy.ProdutoProxy;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ProdutoProxyTest {

    @BeforeEach
    void setUp() {
        BD.addProduto(new Produto(1, "Mesa", "MoveisSA", 500.0f, 450.0f));
        BD.addProduto(new Produto(2, "Cadeira", "MoveisSA", 50.0f, 45.0f));
    }

    @Test
    void deveRetornarDadosProduto() {
        ProdutoProxy produto = new ProdutoProxy(1);

        assertEquals(Arrays.asList("Mesa", "MoveisSA"), produto.obterDadosProduto());
    }

    @Test
    void deveRetornarPrecosProduto() {
        Cliente cliente = new Cliente("jwt123", true);
        ProdutoProxy produto = new ProdutoProxy(2);

        assertEquals(Arrays.asList(50.0f, 45.0f), produto.obterPrecos(cliente));
    }

    @Test
    void deveRetornarExcecaoUsuarioNaoLogadoConsultarPrecosProduto() {
        try {
            Cliente cliente = new Cliente("jwt123", false);
            ProdutoProxy produto = new ProdutoProxy(2);

            produto.obterPrecos(cliente);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Usuário não está logado", e.getMessage());
        }
    }
}
