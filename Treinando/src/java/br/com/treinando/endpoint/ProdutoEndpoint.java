package br.com.treinando.endpoint;

import br.com.treinando.domain.Empresa;
import br.com.treinando.domain.Produto;
import br.com.treinando.service.implement.ProdutoService;
import br.com.treinando.utils.RequestHelper;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProdutoEndpoint extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProdutoEndpoint</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProdutoEndpoint at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        String param = request.getParameter("idProduto");
        String param2 = request.getParameter("idEmpresa");
        ProdutoService service = new ProdutoService();
        
        Gson gson = new Gson();
        
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        if((Objects.isNull(param)) && (Objects.isNull(param2))){
            List<Produto> listaProduto = service.findAll();
            
            out.println(gson.toJson(listaProduto));
        }else if(Objects.nonNull(param)){
            Produto produto = service.findOne(Long.valueOf(param));
            
            out.println(gson.toJson(produto));
        }else{
            List<Produto> produto = service.findByIdEmpresa(Long.valueOf(param2));
            
            out.println(gson.toJson(produto));
        }
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //DO JEITO QUE DÁ CERTO PELO BODY.
        /*Obs: Na hora de colocar o idEmpresa, crie um array da empresa:
        ex: "empresa": { "idEmpresa": 4}*/
        ProdutoService service = new ProdutoService();
        
        Gson gson = new Gson();
        
        String body = RequestHelper.getBody(request);
        
        response.setContentType("appplication/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        Produto produto = gson.fromJson(body, Produto.class);
        
        service.save(produto);
        
        out.println(gson.toJson(produto));
        
        //DO JEITO QUE DÁ CERTO PELOS PARÂMETROS
        /*ProdutoService service = new ProdutoService(); 
        Produto produto = new Produto();
        Gson gson = new Gson();
        
        //Pegando o id da Empresa, para depois passar na variável empresa do Produto
        Empresa empresa = new Empresa();
        empresa.setIdEmpresa(Long.valueOf(request.getParameter("idEmpresa")));
        produto.setEmpresa(empresa);
            
        produto.setNomeProduto(request.getParameter("nomeProduto"));
        produto.setValor(Double.parseDouble(request.getParameter("valor")));
            
        service.save(produto);*/
        
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        ProdutoService service = new ProdutoService();
        String body = RequestHelper.getBody(req);
        Gson gson = new Gson();
        
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        
        Produto produto = gson.fromJson(body, Produto.class);
        
        service.update(produto);
        
        out.println(gson.toJson(produto));
        
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        ProdutoService service = new ProdutoService();
        
        service.delete(Long.valueOf(req.getParameter("idProduto")));
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
