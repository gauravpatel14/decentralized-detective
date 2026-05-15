package defpackage;

import android.accounts.Account;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.Preconditions;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: renamed from: xm0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1752xm0 {
    public final HashSet a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final String e;
    public final Account f;
    public final String g;
    public final HashMap h;
    public String i;

    public C1752xm0() {
        this.a = new HashSet();
        this.h = new HashMap();
    }

    public C1752xm0(GoogleSignInOptions googleSignInOptions) {
        this.a = new HashSet();
        this.h = new HashMap();
        Preconditions.checkNotNull(googleSignInOptions);
        this.a = new HashSet(googleSignInOptions.u);
        this.b = googleSignInOptions.x;
        this.c = googleSignInOptions.y;
        this.d = googleSignInOptions.w;
        this.e = googleSignInOptions.z;
        this.f = googleSignInOptions.v;
        this.g = googleSignInOptions.A;
        this.h = GoogleSignInOptions.h2(googleSignInOptions.B);
        this.i = googleSignInOptions.C;
    }
}
