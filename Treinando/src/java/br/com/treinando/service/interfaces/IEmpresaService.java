package br.com.treinando.service.interfaces;

import br.com.treinando.domain.Empresa;

public interface IEmpresaService extends IService<Empresa>{
    
    Empresa findByIdProduto(Long idProduto);
    
    void deleteByIdProduto(Long idProduto);
}
