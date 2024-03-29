import java.io.*;

public class CrimeStatistics {
	public static void main(String[] args) {

		String[][] indat = new String[50][20];
		double[][] inndat = new double[50][20];

		try {
			File csv = new File("C:\\Users\\82108\\Desktop\\Tools\\2016_Criminal_Record.csv");
			BufferedReader br = new BufferedReader(new FileReader(csv));
			String line = "";
			int row = 0;
			int i = 0;

			while ((line = br.readLine()) != null) {

				String[] token = line.split(",");
				for (i = 0; i < 15; i++) {
					indat[row][i] = (token[i]);
					String str = indat[row][i];
					str = str.replaceAll("\\-", "0");
					indat[row][i] = str;
					
					// 데이터 파일을 csv파일로 변환한 결과값
				}
				row++;
			}
			for (int y = 1; y < 39; y++) {
				for (int x = 2; x < 4; x++) {
					int value = Integer.parseInt(indat[y][x]);
					
					// csv파일로 변환한 값들을 integer 형태로 변환
					inndat[y][x] = value;
				}
				// System.out.println("");
			}
			double sum = 0;
			for (int y = 1; y < 39; y++) {
				sum = inndat[y][3] / inndat[y][2];
				System.out.printf("%s %.2f%% \n", indat[y][1], sum * 100);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
