package br.com.treinando.domain;

public class Empresa {
    
    private Long idEmpresa;
    private String nomeEmpresa;
    private String cnpj;
    private String responsavel;
    private int desdeAno;
    private String descricao;
    
    public Empresa(){
    }

    public Long getIdEmpresa() {
        return idEmpresa;
    }
    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }
    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    public String getResponsavel(){
        return responsavel;
    }
    public void setResponsavel(String responsavel){
        this.responsavel = responsavel;
    }
    
    public int getDesdeAno(){
        return desdeAno;
    }
    public void setDesdeAno(int desdeAno){
        this.desdeAno = desdeAno;
    }
    
    public String getDescricao(){
        return descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
}
