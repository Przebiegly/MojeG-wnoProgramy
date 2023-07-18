package HelpMeAmStuck.WithThisCode;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImageExtractor {
    public static void Tractor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the URL: ");
        String url = scanner.nextLine();

        if (isValidUrl(url)) {
            List<String> imageUrls = extractImageUrls(url);
            if (imageUrls.isEmpty()) {
                System.out.println("No images found on the page.");
            } else {
                System.out.println("Image URLs:");
                for (String imageUrl : imageUrls) {
                    System.out.println(imageUrl);
                }
            }
        } else {
            System.out.println("Invalid URL.");
        }
    }

    private static boolean isValidUrl(String url) {
        return url != null && !url.isEmpty();
    }

    private static List<String> extractImageUrls(String url) {
        List<String> imageUrls = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(url).get();
            Elements images = doc.select("img[src]");
            for (Element image : images) {
                String imageUrl = image.attr("src");
                imageUrls.add(imageUrl);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageUrls;
    }
}
