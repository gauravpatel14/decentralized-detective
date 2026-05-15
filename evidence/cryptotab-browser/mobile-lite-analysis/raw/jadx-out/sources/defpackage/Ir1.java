package defpackage;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Ir1 implements sz1 {
    public final LinkedHashSet a = new LinkedHashSet();

    public Ir1(tz1 tz1Var) {
        tz1Var.c("androidx.savedstate.Restarter", this);
    }

    @Override // defpackage.sz1
    public final Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("classes_to_restore", new ArrayList<>(this.a));
        return bundle;
    }
}
