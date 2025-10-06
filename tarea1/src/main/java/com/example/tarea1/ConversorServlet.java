package com.example.tarea1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ServletBinarios")
public class ConversorServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // Información de los desarrolladores
    private static final String DEVELOPER_NAME_1 = "Darwin R. Oliva";
    private static final String ACCOUNT_NUMBER_1 = "202110020297";
    private static final String DEVELOPER_NAME_2 = "Merari Abigail Valle"; // Segundo nombre
    private static final String ACCOUNT_NUMBER_2 = "202410060982"; // Segundo número de cuenta

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");
        String operation = "";
        String input = "";
        String result = "";
        boolean errorOccurred = false;
        String errorMessage = "";

        if ("Convertir a Decimal".equals(action)) {
            operation = "Conversión de Binario a Decimal";
            input = request.getParameter("binarioInput");
            try {
                int decimal = Integer.parseInt(input, 2);
                result = String.valueOf(decimal);
            } catch (NumberFormatException e) {
                errorOccurred = true;
                errorMessage = "Error: ingresa un número binario válido (solo 0 y 1).";
            }

        } else if ("Convertir a Binario".equals(action)) {
            operation = "Conversión de Decimal a Binario";
            input = request.getParameter("decimalInput");
            try {
                int decimal = Integer.parseInt(input);
                result = Integer.toBinaryString(decimal);
            } catch (NumberFormatException e) {
                errorOccurred = true;
                errorMessage = "Error: Ingresa un número decimal válido.";
            }

        } else {
            errorOccurred = true;
            errorMessage = "Error de Formulario: operación desconocida.";
        }

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Resultado Conversión</title>");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"Style.css\">");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; margin: 20px; background-color: #f4f4f4; color: #333; }");
        out.println(".container { background-color: #fff; padding: 30px; border-radius: 8px; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); max-width: 600px; margin: auto; }");
        out.println("h1, h2 { color: #0056b3; }");
        out.println("p { font-size: 1.1em; }");
        out.println("table { width: 100%; border-collapse: collapse; margin-top: 20px; }");
        out.println("th, td { border: 1px solid black; padding: 8px; text-align: left; }");
        out.println("th { background-color: #f2f2f2; }");
        out.println(".back-link { display: block; margin-top: 20px; color: #007bff; text-decoration: none; font-weight: bold; }");
        out.println(".back-link:hover { text-decoration: underline; }");
        out.println(".error { color: red; font-weight: bold; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container\">");
        out.println("<h2>Servlet Tarea 1: " + DEVELOPER_NAME_1 + "</h2>");
        out.println("<p>Cuenta: " + ACCOUNT_NUMBER_1 + "</p>");
        out.println("<h2>Servlet Tarea 1: " + DEVELOPER_NAME_2 + "</h2>");
        out.println("<p>Cuenta: " + ACCOUNT_NUMBER_2 + "</p>");
        out.println("<p>Operación realizada: " + operation + "</p>");

        if (errorOccurred) {
            out.println("<p class='error'>" + errorMessage + "</p>");
        } else {
            out.println("<table border=\"1\">");
            out.println("<tr><th>Entrada</th><th>Respuesta</th></tr>");
            out.println("<tr><td>" + input + "</td><td>" + result + "</td></tr>");
            out.println("</table>");
        }

        out.println("<br><a href=\"Conversor.html\" class=\"back-link\">Otra Conversión</a>");
        out.println("<a href=\"index.html\" class=\"back-link\">Volver al Menú Principal</a>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
