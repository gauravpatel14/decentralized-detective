package defpackage;

import android.net.ProxyInfo;
import android.net.Uri;

/* JADX INFO: renamed from: nn1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1170nn1 {
    public static final C1170nn1 e = new C1170nn1("", 0, "", new String[0]);
    public final String a;
    public final int b;
    public final String c;
    public final String[] d;

    public C1170nn1(String str, int i, String str2, String[] strArr) {
        this.a = str;
        this.b = i;
        this.c = str2;
        this.d = strArr;
    }

    public static C1170nn1 a(ProxyInfo proxyInfo) {
        if (proxyInfo == null) {
            return null;
        }
        String host = proxyInfo.getHost();
        Uri pacFileUrl = proxyInfo.getPacFileUrl();
        if (host == null) {
            host = "";
        }
        return new C1170nn1(host, proxyInfo.getPort(), Uri.EMPTY.equals(pacFileUrl) ? null : pacFileUrl.toString(), proxyInfo.getExclusionList());
    }

    public final String toString() {
        String str = this.a;
        if (!str.equals("localhost") && !str.isEmpty()) {
            str = "<redacted>";
        }
        return "ProxyConfig [mHost=\"" + str + "\", mPort=" + this.b + ", mPacUrl=" + (this.c == null ? "null" : "\"<redacted>\"") + "]";
    }
}
