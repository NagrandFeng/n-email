package com.nagrand.email.client;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**  
* 读取Properties文件
* @author Nagrand
*/   
public final class EmailProperties {  
	private  static Log log = LogFactory.getLog(EmailProperties.class);
    private static String storePath;
	private static String from;   
    private static String pwd;
    private static String host;
    private static String protocol="smtp";
  
    static {   
        Properties prop = new Properties();   
        InputStream in = Thread.currentThread().getClass().getResourceAsStream("/nagrand.email.properties");
        try {   
            prop.load(in);   
            from = parse(prop.getProperty("nemail.from").trim());
            pwd = parse(prop.getProperty("nemail.pwd").trim());
            host = parse(prop.getProperty("nemail.host").trim());
            if(prop.getProperty("nemail.protocol")!=null){
            	protocol=parse(prop.getProperty("nemail.protocol").trim());
            }
        } catch (IOException e) {   
            log.error(e);
        }   
    }   
  
    /**  
     * 私有构造方法，不需要创建对象  
     */   
   /* private EmailProperties() {   
    }  */ 
  
    private static String parse(String proVal) {
		if(proVal.startsWith("@{") && proVal.endsWith("}")){
			String envKey= proVal.substring("@{".length(), proVal.length()-1);
			return System.getenv(envKey);
		}
		return proVal;
	}

	public static String getFrom() {   
        return from;   
    }   
  
    public static String getPwd() {   
        return pwd;   
    }  
    
    public static String getHost() {   
        return host;   
    }  
    
    public static String getProtocol() {
    	return protocol;   
	} 
    
    public static String getStorePath() {
    	return storePath;   
	} 
  
    public static void main(String args[]){   
        System.out.println(getFrom());   
        System.out.println(getPwd());  

    }

	
}  