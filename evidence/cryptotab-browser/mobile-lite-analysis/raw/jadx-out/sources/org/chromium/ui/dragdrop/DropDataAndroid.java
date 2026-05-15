package org.chromium.ui.dragdrop;

import android.text.TextUtils;
import org.chromium.url.GURL;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class DropDataAndroid {
    public final String a;
    public final GURL b;
    public final byte[] c;
    public final String d;
    public final String e;

    public DropDataAndroid(String str, GURL gurl, byte[] bArr, String str2, String str3) {
        this.a = str;
        this.b = gurl;
        this.c = bArr;
        this.d = str2;
        this.e = str3;
    }

    public static DropDataAndroid create(String str, GURL gurl, byte[] bArr, String str2, String str3) {
        return new DropDataAndroid(str, gurl, bArr, str2, str3);
    }

    public boolean a() {
        return false;
    }

    public final boolean b() {
        return (this.c == null || TextUtils.isEmpty(this.d) || TextUtils.isEmpty(this.e)) ? false : true;
    }
}
