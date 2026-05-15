package defpackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class oT0 {
    public final C0291Xp0 a = new C0291Xp0();

    public static void a(HttpURLConnection httpURLConnection, String str) {
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + str);
    }

    public static String b(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        try {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            try {
                String line = bufferedReader.readLine();
                if (line == null || line.trim().isEmpty()) {
                    throw new RuntimeException("File does not have a MIME boundary");
                }
                String strTrim = line.trim();
                if (!strTrim.startsWith("--") || strTrim.length() < 10) {
                    throw new RuntimeException("File does not have a MIME boundary");
                }
                if (!strTrim.matches("^[a-zA-Z0-9-]*$")) {
                    throw new RuntimeException("File has an illegal MIME boundary: ".concat(strTrim));
                }
                String strSubstring = strTrim.substring(2);
                bufferedReader.close();
                fileReader.close();
                return strSubstring;
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } catch (Throwable th2) {
            try {
                fileReader.close();
            } catch (Throwable unused2) {
            }
            throw th2;
        }
    }
}
