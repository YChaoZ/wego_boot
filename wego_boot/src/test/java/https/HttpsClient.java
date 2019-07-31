package https;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.*;
import java.io.*;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class HttpsClient {
    private static Logger log= LoggerFactory.getLogger(HttpsClient.class);
    private static final class DefaultTrustManager implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }

    private static HttpsURLConnection getHttpsURLConnection(String uri, String method) throws IOException {
        SSLContext ctx = null;
        try {
            ctx = SSLContext.getInstance("TLS");
            ctx.init(new KeyManager[0], new TrustManager[] { new DefaultTrustManager() }, new SecureRandom());
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        SSLSocketFactory ssf = ctx.getSocketFactory();

        URL url = new URL(uri);
        HttpsURLConnection httpsConn = (HttpsURLConnection) url.openConnection();
        httpsConn.setSSLSocketFactory(ssf);
        httpsConn.setHostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String arg0, SSLSession arg1) {
                return true;
            }
        });
        httpsConn.setRequestMethod(method);
        httpsConn.setDoInput(true);
        httpsConn.setDoOutput(true);
        httpsConn.setConnectTimeout(4000);
        if(method.equals("POST")){
            httpsConn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
        }
        return httpsConn;
    }

    private static byte[] getBytesFromStream(InputStream is) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] kb = new byte[1024];
        int len;
        while ((len = is.read(kb)) != -1) {
            baos.write(kb, 0, len);
        }
        byte[] bytes = baos.toByteArray();
        baos.close();
        is.close();
        return bytes;
    }

    private static void setBytesToStream(OutputStream os, byte[] bytes) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        byte[] kb = new byte[1024];
        int len;
        while ((len = bais.read(kb)) != -1) {
            os.write(kb, 0, len);
        }
        os.flush();
        os.close();
        bais.close();
    }

    private static String doGet(String uri) {
        try {
            log.info("https的Get请求链接为: "+uri);
            HttpsURLConnection httpsConn = getHttpsURLConnection(uri, "GET");
            return new String(getBytesFromStream(httpsConn.getInputStream()));
        } catch (IOException e) {
            log.error("http的Get请求出现异常:", e.getCause());
        }
        return null;
    }

    private static String doPost(String uri, String data) {
        try {
            log.info("https的POST请求地址为: "+uri);
            log.info("https的POST请求参数为: "+data);
            HttpsURLConnection httpsConn = getHttpsURLConnection(uri, "POST");
            setBytesToStream(httpsConn.getOutputStream(), data.getBytes("utf-8"));
            return new String(getBytesFromStream(httpsConn.getInputStream()));
        } catch (IOException e){
            log.error("http的Post请求出现异常:", e.getCause());
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(doPost("https://www.baidu.com","hello"));
    }
}
