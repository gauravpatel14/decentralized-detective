package defpackage;

import com.google.android.gms.common.api.Api;
import java.util.Arrays;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class FC2 {
    public Object[] a;
    public int b;
    public boolean c;

    public final void a(Object obj) {
        obj.getClass();
        int i = this.b;
        int i2 = i + 1;
        Object[] objArr = this.a;
        int length = objArr.length;
        if (length < i2) {
            int i3 = length + (length >> 1) + 1;
            if (i3 < i2) {
                int iHighestOneBit = Integer.highestOneBit(i);
                i3 = iHighestOneBit + iHighestOneBit;
            }
            if (i3 < 0) {
                i3 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            }
            this.a = Arrays.copyOf(objArr, i3);
            this.c = false;
        } else if (this.c) {
            this.a = (Object[]) objArr.clone();
            this.c = false;
        }
        Object[] objArr2 = this.a;
        int i4 = this.b;
        this.b = i4 + 1;
        objArr2[i4] = obj;
    }
}
