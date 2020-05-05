package br.com.treinando.repository.implement;

import br.com.treinando.domain.Empresa;
import br.com.treinando.domain.Produto;
import br.com.treinando.repository.interfaces.IProdutoRepository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository implements IProdutoRepository{

    private final String url = "jdbc:postgresql://localhost:5432/treinando";
    private final String user = "-seu usuário-";
    private final String password = "-sua senha-";
    
    @Override
    public Produto save(Produto produto) {
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
            System.out.println("Driver não Encontrado. Classe ProdutoRepository");
        }
        
        try{
            
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = con.prepareStatement("insert into produto (id_empresa, nome_produto, valor) values (?,?,?)");
            
            ps.setLong(1, produto.getEmpresa().getIdEmpresa());
            ps.setString(2, produto.getNomeProduto());
            ps.setDouble(3, produto.getValor());
            
            ps.execute();
            ps.close();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("Erro de Conexão. Classe ProdutoRepository");
        }
        return produto;
    }

    @Override
    public Produto update(Produto produto) {
        
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
            System.out.println("Driver não Encontrado. Classe ProdutoRepository");
        }
        
        try{
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = con.prepareStatement("update produto set id_empresa=?, nome_produto=?, valor=? where id_produto=?");
            
            ps.setLong(1, produto.getEmpresa().getIdEmpresa());
            ps.setString(2, produto.getNomeProduto());
            ps.setDouble(3, produto.getValor());
            
            ps.setLong(4, produto.getIdProduto());
            
            ps.executeUpdate();
            ps.close();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("Erro de Conexão. Classe ProdutoRepository");
        }
        return produto;
    }

    @Override
    public void delete(Long idProduto) {
        
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
            System.out.println("Driver não Encontrado. Classe ProdutoRepository");
        }
        
        try{
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = con.prepareStatement("delete from produto where id_produto=?");
            
            ps.setLong(1, idProduto);
            
            ps.execute();
            ps.close();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("Erro de Conexão. Classe ProdutoRepository");
        }
        
    }

    @Override
    public Produto findOne(Long idProduto) {
        
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
            System.out.println("Driver não Encontrado. Classe ProdutoRepository");
        }
        
        Produto produto = new Produto();
        
        try{
            
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = con.prepareStatement("select id_produto, id_empresa, nome_produto, valor from produto where id_produto=? order by id_produto");
            
            ps.setLong(1, idProduto);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                produto.setIdProduto(rs.getLong(1));
                
                Empresa empresa = new Empresa();
                empresa.setIdEmpresa(rs.getLong(2));
                produto.setEmpresa(empresa);
                
               // produto.getEmpresa().setIdEmpresa(rs.getLong(2));
                produto.setNomeProduto(rs.getString(3));
                produto.setValor(rs.getDouble(4));
            }
            
            ps.execute();
            ps.close();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("Erro de conexão. Classe ProdutoRepository");
        }
        return produto;
    }

    @Override
    public List<Produto> findAll() {
        
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
            System.out.println("Driver não Encontrado. Classe ProdutoRepository");
        }
        
        List<Produto> listaProduto = new ArrayList();
        
        try{
            
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = con.prepareStatement("select id_produto, id_empresa, nome_produto, valor from produto order by id_produto");
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                Produto produto = new Produto();
                
                produto.setIdProduto(rs.getLong(1));
                
                Empresa empresa = new Empresa();
                empresa.setIdEmpresa(rs.getLong(2));
                
                produto.setEmpresa(empresa);
                
                //produto.getEmpresa().setIdEmpresa(rs.getLong(2));
                produto.setNomeProduto(rs.getString(3));
                produto.setValor(rs.getDouble(4));
                
                listaProduto.add(produto);
            }
            
            ps.execute();
            ps.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("Erro de Conexão. Classe ProdutoRepository");
        }
        return listaProduto;
    }

    @Override
    public List<Produto> findByIdEmpresa(Long idEmpresa) {
        
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
            System.out.println("Driver não Encontrado. Classe ProdutoRepository");
        }
        
        List<Produto> listaProduto = new ArrayList();
        
        try{
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = con.prepareStatement("select id_empresa, id_produto, nome_produto, valor from produto where id_empresa=?");
            
            ps.setLong(1, idEmpresa);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Produto produto = new Produto();
                
                Empresa empresa = new Empresa();
                empresa.setIdEmpresa(rs.getLong(1));
                
                produto.setEmpresa(empresa);
                
                produto.setIdProduto(rs.getLong(2));
                produto.setNomeProduto(rs.getString(3));
                produto.setValor(rs.getDouble(4));
                
                listaProduto.add(produto);
            }
            
            ps.execute();
            ps.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("Erro de Conexão. Classe ProdutoRepository");
        }
        return listaProduto;
    }
}
