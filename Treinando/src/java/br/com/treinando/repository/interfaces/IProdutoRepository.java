package br.com.treinando.repository.interfaces;

import br.com.treinando.domain.Produto;
import java.util.List;

public interface IProdutoRepository extends IRepository<Produto>{
    
    List<Produto> findByIdEmpresa(Long idEmpresa);
    
    //void deleteByIdProduto(Long idProduto);
    
}
