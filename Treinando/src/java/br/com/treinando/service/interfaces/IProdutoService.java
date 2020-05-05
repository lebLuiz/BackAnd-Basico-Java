package br.com.treinando.service.interfaces;

import br.com.treinando.domain.Produto;
import java.util.List;

public interface IProdutoService extends IService<Produto>{
    
    List<Produto> findByIdEmpresa(Long idEmpresa);
    
    //void deleteByIdProduto(Long idProduto);
    
}
