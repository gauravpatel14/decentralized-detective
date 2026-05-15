package defpackage;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: renamed from: aY2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0362aY2 {
    public final String a;
    public final String b;
    public final String c;
    public final long d;
    public final Object e;

    public C0362aY2(String str, String str2, String str3, long j, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(obj);
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = j;
        this.e = obj;
    }
}
