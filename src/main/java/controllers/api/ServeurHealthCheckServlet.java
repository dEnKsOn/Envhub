package controllers.api;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

@WebServlet("/api/healthcheck")
public class ServeurHealthCheckServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ip = request.getParameter("ip");
        String status = "offline";

        if (ip != null && !ip.isEmpty()) {
            try (Socket socket = new Socket()) {
                // Tente de se connecter sur le port 80 ou 443 avec un timeout de 2 secondes
                try {
                    socket.connect(new InetSocketAddress(ip, 80), 2000);
                    status = "online";
                } catch (IOException e1) {
                    try (Socket socket443 = new Socket()) {
                        socket443.connect(new InetSocketAddress(ip, 443), 2000);
                        status = "online";
                    } catch (IOException e2) {
                        status = "offline";
                    }
                }
            } catch (Exception e) {
                status = "offline";
            }
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print("{\"status\": \"" + status + "\"}");
        
        out.close(); 
    }
}