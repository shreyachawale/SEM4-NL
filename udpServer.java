import java.io.*;
import java.net.*;

class UDPServer {
    public static void main(String args[]) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9876);
        byte[] receiveData = new byte[1024];
        byte[] sendData;
        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String sentence = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("RECEIVED: " + sentence);
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();

            int truthVal = calcArmstrong(Integer.parseInt(sentence.trim()));
            String valToShow = Integer.toString(truthVal) + '\n';
            sendData = valToShow.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
        }
    }

    public static int calcArmstrong(int num) {
        int temp = num;
        int sum = 0;
        while (num != 0) {
            int rem = num % 10;
            sum += (rem * rem * rem);
            num /= 10;
        }
        if (temp == sum) return 1;
        else return 0;
    }
    public static int palindromeOrNot(int num){
    	if(num < 0) return 0;
    	int sum = 0;
    	int rem;
    	int temp = num;
    	while(num != 0){
    	    rem = num % 10;
    	    sum = (sum*10) + rem;
    	    num /= 10;
    	}
    	if(temp == sum) return 1;
    	else return 0;
    }
    public static int reverseInteger(int num){
    	if (num < 0) {
        num = -num;
    	}
    	int sum = 0;
    	int rem;
    	while(num != 0){
    	    rem = num % 10;
    	    sum = (sum*10) + rem;
    	    num /= 10;
    	}
    	return sum;
    }
    public static int maxFromArray(int[] arr){
    	if(arr.length < 2) return arr[0];
    	int max = Integer.MIN_VALUE;
    	for(int i = 0; i< arr.length; i++){
    	    max = Math.max(arr[i], max);
    	}
    	return max;
    }
    public static int fact(int f){
    	if(f == 0 || f == 1) return 1;
    	return f* fact(f-1);
    }
    public static String vowels(String input){
    	String res = "";
    	for(int i = 0; i< input.length(); i++){
    	    if(input.charAt(i) == 'a' || input.charAt(i) == 'e' || input.charAt(i) == 'o' || input.charAt(i) == 'i' || input.charAt(i) == 'u'){
    	    	res += input.charAt(i);
    	    }
    	}
    	return res;
    }
    public static int[] parseIntArray(String input) {
    // Split the input string by space or comma (assuming integers are separated by space or comma)
    	String[] parts = input.split("[,\\s]+");
    
    // Initialize an array to store the parsed integers
    	int[] result = new int[parts.length];
    
    // Parse each substring into an integer and store it in the array
	for (int i = 0; i < parts.length; i++) {
	    result[i] = Integer.parseInt(parts[i]);
	}
        return result;
    }
}