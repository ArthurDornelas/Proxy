package padrao.proxy;

public class Cliente {
    private String token;
    private boolean usuarioLogado;

    public Cliente(String token, boolean usuarioLogado) {
        this.token = token;
        this.usuarioLogado = usuarioLogado;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(boolean usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }
}
