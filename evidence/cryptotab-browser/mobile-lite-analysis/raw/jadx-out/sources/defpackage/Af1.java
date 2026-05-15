package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Af1 {
    public File a;
    public final C0488cf0 b;

    public Af1(C0488cf0 c0488cf0) {
        this.b = c0488cf0;
    }

    public final File a() {
        if (this.a == null) {
            synchronized (this) {
                try {
                    if (this.a == null) {
                        C0488cf0 c0488cf0 = this.b;
                        c0488cf0.a();
                        this.a = new File(c0488cf0.a.getFilesDir(), "PersistedInstallation." + this.b.d() + ".json");
                    }
                } finally {
                }
            }
        }
        return this.a;
    }

    public final void b(C1631vi c1631vi) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Fid", c1631vi.a);
            jSONObject.put("Status", aM1.b(c1631vi.b));
            jSONObject.put("AuthToken", c1631vi.c);
            jSONObject.put("RefreshToken", c1631vi.d);
            jSONObject.put("TokenCreationEpochInSecs", c1631vi.f);
            jSONObject.put("ExpiresInSecs", c1631vi.e);
            jSONObject.put("FisError", c1631vi.g);
            C0488cf0 c0488cf0 = this.b;
            c0488cf0.a();
            File fileCreateTempFile = File.createTempFile("PersistedInstallation", "tmp", c0488cf0.a.getFilesDir());
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            fileOutputStream.write(jSONObject.toString().getBytes("UTF-8"));
            fileOutputStream.close();
            if (fileCreateTempFile.renameTo(a())) {
            } else {
                throw new IOException("unable to rename the tmpfile to PersistedInstallation");
            }
        } catch (IOException | JSONException unused) {
        }
    }

    public final C1631vi c() {
        JSONObject jSONObject;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[16384];
        try {
            FileInputStream fileInputStream = new FileInputStream(a());
            while (true) {
                try {
                    int i = fileInputStream.read(bArr, 0, 16384);
                    if (i < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable unused) {
                    }
                    throw th;
                }
            }
            jSONObject = new JSONObject(byteArrayOutputStream.toString());
            fileInputStream.close();
        } catch (IOException | JSONException unused2) {
            jSONObject = new JSONObject();
        }
        String strOptString = jSONObject.optString("Fid", null);
        int iOptInt = jSONObject.optInt("Status", 0);
        String strOptString2 = jSONObject.optString("AuthToken", null);
        String strOptString3 = jSONObject.optString("RefreshToken", null);
        long jOptLong = jSONObject.optLong("TokenCreationEpochInSecs", 0L);
        long jOptLong2 = jSONObject.optLong("ExpiresInSecs", 0L);
        String strOptString4 = jSONObject.optString("FisError", null);
        int i2 = aM1.c(5)[iOptInt];
        if (i2 == 0) {
            throw new NullPointerException("Null registrationStatus");
        }
        String str = i2 == 0 ? " registrationStatus" : "";
        if (str.isEmpty()) {
            return new C1631vi(strOptString, i2, strOptString2, strOptString3, jOptLong2, jOptLong, strOptString4);
        }
        throw new IllegalStateException("Missing required properties:".concat(str));
    }
}
