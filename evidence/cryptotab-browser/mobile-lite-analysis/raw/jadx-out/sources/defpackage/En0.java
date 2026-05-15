package defpackage;

import android.text.TextUtils;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class En0 {
    public final String a;
    public final String b;

    public En0(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || En0.class != obj.getClass()) {
            return false;
        }
        En0 en0 = (En0) obj;
        return TextUtils.equals(this.a, en0.a) && TextUtils.equals(this.b, en0.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Header[name=");
        sb.append(this.a);
        sb.append(",value=");
        return S3.a(sb, this.b, "]");
    }
}
