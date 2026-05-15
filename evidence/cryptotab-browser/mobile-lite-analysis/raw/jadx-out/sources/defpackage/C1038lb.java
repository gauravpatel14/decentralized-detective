package defpackage;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;

/* JADX INFO: renamed from: lb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class C1038lb extends EditText {
    public final Ha t;
    public final Mb u;
    public final Ib v;
    public final G82 w;
    public final C1102mb x;
    public C0976kb y;

    public C1038lb(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, Ep1.editTextStyle);
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Ha ha = this.t;
        if (ha != null) {
            ha.a();
        }
        Mb mb = this.u;
        if (mb != null) {
            mb.b();
        }
    }

    @Override // android.widget.TextView
    public final ActionMode.Callback getCustomSelectionActionModeCallback() {
        return F82.d(super.getCustomSelectionActionModeCallback());
    }

    @Override // android.widget.TextView
    public final TextClassifier getTextClassifier() {
        Ib ib;
        if (Build.VERSION.SDK_INT >= 28 || (ib = this.v) == null) {
            if (this.y == null) {
                this.y = new C0976kb(this);
            }
            return super.getTextClassifier();
        }
        TextClassifier textClassifier = ib.b;
        if (textClassifier != null) {
            return textClassifier;
        }
        TextClassificationManager textClassificationManager = (TextClassificationManager) ib.a.getContext().getSystemService(TextClassificationManager.class);
        return textClassificationManager != null ? textClassificationManager.getTextClassifier() : TextClassifier.NO_OP;
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        String[] strArrF;
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.u.getClass();
        int i = Build.VERSION.SDK_INT;
        if (i < 30 && inputConnectionOnCreateInputConnection != null) {
            AbstractC0752h60.a(editorInfo, getText());
        }
        AbstractC1228ob.a(inputConnectionOnCreateInputConnection, editorInfo, this);
        if (inputConnectionOnCreateInputConnection != null && i <= 30 && (strArrF = AbstractC0604eo2.f(this)) != null) {
            editorInfo.contentMimeTypes = strArrF;
            inputConnectionOnCreateInputConnection = new Cw0(inputConnectionOnCreateInputConnection, new C0023Bw0(this));
        }
        return this.x.c(inputConnectionOnCreateInputConnection);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int i = Build.VERSION.SDK_INT;
        if (i < 30 || i >= 33) {
            return;
        }
        ((InputMethodManager) getContext().getSystemService("input_method")).isActive(this);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onDragEvent(DragEvent dragEvent) {
        Activity activity;
        sL rLVar;
        if (Build.VERSION.SDK_INT < 31 && dragEvent.getLocalState() == null && AbstractC0604eo2.f(this) != null) {
            Context context = getContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    activity = null;
                    break;
                }
                if (context instanceof Activity) {
                    activity = (Activity) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
            if (activity == null) {
                Log.i("ReceiveContent", "Can't handle drop: no activity: view=" + this);
            } else if (dragEvent.getAction() != 1 && dragEvent.getAction() == 3) {
                activity.requestDragAndDropPermissions(dragEvent);
                int offsetForPosition = getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
                beginBatchEdit();
                try {
                    Selection.setSelection((Spannable) getText(), offsetForPosition);
                    ClipData clipData = dragEvent.getClipData();
                    if (Build.VERSION.SDK_INT >= 31) {
                        rLVar = new rL(clipData, 3);
                    } else {
                        tL tLVar = new tL();
                        tLVar.b = clipData;
                        tLVar.c = 3;
                        rLVar = tLVar;
                    }
                    AbstractC0604eo2.j(this, rLVar.a());
                    return true;
                } finally {
                    endBatchEdit();
                }
            }
        }
        return super.onDragEvent(dragEvent);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i) {
        sL rLVar;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 31 || AbstractC0604eo2.f(this) == null || !(i == 16908322 || i == 16908337)) {
            return super.onTextContextMenuItem(i);
        }
        ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
        ClipData primaryClip = clipboardManager == null ? null : clipboardManager.getPrimaryClip();
        if (primaryClip != null && primaryClip.getItemCount() > 0) {
            if (i2 >= 31) {
                rLVar = new rL(primaryClip, 1);
            } else {
                tL tLVar = new tL();
                tLVar.b = primaryClip;
                tLVar.c = 1;
                rLVar = tLVar;
            }
            rLVar.c(i == 16908322 ? 0 : 1);
            AbstractC0604eo2.j(this, rLVar.a());
        }
        return true;
    }

    @Override // android.view.View
    public final void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        Ha ha = this.t;
        if (ha != null) {
            ha.c();
        }
    }

    @Override // android.view.View
    public final void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        Ha ha = this.t;
        if (ha != null) {
            ha.d(i);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        Mb mb = this.u;
        if (mb != null) {
            mb.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        Mb mb = this.u;
        if (mb != null) {
            mb.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(F82.e(callback, this));
    }

    @Override // android.widget.TextView
    public final void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.x.a(keyListener));
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        Mb mb = this.u;
        if (mb != null) {
            mb.f(i, context);
        }
    }

    @Override // android.widget.TextView
    public final void setTextClassifier(TextClassifier textClassifier) {
        Ib ib;
        if (Build.VERSION.SDK_INT < 28 && (ib = this.v) != null) {
            ib.b = textClassifier;
            return;
        }
        if (this.y == null) {
            this.y = new C0976kb(this);
        }
        super.setTextClassifier(textClassifier);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1038lb(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC1161na2.a(context);
        Q82.a(getContext(), this);
        Ha ha = new Ha(this);
        this.t = ha;
        ha.b(attributeSet, i);
        Mb mb = new Mb(this);
        this.u = mb;
        mb.e(attributeSet, i);
        mb.b();
        this.v = new Ib(this);
        this.w = new G82();
        C1102mb c1102mb = new C1102mb(this);
        this.x = c1102mb;
        c1102mb.b(attributeSet, i);
        KeyListener keyListener = getKeyListener();
        if (keyListener instanceof NumberKeyListener) {
            return;
        }
        boolean zIsFocusable = super.isFocusable();
        boolean zIsClickable = super.isClickable();
        boolean zIsLongClickable = super.isLongClickable();
        int inputType = super.getInputType();
        KeyListener keyListenerA = c1102mb.a(keyListener);
        if (keyListenerA == keyListener) {
            return;
        }
        super.setKeyListener(keyListenerA);
        super.setRawInputType(inputType);
        super.setFocusable(zIsFocusable);
        super.setClickable(zIsClickable);
        super.setLongClickable(zIsLongClickable);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        return Build.VERSION.SDK_INT >= 28 ? super.getText() : super.getEditableText();
    }
}
