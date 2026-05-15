package defpackage;

import android.content.Context;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class GQ2 {
    public final Context a;
    public final String b;
    public final gF1 c;
    public final CastOptions d;
    public final V23 e;

    public GQ2(Context context, CastOptions castOptions, V23 v23) {
        String strB;
        if (Collections.unmodifiableList(castOptions.u).isEmpty()) {
            strB = Cy.a(castOptions.t);
        } else {
            String str = castOptions.t;
            List listUnmodifiableList = Collections.unmodifiableList(castOptions.u);
            if (str == null) {
                throw new IllegalArgumentException("applicationId cannot be null");
            }
            if (listUnmodifiableList == null) {
                throw new IllegalArgumentException("namespaces cannot be null");
            }
            strB = Cy.b(listUnmodifiableList, str);
        }
        this.c = new gF1(this);
        this.a = ((Context) Preconditions.checkNotNull(context)).getApplicationContext();
        this.b = Preconditions.checkNotEmpty(strB);
        this.d = castOptions;
        this.e = v23;
    }
}
