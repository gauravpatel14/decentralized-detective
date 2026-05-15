package defpackage;

import androidx.fragment.app.n;
import androidx.fragment.app.strictmode.FragmentReuseViolation;

/* JADX INFO: renamed from: Hi0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0092Hi0 {
    public static final Gi0 a = Gi0.a;

    public static Gi0 a(n nVar) {
        while (nVar != null) {
            if (nVar.isAdded()) {
                nVar.getParentFragmentManager();
            }
            nVar = nVar.getParentFragment();
        }
        return a;
    }

    public static final void b(n nVar, String str) {
        new FragmentReuseViolation("Attempting to reuse fragment " + nVar + " with previous ID " + str);
        a(nVar).getClass();
    }
}
