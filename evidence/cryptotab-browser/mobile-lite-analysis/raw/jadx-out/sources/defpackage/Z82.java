package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Z82 {
    private volatile /* synthetic */ int _size = 0;
    public m80[] a;

    public final void a(m80 m80Var) {
        m80Var.b((n80) this);
        m80[] m80VarArr = this.a;
        if (m80VarArr == null) {
            m80VarArr = new m80[4];
            this.a = m80VarArr;
        } else if (this._size >= m80VarArr.length) {
            m80VarArr = (m80[]) Arrays.copyOf(m80VarArr, this._size * 2);
            this.a = m80VarArr;
        }
        int i = this._size;
        this._size = i + 1;
        m80VarArr[i] = m80Var;
        m80Var.u = i;
        while (i > 0) {
            Object[] objArr = this.a;
            int i2 = (i - 1) / 2;
            if (objArr[i2].compareTo(objArr[i]) <= 0) {
                return;
            }
            e(i, i2);
            i = i2;
        }
    }

    public final boolean b() {
        return this._size == 0;
    }

    public final m80 c(int i) {
        Object[] objArr = this.a;
        this._size--;
        if (i < this._size) {
            e(i, this._size);
            int i2 = (i - 1) / 2;
            if (i <= 0 || objArr[i].compareTo(objArr[i2]) >= 0) {
                while (true) {
                    int i3 = i * 2;
                    int i4 = i3 + 1;
                    if (i4 >= this._size) {
                        break;
                    }
                    Object[] objArr2 = this.a;
                    int i5 = i3 + 2;
                    if (i5 >= this._size || objArr2[i5].compareTo(objArr2[i4]) >= 0) {
                        i5 = i4;
                    }
                    if (objArr2[i].compareTo(objArr2[i5]) <= 0) {
                        break;
                    }
                    e(i, i5);
                    i = i5;
                }
            } else {
                e(i, i2);
                while (i2 > 0) {
                    Object[] objArr3 = this.a;
                    int i6 = (i2 - 1) / 2;
                    if (objArr3[i6].compareTo(objArr3[i2]) <= 0) {
                        break;
                    }
                    e(i2, i6);
                    i2 = i6;
                }
            }
        }
        m80 m80Var = objArr[this._size];
        m80Var.b(null);
        m80Var.u = -1;
        objArr[this._size] = null;
        return m80Var;
    }

    public final m80 d() {
        m80 m80VarC;
        synchronized (this) {
            m80VarC = this._size > 0 ? c(0) : null;
        }
        return m80VarC;
    }

    public final void e(int i, int i2) {
        m80[] m80VarArr = this.a;
        m80 m80Var = m80VarArr[i2];
        m80 m80Var2 = m80VarArr[i];
        m80VarArr[i] = m80Var;
        m80VarArr[i2] = m80Var2;
        m80Var.u = i;
        m80Var2.u = i2;
    }
}
