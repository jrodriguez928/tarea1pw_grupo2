package com.example.tarea1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "appnumeros", value = "/ServletNumeros")
public class Appnumeros extends HttpServlet {

    private String nombre1 = "Darwin R. Oliva";
    private String numCuenta = "202110020297";
    private String nombre2= "Merari Abigail Valle";
    private String numCuenta2 = "202410060982";


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("actionSelect");

        try (PrintWriter out = response.getWriter()) {
            String[] listaStr = request.getParameterValues("numeros");
            out.println("<!DOCTYPE html>");
            out.println("<html><head><title>Resultado</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; margin: 20px; background-color: #f4f4f4; color: #333; }");
            out.println(".container { background-color: #fff; padding: 30px; border-radius: 8px; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); max-width: 600px; margin: auto; }");
            out.println("h1, h2 { color: #0056b3; }");
            out.println("p { font-size: 1.1em; }");
            out.println(".back-link { display: block; margin-top: 20px; color: #007bff; text-decoration: none; font-weight: bold; }");
            out.println(".back-link:hover { text-decoration: underline; }");
            out.println("</style>");
            out.println("</head><body>");
            out.println("<div class=\"container\">");
            out.println("<h1>Procesamiento de números</h1>");
            out.println("<p>Nombre: " + nombre1 + "</p>");
            out.println("<p>Número de cuenta: " + numCuenta + "</p>");
            out.println("<p>Nombre: " + nombre2 + "</p>");
            out.println("<p>Numero de cuenta: " + numCuenta2 + "</p>");


            if (listaStr == null || listaStr.length == 0) {
                out.println("<p>No se ingresaron números.</p>");
                out.println("<a href=\"numeros.html\" class=\"back-link\">Volver al formulario de Números</a>");
                out.println("<a href=\"index.html\" class=\"back-link\">Volver al Menú Principal</a>");
                out.println("</div></body></html>");
                return;
            }

            int[] lista = new int[listaStr.length];
            for (int i = 0; i < listaStr.length; i++) {
                lista[i] = Integer.parseInt(listaStr[i]);
            }

            switch (action) {
                case "1": {
                    int mayor = lista[0];
                    for (int i = 1; i < lista.length; i++) {
                        if (lista[i] > mayor) {
                            mayor = lista[i];
                        }
                    }
                    out.println("<h2>El número mayor es: " + mayor + "</h2>");
                    break;
                }
                case "2": {
                    int menor = lista[0];
                    for (int i = 1; i < lista.length; i++) {
                        if (lista[i] < menor) {
                            menor = lista[i];
                        }
                    }
                    out.println("<h2>El número menor es: " + menor + "</h2>");
                    break;
                }
                case "3": {
                    Map<Integer, Integer> frec = new HashMap<>();
                    for (int num : lista) {
                        frec.put(num, frec.getOrDefault(num, 0) + 1);
                    }

                    int masRepetido = lista[0];
                    int maxFrec = 1;

                    for (Map.Entry<Integer, Integer> entry : frec.entrySet()) {
                        if (entry.getValue() > maxFrec) {
                            masRepetido = entry.getKey();
                            maxFrec = entry.getValue();
                        }
                    }

                    if (maxFrec == 1) {
                        out.println("<h2>No hay números repetidos.</h2>");
                    } else {
                        out.println("<h2>El número que más se repite es: " + masRepetido + " (repetido " + maxFrec + " veces)</h2>");
                    }
                    break;
                }
                default:
                    out.println("<h2>Opción no válida.</h2>");
            }

            out.println("<a href=\"numeros.html\" class=\"back-link\">Volver al formulario de Números</a>");
            out.println("<a href=\"index.html\" class=\"back-link\">Volver al Menú Principal</a>");
            out.println("</div></body></html>");

        } catch (NumberFormatException e) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html><head><title>Error</title>");
                out.println("<style>");
                out.println("body { font-family: Arial, sans-serif; margin: 20px; background-color: #f4f4f4; color: #333; }");
                out.println(".container { background-color: #fff; padding: 30px; border-radius: 8px; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); max-width: 600px; margin: auto; }");
                out.println("h1 { color: #dc3545; }");
                out.println(".back-link { display: block; margin-top: 20px; color: #007bff; text-decoration: none; font-weight: bold; }");
                out.println(".back-link:hover { text-decoration: underline; }");
                out.println("</style>");
                out.println("</head><body>");
                out.println("<div class=\"container\">");
                out.println("<h1>Error: Por favor, ingrese números enteros válidos.</h1>");
                out.println("<a href=\"numeros.html\" class=\"back-link\">Volver al formulario de Números</a>");
                out.println("<a href=\"index.html\" class=\"back-link\">Volver al Menú Principal</a>");
                out.println("</div></body></html>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html><head><title>Error</title>");
                out.println("<style>");
                out.println("body { font-family: Arial, sans-serif; margin: 20px; background-color: #f4f4f4; color: #333; }");
                out.println(".container { background-color: #fff; padding: 30px; border-radius: 8px; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); max-width: 600px; margin: auto; }");
                out.println("h1 { color: #dc3545; }");
                out.println(".back-link { display: block; margin-top: 20px; color: #007bff; text-decoration: none; font-weight: bold; }");
                out.println(".back-link:hover { text-decoration: underline; }");
                out.println("</style>");
                out.println("</head><body>");
                out.println("<div class=\"container\">");
                out.println("<h1>Error en el procesamiento: " + e.getMessage() + "</h1>");
                out.println("<a href=\"numeros.html\" class=\"back-link\">Volver al formulario de Números</a>");
                out.println("<a href=\"index.html\" class=\"back-link\">Volver al Menú Principal</a>");
                out.println("</div></body></html>");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void destroy() {
    }
}
