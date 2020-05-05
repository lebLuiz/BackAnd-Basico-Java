package br.com.treinando.service.implement;

import br.com.treinando.domain.Produto;
import br.com.treinando.repository.implement.ProdutoRepository;
import br.com.treinando.service.interfaces.IProdutoService;
import java.util.List;

public class ProdutoService implements IProdutoService{

    @Override
    public Produto save(Produto produto) {
        
        ProdutoRepository repository = new ProdutoRepository();
        
        return repository.save(produto);
        
    }

    @Override
    public Produto update(Produto produto) {
        
        ProdutoRepository repository = new ProdutoRepository();
        
        return repository.update(produto);
        
    }

    @Override
    public void delete(Long idProduto) {
        ProdutoRepository repository = new ProdutoRepository();
        
        repository.delete(idProduto);
    }

    @Override
    public Produto findOne(Long idProduto) {
        
        ProdutoRepository repository = new ProdutoRepository();
        
        return repository.findOne(idProduto);
    }

    @Override
    public List<Produto> findAll() {
        
        ProdutoRepository repository = new ProdutoRepository();
        
        return repository.findAll();
        
    }

    @Override
    public List<Produto> findByIdEmpresa(Long idEmpresa) {
        ProdutoRepository repository = new ProdutoRepository();
        
        return repository.findByIdEmpresa(idEmpresa);
    }
    
}
