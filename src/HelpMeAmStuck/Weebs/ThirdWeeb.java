package HelpMeAmStuck.Weebs;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;


public class ThirdWeeb {
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
            // Process the request
            String requestMethod = exchange.getRequestMethod();
            if (requestMethod.equalsIgnoreCase("GET")) {
                handleGetRequest(exchange);
            } else if (requestMethod.equalsIgnoreCase("POST")) {
                handlePostRequest(exchange);
            } else {
                sendResponse(exchange, "Invalid request method");
            }
        }

        private void handleGetRequest(HttpExchange exchange) throws IOException {
            // Send the HTML form to the client
            String response = "<html><head><title>Calculator</title></head><body>" +
                    "<h1>Calculator</h1>" +
                    "<form method='POST'>" +
                    "<label for='value'>Value:</label>" +
                    "<input type='text' name='value' id='value' required><br>" +
                    "<label for='unit'>Unit:</label>" +
                    "<select name='unit' id='unit'>" +
                    "<option value='cm'>Centimeter</option>" +
                    "<option value='m'>Meter</option>" +
                    "<option value='km'>Kilometer</option>" +
                    "<option value='ft'>Feet</option>" +
                    "<option value='inch'>Inch</option>" +
                    "</select><br>" +
                    "<input type='submit' value='Convert'>" +
                    "</form>" +
                    "<h2>Conversion Result</h2>" +
                    "<div id='result'></div>" +
                    "<script>" +
                    "var canvas = document.getElementById('myCanvas');" +
                    "var ctx = canvas.getContext('2d');" +
                    "ctx.fillStyle = 'green';" +
                    "ctx.fillRect(50, 50, 200, 200);" +
                    "</script>" +
                    "</body></html>";

            sendResponse(exchange, response);
        }

        private void handlePostRequest(HttpExchange exchange) throws IOException {
            // Extract the value and unit from the request
            String value = "";
            String unit = "";
            String requestBody = new String(exchange.getRequestBody().readAllBytes());
            String[] requestParams = requestBody.split("&");
            for (String param : requestParams) {
                String[] keyValue = param.split("=");
                if (keyValue.length == 2) {
                    if (keyValue[0].equalsIgnoreCase("value")) {
                        value = keyValue[1];
                    } else if (keyValue[0].equalsIgnoreCase("unit")) {
                        unit = keyValue[1];
                    }
                }
            }

            // Perform the conversion using the calculator
            String conversionResult = performConversion(value, unit);

            // Send the response
            String response = "<html><head><title>Conversion Result</title></head><body>" +
                    "<h1>Conversion Result</h1>" +
                    "<p>Value: " + value + "</p>" +
                    "<p>Unit: " + unit + "</p>" +
                    "<p>Conversion Result: " + conversionResult + "</p>" +
                    "<script>" +
                    "var resultElement = document.getElementById('result');" +
                    "resultElement.innerText = 'Conversion Result: " + conversionResult + "';" +
                    "</script>" +
                    "</body></html>";

            sendResponse(exchange, response);
        }

        private String performConversion(String value, String unit) {
            // Convert the value to double
            double numericValue;
            try {
                numericValue = Double.parseDouble(value);
            } catch (NumberFormatException e) {
                return "Invalid value";
            }

            // Define the conversion factors
            Map<String, Double> unitMap = new HashMap<>();
            unitMap.put("mm", 0.001);
            unitMap.put("cm", 0.01);
            unitMap.put("m", 1.0);
            unitMap.put("km", 1000.0);
            unitMap.put("ft", 0.3048);
            unitMap.put("inch", 0.0254);

            // Perform the conversion
            double convertedValue = numericValue;
            if (unitMap.containsKey(unit)) {
                convertedValue *= unitMap.get(unit);

                // Calculate feet and inches
                double feet = convertedValue / 0.3048;
                double inches = convertedValue / 0.0254;

                // Format the result
                String conversionResult = String.format("%.2f", convertedValue);
                String feetResult = String.format("%.2f", feet);
                String inchesResult = String.format("%.2f", inches);

                return conversionResult + " meters, " +
                        feetResult + " feet, " + inchesResult + " inches";
            } else {
                return "Invalid unit";
            }
        }


        private void sendResponse(HttpExchange exchange, String response) throws IOException {
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
