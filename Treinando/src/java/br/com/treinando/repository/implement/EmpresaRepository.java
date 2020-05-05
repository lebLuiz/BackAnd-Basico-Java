package br.com.treinando.repository.implement;

import br.com.treinando.domain.Empresa;
import br.com.treinando.repository.interfaces.IEmpresaRepository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpresaRepository implements IEmpresaRepository{

    private final String url = "jdbc:postgresql://localhost:5432/treinando";
    private final String user = "-seu usuário-";
    private final String password = "-sua senha-";
    
    @Override
    public Empresa save(Empresa empresa) {
        
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
            System.out.println("Driver não Encontrado. Classe EmpresaRepository");
        }
        
        try{
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = con.prepareStatement("insert into empresa (nome_empresa, cnpj, responsavel, desde_ano, descricao) values (?,?,?,?,?)");
            
            ps.setString(1, empresa.getNomeEmpresa());
            ps.setString(2, empresa.getCnpj());
            ps.setString(3, empresa.getResponsavel());
            ps.setInt(4, empresa.getDesdeAno());
            ps.setString(5, empresa.getDescricao());
            
            ps.execute();
            ps.close();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("Erro de Conexão. Classe EmpresaRepository");
        }
        return empresa;
    }

    @Override
    public Empresa update(Empresa empresa) {
        
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
            System.out.println("Driver não Encontrado. Classe EmpresaRepository");
        }
        
        try{
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = con.prepareStatement("update empresa set nome_empresa=?, cnpj=?, responsavel=?, desde_ano=?, descricao=? where id_empresa=?");
            
            ps.setString(1, empresa.getNomeEmpresa());
            ps.setString(2, empresa.getCnpj());
            ps.setString(3, empresa.getResponsavel());
            ps.setInt(4, empresa.getDesdeAno());
            ps.setString(5, empresa.getDescricao());
            
            ps.setLong(6, empresa.getIdEmpresa());
            
            ps.executeUpdate();
            ps.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("Erro de Conexão. Classe EmpresaRepository");
        }
        return empresa;
    }

    @Override
    public void delete(Long idEmpresa) {
        
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
            System.out.println("Driver não Encontrado. Classe EmpresaRepository");
        }
        
        try{
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = con.prepareStatement("delete from empresa where id_empresa=?");
        
            ps.setLong(1, idEmpresa);
            
            ps.executeQuery();
            ps.close();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("Erro de Conexão. Classe EmpresaRepository");
        }
    }

    @Override
    public Empresa findOne(Long idEmpresa) {
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
            System.out.println("Driver não Encontrado. Classe EmpresaRepository");
        }
        Empresa empresa = new Empresa();
        try{
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = con.prepareStatement("select id_empresa, nome_empresa, cnpj, responsavel, desde_ano, descricao from empresa where id_empresa=?");
            
            ps.setLong(1, idEmpresa);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                empresa.setIdEmpresa(rs.getLong(1));
                empresa.setNomeEmpresa(rs.getString(2));
                empresa.setCnpj(rs.getString(3));
                empresa.setResponsavel(rs.getString(4));
                empresa.setDesdeAno(rs.getInt(5));
                empresa.setDescricao(rs.getString(6));
                
            }
            
            ps.execute();
            ps.close();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("Erro de Conexão. Classe EmpresaRepository");
        }
        return empresa;
    }

    @Override
    public List<Empresa> findAll() {
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
            System.out.println("Driver não Encontrado. Classe EmpresaRepository");
        }
        List<Empresa> listaEmpresa = new ArrayList();
        try{
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = con.prepareStatement("select id_empresa, nome_empresa, cnpj, responsavel, desde_ano, descricao from empresa order by id_empresa");
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Empresa empresa = new Empresa();
                
                empresa.setIdEmpresa(rs.getLong(1));
                empresa.setNomeEmpresa(rs.getString(2));
                empresa.setCnpj(rs.getString(3));
                empresa.setResponsavel(rs.getString(4));
                empresa.setDesdeAno(rs.getInt(5));
                empresa.setDescricao(rs.getString(6));
                
                listaEmpresa.add(empresa);
            }
            
            ps.execute();
            ps.close();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("Erro de Conexão. Classe EmpresaRepository");
        }
        return listaEmpresa;
    }
    
    //Métodos abstratos para o Produto
    @Override
    public Empresa findByIdProduto(Long idProduto) {
        return null;
    }

    @Override
    public void deleteByIdProduto(Long idProduto) {
    }

}
