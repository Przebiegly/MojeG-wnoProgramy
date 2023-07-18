package HelpMeAmStuck.Weebs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
public class SecondWeeb {

    public static void Weeb() {
        SpringApplication.run(SecondWeeb.class);
    }
}

@Controller
class PhotoController {

  //  @GetMapping("/")
    public String showRandomPhoto(Model model) throws IOException {
        String randomPhotoUrl = getRandomPhotoUrl("https://mega.nz/folder/4XZXVA7J#_XGF8w1L0iSX_HjpwdTMEA/folder/ZbZERDaL");
        model.addAttribute("photoUrl", randomPhotoUrl);
        return "random-photo";
    }

    private static String getRandomPhotoUrl(String websiteUrl) throws IOException {
        String websiteContent = fetchWebsiteContent(websiteUrl);
        String regexPattern = "<img\\s+src=\"([^\"]+\\.jpg)\"\\s+.*>";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(websiteContent);

        List<String> photoUrls = new ArrayList<>();
        while (matcher.find()) {
            String photoUrl = matcher.group(1);
            photoUrls.add(photoUrl);
        }

        Random random = new Random();
        int index = random.nextInt(photoUrls.size());
        return photoUrls.get(index);
    }

    private static String fetchWebsiteContent(String websiteUrl) throws IOException {
        URL url = new URL(websiteUrl);
        URLConnection connection = url.openConnection();
        Scanner scanner = new Scanner(connection.getInputStream());
        scanner.useDelimiter("\\Z");
        String content = scanner.next();
        scanner.close();
        return content;
    }
}
