import java.net.*;
import java.io.*;
/* Ejemplo que implementa un servidor de eco usando TCP. */
public class Servidor {
        public static void main(String argv[]) {
                if (argv.length != 1) {
                        System.err.println("Formato: ServidorTCP <puerto>");
                        System.exit(-1);
                }
                else {
                                        int port = Integer.parseInt(argv[0]);
                                                              final int MAX_LEN = 20;
                            try {
                                    DatagramSocket  mySocket = new DatagramSocket(port);
                                    byte[ ] buffer = new byte[MAX_LEN];
                                    DatagramPacket datagram = new DatagramPacket(buffer, MAX_LEN);
                                    ServerSocket miservidor=new ServerSocket(port);
                                    System.out.println("Socket TCP iniciado");
                                    while(true){
                                    Socket socket=miservidor.accept();
                                    DataInputStream in=new DataInputStream(socket.getInputStream());
                                    BufferedReader d = new BufferedReader(new InputStreamReader(in));
                                    
                                    System.out.println("Recibi tu Mensaje: "+ in);
                                    String mensaje= "Mi respuesta es a tu mensaje de :  "+ in;
                                    DatagramPacket dgramEnv = new DatagramPacket(mensaje.getBytes(),
                                    mensaje.getBytes().length,  socket.getInetAddress(), socket.getPort());
                                    mySocket.send(dgramEnv);
                                    mySocket.close( );
                                    }
                                                }
                                                catch(IOException e){
                                                e.printStackTrace();
                                                }

                                }
        }
                        }
