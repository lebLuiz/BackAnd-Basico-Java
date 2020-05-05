package br.com.treinando.endpoint;

import br.com.treinando.domain.Empresa;
import br.com.treinando.domain.Produto;
import br.com.treinando.service.implement.EmpresaService;
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

public class EmpresaEndpoint extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EmpresaEndpoint</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EmpresaEndpoint at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        String param = request.getParameter("idEmpresa");
        EmpresaService service = new EmpresaService();
        
        Gson gson = new Gson();
        
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        if(Objects.isNull(param)){
            List<Empresa> listaEmpresa = service.findAll();
            
            out.println(gson.toJson(listaEmpresa));
        }else{
            Empresa empresa = service.findOne(Long.valueOf(param));
            
            out.println(gson.toJson(empresa));
        }
    
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        String body  = RequestHelper.getBody(request);
        
        Gson gson = new Gson();
        
        Empresa empresa = gson.fromJson(body, Empresa.class);
        
        EmpresaService service = new EmpresaService();
        
        service.save(empresa);
        
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println(gson.toJson(empresa));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        String body = RequestHelper.getBody(req);
        
        Gson gson = new Gson();
        
        Empresa empresa = gson.fromJson(body, Empresa.class);
        
        EmpresaService service = new EmpresaService();
        
        service.update(empresa);
        
        res.setContentType("application/json;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        out.println(gson.toJson(empresa));
        
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        EmpresaService service = new EmpresaService();
        String param = req.getParameter("idEmpresa");
        
        service.delete(Long.valueOf(param));
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
