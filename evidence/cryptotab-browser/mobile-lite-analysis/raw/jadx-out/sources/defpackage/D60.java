package defpackage;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class D60 extends E60 {
    public final TextView a;
    public final y60 b;
    public boolean c = true;

    public D60(TextView textView) {
        this.a = textView;
        this.b = new y60(textView);
    }

    @Override // defpackage.E60
    public final InputFilter[] a(InputFilter[] inputFilterArr) {
        if (!this.c) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i = 0; i < inputFilterArr.length; i++) {
                InputFilter inputFilter = inputFilterArr[i];
                if (inputFilter instanceof y60) {
                    sparseArray.put(i, inputFilter);
                }
            }
            if (sparseArray.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArray.size()];
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (sparseArray.indexOfKey(i3) < 0) {
                    inputFilterArr2[i2] = inputFilterArr[i3];
                    i2++;
                }
            }
            return inputFilterArr2;
        }
        int length2 = inputFilterArr.length;
        int i4 = 0;
        while (true) {
            y60 y60Var = this.b;
            if (i4 >= length2) {
                InputFilter[] inputFilterArr3 = new InputFilter[inputFilterArr.length + 1];
                System.arraycopy(inputFilterArr, 0, inputFilterArr3, 0, length2);
                inputFilterArr3[length2] = y60Var;
                return inputFilterArr3;
            }
            if (inputFilterArr[i4] == y60Var) {
                return inputFilterArr;
            }
            i4++;
        }
    }

    @Override // defpackage.E60
    public final boolean b() {
        return this.c;
    }

    @Override // defpackage.E60
    public final void c(boolean z) {
        if (z) {
            TextView textView = this.a;
            textView.setTransformationMethod(e(textView.getTransformationMethod()));
        }
    }

    @Override // defpackage.E60
    public final void d(boolean z) {
        this.c = z;
        TextView textView = this.a;
        textView.setTransformationMethod(e(textView.getTransformationMethod()));
        textView.setFilters(a(textView.getFilters()));
    }

    @Override // defpackage.E60
    public final TransformationMethod e(TransformationMethod transformationMethod) {
        return this.c ? ((transformationMethod instanceof I60) || (transformationMethod instanceof PasswordTransformationMethod)) ? transformationMethod : new I60(transformationMethod) : transformationMethod instanceof I60 ? ((I60) transformationMethod).a : transformationMethod;
    }
}
