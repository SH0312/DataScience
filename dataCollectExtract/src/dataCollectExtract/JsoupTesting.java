package dataCollectExtract;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupTesting {
	public static void main(String[] args) {
		String url ="http://www.naver.com";
		JsoupTesting.extractDataWithJsoup(url);
	}

	public static void extractDataWithJsoup(String href) {
		Document doc = null;
		try {
			doc = Jsoup.connect(href).timeout(10 * 1000).userAgent("Chrome").ignoreHttpErrors(true).get();
			if (doc != null) {
				String title = doc.title();
				String text = doc.body().text();
				Elements links = doc.select("a[href]");

				for (Element link : links) {
					String linkHref = link.attr("href");
					String linkText = link.text();
					String linkOuterHtml = link.outerHtml();
					String linkInnerHtml = link.html();
					System.out.println(linkHref + "\t" + linkText + "\t" + linkOuterHtml + "\t" + linkInnerHtml);
				}
			}
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

}
