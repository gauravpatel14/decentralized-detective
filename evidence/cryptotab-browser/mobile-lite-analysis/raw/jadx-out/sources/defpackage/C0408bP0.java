package defpackage;

import android.os.Bundle;
import java.util.ArrayList;

/* JADX INFO: renamed from: bP0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0408bP0 {
    public ArrayList a;

    public final C0468cP0 a() {
        if (this.a == null) {
            return C0468cP0.c;
        }
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("controlCategories", this.a);
        return new C0468cP0(bundle, this.a);
    }
}
