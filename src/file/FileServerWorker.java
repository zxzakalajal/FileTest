package file;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * 파일명 : FileClientWorker
 * 작성일 : 2021-03-15
 * 작성자 : 전창웅
 *@version 0.0.1
 * 개요 : 파일전송 프로그램
 */
public class FileServerWorker {
	public static void main(String[] args) {
		//파일 복사하는 예제를 작업
		FileInputStream fis = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		FileOutputStream fos = null;
		try {
			//파일을 읽어오는 작업
			fis = new FileInputStream("info.pdf");
			dis = new DataInputStream(fis); 
			fos = new FileOutputStream("output.pdf");
			dos = new DataOutputStream(fos);
			byte[] buffer = new byte[1024];
			
			while(true) {
				int count = dis.read(buffer);//buffer에 파일 내용을 복사 --> 몇개 읽어 왔는지?count
				if(count == -1) break;//더 이상 읽을 것이 없는 경우
				dos.write(buffer,0,count);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				dos.close();
				dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
