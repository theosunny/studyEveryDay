package concurrent.art.chapter4.simpleWebPool;

import concurrent.art.chapter4.thredPoolDemo.DeafultThreadPool;
import concurrent.art.chapter4.thredPoolDemo.ThreadPool;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class simpleHttpServer {

    //处理Httpquest的线程池
    static ThreadPool<HttpRequestHandler> threadPools = new DeafultThreadPool<>(1);

    static  String basepath ;
    static ServerSocket serverSocket;
    static  int port = 8080 ;
    public  static  void  setPort(int port){
        if (port>0){
            simpleHttpServer.port=port;
        }
    }
    public  static  void  setBasepath(String basepath){
        if (basepath!=null&&new File(basepath).exists()&&new File(basepath).isDirectory()){
            simpleHttpServer.basepath=basepath;
        }
    }

     public  static void start() throws IOException {
        serverSocket = new ServerSocket(port);
         Socket socket = null;
         while ((socket=serverSocket.accept())!=null){
             //接收一个客户端socket，生成HttpRequestHandler放入线程池
             threadPools.execute(new HttpRequestHandler(socket));
         }
         serverSocket.close();
     }
    public static void main(String[] args) throws IOException {
           setPort(8081);
           setBasepath("C:\\Users\\Administrator\\Downloads");
           start();
   }
    static  class HttpRequestHandler implements Runnable{
        private Socket socket ;
        public HttpRequestHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            String line = null ;
            BufferedReader br = null;
            BufferedReader reader =null;
            PrintWriter out =null;
            InputStream in = null;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String header = reader.readLine();
                String filepath = basepath+header.split(" ")[1];
                out = new PrintWriter(socket.getOutputStream());
                if (filepath.endsWith(".jpg")||filepath.endsWith(".ico")){
                    in = new FileInputStream(filepath);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    int i = 0 ;
                    while ((i=in.read())!=-1){
                        baos.write(i);
                    }
                    byte[] arr = baos.toByteArray();
                    out.println("HTTP/1.1 200 ok");
                    out.println("Server:Molly");
                    out.println("content-type:image/jpeg");
                    out.println("Content-Length:"+arr.length);
                    out.println();
                    socket.getOutputStream().write(arr,0,arr.length);
                }else {
                    br = new BufferedReader(new InputStreamReader(new FileInputStream(filepath)));
                    out = new PrintWriter(socket.getOutputStream());
                    out.println("HTTP/1.1 200 ok");
                    out.println("Server:Molly");
                    out.println("content-type:text/html;charset=utf-8");
                    out.println();
                    while ((line=br.readLine())!=null){
                        out.println(line);
                    }
                }
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                close(br,in,reader,out,socket);
            }
        }
        private static void close(Closeable... closeables){
            if (closeables!=null){
                for (Closeable closeable:closeables){
                    try {
                        closeable.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
