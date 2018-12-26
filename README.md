# IR-Website-Crawler
This application was implemented as the project of the Information Retrieval course <br>

<h1>Project Description:</h1>
This is a crawler project which crawls the websites and searches for the cities Souvenir. <br>

<h2> Technologies Used:</h2>
Java 1.8 <br>
Lucene v6.6.1, for indexing <br>
selenium server  <br>
Google chorome Web driver <br>
<h2> How it works:</h2>
As a simple Crawler, you need to set the URL for websites which you desire to crawl in the code. <br>
Results will be printed in the .txt file and these results will be inputs for indexing process. <br>
You need to extarct results based on your website which you see in code for every URL it is different. <br>

<h2> Detailed Description of Each Used Technologies: </h2>
Lucene: <span style="background-color: #F3F4F4">Apache Lucene</span> is an open-source high performance search engine library written in Java and it is distributed by Apache Foundation,
used for full-text search and indexing.<br>

selenium server: is a test tool that allows you to write automated web application UI tests in any programming language against any HTTP website using any mainstream JavaScript-enabled browser.<br>
we used Google Chorome Web driver and to use it we need to add it in our code: <br>
```
System.setProperty("webdriver.chrome.driver", "C:\\Users\\farazpc.ir\\Downloads\\chromedriver_win32\\chromedriver.exe");

```

<h2> How crawling works </h2>
First, we need to fecth the URL and navigate to it. <br>

```
WebDriver driver = new ChromeDriver();
     driver.get("http://www.google.com/xhtml");

//Navigate to URL
     driver.get(url);
```



Then, we need to fine the table which contains our desired information <br>

```
  WebElement table = (driver.findElement(By.xpath("//*[@id=\"mavara-mid\"]/table");
        List<WebElement> information = (table.findElements(By.tagName("tbody");
        for (WebElement mver : information){ 
            for (WebElement ver : mver.findElements(By.tagName("tr"))) {
                // Get all anchor tags

                List<WebElement> attributes = ver.findElements(By.tagName("a"));
                List<WebElement> titles = ver.findElements(By.tagName("h1"));

                for (WebElement atr : attributes){ 
                   bw.write(atr.getText());
                   bw.newLine();
                }
            }
        }

```

<h3> Author :</h3>
Masoud Erfani <br>
Hope you enjoy it. :)

