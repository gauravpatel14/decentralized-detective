package defpackage;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.util.Log;
import java.util.HashMap;

/* JADX INFO: renamed from: oT2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1217oT2 {
    public static C1217oT2 c;
    public final Context a;
    public final C0963kT2 b;

    public C1217oT2() {
        this.a = null;
        this.b = null;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [hT2] */
    public final String a(final String str) {
        Object objA;
        if (this.a == null) {
            return null;
        }
        try {
            try {
                ?? r0 = new Object() { // from class: hT2
                    public final Object a() {
                        String str2;
                        C1217oT2 c1217oT2 = this.a;
                        String str3 = str;
                        ContentResolver contentResolver = c1217oT2.a.getContentResolver();
                        Uri uri = lS2.a;
                        synchronized (lS2.class) {
                            try {
                                str2 = null;
                                if (lS2.e == null) {
                                    lS2.d.set(false);
                                    lS2.e = new HashMap();
                                    lS2.j = new Object();
                                    contentResolver.registerContentObserver(lS2.a, true, new C0841iS2(null));
                                } else if (lS2.d.getAndSet(false)) {
                                    lS2.e.clear();
                                    lS2.f.clear();
                                    lS2.g.clear();
                                    lS2.h.clear();
                                    lS2.i.clear();
                                    lS2.j = new Object();
                                }
                                Object obj = lS2.j;
                                if (lS2.e.containsKey(str3)) {
                                    String str4 = (String) lS2.e.get(str3);
                                    if (str4 != null) {
                                        str2 = str4;
                                    }
                                } else {
                                    int length = lS2.k.length;
                                    Cursor cursorQuery = contentResolver.query(lS2.a, null, null, new String[]{str3}, null);
                                    if (cursorQuery != null) {
                                        try {
                                            if (cursorQuery.moveToFirst()) {
                                                String string = cursorQuery.getString(1);
                                                if (string != null && string.equals(null)) {
                                                    string = null;
                                                }
                                                synchronized (lS2.class) {
                                                    try {
                                                        if (obj == lS2.j) {
                                                            lS2.e.put(str3, string);
                                                        }
                                                    } finally {
                                                    }
                                                }
                                                if (string != null) {
                                                    str2 = string;
                                                }
                                            } else {
                                                synchronized (lS2.class) {
                                                    try {
                                                        if (obj == lS2.j) {
                                                            lS2.e.put(str3, null);
                                                        }
                                                    } finally {
                                                    }
                                                }
                                            }
                                        } finally {
                                            cursorQuery.close();
                                        }
                                    }
                                }
                            } finally {
                            }
                        }
                        return str2;
                    }
                };
                try {
                    objA = r0.a();
                } catch (SecurityException unused) {
                    long jClearCallingIdentity = Binder.clearCallingIdentity();
                    try {
                        objA = r0.a();
                    } finally {
                        Binder.restoreCallingIdentity(jClearCallingIdentity);
                    }
                }
                return (String) objA;
            } catch (SecurityException e) {
                e = e;
                Log.e("GservicesLoader", "Unable to read GServices for: ".concat(String.valueOf(str)), e);
                return null;
            }
        } catch (IllegalStateException e2) {
            e = e2;
            Log.e("GservicesLoader", "Unable to read GServices for: ".concat(String.valueOf(str)), e);
            return null;
        } catch (NullPointerException e3) {
            e = e3;
            Log.e("GservicesLoader", "Unable to read GServices for: ".concat(String.valueOf(str)), e);
            return null;
        }
    }

    public C1217oT2(Context context) {
        this.a = context;
        C0963kT2 c0963kT2 = new C0963kT2(null);
        this.b = c0963kT2;
        context.getContentResolver().registerContentObserver(lS2.a, true, c0963kT2);
    }
}
