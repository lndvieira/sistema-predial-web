
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Empresa;
import model.Horario;
import service.EmpresaService;

/**
 * Servlet implementation class SistemaPredialServlet
 */
@WebServlet("/SistemaPredialServlet")
public class SistemaPredialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SistemaPredialServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pRazao = request.getParameter("razao");
		String pCNPJ = request.getParameter("cnpj");
		String pTemp = request.getParameter("temp");
		int pConj = Integer.parseInt(request.getParameter("conj"));
		Horario pHoraFunc = new Horario(request.getParameter("horaFuncE"), request.getParameter("horaFuncS"));
		Horario pHoraAR = new Horario(request.getParameter("horaArL"), request.getParameter("horaArD"));
		String pAcao = request.getParameter("Acao");
		
		if ("Cadastrar".equals(pAcao)) {
		Empresa empresa = new Empresa(pRazao,pCNPJ,pTemp,pConj,pHoraFunc,pHoraAR);
		// instanciar o service
		EmpresaService es = new EmpresaService();
		es.incluir(empresa);
		empresa.equals(es.carregar(empresa.getCnpj()));
		// enviar para o jsp
		request.setAttribute("empresa", empresa);
		RequestDispatcher view = request.getRequestDispatcher("predio.jsp");
		view.forward(request, response);
		}
		
		if ("Deletar".equals(pAcao)) {
			Empresa empresa = new Empresa(pRazao,pCNPJ,pTemp,pConj,pHoraFunc,pHoraAR);
			// instanciar o service
			EmpresaService es = new EmpresaService();
			empresa.equals(es.carregar(empresa.getCnpj()));
			es.excluir(empresa.getCnpj());
			// enviar para o jsp
			request.setAttribute("empresa", empresa);
			RequestDispatcher view = request.getRequestDispatcher("predio.jsp");
			view.forward(request, response);
			}
		
		if ("Consultar".equals(pAcao)) {
			Empresa empresa = new Empresa();
			empresa.setCnpj(pCNPJ);
			// instanciar o service
			EmpresaService es = new EmpresaService();
			empresa.equals(es.carregar(empresa.getCnpj()));
			es.carregar(empresa.getCnpj());
			// enviar para o jsp
			request.setAttribute("empresa", empresa);
			RequestDispatcher view = request.getRequestDispatcher("predio.jsp");
			view.forward(request, response);
			}
		
		if ("Atualizar".equals(pAcao)) {
			Empresa empresa = new Empresa(pRazao,pCNPJ,pTemp,pConj,pHoraFunc,pHoraAR);
			// instanciar o service
			EmpresaService es = new EmpresaService();
			if(empresa.equals(es.carregar(empresa.getCnpj()))){
				es.atualizar(empresa, empresa.getCnpj());
				// enviar para o jsp
				request.setAttribute("empresa", empresa);
				RequestDispatcher view = request.getRequestDispatcher("predio.jsp");
				view.forward(request, response);
			}	
		}
	}

}