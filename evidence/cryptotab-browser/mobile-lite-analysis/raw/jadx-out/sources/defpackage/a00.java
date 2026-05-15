package defpackage;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class a00 {
    public long a;
    public final String b;
    public final String c;
    public final long d;
    public final long e;
    public final long f;
    public final long g;
    public final List h;

    public a00(String str, String str2, long j, long j2, long j3, long j4, List list) {
        this.b = str;
        this.c = "".equals(str2) ? null : str2;
        this.d = j;
        this.e = j2;
        this.f = j3;
        this.g = j4;
        this.h = list;
    }

    public static a00 a(b00 b00Var) throws IOException {
        if (c00.i(b00Var) != 538247942) {
            throw new IOException();
        }
        String strK = c00.k(b00Var);
        String strK2 = c00.k(b00Var);
        long j = c00.j(b00Var);
        long j2 = c00.j(b00Var);
        long j3 = c00.j(b00Var);
        long j4 = c00.j(b00Var);
        int i = c00.i(b00Var);
        if (i < 0) {
            throw new IOException(AbstractC1214oR1.a(i, "readHeaderList size="));
        }
        List listEmptyList = i == 0 ? Collections.emptyList() : new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            listEmptyList.add(new En0(c00.k(b00Var).intern(), c00.k(b00Var).intern()));
        }
        return new a00(strK, strK2, j, j2, j3, j4, listEmptyList);
    }

    public final C0994kw b(byte[] bArr) {
        C0994kw c0994kw = new C0994kw();
        c0994kw.a = bArr;
        c0994kw.b = this.c;
        c0994kw.c = this.d;
        c0994kw.d = this.e;
        c0994kw.e = this.f;
        c0994kw.f = this.g;
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        List<En0> list = this.h;
        for (En0 en0 : list) {
            treeMap.put(en0.a, en0.b);
        }
        c0994kw.g = treeMap;
        c0994kw.h = Collections.unmodifiableList(list);
        return c0994kw;
    }

    public final boolean c(BufferedOutputStream bufferedOutputStream) {
        try {
            c00.m(bufferedOutputStream, 538247942);
            c00.o(bufferedOutputStream, this.b);
            String str = this.c;
            if (str == null) {
                str = "";
            }
            c00.o(bufferedOutputStream, str);
            c00.n(bufferedOutputStream, this.d);
            c00.n(bufferedOutputStream, this.e);
            c00.n(bufferedOutputStream, this.f);
            c00.n(bufferedOutputStream, this.g);
            List<En0> list = this.h;
            if (list != null) {
                c00.m(bufferedOutputStream, list.size());
                for (En0 en0 : list) {
                    c00.o(bufferedOutputStream, en0.a);
                    c00.o(bufferedOutputStream, en0.b);
                }
            } else {
                c00.m(bufferedOutputStream, 0);
            }
            bufferedOutputStream.flush();
            return true;
        } catch (IOException e) {
            AbstractC1583uq2.a("%s", e.toString());
            return false;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.util.List] */
    public a00(String str, C0994kw c0994kw) {
        String str2 = c0994kw.b;
        long j = c0994kw.c;
        long j2 = c0994kw.d;
        long j3 = c0994kw.e;
        long j4 = c0994kw.f;
        ?? arrayList = c0994kw.h;
        if (arrayList == 0) {
            Map map = c0994kw.g;
            arrayList = new ArrayList(map.size());
            for (Map.Entry entry : map.entrySet()) {
                arrayList.add(new En0((String) entry.getKey(), (String) entry.getValue()));
            }
        }
        this(str, str2, j, j2, j3, j4, arrayList);
    }
}
