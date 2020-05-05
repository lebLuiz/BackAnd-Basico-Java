package br.com.treinando.repository.interfaces;

import br.com.treinando.domain.Empresa;

public interface IEmpresaRepository extends IRepository<Empresa>{
    
    Empresa findByIdProduto(Long idProduto);
    
    void deleteByIdProduto(Long idProduto);
}
