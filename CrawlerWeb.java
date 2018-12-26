package crawlerweb;

import com.google.common.collect.Iterables;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.CharArraySet;
import org.apache.lucene.analysis.StopFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.fa.PersianAnalyzer;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.IndexOptions;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 *
 * @author farazpc.ir
 */
public class CrawlerWeb {

    public static String indexdir = "C:\\Users\\farazpc.ir\\Documents\\NetBeansProjects\\CrawlerWeb\\indexes";
    public static String Textdir = "C:\\Users\\farazpc.ir\\Documents\\NetBeansProjects\\CrawlerWeb\\results.txt";
    public static Analyzer analyzer = new PersianAnalyzer();

    public static void crawling() throws IOException {
        // write our retrived data
        FileWriter fw = new FileWriter("results.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);

        String url = "http://daneshnameh.roshd.ir/mavara/mavara-index.php?page=%D8%B3%D9%88%D8%BA%D8%A7%D8%AA+%D8%B4%D9%87%D8%B1%D9%87%D8%A7%DB%8C+%D9%85%D8%AE%D8%AA%D9%84%D9%81+%D8%A7%DB%8C%D8%B1%D8%A7%D9%86&SSOReturnPage=Check&Rand=0";
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\farazpc.ir\\Downloads\\chromedriver_win32\\chromedriver.exe");
        // define chrome driver
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com/xhtml");

        // Navigate to URL
        driver.get(url);
        WebElement table = driver.findElement(By.xpath("//*[@id=\"mavara-mid\"]/table"));
        List<WebElement> information = table.findElements(By.tagName("tbody"));
        for (WebElement mver : information) {
            for (WebElement ver : mver.findElements(By.tagName("tr"))) {
                // Get all anchor tags

                List<WebElement> attributes = ver.findElements(By.tagName("a"));
                List<WebElement> titles = ver.findElements(By.tagName("h1"));

                for (WebElement atr : attributes) {
                    //System.out.println(atr.getText());
                    bw.write(atr.getText());
                    bw.newLine();
                }
            }
        }
        bw.close();
        fw = new FileWriter("results.txt", true);
        BufferedWriter sw = new BufferedWriter(fw);
        String url2 = "http://www.noonoab.ir/post/33913/%D9%85%D8%B9%D8%B1%D9%81%DB%8C-%D8%B3%D9%88%D8%BA%D8%A7%D8%AA-%D8%B4%D9%87%D8%B1-%D9%87%D8%A7%DB%8C-%D9%85%D8%AE%D8%AA%D9%84%D9%81-%D8%A7%DB%8C%D8%B1%D8%A7%D9%86";
        driver.get(url2);
        WebElement table2 = driver.findElement(By.xpath("/html/body/section/section[3]/section/div[1]/div[2]/article/div[2]"));
        List<WebElement> information2 = table2.findElements(By.tagName("p"));
        List<WebElement> information3 = table2.findElements(By.tagName("h4"));
        int cur = 0;
        while (cur != information2.size() && cur != information3.size()) {
            WebElement el = information3.get(cur);
            WebElement en = information2.get(cur);
            cur++;
            sw.write(el.getText() + "");
            sw.newLine();
            sw.write(en.getText());

        }
        sw.close();
        fw = new FileWriter("results.txt", true);
        BufferedWriter sw2 = new BufferedWriter(fw);

        String url3 = "http://www.entekhab.ir/fa/news/55373/%D8%B3%D9%88%D8%BA%D8%A7%D8%AA%DB%8C-%D8%A7%D8%B3%D8%AA%D8%A7%D9%86%D9%87%D8%A7%DB%8C-%D9%85%D8%AE%D8%AA%D9%84%D9%81-%D8%A7%DB%8C%D8%B1%D8%A7%D9%86-%DA%86%DB%8C%D8%B3%D8%AA";
        driver.get(url3);
        WebElement table3 = driver.findElement(By.xpath("//*[@id=\"news\"]/div[3]/div/div/div/div/div[1]/div[3]/div[1]/div[2]"));
        List<WebElement> site3info = table3.findElements(By.tagName("p"));
        for (WebElement entekhab : site3info) {
            sw2.write(entekhab.getText());
            sw2.newLine();
        }
        sw.close();
        fw = new FileWriter("results.txt", true);
        BufferedWriter sw3 = new BufferedWriter(fw);

        String url4 = "http://www.bultannews.com/fa/news/156799/%D8%B3%D9%88%D8%BA%D8%A7%D8%AA-%D8%B4%D9%87%D8%B1%D9%87%D8%A7-%D9%88-%D8%A7%D8%B3%D8%AA%D8%A7%D9%86%D9%87%D8%A7%DB%8C-%D8%A7%DB%8C%D8%B1%D8%A7%D9%86-%D8%AF%D8%B1-%DB%8C%DA%A9-%D9%86%DA%AF%D8%A7%D9%87";
        driver.get(url4);
        WebElement table4 = driver.findElement(By.xpath("//*[@id=\"news\"]/div[7]/div/div[1]/div[1]/div[2]/div[5]"));

        List<WebElement> site4info = table4.findElements(By.tagName("p"));
        for (WebElement site4 : site4info) {
            sw3.write(site4.getText());
            sw3.newLine();
        }
        sw.close();
        fw = new FileWriter("results.txt", true);
        BufferedWriter sw4 = new BufferedWriter(fw);

        String url5 = "http://sicas.ir/article/view/8539/%D8%B3%D9%88%D8%BA%D8%A7%D8%AA-%D8%B4%D9%87%D8%B1-%D9%87%D8%A7%DB%8C-%D9%85%D8%AE%D8%AA%D9%84%D9%81-%D8%A7%DB%8C%D8%B1%D8%A7%D9%86";
        driver.get(url5);
        WebElement table5 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div"));
        List<WebElement> site5info = table5.findElements(By.tagName("p"));
        for (WebElement ur5 : site5info) {
            sw4.write(ur5.getText());
            sw4.newLine();

        }
      
        TokenStream tokenStream = new StandardTokenizer();
        final List<String> stop_Words = Arrays.asList("منو", "خانه دانشنامه", "دانشنامه", "انجمن", "گالری تصویر");
        tokenStream = new StopFilter(tokenStream, StopFilter.makeStopSet(stop_Words));

        Path path = Paths.get(indexdir);
        Directory directory = FSDirectory.open(path);
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter iwriter = new IndexWriter(directory, config);
        FieldType fl = new FieldType();
        fl.setStoreTermVectors(true);
        fl.setTokenized(true);
        fl.setIndexOptions(IndexOptions.DOCS_AND_FREQS);

        File file = new File(Textdir);
        Document doc = new Document();
        doc.add(new Field("content", new FileReader(file), fl));
        doc.add(new StringField("filename", file.getName(), Field.Store.YES));
        iwriter.addDocument(doc);

        iwriter.close();

    }

    public static void main(String[] args) throws IOException {
        crawling();

    }

}
