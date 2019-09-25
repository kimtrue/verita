package net05.json;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import com.google.gson.Gson;

public class Test03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {

				String transUrl = "https://openapi.naver.com/v1/language/translate";
				URL url = new URL(transUrl);
				System.out.println("번역을 시작합니다");
				System.out.print("우리말(종료quit) : ");
				String ko = sc.nextLine();
				if (ko.equals("quit")) {
					System.out.println(" 종료합니다");
					break;
				}
				String text = URLEncoder.encode(ko, "utf-8");
				System.out.println("1. 영어 2. 일본어 3. 중국어 : ");
				int lang = Integer.parseInt(sc.nextLine());
				String target = null;
				switch (lang) {
				case 1:	target = "en";break;
				case 2:	target = "ja"; break;
				case 3:	target = "zh-CN"; break;
				default: continue;
				}
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("POST");
				con.setRequestProperty("X-Naver-Client-Id", "qbd8haQjeTzrzafAPufQ");
				con.setRequestProperty("X-Naver-Client-Secret", "bSFnEmT_jd");
				String query = "source=ko&target=" + target + "&text=" + text;
				con.setDoOutput(true);

				OutputStream out = con.getOutputStream();
				out.write(query.getBytes());

				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

				// 담아주기
				Trans trans = new Gson().fromJson(br, Trans.class);
				System.out.println(trans.message.result.getTranslatedText());
				
				

				br.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

}
