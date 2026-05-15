package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.iid.zzp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Properties;

/* JADX INFO: renamed from: cZ2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0483cZ2 {
    public static KZ2 a(SharedPreferences sharedPreferences, String str) throws zzp {
        long j;
        String string = sharedPreferences.getString(RD2.c(str, "|P|"), null);
        String string2 = sharedPreferences.getString(RD2.c(str, "|K|"), null);
        if (string == null || string2 == null) {
            return null;
        }
        KeyPair keyPairF = f(string, string2);
        String string3 = sharedPreferences.getString(RD2.c(str, "cre"), null);
        if (string3 != null) {
            try {
                j = Long.parseLong(string3);
            } catch (NumberFormatException unused) {
                j = 0;
            }
        } else {
            j = 0;
        }
        return new KZ2(keyPairF, j);
    }

    public static KZ2 b(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            String property = properties.getProperty("pub");
            String property2 = properties.getProperty("pri");
            if (property != null && property2 != null) {
                try {
                    KZ2 kz2 = new KZ2(f(property, property2), Long.parseLong(properties.getProperty("cre")));
                    fileInputStream.close();
                    return kz2;
                } catch (NumberFormatException e) {
                    throw new zzp(e);
                }
            }
            fileInputStream.close();
            return null;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    fileInputStream.close();
                } catch (Throwable th3) {
                    AbstractC1186o13.a.a(th, th3);
                }
                throw th2;
            }
        }
    }

    public static void c(Context context, String str, KZ2 kz2) {
        KeyPair keyPair = kz2.a;
        try {
            File fileI = i(context, str);
            fileI.createNewFile();
            Properties properties = new Properties();
            properties.setProperty("pub", Base64.encodeToString(keyPair.getPublic().getEncoded(), 11));
            properties.setProperty("pri", Base64.encodeToString(keyPair.getPrivate().getEncoded(), 11));
            properties.setProperty("cre", String.valueOf(kz2.b));
            FileOutputStream fileOutputStream = new FileOutputStream(fileI);
            try {
                properties.store(fileOutputStream, (String) null);
                fileOutputStream.close();
            } finally {
            }
        } catch (IOException e) {
            String strValueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 21);
            sb.append("Failed to write key: ");
            sb.append(strValueOf);
            Log.w("InstanceID", sb.toString());
        }
    }

    public static void d(Context context, String str, KZ2 kz2) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
        try {
            if (kz2.equals(a(sharedPreferences, str))) {
                return;
            }
        } catch (zzp unused) {
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        String strC = RD2.c(str, "|P|");
        KeyPair keyPair = kz2.a;
        editorEdit.putString(strC, Base64.encodeToString(keyPair.getPublic().getEncoded(), 11));
        editorEdit.putString(RD2.c(str, "|K|"), Base64.encodeToString(keyPair.getPrivate().getEncoded(), 11));
        editorEdit.putString(RD2.c(str, "cre"), String.valueOf(kz2.b));
        editorEdit.commit();
    }

    public static KZ2 e(Context context, String str) {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            KZ2 kz2 = new KZ2(keyPairGenerator.generateKeyPair(), System.currentTimeMillis());
            try {
                KZ2 kz2G = g(context, str);
                if (kz2G != null) {
                    return kz2G;
                }
            } catch (zzp unused) {
            }
            c(context, str, kz2);
            d(context, str, kz2);
            return kz2;
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public static KeyPair f(String str, String str2) throws zzp {
        try {
            byte[] bArrDecode = Base64.decode(str, 8);
            byte[] bArrDecode2 = Base64.decode(str2, 8);
            try {
                KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                return new KeyPair(keyFactory.generatePublic(new X509EncodedKeySpec(bArrDecode)), keyFactory.generatePrivate(new PKCS8EncodedKeySpec(bArrDecode2)));
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                String strValueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 19);
                sb.append("Invalid key stored ");
                sb.append(strValueOf);
                Log.w("InstanceID", sb.toString());
                throw new zzp(e);
            }
        } catch (IllegalArgumentException e2) {
            throw new zzp(e2);
        }
    }

    public static KZ2 g(Context context, String str) throws zzp {
        try {
            KZ2 kz2H = h(context, str);
            if (kz2H != null) {
                d(context, str, kz2H);
                return kz2H;
            }
            e = null;
        } catch (zzp e) {
            e = e;
        }
        try {
            KZ2 kz2A = a(context.getSharedPreferences("com.google.android.gms.appid", 0), str);
            if (kz2A != null) {
                c(context, str, kz2A);
                return kz2A;
            }
        } catch (zzp e2) {
            e = e2;
        }
        if (e == null) {
            return null;
        }
        throw e;
    }

    public static KZ2 h(Context context, String str) throws zzp {
        File fileI = i(context, str);
        if (!fileI.exists()) {
            return null;
        }
        try {
            try {
                return b(fileI);
            } catch (IOException e) {
                String strValueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 45);
                sb.append("IID file exists, but failed to read from it: ");
                sb.append(strValueOf);
                Log.w("InstanceID", sb.toString());
                throw new zzp(e);
            }
        } catch (IOException unused) {
            return b(fileI);
        }
    }

    public static File i(Context context, String str) {
        String string;
        if (TextUtils.isEmpty(str)) {
            string = "com.google.InstanceId.properties";
        } else {
            try {
                String strEncodeToString = Base64.encodeToString(str.getBytes("UTF-8"), 11);
                StringBuilder sb = new StringBuilder(String.valueOf(strEncodeToString).length() + 33);
                sb.append("com.google.InstanceId_");
                sb.append(strEncodeToString);
                sb.append(".properties");
                string = sb.toString();
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
        File noBackupFilesDir = context.getNoBackupFilesDir();
        if (noBackupFilesDir == null || !noBackupFilesDir.isDirectory()) {
            Log.w("InstanceID", "noBackupFilesDir doesn't exist, using regular files directory instead");
            noBackupFilesDir = context.getFilesDir();
        }
        return new File(noBackupFilesDir, string);
    }
}
