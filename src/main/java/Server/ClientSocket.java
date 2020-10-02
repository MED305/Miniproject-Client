package Server;
import javax.imageio.IIOException;
import java.io.IOException;
import java.net.*;

public class ClientSocket {
    public  enum Error {
        NONE, INVALID_HOST, SOCKET_EXCEPTION
    }
    private int port;
    private String ipAddress;
    private InetAddress serverAddress;
    private Error errorCode = Error.NONE;
    private DatagramSocket socket;

    /**
     *
     * @param host
     *              here we should write the IP address in this format 5000 is the socket
     *              eg. 192.168.1.1:5000
     */

    public ClientSocket(String host){


    }
    /**
     * the format should be:
     * @param host
     *              eg. 192.168.1.1
     * @param port
     *              eg. 5000
     */
    public ClientSocket(String  host, int port){
        this.ipAddress = host;
        this.port = port;
    }

    public boolean connect(){
        try {
            serverAddress = InetAddress.getByName(ipAddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            errorCode = Error.INVALID_HOST;
            return false;
        }
        try {
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
            errorCode = Error.SOCKET_EXCEPTION;
            return false;
        }

    }
    public void send(byte[] data){
        assert(socket.isConnected());
        DatagramPacket packet = new DatagramPacket(data, data.length, serverAddress, port);
        try{
            socket.send(packet);
        } catch (IOException e){
            e.printStackTrace();
        }

    }
    public Error getErrorCode() {
        return errorCode;
    }
}
