package echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	// 필드

	// 생성자

	// 메소드gs

	// 메소드 일반
	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = new ServerSocket();
		serverSocket.bind(new InetSocketAddress("192.168.0.109", 10001)); // IP, 포트번호 세팅, 일단 새로 생성해서 넣는거 외우기

		System.out.println("<서버시작>");
		System.out.println("================================================");
		System.out.println("[연결을 기다리고 있습니다.]");
		
		
		//반복구간 시작
		while(true) {
			Socket socket = serverSocket.accept();
			System.out.println("[클라이언트가 연결되었습니다.]");
			
			
			//출장 --> 세팅 + 메세지 주고받기
			Thread thread = new ServerThread(socket);
			thread.start();
			
			//탈출조건 --> 생략 (서버스레드에 있어서)
		}
		
	}

}
