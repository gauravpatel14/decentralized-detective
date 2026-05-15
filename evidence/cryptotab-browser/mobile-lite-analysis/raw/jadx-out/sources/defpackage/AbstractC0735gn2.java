package defpackage;

/* JADX INFO: renamed from: gn2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0735gn2 extends AbstractC0669fn2 {
    public qc1[] a;
    public String b;
    public int c;

    public AbstractC0735gn2() {
        this.a = null;
        this.c = 0;
    }

    public qc1[] getPathData() {
        return this.a;
    }

    public String getPathName() {
        return this.b;
    }

    public void setPathData(qc1[] qc1VarArr) {
        qc1[] qc1VarArr2 = this.a;
        boolean z = false;
        if (qc1VarArr2 != null && qc1VarArr != null && qc1VarArr2.length == qc1VarArr.length) {
            int i = 0;
            while (true) {
                if (i >= qc1VarArr2.length) {
                    z = true;
                    break;
                }
                qc1 qc1Var = qc1VarArr2[i];
                char c = qc1Var.a;
                qc1 qc1Var2 = qc1VarArr[i];
                if (c != qc1Var2.a || qc1Var.b.length != qc1Var2.b.length) {
                    break;
                } else {
                    i++;
                }
            }
        }
        if (!z) {
            this.a = rc1.c(qc1VarArr);
            return;
        }
        qc1[] qc1VarArr3 = this.a;
        for (int i2 = 0; i2 < qc1VarArr.length; i2++) {
            qc1VarArr3[i2].a = qc1VarArr[i2].a;
            int i3 = 0;
            while (true) {
                float[] fArr = qc1VarArr[i2].b;
                if (i3 < fArr.length) {
                    qc1VarArr3[i2].b[i3] = fArr[i3];
                    i3++;
                }
            }
        }
    }

    public AbstractC0735gn2(AbstractC0735gn2 abstractC0735gn2) {
        this.a = null;
        this.c = 0;
        this.b = abstractC0735gn2.b;
        this.a = rc1.c(abstractC0735gn2.a);
    }
}
