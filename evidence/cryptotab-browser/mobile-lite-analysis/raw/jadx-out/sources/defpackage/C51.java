package defpackage;

import android.net.Uri;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C51 {
    public final Uri a;

    public C51(Uri uri) {
        this.a = uri;
    }

    public static C51 a(Uri uri) {
        if (uri != null && uri.getScheme() != null && uri.getAuthority() != null) {
            String scheme = uri.getScheme();
            if (!scheme.equals("http") && !scheme.equals("https")) {
                return null;
            }
            int port = uri.getPort();
            if (scheme.equals("http") && port == 80) {
                port = -1;
            }
            if (scheme.equals("https") && port == 443) {
                port = -1;
            }
            String host = uri.getHost();
            if (port != -1) {
                host = host + ":" + port;
            }
            try {
                return new C51(uri.normalizeScheme().buildUpon().opaquePart("").fragment("").path("").encodedAuthority(host).clearQuery().build());
            } catch (UnsupportedOperationException unused) {
            }
        }
        return null;
    }

    public static C51 b(String str) {
        return a(Uri.parse(str));
    }

    public static C51 c(String str) {
        Uri uri = Uri.parse(str);
        C51 c51A = a(uri);
        if (c51A != null) {
            return c51A;
        }
        throw new IllegalArgumentException("Could not parse: " + uri);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C51.class != obj.getClass()) {
            return false;
        }
        return this.a.equals(((C51) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return this.a.toString();
    }
}
