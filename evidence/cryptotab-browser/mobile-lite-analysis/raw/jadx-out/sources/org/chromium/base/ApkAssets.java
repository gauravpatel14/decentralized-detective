package org.chromium.base;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import defpackage.AbstractC1499tM;
import java.io.IOException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class ApkAssets {
    public static String a;

    public static long[] open(String str, String str2) {
        AssetFileDescriptor assetFileDescriptorOpenNonAssetFd = null;
        a = null;
        try {
            try {
                Context contextA = AbstractC1499tM.a;
                if (!TextUtils.isEmpty(str2) && BundleUtils.f(str2)) {
                    contextA = BundleUtils.a(contextA, str2);
                }
                assetFileDescriptorOpenNonAssetFd = contextA.getAssets().openNonAssetFd(str);
                long[] jArr = {assetFileDescriptorOpenNonAssetFd.getParcelFileDescriptor().detachFd(), assetFileDescriptorOpenNonAssetFd.getStartOffset(), assetFileDescriptorOpenNonAssetFd.getLength()};
                try {
                    assetFileDescriptorOpenNonAssetFd.close();
                } catch (IOException e) {
                    Log.e("cr_ApkAssets", "Unable to close AssetFileDescriptor", e);
                }
                return jArr;
            } catch (IOException e2) {
                a = "Error while loading asset " + str + " from " + str2 + ": " + e2;
                if (!e2.getMessage().equals("") && !e2.getMessage().equals(str)) {
                    Log.e("cr_ApkAssets", a);
                }
                long[] jArr2 = {-1, -1, -1};
                if (assetFileDescriptorOpenNonAssetFd != null) {
                    try {
                        assetFileDescriptorOpenNonAssetFd.close();
                    } catch (IOException e3) {
                        Log.e("cr_ApkAssets", "Unable to close AssetFileDescriptor", e3);
                    }
                }
                return jArr2;
            }
        } catch (Throwable th) {
            if (assetFileDescriptorOpenNonAssetFd != null) {
                try {
                    assetFileDescriptorOpenNonAssetFd.close();
                } catch (IOException e4) {
                    Log.e("cr_ApkAssets", "Unable to close AssetFileDescriptor", e4);
                }
            }
            throw th;
        }
    }

    public static String takeLastErrorString() {
        String str = a;
        a = null;
        return str;
    }
}
