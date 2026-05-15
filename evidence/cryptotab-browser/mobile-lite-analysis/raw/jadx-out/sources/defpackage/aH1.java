package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class aH1 {
    public final String a;
    public final List b;

    public aH1(String str, ArrayList arrayList) {
        this.a = str;
        this.b = Collections.unmodifiableList(arrayList);
    }
}
