package defpackage;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class c00 {
    public final C1411rq2 c;
    public final LinkedHashMap a = new LinkedHashMap(16, 0.75f, true);
    public long b = 0;
    public final int d = 5242880;

    public c00(C1411rq2 c1411rq2) {
        this.c = c1411rq2;
    }

    public static String c(String str) {
        int length = str.length() / 2;
        return String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode());
    }

    public static int h(b00 b00Var) throws IOException {
        int i = b00Var.read();
        if (i != -1) {
            return i;
        }
        throw new EOFException();
    }

    public static int i(b00 b00Var) {
        return (h(b00Var) << 24) | h(b00Var) | (h(b00Var) << 8) | (h(b00Var) << 16);
    }

    public static long j(b00 b00Var) {
        return (((long) h(b00Var)) & 255) | ((((long) h(b00Var)) & 255) << 8) | ((((long) h(b00Var)) & 255) << 16) | ((((long) h(b00Var)) & 255) << 24) | ((((long) h(b00Var)) & 255) << 32) | ((((long) h(b00Var)) & 255) << 40) | ((((long) h(b00Var)) & 255) << 48) | ((255 & ((long) h(b00Var))) << 56);
    }

    public static String k(b00 b00Var) {
        return new String(l(b00Var, j(b00Var)), "UTF-8");
    }

    public static byte[] l(b00 b00Var, long j) throws IOException {
        long j2 = b00Var.t - b00Var.u;
        if (j >= 0 && j <= j2) {
            int i = (int) j;
            if (i == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(b00Var).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j + ", maxLength=" + j2);
    }

    public static void m(BufferedOutputStream bufferedOutputStream, int i) throws IOException {
        bufferedOutputStream.write(i & 255);
        bufferedOutputStream.write((i >> 8) & 255);
        bufferedOutputStream.write((i >> 16) & 255);
        bufferedOutputStream.write((i >> 24) & 255);
    }

    public static void n(BufferedOutputStream bufferedOutputStream, long j) throws IOException {
        bufferedOutputStream.write((byte) j);
        bufferedOutputStream.write((byte) (j >>> 8));
        bufferedOutputStream.write((byte) (j >>> 16));
        bufferedOutputStream.write((byte) (j >>> 24));
        bufferedOutputStream.write((byte) (j >>> 32));
        bufferedOutputStream.write((byte) (j >>> 40));
        bufferedOutputStream.write((byte) (j >>> 48));
        bufferedOutputStream.write((byte) (j >>> 56));
    }

    public static void o(BufferedOutputStream bufferedOutputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        n(bufferedOutputStream, bytes.length);
        bufferedOutputStream.write(bytes, 0, bytes.length);
    }

    public final synchronized C0994kw a(String str) {
        a00 a00Var = (a00) this.a.get(str);
        if (a00Var == null) {
            return null;
        }
        File fileB = b(str);
        try {
            b00 b00Var = new b00(new BufferedInputStream(new FileInputStream(fileB)), fileB.length());
            try {
                a00 a00VarA = a00.a(b00Var);
                if (TextUtils.equals(str, a00VarA.b)) {
                    return a00Var.b(l(b00Var, b00Var.t - b00Var.u));
                }
                AbstractC1583uq2.a("%s: key=%s, found=%s", fileB.getAbsolutePath(), str, a00VarA.b);
                a00 a00Var2 = (a00) this.a.remove(str);
                if (a00Var2 != null) {
                    this.b -= a00Var2.a;
                }
                return null;
            } finally {
                b00Var.close();
            }
        } catch (IOException e) {
            AbstractC1583uq2.a("%s: %s", fileB.getAbsolutePath(), e.toString());
            synchronized (this) {
                boolean zDelete = b(str).delete();
                a00 a00Var3 = (a00) this.a.remove(str);
                if (a00Var3 != null) {
                    this.b -= a00Var3.a;
                }
                if (!zDelete) {
                    AbstractC1583uq2.a("Could not delete cache entry for key=%s, filename=%s", str, c(str));
                }
                return null;
            }
        }
    }

    public final File b(String str) {
        return new File(this.c.a(), c(str));
    }

    public final synchronized void d() {
        long length;
        b00 b00Var;
        File fileA = this.c.a();
        if (!fileA.exists()) {
            if (!fileA.mkdirs()) {
                AbstractC1583uq2.b("Unable to create cache dir %s", fileA.getAbsolutePath());
            }
            return;
        }
        File[] fileArrListFiles = fileA.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            try {
                length = file.length();
                b00Var = new b00(new BufferedInputStream(new FileInputStream(file)), length);
            } catch (IOException unused) {
                file.delete();
            }
            try {
                a00 a00VarA = a00.a(b00Var);
                a00VarA.a = length;
                g(a00VarA.b, a00VarA);
                b00Var.close();
            } catch (Throwable th) {
                b00Var.close();
                throw th;
            }
        }
    }

    public final void e() {
        long j = this.b;
        int i = this.d;
        if (j < i) {
            return;
        }
        SystemClock.elapsedRealtime();
        Iterator it = this.a.entrySet().iterator();
        while (it.hasNext()) {
            a00 a00Var = (a00) ((Map.Entry) it.next()).getValue();
            if (b(a00Var.b).delete()) {
                this.b -= a00Var.a;
            } else {
                String str = a00Var.b;
                AbstractC1583uq2.a("Could not delete cache entry for key=%s, filename=%s", str, c(str));
            }
            it.remove();
            if (this.b < i * 0.9f) {
                return;
            }
        }
    }

    public final synchronized void f(String str, C0994kw c0994kw) {
        BufferedOutputStream bufferedOutputStream;
        a00 a00Var;
        long length = this.b + ((long) c0994kw.a.length);
        int i = this.d;
        if (length <= i || r2.length <= i * 0.9f) {
            File fileB = b(str);
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileB));
                a00Var = new a00(str, c0994kw);
            } catch (IOException unused) {
                if (!fileB.delete()) {
                    AbstractC1583uq2.a("Could not clean up file %s", fileB.getAbsolutePath());
                }
                if (!this.c.a().exists()) {
                    AbstractC1583uq2.a("Re-initializing cache after external clearing.", new Object[0]);
                    this.a.clear();
                    this.b = 0L;
                    d();
                }
            }
            if (!a00Var.c(bufferedOutputStream)) {
                bufferedOutputStream.close();
                AbstractC1583uq2.a("Failed to write header for %s", fileB.getAbsolutePath());
                throw new IOException();
            }
            bufferedOutputStream.write(c0994kw.a);
            bufferedOutputStream.close();
            a00Var.a = fileB.length();
            g(str, a00Var);
            e();
        }
    }

    public final void g(String str, a00 a00Var) {
        LinkedHashMap linkedHashMap = this.a;
        if (linkedHashMap.containsKey(str)) {
            this.b = (a00Var.a - ((a00) linkedHashMap.get(str)).a) + this.b;
        } else {
            this.b += a00Var.a;
        }
        linkedHashMap.put(str, a00Var);
    }
}
