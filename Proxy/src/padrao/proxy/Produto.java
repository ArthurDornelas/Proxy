package padrao.proxy;

import java.util.Arrays;
import java.util.List;

public class Produto implements IProduto {
    private Integer codigo;
    private String nome;
    private String vendedor;
    private Float preco;
    private Float precoComDesconto;

    public Produto(Integer codigo) {
        this.codigo = codigo;
        Produto objeto = BD.getProduto(codigo);
        this.nome = objeto.nome;
        this.vendedor = objeto.vendedor;
        this.preco = objeto.preco;
        this.precoComDesconto = objeto.precoComDesconto;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public Produto(Integer codigo, String nome, String vendedor, Float preco, Float precoComDesconto) {
        this.codigo = codigo;
        this.nome = nome;
        this.vendedor = vendedor;
        this.preco = preco;
        this.precoComDesconto = precoComDesconto;
    }

    @Override
    public List<String> obterDadosProduto() {
        return Arrays.asList(this.nome, this.vendedor);
    }

    @Override
    public List<Float> obterPrecos(Cliente cliente) {
        return Arrays.asList(this.preco, this.precoComDesconto);
    }
}
