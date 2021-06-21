package echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws IOException { // 프로그램 사용할 유저쪽

		Socket socket = new Socket();
		System.out.println("<클라이언트 시작>");
		System.out.println("================================================");

		System.out.println("[서버에 연결을 요청합니다.]");

		socket.connect(new InetSocketAddress("3.36.334.186", 10001));

		System.out.println("[서버에 연결되었습니다.]");

		// OutputStream out = new FileOutputStream("C:\\javastudy\\file\\biteImg");

		// 메세지 보내기용 스트림
		OutputStream os = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw); // 삼단으로 내보내기

		// String str = "안녕";

		// 메세지 받기용 스트림
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);

		// 스캐너
		Scanner sc = new Scanner(System.in);  //스캐너는 잘 묶인 스트림 형태..
		
		//스캐너-스트림 
		/*
		InputStream in = System.in; //시스템이라는 스태틱, 키보드
		InputStreamReader sisr = new InputStreamReader(in);
		BufferedReader sbr = new BufferedReader(sisr);
		*/

		while (true) {
			// 메세지 보내기
			// 키보드 입력
			String str = sc.nextLine();
			
			//String str = sbr.readLine();
			
			if("/q".equals(str)) {
				System.out.println("접속 종료되었습니다.");
				break;
			}

			// 보내기
			bw.write("(김서현)"+ str);
			bw.newLine();
			bw.flush(); // 버퍼에 비해 안녕이 너무 작아서 그냥은 전송이 안돼가지구 써줌, 꽉 안차도 보내라~ 하는거

			// 메세지 받기
			String reMsg = br.readLine(); 
			System.out.println("server:[" + reMsg + "]");
		}
		System.out.println("=======================================");
		
		
		
		
		System.out.println("<클라이언트 종료>"); //아래가 println 풀어쓴것
		
		//println-stream
		/*
		OutputStream out = System.out;
		OutputStreamWriter sosw = new OutputStreamWriter(out);
		BufferedWriter sbw = new BufferedWriter(sosw);
		
		sbw.write("<클라이언트 종료>");
		sbw.newLine();
		sbw.flush();
		*/
		

		sc.close();
		
		socket.close();
	}

}
