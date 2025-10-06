package com.proyectnumeros.www.app_numerosd;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;@WebServlet(name = "appnumeros", value = "/App_numeros")
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
            out.println("<html><head><title>Resultado</title></head><body>");
            out.println("<h1>Procesamiento de números</h1>");
            out.println("<p>Nombre: " + nombre1 + "</p>");
            out.println("<p>Número de cuenta: " + numCuenta + "</p>");
            out.println("<p>Nombre: " + nombre2 + "</p>");
            out.println("<p>Numero de cuenta: " + numCuenta2 + "</p>");


         /*   if (listaStr == null || listaStr.length == 0) {
                out.println("<p>No se ingresaron números.</p>");
                out.println("</body></html>");
                return;
            }   Lineas solo para Ver si llegaba a Srvl*/

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

            out.println("</body></html>");

        } catch (Exception e) {
            e.printStackTrace();
            try (PrintWriter out = response.getWriter()) {
                out.println("<p>Error en el procesamiento: " + e.getMessage() + "</p>");
                out.println("</body></html>");
            }
        }
    }

    @Override
    public void destroy() {

    }
}
