package defpackage;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: zg0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1860zg0 implements Cloneable {
    public final int t;
    public final List u;
    public InterfaceC0208Ri2 v;

    public C1860zg0(HC0... hc0Arr) {
        int length = hc0Arr.length;
        this.t = length;
        this.u = Arrays.asList(hc0Arr);
        HC0 hc0 = hc0Arr[0];
        hc0Arr[length - 1].getClass();
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C1860zg0 clone() {
        List list = this.u;
        int size = list.size();
        HC0[] hc0Arr = new HC0[size];
        for (int i = 0; i < size; i++) {
            hc0Arr[i] = ((HC0) list.get(i)).clone();
        }
        return new C1860zg0(hc0Arr);
    }

    public final String toString() {
        String str = " ";
        for (int i = 0; i < this.t; i++) {
            str = str + Float.valueOf(((HC0) this.u.get(i)).v) + "  ";
        }
        return str;
    }
}
