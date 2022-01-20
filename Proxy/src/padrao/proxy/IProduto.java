package padrao.proxy;

import java.util.List;

public interface IProduto {
    List<String> obterDadosProduto();
    List<Float> obterPrecos(Cliente cliente);
}
