public class Solution extends Reader4{
	/**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
     public int read(char[] buf, int n){
     	char[] tmp = new char[4];
     	boolean eof = false;
     	int num = 0;
     	while(num < n && eof == false){
     		int size = read4(tmp);
     		if(size < 4) eof = true;
     		int len = Math.min(n - num, size);
     		System.arraycopy(tmp, 0, buf, num, len);
     		num += len;
     	}
     	return num;
     }
}