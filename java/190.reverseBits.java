public class Solution{
    public int reverseBits(int n){
        int rst = 0;
        for(int i = 0; i < 32; i++){
            rst = (rst << 1) + (n>>>i & 1);
            
        }
        return rst;
    }
}

/*
	public class Solution{
    private final Map<Byte, Integer> cache = new HashMap<Byte, Integer>();
    public int reverseBits(int n){
        byte[] bytes = new byte[4];
        for(int i = 0; i < 4; i++)
            bytes[i] = (byte)((n>>>8*i)&0xFF);
        int rst = 0;
        for(int i = 0; i < 4; i++){
            rst = rst << 8 | reverseByte(bytes[i]);
        }
        return rst;
    }
    
    private int reverseByte(byte b){
        Integer value = cache.get(b);
        if(value != null) return value;
        value = 0;
        for(int i = 0; i < 8; i++){
            value = value<< 1 | ((b>>>i) & 1);
        }
        cache.put(b, value);
        return value;
    }
}
*/