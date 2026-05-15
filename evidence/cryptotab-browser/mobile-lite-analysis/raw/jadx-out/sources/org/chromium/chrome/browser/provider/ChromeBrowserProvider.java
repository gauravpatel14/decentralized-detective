package org.chromium.chrome.browser.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import defpackage.UM1;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import org.chromium.base.BundleUtils;
import org.chromium.chrome.browser.base.SplitChromeApplication;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class ChromeBrowserProvider extends ContentProvider {
    public UM1 u;
    public final Object t = new Object();
    public final String v = "gC";

    public final UM1 a() {
        UM1 um1;
        synchronized (this.t) {
            try {
                if (this.u == null) {
                    UM1 um12 = (UM1) BundleUtils.g(SplitChromeApplication.b(getContext()), this.v);
                    this.u = um12;
                    um12.a = this;
                }
                um1 = this.u;
            } catch (Throwable th) {
                throw th;
            }
        }
        return um1;
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        a().getClass();
        return 0;
    }

    @Override // android.content.ContentProvider
    public final void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        a().getClass();
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        return a().a(uri);
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        a().getClass();
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return a().b();
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        a().getClass();
        return 0;
    }
}
