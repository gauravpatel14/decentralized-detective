package defpackage;

import android.content.res.Resources;
import java.util.Objects;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class gv1 {
    public final Resources a;
    public final Resources.Theme b;

    public gv1(Resources resources, Resources.Theme theme) {
        this.a = resources;
        this.b = theme;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || gv1.class != obj.getClass()) {
            return false;
        }
        gv1 gv1Var = (gv1) obj;
        return this.a.equals(gv1Var.a) && Objects.equals(this.b, gv1Var.b);
    }

    public final int hashCode() {
        return Objects.hash(this.a, this.b);
    }
}
