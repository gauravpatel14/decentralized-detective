package defpackage;

import com.google.android.gms.common.api.Api;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class t23 implements Iterator {
    public String t;
    public final String v;
    public final boolean w;
    public int y;
    public final /* synthetic */ G23 z;
    public int u = 2;
    public int x = 0;

    public t23(G23 g23, v33 v33Var, String str) {
        this.z = g23;
        v33Var.getClass();
        this.w = v33Var.a;
        this.y = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.v = str;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int length;
        String str;
        int i;
        int i2 = this.u;
        if (i2 == 4) {
            throw new IllegalStateException();
        }
        int i3 = i2 - 1;
        String string = null;
        if (i2 == 0) {
            throw null;
        }
        if (i3 == 0) {
            return true;
        }
        if (i3 != 2) {
            this.u = 4;
            int i4 = this.x;
            while (true) {
                length = this.x;
                if (length == -1) {
                    this.u = 3;
                    break;
                }
                str = this.v;
                int length2 = str.length();
                f23.b(length, length2);
                while (true) {
                    if (length >= length2) {
                        length = -1;
                        break;
                    }
                    if (str.charAt(length) == this.z.a.a) {
                        break;
                    }
                    length++;
                }
                if (length == -1) {
                    length = str.length();
                    this.x = -1;
                    i = -1;
                } else {
                    i = length + 1;
                    this.x = i;
                }
                if (i == i4) {
                    int i5 = i + 1;
                    this.x = i5;
                    if (i5 > str.length()) {
                        this.x = -1;
                    }
                } else {
                    if (i4 < length) {
                        str.charAt(i4);
                    }
                    if (i4 < length) {
                        str.charAt(length - 1);
                    }
                    if (!this.w || i4 != length) {
                        break;
                    }
                    i4 = this.x;
                }
            }
            int i6 = this.y;
            if (i6 == 1) {
                length = str.length();
                this.x = -1;
                if (length > i4) {
                    str.charAt(length - 1);
                }
            } else {
                this.y = i6 - 1;
            }
            string = str.subSequence(i4, length).toString();
            this.t = string;
            if (this.u != 3) {
                this.u = 1;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.u = 2;
        String str = this.t;
        this.t = null;
        return str;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
