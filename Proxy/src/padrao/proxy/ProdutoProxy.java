package padrao.proxy;

import java.util.List;

public class ProdutoProxy implements IProduto {
    private Produto produto;
    private Integer codigo;

    public ProdutoProxy(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public List<String> obterDadosProduto() {
        if (this.produto == null) {
            this.produto = new Produto(this.codigo);
        }
        return this.produto.obterDadosProduto();
    }

    @Override
    public List<Float> obterPrecos(Cliente cliente) {
        if (!cliente.isUsuarioLogado()) {
            throw new IllegalArgumentException("Usuário não está logado");
        }
        if (this.produto == null) {
            this.produto = new Produto(this.codigo);
        }
        return this.produto.obterPrecos(cliente);
    }
}
