package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.chromium.ui.modelutil.PropertyModel;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Ve1 {
    public final HashMap a = new HashMap();

    public final void a(int i, int i2, PropertyModel propertyModel, boolean z) {
        Integer numValueOf = Integer.valueOf((i * 10) + i2);
        HashMap map = this.a;
        List arrayList = (List) map.get(numValueOf);
        if (arrayList == null) {
            arrayList = new ArrayList();
            map.put(numValueOf, arrayList);
        }
        arrayList.add(z ? 0 : arrayList.size(), propertyModel);
    }
}
