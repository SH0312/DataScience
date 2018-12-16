package dataCollectExtract;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import com.univocity.parsers.common.processor.RowListProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import com.univocity.parsers.tsv.TsvParser;
import com.univocity.parsers.tsv.TsvParserSettings;

public class TestUnivocity {
	public static void main(String[] args) {
		String filename = "C:\\Users\\SH\\Desktop\\testCSV.csv";
		String filename2 = "C:\\Users\\SH\\Desktop\\testTSV.tsv";
		TestUnivocity.parseCsv(filename);
		System.out.println("============================");
		TestUnivocity.parseTsv(filename2);

	}
	//CSV Comma Separated Value
	public static void parseCsv(String fileName) {
		CsvParserSettings parserSettings = new CsvParserSettings();

		parserSettings.setLineSeparatorDetectionEnabled(true); // 줄 구분자 자동 인식
		RowListProcessor rowProcessor = new RowListProcessor(); // 각 행 리스트 저장

		parserSettings.setRowProcessor(rowProcessor);

		parserSettings.setHeaderExtractionEnabled(true); // 첫줄 해더로 사용
		CsvParser parser = new CsvParser(parserSettings);

		parser.parse(new File(fileName));

		String[] headers = rowProcessor.getHeaders();

		List<String[]> rows = rowProcessor.getRows();
		System.out.print("[");
		for (int i = 0; i < headers.length; i++) {
			System.out.print(headers[i]);
			if (i + 1 != headers.length)
				System.out.print(", ");
		}
		System.out.println("]");
		for (int i = 0; i < rows.size(); i++) {
			System.out.println(Arrays.asList(rows.get(i)));
		}
	}

	
	//TSV Tab Separated Value
	public static void parseTsv(String fileName) {
		TsvParserSettings settings = new TsvParserSettings();
		settings.getFormat().setLineSeparator("\n");
		TsvParser parser = new TsvParser(settings);
		List<String[]> allRows = parser.parseAll(new File(fileName));
		
		for(int i = 0; i < allRows.size(); i++) {
			System.out.println(Arrays.asList(allRows.get(i)));
		}
	}

}