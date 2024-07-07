package leetcode;
/*
 * Given a string queryIP, return "IPv4" if IP is a valid IPv4 address, 
 * "IPv6" if IP is a valid IPv6 address or "Neither" if IP is not a correct IP of any type.

A valid IPv4 address is an IP in the form "x1.x2.x3.x4" 
where 0 <= xi <= 255 and xi cannot contain leading zeros. 
For example, "192.168.1.1" and "192.168.1.0" are valid IPv4 addresses while "192.168.01.1",
 "192.168.1.00", and "192.168@1.1" are invalid IPv4 addresses.

A valid IPv6 address is an IP in the form "x1:x2:x3:x4:x5:x6:x7:x8" where:

1 <= xi.length <= 4
xi is a hexadecimal string which may contain digits, 
lowercase English letter ('a' to 'f') and upper-case English letters ('A' to 'F').
Leading zeros are allowed in xi.
For example, "2001:0db8:85a3:0000:0000:8a2e:0370:7334" and 
"2001:db8:85a3:0:0:8A2E:0370:7334" are valid IPv6 addresses, 
while "2001:0db8:85a3::8A2E:037j:7334" and "02001:0db8:85a3:0000:0000:8a2e:0370:7334" 
are invalid IPv6 addresses.

 

Example 1:

Input: queryIP = "172.16.254.1"
Output: "IPv4"
Explanation: This is a valid IPv4 address, return "IPv4".
Example 2:

Input: queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
Output: "IPv6"
Explanation: This is a valid IPv6 address, return "IPv6".
Example 3:

Input: queryIP = "256.256.256.256"
Output: "Neither"
Explanation: This is neither a IPv4 address nor a IPv6 address.
 */
public class Q_468_Validate_IP_address {
	public String validIPAddress(String IP) {
        if(IPV4(IP)){
            return "IPv4";
        }
        if(IPV6(IP)){
            return "IPv6";
        }
        return "Neither";
        
    }
    public boolean IPV4(String ip){
        if(ip.length()<7) return false;
        if(ip.charAt(0)=='.') return false;
        if(ip.charAt(ip.length()-1)=='.') return false;
        String[] values = ip.split("\\.");
        if(values.length !=4) return false;
        for(String val:values){
            if(!isvalidIPv4(val)){
                return false;
            }
        }
        return true;
    }
    public boolean isvalidIPv4(String val){
        if(val.startsWith("0") && val.length()>1) return false;
        try{
             int curr = Integer.parseInt(val);
        if(curr<0 || curr>255) return false;
        if(curr == 0 && val.charAt(0) !='0') return false;
        }catch(NumberFormatException nfe){
            return false;
        }
       
        return true;
    }

    public boolean IPV6(String ip){
        if(ip.length()<15) return false;
        if(ip.charAt(0)==':') return false;
        if(ip.charAt(ip.length()-1)==':') return false;
        String[] values = ip.split("\\:");
        if(values.length!=8) return false;
        for(String val:values){
            if(!isvalidIPv6(val)){
                return false;
            }
        }
        return true;
    }
    public boolean isvalidIPv6(String val){
        if(val.length()>4 || val.length()==0) return false;
        char[] chars = val.toCharArray();
        for(char c:chars){
            boolean isDigit = c>=48 && c<= 57;
            boolean isUpper = c>= 65 && c<=70;
            boolean isLower = c>=97 && c<= 102;
            if(!(isDigit || isUpper || isLower)){
                return false;
            }
        }
        return true;

    }

}
