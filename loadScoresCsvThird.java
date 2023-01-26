import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

class loadScoresCsvThird {
    public static void main(String[] args) {

        String[][] data = new String[6][4];
        int[] scoreLank = { 0, 1, 2, 3, 4, 5 };

        int i = 0;
        // パスを適切に設定してください パスは ./java-kadai03
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(".", "java-kadai03", "scores.csv"))) {
            var line = "";
            while ((line = reader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, ",", false);

                // 格納
                data[i][0] = st.nextToken();
                data[i][1] = st.nextToken();
                data[i][2] = st.nextToken();
                data[i][3] = st.nextToken();

                // カウント
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (i = 1; i < data.length - 1; i++) {
            for (int j = 1; j < data.length - i - 1; j++) {
                if (Integer.parseInt(data[j][2]) < Integer.parseInt(data[j + 1][2])) {
                    int temp = scoreLank[j];
                    scoreLank[j] = scoreLank[j + 1];
                    scoreLank[j + 1] = temp;
                }
            }
        }
        // 出力
        for (i = 0; i < data.length; i++) {
            System.out.printf("%-6s%-9s%-7s%s", data[scoreLank[i]][0], data[scoreLank[i]][1], data[scoreLank[i]][2], data[scoreLank[i]][3]);
            System.out.println();
        }
    }
}