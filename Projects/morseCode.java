//converts an inputted sentence to morse code to english

import java.util.Scanner;
import javax.sound.sampled.*;
public class morseCode{
	public static void main(String[] args) throws LineUnavailableException
	{
		Scanner scan = new Scanner(System.in);
	    char[] sen = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
	                   'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 
	                   'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
	                   ',', '.', '?' };
	
	    String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", 
	                	   ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
	                	   "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
	                	   "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
	                	   "-----", "--..--", ".-.-.-", "..--.." };
	    
	    
	    String in = scan.nextLine().toLowerCase();
	    char[] chars = in.toCharArray();
	    String str = "";
	    for (int i = 0; i < chars.length; i++)
	    {
	        for (int j = 0; j < sen.length; j++)
	        {
	            if (sen[j] == chars[i])
	            {
	                str = str + morse[j] + ' ';
	            }
	        }
	    }
	    System.out.println(str);
	    for (int i = 0; i < str.length(); i++)
	    {
	    	if (str.charAt(i)=='.') tone(1000,180,1.0);
	    	if (str.charAt(i)=='-') tone(1000,500,1.0);
	    	if (str.charAt(i)==' ') tone(1000,700,0.0);
	    }
	}
    
    public static void tone(int hz, int msecs, double vol) throws LineUnavailableException{
    	float SAMPLE_RATE = 8000f;
    	byte[] buf = new byte[1];
    	AudioFormat af = new AudioFormat(SAMPLE_RATE,8,1,true,false);
    	SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
    	sdl.open(af);
    	sdl.start();
    	for (int i=0; i < msecs*8; i++) {
    	double angle = i / (SAMPLE_RATE / hz) * 2.0 * Math.PI;
    	buf[0] = (byte)(Math.sin(angle) * 127.0 * vol);
    	sdl.write(buf,0,1);
    	}
    	sdl.drain();
    	sdl.stop();
    	sdl.close();
    	}
}
