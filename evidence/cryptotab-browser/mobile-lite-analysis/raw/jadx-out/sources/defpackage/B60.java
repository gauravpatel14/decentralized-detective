package defpackage;

import android.text.Editable;
import android.text.Selection;
import android.view.KeyEvent;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class B60 {
    public static boolean a(Editable editable, KeyEvent keyEvent, boolean z) {
        C60[] c60Arr;
        if (!KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (selectionStart != -1 && selectionEnd != -1 && selectionStart == selectionEnd && (c60Arr = (C60[]) editable.getSpans(selectionStart, selectionEnd, C60.class)) != null && c60Arr.length > 0) {
            for (C60 c60 : c60Arr) {
                int spanStart = editable.getSpanStart(null);
                int spanEnd = editable.getSpanEnd(null);
                if ((z && spanStart == selectionStart) || ((!z && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }
}
