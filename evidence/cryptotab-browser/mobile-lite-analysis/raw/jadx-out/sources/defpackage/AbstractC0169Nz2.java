package defpackage;

import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;

/* JADX INFO: renamed from: Nz2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0169Nz2 {
    public static final C0077Fy2 a;
    public static final Api b;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        Api.ClientKey clientKey2 = new Api.ClientKey();
        C0077Fy2 c0077Fy2 = new C0077Fy2();
        a = c0077Fy2;
        C0504cz2 c0504cz2 = new C0504cz2();
        new Scope(Scopes.PROFILE);
        new Scope(Scopes.EMAIL);
        b = new Api("SignIn.API", c0077Fy2, clientKey);
        new Api("SignIn.INTERNAL_API", c0504cz2, clientKey2);
    }
}
