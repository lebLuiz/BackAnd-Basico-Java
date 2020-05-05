package br.com.treinando.service.implement;

import br.com.treinando.domain.Empresa;
import br.com.treinando.repository.implement.EmpresaRepository;
import br.com.treinando.service.interfaces.IEmpresaService;
import java.util.List;

public class EmpresaService implements IEmpresaService{

    @Override
    public Empresa save(Empresa empresa) {
        EmpresaRepository repository = new EmpresaRepository();
        
        return repository.save(empresa);
    }

    @Override
    public Empresa update(Empresa empresa) {
        EmpresaRepository repository = new EmpresaRepository();
        
        return repository.update(empresa);
    }

    @Override
    public void delete(Long idEmpresa) {
        EmpresaRepository repository = new EmpresaRepository();
        
        repository.delete(idEmpresa);
    }

    @Override
    public Empresa findOne(Long idEmpresa) {
        EmpresaRepository repository = new EmpresaRepository();
        
        return repository.findOne(idEmpresa);
    }

    @Override
    public List<Empresa> findAll() {
        EmpresaRepository repository = new EmpresaRepository();
        
        return repository.findAll();
    }
    
    //Métodos abstratos do Produto
    @Override
    public Empresa findByIdProduto(Long idProduto) {
        return null;
    }

    @Override
    public void deleteByIdProduto(Long idProduto) {
    }
}
