package com.example.tarea1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Math;

@WebServlet(name = "ServletHipotenusa", value = "/ServletHipotenusa")
public class ServletHipotenusa extends HttpServlet {

    private static final String DEVELOPER_NAME_1 = "José Tomás Izaguirre";
    private static final String ACCOUNT_NUMBER_1 = "202320010064";
    private static final String DEVELOPER_NAME_2 = "Joseph Stalyn Rodriguez Inestroza";
    private static final String ACCOUNT_NUMBER_2 = "202420010081";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            double ladoA = Double.parseDouble(request.getParameter("ladoA"));
            double ladoB = Double.parseDouble(request.getParameter("ladoB"));

            if (ladoA <= 0 || ladoB <= 0) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Error</title>");
                out.println("<style>");
                out.println("body { font-family: Arial, sans-serif; margin: 20px; background-color: #f4f4f4; color: #333; }");
                out.println(".container { background-color: #fff; padding: 30px; border-radius: 8px; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); max-width: 600px; margin: auto; }");
                out.println("h1 { color: #dc3545; }");
                out.println(".back-link { display: block; margin-top: 20px; color: #007bff; text-decoration: none; font-weight: bold; }");
                out.println(".back-link:hover { text-decoration: underline; }");
                out.println("</style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<div class=\"container\">");
                out.println("<h1>Error: Los lados deben ser números positivos.</h1>");
                out.println("<a href=\"hipotenusa.html\" class=\"back-link\">Volver al formulario de Hipotenusa</a>");
                out.println("<a href=\"index.html\" class=\"back-link\">Volver al Menú Principal</a>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
                return;
            }

            double hipotenusa = Math.sqrt(Math.pow(ladoA, 2) + Math.pow(ladoB, 2));

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultado Hipotenusa</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; margin: 20px; background-color: #f4f4f4; color: #333; }");
            out.println(".container { background-color: #fff; padding: 30px; border-radius: 8px; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); max-width: 600px; margin: auto; }");
            out.println("h1 { color: #28a745; }");
            out.println("p { font-size: 1.1em; }");
            out.println("table { width: 100%; border-collapse: collapse; margin-top: 20px; }");
            out.println("th, td { border: 1px solid black; padding: 8px; text-align: left; }");
            out.println("th { background-color: #f2f2f2; }");
            out.println(".back-link { display: block; margin-top: 20px; color: #007bff; text-decoration: none; font-weight: bold; }");
            out.println(".back-link:hover { text-decoration: underline; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"container\">");
            out.println("<h2>Servlet Tarea 1: " + DEVELOPER_NAME_1 + "</h2>");
            out.println("<p>Cuenta: " + ACCOUNT_NUMBER_1 + "</p>");
            out.println("<h2>Servlet Tarea 1: " + DEVELOPER_NAME_2 + "</h2>");
            out.println("<p>Cuenta: " + ACCOUNT_NUMBER_2 + "</p>");
            out.println("<p>Operación realizada: Cálculo de la hipotenusa</p>");
            out.println("<table border=\"1\">");
            out.println("<tr><th>Entrada</th><th>Respuesta</th></tr>");
            out.println("<tr><td>Lado A: " + ladoA + "<br>Lado B: " + ladoB + "</td><td>Hipotenusa: " + String.format("%.2f", hipotenusa) + "</td></tr>");
            out.println("</table>");
            out.println("<a href=\"hipotenusa.html\" class=\"back-link\">Calcular otra Hipotenusa</a>");
            out.println("<a href=\"index.html\" class=\"back-link\">Volver al Menú Principal</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");

        } catch (NumberFormatException e) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Error</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; margin: 20px; background-color: #f4f4f4; color: #333; }");
            out.println(".container { background-color: #fff; padding: 30px; border-radius: 8px; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); max-width: 600px; margin: auto; }");
            out.println("h1 { color: #dc3545; }");
            out.println(".back-link { display: block; margin-top: 20px; color: #007bff; text-decoration: none; font-weight: bold; }");
            out.println(".back-link:hover { text-decoration: underline; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"container\">");
            out.println("<h1>Error: Por favor, ingrese números válidos para los lados A y B.</h1>");
            out.println("<a href=\"hipotenusa.html\" class=\"back-link\">Volver al formulario de Hipotenusa</a>");
            out.println("<a href=\"index.html\" class=\"back-link\">Volver al Menú Principal</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
}
