package com.example.numerosbinarios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/conversor")
public class ConversorServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");

        out.println("<h3>Resultado:</h3>");

        if ("Convertir a Decimal".equals(action)) {
            String binarioStr = request.getParameter("binarioInput");
            try {
                int decimal = Integer.parseInt(binarioStr, 2);
                out.println("<p class='success'>El numero Binario <strong>" + binarioStr + "</strong> es <strong>" + decimal + "</strong> en Decimal.</p>");
            } catch (NumberFormatException e) {
                out.println("<p class='error'>Error: ingresa cualquier numero binario  (solo 0 y 1).</p>");
            }

        } else if ("Convertir a Binario".equals(action)) {
            String decimalStr = request.getParameter("decimalInput");
            try {
                int decimal = Integer.parseInt(decimalStr);
                String binario = Integer.toBinaryString(decimal);
                out.println("<p class='success'>El numero Decimal <strong>" + decimal + "</strong> es <strong>" + binario + "</strong> en Binario.</p>");
            } catch (NumberFormatException e) {
                out.println("<p class='error'>Error: Ingresa cualquier  numero decimal</p>");
            }

        } else {
            out.println("<p class='error'>Error de Formulario: numero desconocido </p>");
        }

        out.println("<button onclick=\"limpiarResultado()\" > Otra Conversion</button>");
    }
}