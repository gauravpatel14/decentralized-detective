package com.google.firebase.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import defpackage.C0001Af0;
import defpackage.C0488cf0;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class FirebaseInitProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public final void attachInfo(Context context, ProviderInfo providerInfo) {
        Preconditions.checkNotNull(providerInfo, "FirebaseInitProvider ProviderInfo cannot be null.");
        if ("com.google.firebase.firebaseinitprovider".equals(providerInfo.authority)) {
            throw new IllegalStateException("Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle.");
        }
        super.attachInfo(context, providerInfo);
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        C0488cf0 c0488cf0F;
        Context context = getContext();
        synchronized (C0488cf0.j) {
            try {
                if (C0488cf0.l.containsKey("[DEFAULT]")) {
                    c0488cf0F = C0488cf0.c();
                } else {
                    C0001Af0 c0001Af0A = C0001Af0.a(context);
                    if (c0001Af0A == null) {
                        Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                        c0488cf0F = null;
                    } else {
                        c0488cf0F = C0488cf0.f(context, c0001Af0A);
                    }
                }
            } finally {
            }
        }
        if (c0488cf0F == null) {
            Log.i("FirebaseInitProvider", "FirebaseApp initialization unsuccessful");
            return false;
        }
        Log.i("FirebaseInitProvider", "FirebaseApp initialization successful");
        return false;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
