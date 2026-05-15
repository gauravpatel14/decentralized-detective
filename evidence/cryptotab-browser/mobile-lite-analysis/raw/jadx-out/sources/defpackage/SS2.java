package defpackage;

import android.content.ContentResolver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Binder;
import android.os.StrictMode;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class SS2 {
    public static final gf g = new gf(0);
    public static final String[] h = {"key", "value"};
    public final ContentResolver a;
    public final Uri b;
    public final OS2 c;
    public final Object d;
    public volatile Map e;
    public final ArrayList f;

    public SS2(ContentResolver contentResolver, Uri uri) {
        OS2 os2 = new OS2(this);
        this.c = os2;
        this.d = new Object();
        this.f = new ArrayList();
        contentResolver.getClass();
        uri.getClass();
        this.a = contentResolver;
        this.b = uri;
        contentResolver.registerContentObserver(uri, false, os2);
    }

    public static SS2 a(ContentResolver contentResolver, Uri uri) {
        SS2 ss2;
        synchronized (SS2.class) {
            gf gfVar = g;
            ss2 = (SS2) gfVar.get(uri);
            if (ss2 == null) {
                try {
                    SS2 ss22 = new SS2(contentResolver, uri);
                    try {
                        gfVar.put(uri, ss22);
                    } catch (SecurityException unused) {
                    }
                    ss2 = ss22;
                } catch (SecurityException unused2) {
                }
            }
        }
        return ss2;
    }

    public static synchronized void c() {
        try {
            for (SS2 ss2 : (ff) g.values()) {
                ss2.a.unregisterContentObserver(ss2.c);
            }
            g.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.os.StrictMode$ThreadPolicy, java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r2v4, types: [NS2] */
    public final Map b() {
        Map map;
        ?? r0;
        Object objA;
        Map map2 = this.e;
        ?? r02 = map2;
        if (map2 == null) {
            synchronized (this.d) {
                ?? r03 = this.e;
                r0 = r03;
                if (r03 == 0) {
                    try {
                        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                        try {
                            ?? r2 = new Object() { // from class: NS2
                                public final Object a() {
                                    String[] strArr = SS2.h;
                                    SS2 ss2 = this.a;
                                    Cursor cursorQuery = ss2.a.query(ss2.b, strArr, null, null, null);
                                    if (cursorQuery == null) {
                                        return Collections.emptyMap();
                                    }
                                    try {
                                        int count = cursorQuery.getCount();
                                        if (count == 0) {
                                            return Collections.emptyMap();
                                        }
                                        Map gfVar = count <= 256 ? new gf(count) : new HashMap(count, 1.0f);
                                        while (cursorQuery.moveToNext()) {
                                            gfVar.put(cursorQuery.getString(0), cursorQuery.getString(1));
                                        }
                                        cursorQuery.close();
                                        return gfVar;
                                    } finally {
                                        cursorQuery.close();
                                    }
                                }
                            };
                            try {
                                objA = r2.a();
                            } catch (SecurityException unused) {
                                long jClearCallingIdentity = Binder.clearCallingIdentity();
                                try {
                                    objA = r2.a();
                                } finally {
                                    Binder.restoreCallingIdentity(jClearCallingIdentity);
                                }
                            }
                            map = (Map) objA;
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        } catch (SQLiteException | IllegalStateException | SecurityException unused2) {
                            Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                            map = null;
                        }
                        this.e = map;
                        r0 = map;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(r03);
                        throw th;
                    }
                }
            }
            r02 = r0;
        }
        return r02 != 0 ? r02 : Collections.emptyMap();
    }
}
