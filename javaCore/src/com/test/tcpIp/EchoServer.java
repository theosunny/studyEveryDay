package com.test.tcpIp;



import com.sun.deploy.util.StringUtils;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * tcp的服务端
 */
public class EchoServer {
    /**
     * 可以用 telnet open localhost 8888测试
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
    ServerSocket server= null;//声明server服务端对象
    Socket client =null; //定义客户端
    PrintStream out =null;
    BufferedReader buf =null;
    server = new ServerSocket(8888);//开放8888端口给客户

    boolean f =true;
    while (f){
        System.out.println("服务器运行等待客户端连接");
        client=server.accept();

        //得到客户端输入信息
        buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintStream(client.getOutputStream());//实例化客户端输出流
        System.out.println("有客户端连接"+System.currentTimeMillis());
        boolean flag=true;//标志位表示客户端是否操作完毕
        while (flag){ //客户端循环操作
            //在此处不间断接收信息
            String str = buf.readLine();
            if(str==null||"".equals(str)){
                flag = false;
            }else{
                //为bye也结束
                if("bye".equals(str)){
                    flag=false;
                }else {
                    System.out.println("客户端连接"+str);
                    out.println("echo"+str);
                }
            }

        }
        out.close();
        buf.close();
    }
        server.close();

}
}
