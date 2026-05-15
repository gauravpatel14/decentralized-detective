package defpackage;

import android.util.Log;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;

/* JADX INFO: renamed from: hf0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0793hf0 {
    public final Z40 a;
    public final InterfaceC0988kn1 b;

    public C0793hf0(C0488cf0 c0488cf0, InterfaceC0988kn1 interfaceC0988kn1) {
        c0488cf0.a();
        Api.ApiOptions.NoOptions noOptions = Api.ApiOptions.NO_OPTIONS;
        GoogleApi.Settings settings = GoogleApi.Settings.DEFAULT_SETTINGS;
        this.a = new Z40(c0488cf0.a, Z40.a, noOptions, settings);
        this.b = interfaceC0988kn1;
        if (interfaceC0988kn1.get() == null) {
            Log.w("FDL", "FDL logging failed. Add a dependency for Firebase Analytics to your app to enable logging of Dynamic Link events.");
        }
    }
}
