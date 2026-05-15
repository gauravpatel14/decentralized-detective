package defpackage;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: aP0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0351aP0 {
    public final List a;
    public final boolean b;

    public C0351aP0(ArrayList arrayList, boolean z) {
        if (arrayList.isEmpty()) {
            this.a = Collections.emptyList();
        } else {
            this.a = Collections.unmodifiableList(new ArrayList(arrayList));
        }
        this.b = z;
    }

    public static C0351aP0 a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("routes");
        if (parcelableArrayList != null) {
            for (int i = 0; i < parcelableArrayList.size(); i++) {
                Bundle bundle2 = (Bundle) parcelableArrayList.get(i);
                arrayList.add(bundle2 != null ? new OO0(bundle2) : null);
            }
        }
        return new C0351aP0(arrayList, bundle.getBoolean("supportsDynamicGroupRoute", false));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("MediaRouteProviderDescriptor{ routes=");
        List list = this.a;
        sb.append(Arrays.toString(list.toArray()));
        sb.append(", isValid=");
        int size = list.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                z = true;
                break;
            }
            OO0 oo0 = (OO0) list.get(i);
            if (oo0 == null || !oo0.e()) {
                break;
            }
            i++;
        }
        sb.append(z);
        sb.append(" }");
        return sb.toString();
    }
}
