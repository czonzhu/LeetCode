public class Solution extends Reader4{
	/**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
     private char[] tmp = new char[4];
     int offset = 0, bufleft = 0;
     public int read(char[] buf, int n){
     	int num = 0;
     	boolean eof = false;
     	while(!eof && num < n){
     		int size = bufleft != 0 ? bufleft : read4(tmp);
     		if(bufleft == 0 && size < 4) eof = true;
     		int len = Math.min(n - num, size);
     		System.arraycopy(tmp, offset, buf, num, len);
     		num += len;
     		offset = (offset + len) % 4;
     		bufleft = size - len;
     	}
     	return num;
     }
}