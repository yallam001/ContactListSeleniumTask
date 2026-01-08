package AuthenticationTestCases;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;


public class SignUpUtil {
    private static final String TestPrjRoot = "src/test/java/";
    private static final String TestDataFolder = "TestingData/";

    public static String ReadFromFile(String fileName,
                                      String Key) throws FileNotFoundException {
        FileReader reader = new FileReader(
                TestPrjRoot + TestDataFolder + fileName);
        JsonElement e1 = JsonParser.parseReader(reader);
        return e1.getAsJsonObject().get(Key).getAsString();
    }

    public static user[] ReadUsers(String fileName) throws FileNotFoundException {
        FileReader reader = new FileReader(
                TestPrjRoot + TestDataFolder + fileName);
        user[] listOfCredentials = new Gson().fromJson(reader,
                user[].class);
        return listOfCredentials;
    }
}
