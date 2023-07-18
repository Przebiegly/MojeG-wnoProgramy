package HelpMeAmStuck.Weebs;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class FirstWeeb {
    public static void Weeb() throws IOException {

        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);


        server.createContext("/", new MyHandler());

        // Start the server
        server.start();

        System.out.println("Server running on port 8000");
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // Send the HTML response
            String response = "<html><head><style>" +
                    "table { border-collapse: collapse; }" +
                    "td { width: 100px; height: 100px; text-align: center; font-size: 24px; font-weight: bold; }" +
                    ".x { color: red; }" +
                    ".o { color: blue; }" +
                    "</style></head><body>" +
                    "<h1>Tic-Tac-Toe Board</h1>";
            response += "<table>";
            response += "<tr><td class='x'>X</td><td class='o'>O</td><td class='x'>X</td></tr>";
            response += "<tr><td class='o'>O</td><td class='x'>X</td><td class='o'>O</td></tr>";
            response += "<tr><td class='x'>X</td><td class='o'>O</td><td class='x'>X</td></tr>";
            response += "</table>";
            response += "<canvas id='myCanvas' width='400' height='400'></canvas>";
            response += "<script>" +
                    "var canvas = document.getElementById('myCanvas');" +
                    "var ctx = canvas.getContext('2d');" +
                    "ctx.fillStyle = 'green';" +
                    "ctx.fillRect(50, 50, 200, 200);" +
                    "</script>";
            response += "</body></html>";

            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}






