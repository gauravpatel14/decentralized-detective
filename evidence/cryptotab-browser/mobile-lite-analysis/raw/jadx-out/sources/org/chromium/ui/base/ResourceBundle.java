package org.chromium.ui.base;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.util.Log;
import defpackage.AbstractC1499tM;
import defpackage.BN0;
import defpackage.F;
import java.io.IOException;
import java.util.Arrays;
import org.chromium.base.LocaleUtils;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ResourceBundle {
    public static String[] a;

    public static String getLocalePakResourcePath(String str, boolean z, boolean z2) {
        String strA;
        String strB;
        String[] strArr = a;
        if (strArr == null || Arrays.binarySearch(strArr, str) < 0) {
            return null;
        }
        if (!z) {
            strA = "assets/stored-locales/";
        } else if (str.equals("en-US")) {
            strA = "assets/fallback-locales/";
        } else {
            strB = LocaleUtils.b(str);
            strB.getClass();
            switch (strB) {
                case "he":
                    strB = "iw";
                    break;
                case "id":
                    strB = "in";
                    break;
                case "yi":
                    strB = "ji";
                    break;
                case "fil":
                    strB = "tl";
                    break;
            }
            strA = BN0.a("assets/locales#lang_", strB, "/");
        }
        String strB2 = F.b(strA, str, ".pak");
        AssetManager assets = AbstractC1499tM.a.getAssets();
        try {
            AssetFileDescriptor assetFileDescriptorOpenNonAssetFd = assets.openNonAssetFd(strB2);
            if (assetFileDescriptorOpenNonAssetFd != null) {
                assetFileDescriptorOpenNonAssetFd.close();
            }
            return strB2;
        } catch (IOException e) {
            String strA2 = BN0.a("assets/locales/", str, ".pak");
            try {
                AssetFileDescriptor assetFileDescriptorOpenNonAssetFd2 = assets.openNonAssetFd(strA2);
                if (assetFileDescriptorOpenNonAssetFd2 != null) {
                    assetFileDescriptorOpenNonAssetFd2.close();
                }
                return strA2;
            } catch (IOException unused) {
                if (z2) {
                    Log.e("cr_ResourceBundle", "path=" + strB2, e);
                }
                return null;
            }
        }
    }

    public static void setNoAvailableLocalePaks() {
        a = new String[0];
    }
}
