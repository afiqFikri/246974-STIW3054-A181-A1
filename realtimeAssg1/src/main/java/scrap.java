import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;


public class scrap {
    public static ArrayList<String> list = new ArrayList<String>();

    public ArrayList<String> getArrayList() {

        try {
            Document doc = Jsoup.connect("https://ms.wikipedia.org/wiki/Malaysia").get();

            Elements table = doc.select("table.wikitable");
            Elements rows = table.get(1).select("table.wikitable");

            for (Element row : rows) {
                Elements thh = row.getElementsByTag("th");
                Elements tdd = row.getElementsByTag("td");

                for (int i = 0; i < thh.size(); i++) {
                    list.add(thh.get(i).text());
                    list.add(tdd.get(i).text());
                }
            }

            for (int j = 0; j <= list.size(); j++) {
                System.out.println(list.get(j) + "  :  " + list.get(j + 1));
                j = j + 1;
            }

        } catch (Exception e) {

        }
        return list;
    }
}
